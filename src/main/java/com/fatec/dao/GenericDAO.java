package com.fatec.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fatec.factory.Factory;

public class GenericDAO<Entidade> implements Serializable {

	private static final long serialVersionUID = 1L;
	protected Class<?> classe;

	public GenericDAO(Class<?> classe) {
		this.classe = classe;

	}

	public void salvar(Entidade e) {
		try {
			EntityManager em = Factory.getEntityManager();
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
			em.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void editar(Entidade e) {
		try {
			EntityManager em = Factory.getEntityManager();
			em.getTransaction().begin();
			em.merge(e);
			em.getTransaction().commit();
			em.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deletar(Long id) {
		try {
			EntityManager em = Factory.getEntityManager();
			em.getTransaction().begin();
			em.remove(em.getReference(classe, id));
			em.getTransaction().commit();
			em.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {
		try {
			Query q = Factory.getEntityManager().createQuery("select p from " + classe.getSimpleName() + " p", classe);
			return q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public Entidade bucarPorID(Long id) {
		try {
			Query q = Factory.getEntityManager()
					.createQuery("select p from " + classe.getSimpleName() + " p where p.id -:id", classe);
			q.setParameter("id", id);
			q.setMaxResults(1);
			return (Entidade) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}

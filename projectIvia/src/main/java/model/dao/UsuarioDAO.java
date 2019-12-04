package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import model.JPAUtil.UtilJPA;
import model.entity.Usuario;

public class UsuarioDAO {
	
EntityManager em = UtilJPA.getEntityManager();
	
	/**
	 * Metodo para cadastrar usuario
	 * @param usuario
	 */
	
	public void create(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
		}catch(Exception exp){
			exp.printStackTrace();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}	
	}
	
	/**
	 * Metodo para atualizar usuario
	 * @param usuario
	 */
	public void update(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.merge(usuario);
			em.getTransaction().commit();
		}catch(Exception exp){
			exp.printStackTrace();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}
	
	/**
	 * Deletar um usuario
	 * @param usuario
	 */
	public void remove(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
		}catch(Exception exp){
			exp.printStackTrace();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}
	
	/**
	 * Pegar usuario do login
	 * @param login
	 * @param senha
	 * @return
	 */
	public Usuario getUsuario(String login, String senha) {
		try {
			Usuario usuario = (Usuario) em.createQuery("SELECT u FROM Usuario u where u.login = :name and u.senha = :senha").setParameter("name", login).setParameter("senha", senha).getSingleResult();
			return usuario;
		}catch(NoResultException exp){
			return null;
		}
	}
	
	/**
	 * Listar todos os usuarios
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> getList() {
		List<Usuario> usuarios = null;
		try {
			usuarios = em.createQuery("FROM Usuario").getResultList();
		} catch(Exception exp) {
			exp.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
		return usuarios;
	}

}

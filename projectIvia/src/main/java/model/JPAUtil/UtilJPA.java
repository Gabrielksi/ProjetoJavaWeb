package model.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilJPA {
	
	private static EntityManagerFactory emf;
	
	/**
	 * Criar Factory quer será usado na aplicacao
	 */
	public static void createEntityManagerFactory() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("projetoIvia");
		}
	}
	
	/**
	 * Cria e retorna EntityManager
	 * @return
	 */
	public static EntityManager getEntityManager() {
		if(emf == null) {
			createEntityManagerFactory();
		}
		return emf.createEntityManager();
	}
	
	/**
	 * Finaliza o factory
	 */
	public static void closeEntityManagerFactory() {
		emf.close();
	}

}

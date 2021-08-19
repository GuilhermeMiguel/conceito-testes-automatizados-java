package br.com.empresa.testes.integracao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	//testes é o nome do persistence unit
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("testes");
	
	public static EntityManager criaEntityManager() {
		return factory.createEntityManager();
	}

	
}

package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
			
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//buscando no DB
		Pessoa p = em.find(Pessoa.class, 2);
		
		/*
		 *  Sempre que for fazer alguma alteração tem que colocar o Transaction, 
		 *  a menos que seja uma simples consulta.
		 */
		
		/*
		 * Apaga uma pessoa no DB, mas para remover tem de ser um objeto monitorado,
		 * ou seja, que acabou de ser inserido ou que você buscou e ainda não fechou
		 * o EntityManager.
		 */
				
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("Pronto!");
		
		em.close();
		emf.close();
	}
	
}

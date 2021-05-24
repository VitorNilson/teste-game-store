//package br.com.supera.game.store;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import br.com.supera.game.store.model.Product;
//
//public class Test {
//
//	public static void main(String[] args) {
//		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("productDS");
//		EntityManager em = emf.createEntityManager();
//		
//		List<Product> lista = em.createNamedQuery("SELECT p FROM Product p", Product.class).getResultList();
//		
//		for(Product objeto : lista) {
//			System.out.println("Objeto no banco: " + objeto.getName());
//		}
//		
//		Product produto = new Product("Teste");
//		em.getTransaction().begin();
//		em.persist(produto);
//		em.getTransaction().commit();
//		
//		em.close();
//		emf.close();
//		
//	}
//}

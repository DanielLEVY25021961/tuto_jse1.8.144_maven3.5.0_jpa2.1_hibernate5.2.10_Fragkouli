package levy.daniel.application.model.dao.metier.book.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.model.dao.IDaoGeneric;
import levy.daniel.application.model.metier.book.impl.Book; 

/**
 * class BookDaoTest :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 11 sept. 2017
 *
 */
public class BookDaoTest {

	// ************************ATTRIBUTS************************************/

	/**
	 * dao : IDaoGeneric<Book,Long> :<br/>
	 * BookDao.<br/>
	 */
	public final transient IDaoGeneric<Book, Long> dao = new BookDao();
	
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(BookDaoTest.class);
	
	
	// *************************METHODES************************************/
		
	 /**
	 * method CONSTRUCTEUR BookDaoTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public BookDaoTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * method testCreate() :<br/>
	 * <ul>
	 * Teste la méthode create(Book pBook) :<br/>
	 * <li>garantit que create(...) retourne l'instance 
	 * persistante.</li>
	 * <li>garantit que les instances retournées par 
	 * create(...) ont un ID.</li>
	 * <li>garantit que create(null) retourne null.</li>
	 * </ul>
	 */
	@Test
	public void testCreate() {
		
		/* TEST NULLITE. *****/
		final Book bookNull = null;
		final Book bookNullPersistant = this.dao.create(bookNull);
		
		/* garantit que create(null) retourne null. */
		assertNull("BookNullPersistant doit être null : "
				, bookNullPersistant);
		
		
		/* TEST CREATE. ******/
		/* Création de 3 livres. */
		/* PERSISTENCE. ****/
		final List<Book> listeBooks = this.creerTroisLivres();
		
		final Book book1Persistant = listeBooks.get(0);
		final Book book2Persistant = listeBooks.get(1);
		final Book book3Persistant = listeBooks.get(2);
		
		
		/* garantit que create(...) retourne l'instance persistante. */
		assertNotNull("non null : ", book1Persistant);
		assertNotNull("non null : ", book2Persistant);
		assertNotNull("non null : ", book3Persistant);
		
		/* garantit que les instances retournées par create(...) ont un ID. */
		assertNotNull("ID non null : ", book1Persistant.getId());
		assertNotNull("ID non null : ", book2Persistant.getId());
		assertNotNull("ID non null : ", book3Persistant.getId());
		
//		System.out.println();
//		System.out.println("CREATION DES LIVRES");
//		System.out.println(book1Persistant.toString());
//		System.out.println(book2Persistant.toString());
//		System.out.println(book3Persistant.toString());
//		System.out.println();
//		
//		final List<Book> listeLivres = this.dao.findAll();
//		
//		System.out.println();
//		System.out.println("LIVRES EN BASE");
//		System.out.println(listeLivres);
//		System.out.println();

	} // Fin de testCreate().______________________________________________


	
	/**
	 * method testPersist() :<br/>
	 * <ul>
	 * Teste la méthode persist(Book pBook) :<br/>
	 * <li>garantit que persiste(...) ajoute en base.</li>
	 * </ul>
	 */
	@Test
	public void testPersist() {
		
		/* Nombre initial d'objets en base. */
		final Long nombreInitial = this.dao.count();
		
//		System.out.println("nombre initial de Book en base : " + nombreInitial);
		
		/* TEST NULLITE. *****/
		final Book bookNull = null;
		this.dao.persist(bookNull);
		
		/* Nombre final d'objets en base. */
		final Long nombreFinalNull = this.dao.count();
		
		/* garantit que persist(null) ne fait rien.. */
		assertEquals("nombre final == nombre initial : "
				, nombreFinalNull, nombreInitial);
		
		
		/* TEST PERSIST. ******/
		/* Instanciation d'un nouveau Book. */
		final Book newBook 
			= new Book("nouveau livre persist", "nouvel auteur persist");
		
		/* PERSISTENCE. ****/
		this.dao.persist(newBook);
		
		/* Nombre final d'objets en base. */
		final Long nombreFinal = this.dao.count();
		
//		System.out.println("nombre final de Book en base : " + nombreFinal);
		
		/* garantit que persiste(...) ajoute en base. */
		assertTrue("nombre final == nombre initial + 1 : "
				, nombreFinal == nombreInitial + 1);
		
	} // Fin de testPersist()._____________________________________________
	

	
	/**
	 * method testCreateReturnId() :<br/>
	 * <ul>
	 * Teste la méthode createReturnId(Book pBook) :<br/>
	 * <li>garantit que createReturnId(...) ajoute en base.</li>
	 * </ul>
	 */
	@Test
	public void testCreateReturnId() {
		
		/* TEST NULLITE. *****/
		final Book bookNull = null;
		final Long bookNullPersistantID = this.dao.createReturnId(bookNull);
		
		/* garantit que create(null) retourne null. */
		assertNull("ID de BookNullPersistant doit être null : "
				, bookNullPersistantID);
		
	} // Fin de testCreateReturnId().______________________________________


	
	/**
	 * method testRetrieve() :<br/>
	 * <ul>
	 * Teste la méthode retrieve(Book pBook) :<br/>
	 * <li>garantit que retrieve(...) retrouve en base.</li>
	 * </ul>
	 */
	@Test
	public void testRetrieve() {
		
		/* Instanciation d'un nouveau Book. */
		final Book newBook 
		= new Book("nouveau livre à retrieve", "nouvel auteur à retrieve");
		
		/* PERSISTENCE. ****/
		this.dao.persist(newBook);
		
		/* PERSISTENCE. ****/
		final Book bookRetrieve = this.dao.retrieve(newBook);
		
		/* garantit que retrieve(...) retrouve en base. */
		assertNotNull("non null Book retrouvé : ", bookRetrieve);
		
//		System.out.println();
//		System.out.println("LIVRE RETROUVE : " + bookRetrieve);
//		System.out.println();
		
	} // Fin de testRetrieve().____________________________________________
	
	
	
	/**
	 * method creerTroisLivres() :<br/>
	 * Crée 3 Books en base.<br/>
	 * <br/>
	 * 
	 * @return List&lt;Book&gt;. : Liste contenant 3 livres en base<br/>
	 */
	private List<Book> creerTroisLivres() {
		
		/* Création de 3 livres. */
		final Book book1 = new Book("La maison rose", "Georges Gershwin");
		final Book book2 = new Book("La maison verte", "Georges Karam");
		final Book book3 = new Book("Ivanohe", "Walter Scott");
				
		/* PERSISTENCE. ****/
		final Book book1Persistant = this.dao.create(book1);
		final Book book2Persistant = this.dao.create(book2);
		final Book book3Persistant = this.dao.create(book3);
		
		final List<Book> resultat = new ArrayList<Book>();
		
		resultat.add(book1Persistant);
		resultat.add(book2Persistant);
		resultat.add(book3Persistant);
		
		return resultat;
		
	} // Fin de creerTroisLivres().________________________________________
	
	
	
} // FIN DE LA CLASSE BookDaoTest.-------------------------------------------

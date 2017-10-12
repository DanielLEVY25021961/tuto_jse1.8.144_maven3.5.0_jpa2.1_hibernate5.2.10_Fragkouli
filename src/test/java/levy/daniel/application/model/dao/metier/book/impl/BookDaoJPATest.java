package levy.daniel.application.model.dao.metier.book.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.model.dao.IDaoGenericJPA;
import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.metier.book.impl.Book;
import levy.daniel.application.model.metier.book.impl.SousBook; 


/**
 * class BookDaoJPATest :<br/>
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
 * @since 19 sept. 2017
 *
 */
public class BookDaoJPATest {

	// ************************ATTRIBUTS************************************/

	/**
	 * MESSAGE_CREATE_NULL : String :<br/>
	 * "create(null) doit être null : ".<br/>
	 */
	public static final String MESSAGE_CREATE_NULL 
		= "create(null) doit être null : ";
	
	
	/**
	 * MESSAGE_DOUBLON : String :<br/>
	 * "Un doublon doit lever une PersistenceException : ".<br/>
	 */
	public static final String MESSAGE_DOUBLON 
		= "Un doublon doit lever une PersistenceException : ";

	
	/**
	 * MESSAGE_BOOK_CREE : String :<br/>
	 * "Book créé et non null : ".<br/>
	 */
	public static final String MESSAGE_BOOK_CREE 
		= "Book créé et non null : ";

	
	/**
	 * MESSAGE_ID_CREE : String :<br/>
	 * "ID créé et non null : ".<br/>
	 */
	public static final String MESSAGE_ID_CREE 
		= "ID créé et non null : ";
	
	
	/**
	 * MESSAGE_BOOK_NON_NULL : String :<br/>
	 * "Book retrouvé non null : ".<br/>
	 */
	public static final String MESSAGE_BOOK_NON_NULL 
		= "Book retrouvé non null : ";

	
	/**
	 * MESSAGE_ID_BOOK_NON_NULL : String :<br/>
	 * "ID Book retrouvé non null : ".<br/>
	 */
	public static final String MESSAGE_ID_BOOK_NON_NULL 
		= "ID Book retrouvé non null : ";
	
	
	/**
	 * MESSAGE_LISTE_NULL : String :<br/>
	 * "La liste de sous-classes doit être null : ".<br/>
	 */
	public static final String MESSAGE_LISTE_NULL 
		= "La liste de sous-classes doit être null : ";
	
	
	/**
	 * MESSAGE_UTILISATEUR : String :<br/>
	 * "Le message Utilisateur de l'exception ne doit pas être null : ".<br/>
	 */
	public static final String MESSAGE_UTILISATEUR 
		= "Le message Utilisateur de l'exception ne doit pas être null : ";
	
	
	/**
	 * MESSAGE_TECHNIQUE : String :<br/>
	 * "Le message Technique de l'exception ne doit pas être null : ".<br/>
	 */
	public static final String MESSAGE_TECHNIQUE 
	= "Le message Technique de l'exception ne doit pas être null : ";

	
	/**
	 * UTILISATEUR : String :<br/>
	 * "MESSAGE UTILISATEUR : ".<br/>
	 */
	public static final String UTILISATEUR = "MESSAGE UTILISATEUR : ";

	
	/**
	 * TECHNIQUE : String :<br/>
	 * "MESSAGE TECHNIQUE : ".<br/>
	 */
	public static final String TECHNIQUE = "MESSAGE TECHNIQUE : ";

	
	/**
	 * NOMBRE_INITIAL : String :<br/>
	 * "nombre initial de Book en base : ".<br/>
	 */
	public static final String NOMBRE_INITIAL 
		= "nombre initial de Book en base : ";

	
	/**
	 * NOMBRE_FINAL : String :<br/>
	 * "nombre final de Book en base : ".<br/>
	 */
	public static final String NOMBRE_FINAL 
		= "nombre final de Book en base : ";

	
	/**
	 * LISTE_BOOKS : String :<br/>
	 * "LISTE DES BOOKS : ".<br/>
	 */
	public static final String LISTE_BOOKS 
		= "LISTE DES BOOKS : ";

	
	/**
	 * QBOOKS : String :<br/>
	 * "NOMBRE APRES CREATION DE 4 BOOKS : ".<br/>
	 */
	public static final String QBOOKS 
		= "NOMBRE APRES CREATION DE 4 BOOKS : ";

	
	/**
	 * dao : IDaoGeneric<Book,Long> :<br/>
	 * BookDao.<br/>
	 */
	public final transient IDaoGenericJPA<Book, Long> dao = new BookDaoJPA();
	
	
	/**
	 * AFFICHAGE_GENERAL : Boolean :<br/>
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;

	
	/**
	 * DELETE_APRES_TEST : Boolean :<br/>
	 * Boolean qui commande le vidage de la table après chaque test.<br/>
	 */
	public static final Boolean DELETE_APRES_TEST = false;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(BookDaoJPATest.class);
	
	
	// *************************METHODES************************************/
		
	 /**
	 * method CONSTRUCTEUR BookDaoTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public BookDaoJPATest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/* CREATE ************/
	
	
	/**
	 * method testCreate() :<br/>
	 * <ul>
	 * Teste la méthode create(Book pBook) :<br/>
	 * <li>garantit que create(...) retourne l'instance 
	 * persistante.</li>
	 * <li>garantit que create(...) peut créer une 
	 * instance de sous-classe en base.</li>
	 * <li>garantit que les instances retournées par 
	 * create(...) ont un ID.</li>
	 * <li>garantit que create(null) retourne null.</li>
	 * </ul>
	 */
	@Test
	public void testCreate() {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		Book book1Persistant = null;
		Book book2Persistant = null;
		Book book3Persistant = null;
		Book book4Persistant = null;
		
		try {
			
			/* TEST NULLITE. *****/
			final Book bookNull = null;
			final Book bookNullPersistant = this.dao.create(bookNull);
			
			/* garantit que create(null) retourne null. */
			assertNull(MESSAGE_CREATE_NULL
					, bookNullPersistant);
			
			
			/* TEST CREATE. ******/

			/* Création de 4 livres. */
			final Book book1 
				= new Book(
						"La maison rose create"
						, "Georges Gershwin create");
			final Book book2 
				= new Book(
						"La maison verte create"
						, "Georges Karam create");
			final Book book3 
				= new Book(
						"Ivanohe create"
						, "Walter Scott create");
			final SousBook book4 
				= new SousBook(
						"titre sousBook create"
						, "auteur sousBook create"
						, "editeur sousBook create");
					
			/* PERSISTENCE. ****/
			book1Persistant = this.dao.create(book1);
			book2Persistant = this.dao.create(book2);
			book3Persistant = this.dao.create(book3);
			book4Persistant = this.dao.create(book4);
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println();
				System.out.println("CREATION DES LIVRES");
				System.out.println(book1Persistant.toString());
				System.out.println(book2Persistant.toString());
				System.out.println(book3Persistant.toString());
				System.out.println(book4Persistant.toString());
				System.out.println();
				
				final List<Book> listeLivres = this.dao.findAll();
				
				System.out.println();
				System.out.println("LIVRES EN BASE");
				System.out.println(this.dao.afficherListe(listeLivres));
				System.out.println();
				
			}

			/* garantit que create(...) retourne l'instance persistante. */
			assertNotNull(MESSAGE_BOOK_CREE, book1Persistant);
			assertNotNull(MESSAGE_BOOK_CREE, book2Persistant);
			assertNotNull(MESSAGE_BOOK_CREE, book3Persistant);
			/* garantit que create(...) peut créer une instance de sous-classe en base. */
			assertNotNull(MESSAGE_BOOK_CREE, book4Persistant);
			
			/* garantit que les instances retournées par create(...) 
			 * ont un ID. */
			assertNotNull(MESSAGE_ID_CREE, book1Persistant.getId());
			assertNotNull(MESSAGE_ID_CREE, book2Persistant.getId());
			assertNotNull(MESSAGE_ID_CREE, book3Persistant.getId());
			assertNotNull(MESSAGE_ID_CREE, book4Persistant.getId());
			
			
			/* VIDAGE DE LA TABLE. */
			if (DELETE_APRES_TEST) {
				this.dao.deleteAll();
			}
		
		}
		
		catch (AbstractDaoException e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println(UTILISATEUR 
						+ e.getMessageUtilisateur());
				System.out.println(TECHNIQUE 
						+ e.getMessageTechnique());
				
			}
			
			assertNotNull(MESSAGE_UTILISATEUR
					, e.getMessageUtilisateur());
			assertNotNull(MESSAGE_TECHNIQUE
					, e.getMessageTechnique());
			assertNull(MESSAGE_DOUBLON, book1Persistant);
			
		}

	} // Fin de testCreate().______________________________________________

	
	
	/**
	 * method testCreateDoublon() :<br/>
	 * <ul>
	 * Teste l'impossibilité de créer des doublons :<br/>
	 * <li>garantit qu'une tentative de création de doublon 
	 * retourne une javax.persistence.PersistenceException.</li>
	 * </ul>
	 */
	@Test
	public void testCreateDoublon() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		Book book1Persistant = null;
		Book book2Persistant = null;
		
		/* Instanciation d'un nouveau Book. */
		final Book newBook1 
		= new Book("nouveau livredoublon1"
					, "nouvel auteurdoublon1");
		final Book newBook2 
		= new Book("nouveau livredoublon1"
					, "nouvel auteurdoublon1");
		
		/* PERSISTENCE. ****/
		try {
			
			book1Persistant 
				= this.dao.create(newBook1);
			
			assertNotNull("Book1 doit être créé : "
						, book1Persistant);
			
			book2Persistant 
				= this.dao.create(newBook2);
			
		}
		catch (AbstractDaoException e) {
				
				/* AFFICHAGE A LA CONSOLE. */
				if (AFFICHAGE_GENERAL && affichage) {
					
					System.out.println(UTILISATEUR
							+ e.getMessageUtilisateur());
					System.out.println(TECHNIQUE
							+ e.getMessageTechnique());
					
				}
				
				assertNotNull(MESSAGE_UTILISATEUR
						, e.getMessageUtilisateur());
				assertNotNull(MESSAGE_TECHNIQUE
						, e.getMessageTechnique());
				assertNull(MESSAGE_DOUBLON, book2Persistant);
				
		}
		
	} // Fin de testCreateDoublon()._______________________________________

	
	
	/**
	 * method testSaveSousClasse() :<br/>
	 * <ul>
	 * Teste la méthode save(SousBook pSousBook) :<br/>
	 * <li>garantit que save(...) retourne l'instance 
	 * persistante.</li>
	 * <li>garantit que save(...) retourne le Type S 
	 * (sous-classe de T).</li>
	 * <li>garantit que les instances retournées par 
	 * save(...) ont un ID.</li>
	 * <li>garantit que save(null) retourne null.</li>
	 * </ul>
	 */
	@Test
	public void testSaveSousClasse() {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		SousBook book1Persistant = null;
		SousBook book2Persistant = null;
		SousBook book3Persistant = null;
		Book book4Persistant = null;
		
		try {
			
			/* TEST NULLITE. *****/
			final SousBook bookNull = null;
			final SousBook bookNullPersistant = this.dao.save(bookNull);

			/* garantit que create(null) retourne null. */
			assertNull("save(null) doit être null : ", bookNullPersistant);

			/* TEST CREATE. ******/
			/* Création de 4 livres. */
			final SousBook book1 
				= new SousBook(
						"La maison rose save"
						, "Georges Gershwin save"
						, "Calmann Lévy save");
			final SousBook book2 
				= new SousBook(
						"La maison verte save"
						, "Georges Karam save"
						, "Dunod save");
			final SousBook book3 
				= new SousBook(
						"Ivanohe save"
						, "Walter Scott save"
						, "Dunod save");
			final Book book4 
				= new Book("titre Book save"
						, "auteur Book save");

			/* PERSISTENCE. ****/
			book1Persistant = this.dao.save(book1);
			book2Persistant = this.dao.save(book2);
			book3Persistant = this.dao.save(book3);
			/* garantit que save(...) retourne le Type S 
			 * (sous-classe de T). */
			book4Persistant = this.dao.save(book4);
			
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println();
				System.out.println("CREATION DES SOUS-BOOKS ET BOOKS");
				System.out.println(book1Persistant.toString());
				System.out.println(book2Persistant.toString());
				System.out.println(book3Persistant.toString());
				System.out.println(book4Persistant.toString());
				System.out.println();
				
				final List<Book> listeLivres = this.dao.findAll();
				
				System.out.println();
				System.out.println("SOUS-BOOKS ET BOOKS EN BASE");
				System.out.println(this.dao.afficherListe(listeLivres));
				System.out.println();
				
			}


			/* garantit que create(...) retourne l'instance persistante. */
			assertNotNull(MESSAGE_BOOK_CREE, book1Persistant);
			assertNotNull(MESSAGE_BOOK_CREE, book2Persistant);
			assertNotNull(MESSAGE_BOOK_CREE, book3Persistant);
			assertNotNull(MESSAGE_BOOK_CREE, book4Persistant);

			/*
			 * garantit que les instances retournées par save(...) ont un
			 * ID.
			 */
			assertNotNull(MESSAGE_ID_CREE, book1Persistant.getId());
			assertNotNull(MESSAGE_ID_CREE, book2Persistant.getId());
			assertNotNull(MESSAGE_ID_CREE, book3Persistant.getId());
			assertNotNull(MESSAGE_ID_CREE, book4Persistant.getId());
			
			/* VIDAGE DE LA TABLE. */
			if (DELETE_APRES_TEST) {
				this.dao.deleteAll();
			}
				
		}
		catch (AbstractDaoException e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println(UTILISATEUR
						+ e.getMessageUtilisateur());
				System.out.println(TECHNIQUE 
						+ e.getMessageTechnique());
				
			}
			
			assertNotNull(MESSAGE_UTILISATEUR
					, e.getMessageUtilisateur());
			assertNotNull(MESSAGE_TECHNIQUE
					, e.getMessageTechnique());
			assertNull(MESSAGE_DOUBLON, book1Persistant);
			
		}

	} // Fin de testSaveSousClasse().______________________________________
	

	
	/**
	 * method testPersist() :<br/>
	 * <ul>
	 * Teste la méthode persist(Book pBook) :<br/>
	 * <li>garantit que persist(...) ajoute en base.</li>
	 * <li>garantit que persist(...) peut créer une instance 
	 * de sous-classe en base.</li>
	 * <li>garantit que persist(null) retourne null.</li>
	 * </ul>
	 */
	@Test
	public void testPersist() {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		try {
			
			/* Nombre initial d'objets en base. */
			final Long nombreInitial = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_INITIAL 
						+ nombreInitial);
			}
						
			/* TEST NULLITE. *****/
			final Book bookNull = null;
			this.dao.persist(bookNull);
			
			/* Nombre final d'objets en base. */
			final Long nombreFinalNull = this.dao.count();
			
			/* garantit que persist(null) ne fait rien. */
			assertEquals("nombre final == nombre initial : "
					, nombreFinalNull, nombreInitial);
			
			
			/* TEST PERSIST. ******/
			/* Instanciation d'un nouveau Book. */
			final Book book1 
				= new Book("nouveau livre persist"
						, "nouvel auteur persist");
			final SousBook book2 
				= new SousBook(
						"Title SousBook persist"
						, "Author SousBook persist"
						, "Editor SousBook persist");
			
			/* PERSISTENCE. ****/
			this.dao.persist(book1);
			/* garantit que persist(...) peut créer une instance 
			 * de sous-classe en base. */
			this.dao.persist(book2);
			
			/* Nombre final d'objets en base. */
			final Long nombreFinal = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_FINAL 
						+ nombreFinal);
			}
						
			/* garantit que persiste(...) ajoute en base. */
			assertTrue("nombre final == nombre initial + 2 : "
					, nombreFinal == nombreInitial + 2);
			
			/* VIDAGE DE LA TABLE. */
			if (DELETE_APRES_TEST) {
				this.dao.deleteAll();
			}
			
		}
		catch (AbstractDaoException e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println(UTILISATEUR 
						+ e.getMessageUtilisateur());
				System.out.println(TECHNIQUE 
						+ e.getMessageTechnique());
				
			}
			
			assertNotNull(MESSAGE_UTILISATEUR
					, e.getMessageUtilisateur());
			assertNotNull(MESSAGE_TECHNIQUE
					, e.getMessageTechnique());
						
		}
		
	} // Fin de testPersist()._____________________________________________
	

	
	/**
	 * method testPersistSousClasse() :<br/>
	 *  <ul>
	 * Teste la méthode persistSousClasse(Book pBook) :<br/>
	 * <li>garantit que persistSousClasse(...) ajoute en base.</li>
	 * <li>garantit que persistSousClasse(null) retourne null.</li>
	 * </ul>
	 */
	@Test
	public void testPersistSousClasse() {
	
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		try {
			
			/* Nombre initial d'objets en base. */
			final Long nombreInitial = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_INITIAL 
				+ nombreInitial);
			}
			
			
			/* TEST NULLITE. *****/
			final Book bookNull = null;
			final SousBook sousBookNull = null;
			
			this.dao.persistSousClasse(bookNull);
			this.dao.persistSousClasse(sousBookNull);
			
			/* Nombre final d'objets en base. */
			final Long nombreFinalNull = this.dao.count();
						
			/* garantit que persistSousClasse(null) ne fait rien. */
			assertEquals("nombre final == nombre initial : "
					, nombreFinalNull, nombreInitial);
			
			/* TEST PERSISTSOUSCLASSE. *****/
			
			/* Création de 4 livres. */
			final SousBook book1 
				= new SousBook(
						"La maison rose testPersistSousClasse"
						, "Georges Gershwin testPersistSousClasse"
						, "Calmann Lévy testPersistSousClasse");
			final SousBook book2 
				= new SousBook(
						"La maison verte testPersistSousClasse"
						, "Georges Karam testPersistSousClasse"
						, "Dunod testPersistSousClasse");
			final SousBook book3 
				= new SousBook("Ivanohe testPersistSousClasse"
						, "Walter Scott testPersistSousClasse"
						, "Dunod testPersistSousClasse");
			final Book book4 
				= new Book(
						"Papy Gonzales testPersistSousClasse"
						, "Romain Gary testPersistSousClasse");

			/* PERSISTENCE. ****/
			this.dao.persistSousClasse(book1);
			this.dao.persistSousClasse(book2);
			this.dao.persistSousClasse(book3);
			this.dao.persistSousClasse(book4);

			/* Nombre final d'objets en base. */
			final Long nombreFinal = this.dao.count();

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_FINAL
				+ nombreFinal);
			}
						
			/* garantit que persistSousClasse(...) ajoute en base. */
			assertTrue("nombre final == nombre initial + 4 : "
					, nombreFinal == nombreInitial + 4);
			
			/* VIDAGE DE LA TABLE. */
			if (DELETE_APRES_TEST) {
				this.dao.deleteAll();
			}
			
		}
		catch (AbstractDaoException e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println(UTILISATEUR 
						+ e.getMessageUtilisateur());
				System.out.println(TECHNIQUE 
						+ e.getMessageTechnique());
				
			}
			
			assertNotNull(MESSAGE_UTILISATEUR
					, e.getMessageUtilisateur());
			assertNotNull(MESSAGE_TECHNIQUE
					, e.getMessageTechnique());
						
		}
		
	} // Fin de testPersistSousClasse().___________________________________
	
	
	
	/**
	 * method testCreateReturnId() :<br/>
	 * <ul>
	 * Teste la méthode createReturnId(Book pBook) :<br/>
	 * <li>garantit que createReturnId(...) ajoute en base.</li>
	 * <li>garantit que createReturnId(...) peut créer une instance 
	 * de sous-classe en base.</li>
	 * <li>garantit que createReturnId(...) retourne un ID non null.</li>
	 * </ul>
	 */
	@Test
	public void testCreateReturnId() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		Long iD1 = null;
		Long iD2 = null;
		
		try {
			
			/* TEST NULLITE. *****/
			final Book bookNull = null;
			final Long bookNullPersistantID 
				= this.dao.createReturnId(bookNull);
			
			/* garantit que createReturnId(null) retourne null. */
			assertNull("ID de BookNullPersistant doit être null : "
					, bookNullPersistantID);
			
			/* TEST createAnsReturnID */
			/* Instanciation d'un nouveau Book. */
			final Book newBook1 
			= new Book("nouveau livre à createReturnId"
					, "nouvel auteur à createReturnId");
			final SousBook newBook2 
			= new SousBook("nouveau SousBook à createReturnId"
					, "nouvel auteur SousBookà createReturnId"
					, "nouvel Editeur SousBook createReturnId");
			
			/* PERSISTENCE. ****/
			iD1 = this.dao.createReturnId(newBook1);
			/* garantit que createReturnId(...) peut créer 
			 * une instance de sous-classe en base.*/
			iD2 = this.dao.createReturnId(newBook2);

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println("ID1 dans testCreateReturnId() : " + iD1);
				System.out.println("ID2 dans testCreateReturnId() : " + iD2);
				
			}
			
			
			/* garantit que createReturnId(...) retourne un ID non null. */
			assertNotNull("ID1 ne doit pas être null : ", iD1);
			assertNotNull("ID2 ne doit pas être null : ", iD2);
			
			/* VIDAGE DE LA TABLE. */
			if (DELETE_APRES_TEST) {
				this.dao.deleteAll();
			}
			
		}		
		catch (AbstractDaoException e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println(UTILISATEUR 
						+ e.getMessageUtilisateur());
				System.out.println(TECHNIQUE 
						+ e.getMessageTechnique());
				
			}
			
			assertNotNull(MESSAGE_UTILISATEUR
					, e.getMessageUtilisateur());
			assertNotNull(MESSAGE_TECHNIQUE
					, e.getMessageTechnique());
			
			assertNull("ID1 doit être null : "
							, iD1);
						
		}
		
	} // Fin de testCreateReturnId().______________________________________


	
	/**
	 * method testSaveIterable() :<br/>
	 * <ul>
	 * Teste la méthode save(Iterable&lt;SousBook&gt;) :<br/>
	 * <li>garantit que save(Iterable&lt;SousBook&gt;) 
	 * retourne une liste d'objets persistants.</li>
	 * <li>garantit que les instances retournées dans la 
	 * liste par save(Iterable&lt;SousBook&gt;) ont un ID.</li>
	 * <li>garantit que save(null) retourne null.</li>
	 * </ul>
	 */
	@Test
	public void testSaveIterable() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		List<Book> listeBooksPersistante = null;
		
		try {
			
			/* Nombre initial d'objets en base. */
			final Long nombreInitial = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_INITIAL 
				+ nombreInitial);
			}

			/* TEST NULLITE. *****/
			final List<SousBook> listeNull = null;
			final List<SousBook> listeNullPersistante 
				= (List<SousBook>) this.dao.save(listeNull);
			
			/* garantit que save(null) retourne null. */
			assertNull(MESSAGE_LISTE_NULL
					, listeNullPersistante);
			
			
			/* TEST SAVE. *****/
			
			/* Création de 4 livres. */
			final SousBook book1 
				= new SousBook(
						"La maison rose testSaveIterable"
						, "Georges Gershwin testSaveIterable"
						, "Calmann Lévy testSaveIterable");
			final SousBook book2 
				= new SousBook(
						"La maison verte testSaveIterable"
						, "Georges Karam testSaveIterable"
						, "Dunod testSaveIterable");
			final SousBook book3 
				= new SousBook("Ivanohe testSaveIterable"
						, "Walter Scott testSaveIterable"
						, "Dunod testSaveIterable");
			final Book book4 
				= new Book(
						"Papy Gonzales testSaveIterable"
						, "Romain Gary testSaveIterable");

			/* Création d'un Iterable. */
			final List<Book> listeBooks = new ArrayList<Book>();
			listeBooks.add(book1);
			listeBooks.add(book2);
			listeBooks.add(book3);
			listeBooks.add(book4);
			
			/* PERSISTENCE. */
			listeBooksPersistante 
				= (List<Book>) this.dao.save(listeBooks);
			
			/* Nombre final d'objets en base. */
			final Long nombreFinal = this.dao.count();

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_FINAL 
				+ nombreFinal);
				
				System.out.println();
				System.out.println("LISTE DES BOOKS ET SOUS-CLASSES : ");
				System.out.println(
						this.dao.afficherListe(listeBooksPersistante));
				System.out.println();
			}

			/* garantit que persistSousClasse(...) ajoute en base. */
			assertTrue("nombre final == nombre initial + 4 : "
					, nombreFinal == nombreInitial + 4);
			
			/* VIDAGE DE LA TABLE. */
			if (DELETE_APRES_TEST) {
				this.dao.deleteAll();
			}
			
		}			
		catch (AbstractDaoException e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println(UTILISATEUR 
						+ e.getMessageUtilisateur());
				System.out.println(TECHNIQUE 
						+ e.getMessageTechnique());
				
			}
			
			assertNotNull(MESSAGE_UTILISATEUR
					, e.getMessageUtilisateur());
			assertNotNull(MESSAGE_TECHNIQUE
					, e.getMessageTechnique());
			
			assertNull("La liste doit être null : "
							, listeBooksPersistante);
						
		}
		
	} // Fin de testSaveIterable().________________________________________

	
	
	/* READ *************/
	
	
	
	/**
	 * method testRetrieve() :<br/>
	 * <ul>
	 * Teste la méthode retrieve(Book pBook) :<br/>
	 * <li>garantit que retrieve(...) retrouve en base.</li>
	 * <li>garantit que retrieve(...) retrouve 
	 * les sous-classes de T en base.</li>
	 * <li>garantit que retrieve(inexistant) retourne null.</li>
	 * <li>garantit que le Book retrouvé a un ID (persistent).</li>
	 * </ul>
	 */
	@Test
	public void testRetrieve() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		Book book1Retrieve = null;
		Book book2Retrieve = null;
		Book bookInexistantRetrieve = null;
		
		try {
			
			/* Instanciation d'un nouveau Book. */
			final Book book1 
			= new Book("nouveau livre à retrieve"
					, "nouvel auteur à retrieve");
			final SousBook book2 
				= new SousBook(
						"nouveau Titre SousBook retrieve"
						, "nouvel auteur SousBook retrieve"
						, "nouvel editor SousBook retrieve");
			final Book bookInexistant 
			= new Book("nouveau livre Inexistant à retrieve"
					, "nouvel auteur Inexistant à retrieve");
			
			
			/* PERSISTENCE. ****/
			this.dao.persist(book1);
			this.dao.persist(book2);
			
			/* RETRIEVE. ****/
			book1Retrieve = this.dao.retrieve(book1);
			book2Retrieve = this.dao.retrieve(book2);
			bookInexistantRetrieve = this.dao.retrieve(bookInexistant);
			
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println();
				System.out.println("LIVRE RETROUVE : " 
						+ book1Retrieve.toString());
				System.out.println("SOUS-BOOK RETROUVE : " 
						+ book2Retrieve.toString());
				if (bookInexistantRetrieve == null) {
					System.out.println("BOOK INEXISTANT : NULL");
				}
				System.out.println();

			}
			
			/* garantit que retrieve(...) retrouve en base. */
			assertNotNull(MESSAGE_BOOK_NON_NULL
					, book1Retrieve);
			/* garantit que retrieve(...) retrouve 
			 * les sous-classes de T en base. */
			assertNotNull(MESSAGE_BOOK_NON_NULL
					, book2Retrieve);
			/* garantit que retrieve(inexistant) retourne null. */
			assertNull("Book inexistant doit retourner null : "
					, bookInexistantRetrieve);
			
			/* garantit que le Book retrouvé a un ID (persistent). */
			assertNotNull(MESSAGE_ID_BOOK_NON_NULL
					, book1Retrieve.getId());
			assertNotNull(MESSAGE_ID_BOOK_NON_NULL
					, book2Retrieve.getId());
			
			/* VIDAGE DE LA TABLE. */
			if (DELETE_APRES_TEST) {
				this.dao.deleteAll();
			}
						
		}
		catch (AbstractDaoException e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println(UTILISATEUR 
						+ e.getMessageUtilisateur());
				System.out.println(TECHNIQUE 
						+ e.getMessageTechnique());
				
			}
			
			assertNotNull(MESSAGE_UTILISATEUR
					, e.getMessageUtilisateur());
			assertNotNull(MESSAGE_TECHNIQUE
					, e.getMessageTechnique());
			
			assertNull("La livre doit être null : "
							, book1Retrieve);
						
		}
		
	} // Fin de testRetrieve().____________________________________________
	

	
	/**
	 * method testRetrieveByIdMetier() :<br/>
	 * <ul>
	 * Teste la méthode retrieve(Book pBook) :<br/>
	 * <li>garantit que retrieve(...) retrouve en base.</li>
	 * <li>garantit que le Book retrouvé a un ID (persistent).</li>
	 * </ul>
	 */
	@Test
	public void testRetrieveByIdMetier() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		Book book1Retrieve = null;
		Book book2Retrieve = null;
		Book bookInexistantRetrieveId = null;
		
		try {
			
			/* Instanciation d'un nouveau Book. */
			final Book book1 
			= new Book("nouveau livre à retrieveByIdMetier"
					, "nouvel auteur à retrieveByIdMetier");
			final SousBook book2 
			= new SousBook(
					"nouveau SousBook à retrieveByIdMetier"
					, "nouvel auteur SousBook retrieveByIdMetier"
					, "nouvel éditeur SousBook retrieveByIdMetier");
			final Book bookInexistant 
			= new Book("nouveau livre Inexistant à retrieveByIdMetier"
					, "nouvel auteur Inexistant à retrieveByIdMetier");
			
			/* PERSISTENCE. ****/
			this.dao.persist(book1);
			this.dao.persist(book2);
			
			/* RETRIEVEBYIDMETIER. ****/
			book1Retrieve = this.dao.retrieve(book1);
			book2Retrieve = this.dao.retrieve(book2);
			bookInexistantRetrieveId = this.dao.retrieve(bookInexistant);
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println();
				System.out.println("LIVRE RETROUVE : " 
						+ book1Retrieve.toString());
				System.out.println("SOUS-BOOK RETROUVE : " 
						+ book2Retrieve.toString());
				if (bookInexistantRetrieveId == null) {
					System.out.println("BOOK INEXISTANT : NULL");
				}
				System.out.println();

			}			

			/* garantit que retrieve(...) retrouve en base. */
			assertNotNull(MESSAGE_BOOK_NON_NULL
					, book1Retrieve);
			assertNotNull(MESSAGE_BOOK_NON_NULL
					, book2Retrieve);
			/* garantit que retrieveByIdMetier(inexistant) retourne null. */
			assertNull("Book inexistant doit retourner null : "
					, bookInexistantRetrieveId);
			
			/* garantit que le Book retrouvé a un ID (persistent). */
			assertNotNull(MESSAGE_ID_BOOK_NON_NULL
						, book1Retrieve.getId());
			assertNotNull(MESSAGE_ID_BOOK_NON_NULL
					, book2Retrieve.getId());
			
			/* VIDAGE DE LA TABLE. */
			if (DELETE_APRES_TEST) {
				this.dao.deleteAll();
			}
			
		}
		catch (AbstractDaoException e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println(UTILISATEUR 
						+ e.getMessageUtilisateur());
				System.out.println(TECHNIQUE 
						+ e.getMessageTechnique());
				
			}
			
			assertNotNull(MESSAGE_UTILISATEUR
					, e.getMessageUtilisateur());
			assertNotNull(MESSAGE_TECHNIQUE
					, e.getMessageTechnique());
			
			assertNull("La livre doit être null : "
							, book1Retrieve);
						
		}
		
	} // Fin de testRetrieveByIdMetier().__________________________________


	
	/**
	 * method testFindById() :<br/>
	 * <ul>
	 * Teste la méthode findById(ID) :<br/>
	 * <li>garantit que findById(...) retrouve en base.</li>
	 * <li>garantit que findById(id Inexistant) retourne null.</li>
	 * <li>garantit que findById(Sous-Classe) retrouve en base.</li>
	 * <li>garantit que le Book retrouvé a un ID (persistent).</li>
	 * </ul>
	 */
	@Test
	public void testFindById() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		Book bookPersistant1 = null;
		Book bookPersistantInexistant = null;
		Book bookPersistant2 = null;
		
		try {
			
			/* Instanciation d'un nouveau Book. */
			final Book newBook1 
			= new Book("nouveau livre testFindById"
					, "nouvel auteur testFindById");
			
			final SousBook newSousBook2 
			= new SousBook(
					"nouveau SousBook testFindById"
					, "nouvel auteur SousBook testFindById"
					, "nouvel editor SousBook testFindById");
			
			/* PERSISTENCE. ****/
			final Long iD1 = this.dao.createReturnId(newBook1);
			final Long idInexistant = 20000L;
			final Long iD2 = this.dao.createReturnId(newSousBook2);
			
			/* FindById. */
			bookPersistant1 = this.dao.findById(iD1);
			/* garantit que findById(id Inexistant) retourne null. */
			bookPersistantInexistant = this.dao.findById(idInexistant);
			/* garantit que findById(Sous-Classe) retrouve en base. */
			bookPersistant2 = this.dao.findById(iD2);
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println();
				System.out.println("ID1 LIVRE A RETROUVER : " 
						+ iD1);
				System.out.println("BOOK1 RETROUVE : " 
						+ bookPersistant1.toString());
				System.out.println();
				System.out.println("ID INEXISTANT A RETROUVER : " 
						+ idInexistant);
				if (bookPersistantInexistant == null) {
					System.out.println("BOOK INEXISTANT RETROUVE : NULL");
				}				
				System.out.println();
				System.out.println("ID2 SOUS-BOOK A RETROUVER : " 
						+ iD2);
				System.out.println("SOUS-BOOK2 RETROUVE : " 
						+ bookPersistant2.toString());

			}
			
			assertEquals(
					"Même Book : "
					, newBook1, bookPersistant1);
			assertNull(
					"Id inexistant doit retourner null : "
					, bookPersistantInexistant);
			assertEquals(
					"Même Sous-Book : "
					, newSousBook2, bookPersistant2);
			
			/* garantit que findById(...) retrouve en base. */
			assertNotNull(MESSAGE_BOOK_NON_NULL
					, bookPersistant1);
			
			/* garantit que le Book retrouvé a un ID (persistent). */
			assertNotNull(MESSAGE_ID_BOOK_NON_NULL
						, bookPersistant1.getId());
			
			/* VIDAGE DE LA TABLE. */
			if (DELETE_APRES_TEST) {
				this.dao.deleteAll();
			}
			
		}
		catch (AbstractDaoException e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println(UTILISATEUR 
						+ e.getMessageUtilisateur());
				System.out.println(TECHNIQUE 
						+ e.getMessageTechnique());
				
			}
			
			assertNotNull(MESSAGE_UTILISATEUR
					, e.getMessageUtilisateur());
			assertNotNull(MESSAGE_TECHNIQUE
					, e.getMessageTechnique());
			
		}
				
	} // Fin de testFindById().____________________________________________


	
	/**
	 * method testGetOne() :<br/>
	 * <ul>
	 * Teste la méthode getOne(ID) :<br/>
	 * <li>garantit que getOne(...) retrouve en base.</li>
	 * <li>garantit que le Book retrouvé a un ID (persistent).</li>
	 * </ul>
	 */
	@Test
	public void testGetOne() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		Book bookPersistant1 = null;
		
		try {
			
			/* Instanciation d'un nouveau Book. */
			final Book newBook1 
			= new Book("nouveau livre testGetOne"
					, "nouvel auteur testGetOne");
			
			/* PERSISTENCE. ****/
			final Long iD1 = this.dao.createReturnId(newBook1);
			
			/* getOne. */
			bookPersistant1 = this.dao.getOne(iD1);
			
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println();
				System.out.println("ID1 LIVRE A RETROUVER : " 
						+ iD1);
				System.out.println("BOOK1 RETROUVE : " 
						+ bookPersistant1.toString());

			}

			
			assertEquals("Même objet", newBook1, bookPersistant1);
			
			/* garantit que getOne(...) retrouve en base. */
			assertNotNull(MESSAGE_BOOK_NON_NULL
					, bookPersistant1);
			
			/* garantit que le Book retrouvé a un ID (persistent). */
			assertNotNull(MESSAGE_ID_BOOK_NON_NULL
						, bookPersistant1.getId());
			
			/* VIDAGE DE LA TABLE. */
			if (DELETE_APRES_TEST) {
				this.dao.deleteAll();
			}
			
		}
		catch (AbstractDaoException e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println(UTILISATEUR 
						+ e.getMessageUtilisateur());
				System.out.println(TECHNIQUE 
						+ e.getMessageTechnique());
				
			}
			
			assertNotNull(MESSAGE_UTILISATEUR
					, e.getMessageUtilisateur());
			assertNotNull(MESSAGE_TECHNIQUE
					, e.getMessageTechnique());
			
		}
					
	} // Fin de testGetOne().______________________________________________
	
	
	
	/**
	 * method testFindAll() :<br/>
	 * <ul>
	 * Teste la méthode findAll() :<br/>
	 * <li>garantit que findAll() retourne la liste 
	 * de tous les Books en base.</li>
	 * <li>garantit que findAll() retourne aussi les 
	 * sous-classes de T.</li>
	 * </ul>
	 */
	@Test
	public void testFindAll() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
				
		try {
			
			/* Nombre initial d'objets en base. */
			final Long nombreInitial = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_INITIAL 
						+ nombreInitial);
			}

			/* Création de 4 livres. */
			final Book book1 = new Book("La maison testFindAll"
					, "Georges testFindAll");
			final Book book2 = new Book("La maison testFindAll2"
					, "Georges testFindAll2");
			final Book book3 = new Book("Ivanohe testFindAll"
					, "Walter Scott testFindAll");
			final SousBook book4 
			= new SousBook(
					"title SousBook testFindAll"
					, "author SousBook testFindAll"
					, "editor SousBook testFindAll");
					
			/* PERSISTENCE. ****/
			this.dao.create(book1);
			this.dao.create(book2);
			this.dao.create(book3);
			this.dao.create(book4);
			
			/* Nombre final d'objets en base. */
			final Long nombreFinal = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_FINAL 
						+ nombreFinal);
			}
			
			final List<Book> listeTousBooks = this.dao.findAll();
			/* garantit que findAll() retourne aussi les sous-classes de T. */
			final int tailleListe = listeTousBooks.size();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println();
				System.out.println("LISTE DES BOOKS EN BASE : ");
				System.out.println(this.dao.afficherListe(listeTousBooks));
				System.out.println();
				
			}
						
			/* garantit que findAll() retourne la liste 
			 * de tous les Books en base. */
			assertTrue("nombreFinal == nombreInitial + 4 (findAll()) : "
					, nombreFinal == nombreInitial + 4);
			assertTrue("tailleListe == nombreFinal : "
					, tailleListe == nombreFinal);
			
			/* VIDAGE DE LA TABLE. */
			if (DELETE_APRES_TEST) {
				this.dao.deleteAll();
			}
			
		}
		catch (AbstractDaoException e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println(UTILISATEUR 
						+ e.getMessageUtilisateur());
				System.out.println(TECHNIQUE 
						+ e.getMessageTechnique());
				
			}
			
			assertNotNull(MESSAGE_UTILISATEUR
					, e.getMessageUtilisateur());
			assertNotNull(MESSAGE_TECHNIQUE
					, e.getMessageTechnique());
			
		}
		
	} // Fin de testFindAll()._____________________________________________
	

	
	/**
	 * method testfindAllMaxMax() :<br/>
	 * <ul>
	 * Teste la méthode findAllMax() :<br/>
	 * <li>garantit que findAllMax(...) retourne la liste 
	 * des pMax premiers Books en base 
	 * si pMax <= nbre enregistrements.</li>
	 * <li>garantit que findAllMax(...) retourne la liste 
	 * de tous les Books en base si pMax > nombre d'enregistrements.</li>
	 * </ul>
	 */
	@Test
	public void testfindAllMax() {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
						
		try {
			
			/* Nombre initial d'objets en base. */
			final Long nombreInitial = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_INITIAL 
						+ nombreInitial);
			}

			/* Création de 4 livres. */
			final Book book1 = new Book("La maison testfindAllMax"
					, "Georges testfindAllMax");
			final Book book2 = new Book("La poupée testfindAllMax"
					, "Brigitte testfindAllMax");
			final Book book3 = new Book("Ivanohe testfindAllMax"
					, "Walter Scott testfindAllMax");
			final SousBook book4 
				= new SousBook("Title SousBook testfindAllMax"
					, "Author SousBook testfindAllMax"
					, "Editor SousBook testfindAllMax");
					
			/* PERSISTENCE. ****/
			this.dao.create(book1);
			this.dao.create(book2);
			this.dao.create(book3);
			this.dao.create(book4);
			
			/* Nombre final d'objets en base. */
			final Long nombreFinal = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_FINAL 
						+ nombreFinal);
			}
			
			
			final Long max = 2L;
			final List<Book> listeBooksMax2 = this.dao.findAllMax(max);
			final int tailleListe = listeBooksMax2.size();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println();
				System.out.println("LISTE DES BOOKS EN BASE LIMITEE A : " + max);
				System.out.println(this.dao.afficherListe(listeBooksMax2));
				System.out.println();

			}
			
			
			/* garantit que findAllMax(...) retourne la liste 
			 * des pMax premiers Books en base 
			 * si pMax <= nbre enregistrements. */
			assertTrue("nombreFinal == nombreInitial + 4 : "
					, nombreFinal == nombreInitial + 4);
			
			assertTrue("tailleListe == max : "
					, tailleListe == max);
			
			
			final Long max7 = nombreFinal + 7L;
			final List<Book> listeBooksMax7 = this.dao.findAllMax(max7);
			final int tailleListe7 = listeBooksMax7.size();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println();
				System.out.println("LISTE DES BOOKS EN BASE LIMITEE A : " + max7);
				System.out.println(this.dao.afficherListe(listeBooksMax7));
				System.out.println();
				
			}
						
			/* garantit que findAllMax(...) retourne la liste 
			 * de tous les Books en base si pMax > nombre d'enregistrements. */
			assertTrue("tailleListe7 == nombreFinal : "
					, tailleListe7 == nombreFinal);
			
			/* VIDAGE DE LA TABLE. */
			if (DELETE_APRES_TEST) {
				this.dao.deleteAll();
			}
			
		}
		catch (AbstractDaoException e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println(UTILISATEUR 
						+ e.getMessageUtilisateur());
				System.out.println(TECHNIQUE 
						+ e.getMessageTechnique());
				
			}
			
			assertNotNull(MESSAGE_UTILISATEUR
					, e.getMessageUtilisateur());
			assertNotNull(MESSAGE_TECHNIQUE
					, e.getMessageTechnique());
			
		}
		
	} // Fin de testfindAllMaxMax()._____________________________________________
	
	

	/**
	 * method testFindAllIterable() :<br/>
	 * <ul>
	 * Teste la méthode findAll(Iterable&lt;ID&gt;) :<br/>
	 * <li>garantit que findAllIterable&lt;ID&gt;) retourne la liste 
	 * d'objets métier ayant les ID passés en paramètre 
	 * si ils ont existants en base.</li>
	 * </ul>
	 */
	@Test
	public void testFindAllIterable() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
						
		try {
			
			/* Nombre initial d'objets en base. */
			final Long nombreInitial = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_INITIAL 
						+ nombreInitial);
			}


			/* Création de 4 livres. */
			final Book book1 = new Book("La maison testFindAllIterable"
					, "Georges testFindAllIterable");
			final Book book2 = new Book("La poupée testFindAllIterable"
					, "Brigitte testFindAllIterable");
			final Book book3 = new Book("Ivanohe testFindAllIterable"
					, "Walter Scott testFindAllIterable");
			final SousBook book4 = new SousBook(
					"Papy Gonzales testFindAllIterable"
					, "Romain Gary testFindAllIterable"
					, "Editeur SousBook testFindAllIterable");
					
			/* PERSISTENCE. ****/
			final Long id1 = this.dao.createReturnId(book1);
			this.dao.createReturnId(book2);
			final Long id3 = this.dao.createReturnId(book3);
			final Long id4 = this.dao.createReturnId(book4);
			
			final Long idInexistant = 20000L;
			
			/* Constitution d'un Iterable<ID>. */
			final List<Long> listIDs = new ArrayList<Long>();
			listIDs.add(id1);
			listIDs.add(id3);
			listIDs.add(id4);
			listIDs.add(idInexistant);
			
			/* Nombre final d'objets en base. */
			final Long nombreFinal = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_FINAL 
						+ nombreFinal);
			}

			
			/* récupération de la liste des livres. */
			final List<Book> listeBooks 
				= (List<Book>) this.dao.findAll(listIDs);
			
			final int tailleListe = listeBooks.size();

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println();
				System.out.println("LISTE DES BOOKS TROUVES EN BASE : ");
				System.out.println(this.dao.afficherListe(listeBooks));
				System.out.println();
				
			}
						
			/* garantit que findAllIterable&lt;ID&gt;) retourne la liste 
			 * d'objets métier ayant les ID passés en paramètre 
			 * si ils ont existants en base. */
			assertTrue("nombreFinal == nombreInitial + 4 : "
					, nombreFinal == nombreInitial + 4);
			assertTrue("tailleListe == 3 : "
					, tailleListe == 3);
			
			/* VIDAGE DE LA TABLE. */
			if (DELETE_APRES_TEST) {
				this.dao.deleteAll();
			}
			
		}
		catch (AbstractDaoException e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println(UTILISATEUR 
						+ e.getMessageUtilisateur());
				System.out.println(TECHNIQUE 
						+ e.getMessageTechnique());
				
			}
			
			assertNotNull(MESSAGE_UTILISATEUR
					, e.getMessageUtilisateur());
			assertNotNull(MESSAGE_TECHNIQUE
					, e.getMessageTechnique());
			
		}
		
	} // Fin de testFindAll()._____________________________________________
	


	/* UPDATE *************/

	
	/**
	 * method testUpdate() :<br/>
	 * <ul>
	 * Teste la méthode update(Book pBook) :<br/>
	 * <li>garantit que update(...) retourne l'instance 
	 * persistante modifiée.</li>
	 * <li>garantit que les instances retournées par 
	 * update(...) ont un ID.</li>
	 * <li>garantit que update(null) retourne null.</li>
	 * </ul>
	 */
	@Test
	public void testUpdate() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
								
		try {
			
			/* Nombre initial d'objets en base. */
			final Long nombreInitial = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_INITIAL 
						+ nombreInitial);
			}

			/* Création de 4 livres. */
			final Book book1 = new Book("La maison testUpdate"
					, "Georges testtestUpdate");
			final Book book2 = new Book("La poupée testUpdate"
					, "Brigitte testUpdate");
			final Book book3 = new Book("Ivanohe testUpdate"
					, "Walter Scott testUpdate");
			final SousBook book4 
				= new SousBook(
						"title SousBook testUpdate"
						, "author SousBook testUpdate"
						, "editor SousBook testUpdate");
					
			/* PERSISTENCE. ****/
			this.dao.create(book1);
			this.dao.create(book2);
			this.dao.create(book3);
			this.dao.create(book4);
			
			/* Nombre final d'objets en base. */
			final Long nombreFinal = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_FINAL 
						+ nombreFinal);
			}
			
			assertTrue("nombreFinal == nombreInitial + 4 : "
					, nombreFinal == nombreInitial + 4);
			
			/* TEST NULLITE. *****/
			final Book bookNull = null;
			final Book bookNullPersistant = this.dao.update(bookNull);
			
			/* garantit que update(null) retourne null. */
			assertNull("BookNullPersistant doit être null : "
					, bookNullPersistant);

			/* TEST UPDATE. ******/
			final Book book1AModifier = this.dao.retrieve(book1);
			final SousBook book4AModifier 
				= (SousBook) this.dao.retrieve(book4);
			
			/* Modification. */
			final String title1Modifie = "La maison testUpdate modifié";
			final String author1Modifie = "Georges testtestUpdate modifié";
			book1AModifier.setTitle(title1Modifie);
			book1AModifier.setAuthor(author1Modifie);
			
			final String title4Modifie = "title SousBook testUpdate modifié";
			final String author4Modifie = "author SousBook testUpdate modifié";
			final String editor4Modifie = "editor SousBook testUpdate modifié";
			book4AModifier.setTitle(title4Modifie);
			book4AModifier.setAuthor(author4Modifie);
			book4AModifier.setEditor(editor4Modifie);
			
			/* PERSISTENCE DE LA MODIFICATION. */
			final Book book1AModifierEnBase 
				= this.dao.update(book1AModifier);
			final SousBook book4AModifierEnBase 
				= (SousBook) this.dao.update(book4AModifier);
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println();
				System.out.println("BOOK1 MODIFIE EN BASE : " 
						+ book1AModifierEnBase.toString());
				System.out.println("SOUS-BOOK4 MODIFIE EN BASE : " 
						+ book4AModifierEnBase.toString());
				System.out.println();
				
			}
			
			
			/* garantit que update(...) retourne l'instance 
			 * persistante modifiée.*/
			assertEquals("titleModifie modifié : "
					, title1Modifie
						, book1AModifierEnBase.getTitle());
			
			assertEquals("authorModifie modifié : "
					, author1Modifie
						, book1AModifierEnBase.getAuthor());
			
			assertEquals("titleModifie modifié : "
					, title4Modifie
						, book4AModifierEnBase.getTitle());
			
			assertEquals("authorModifie modifié : "
					, author4Modifie
						, book4AModifierEnBase.getAuthor());
			
			assertEquals("editorModifie modifié : "
					, editor4Modifie
						, book4AModifierEnBase.getEditor());
			
			/* garantit que les instances retournées par 
			 * update(...) ont un ID.*/
			assertNotNull("ID non null : ", book1AModifierEnBase.getId());
			assertNotNull("ID non null : ", book4AModifierEnBase.getId());
			
			/* VIDAGE DE LA TABLE. */
			if (DELETE_APRES_TEST) {
				this.dao.deleteAll();
			}
			
		}
		catch (AbstractDaoException e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println(UTILISATEUR 
						+ e.getMessageUtilisateur());
				System.out.println(TECHNIQUE 
						+ e.getMessageTechnique());
				
			}
			
			assertNotNull(MESSAGE_UTILISATEUR
					, e.getMessageUtilisateur());
			assertNotNull(MESSAGE_TECHNIQUE
					, e.getMessageTechnique());
			
		}
				
	} // Fin de testUpdate().______________________________________________


	
	
	/**
	 * method testDelete() :<br/>
	 * <ul>
	 * Teste la méthode delete(Book pBook) :<br/>
	 * <li>garantit que delete(...) détruit l'instance 
	 * persistante.</li>
	 * <li>garantit que delete(inexistant) retourne false.</li>
	 * </ul>
	 */
	@Test
	public void testDelete() {
		
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		boolean deleteInexistant = true;
		boolean deleteBook1 = true;
		boolean deleteBook2 = true;
		
		try {
			
			/* Nombre initial d'objets en base. */
			final Long nombreInitial = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_INITIAL 
						+ nombreInitial);
			}

			final Book book1 
				= new Book(
						"title Book1 delete"
						, "Author Book1 delete");
			final Book bookInexistant 
				= new Book(
						"title Book inexistant"
						, "Author Book inexistant");
			final SousBook book2 
				= new SousBook(
						"title SousBook2 delete"
						, "Author SousBook2 delete"
						, "Editor SousBook2 delete");
			final SousBook book3 
			= new SousBook(
					"title SousBook3 delete"
					, "Author SousBook3 delete"
					, "Editor SousBook3 delete");
			
			/* PERSISTENCE. */
			this.dao.persist(book1);
			this.dao.persist(book2);
			this.dao.persist(book3);
			
			/* Nombre final d'objets en base. */
			final Long nombreApresCreate = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println("NOMBRE APRES CREATION DE 3 BOOKS : " 
						+ nombreApresCreate);
			}
			
			assertTrue("nombreApresCreate == nombreInitial + 3 : "
					, nombreApresCreate == nombreInitial + 3);

			/* DELETE. */
			deleteInexistant = this.dao.delete(bookInexistant);
			deleteBook1 = this.dao.delete(book1);
			deleteBook2 = this.dao.delete(book2);
			
			/* Nombre final d'objets en base. */
			final Long nombreFinal = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_FINAL 
						+ nombreFinal);
			}

			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println();
				System.out.println("DESTRUCTION DE L'INEXISTANT : " 
						+ deleteInexistant);
				System.out.println("DESTRUCTION DE BOOK1 : " 
						+ deleteBook1);
				System.out.println("DESTRUCTION DE BOOK2 : " 
						+ deleteBook2);
				System.out.println();
				
			}
			
			/* garantit que delete(...) détruit l'instance persistante.*/
			/* garantit que delete(inexistant) retourne false. */			
			assertTrue("nombreFinal == nombreApresCreate - 2 : "
					, nombreFinal == nombreApresCreate - 2);
			
			/* VIDAGE DE LA TABLE. */
			if (DELETE_APRES_TEST) {
				this.dao.deleteAll();
			}
						
		}
		catch (AbstractDaoException e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println(UTILISATEUR 
						+ e.getMessageUtilisateur());
				System.out.println(TECHNIQUE 
						+ e.getMessageTechnique());
				
			}
			
			assertNotNull(MESSAGE_UTILISATEUR
					, e.getMessageUtilisateur());
			assertNotNull(MESSAGE_TECHNIQUE
					, e.getMessageTechnique());
			
		}
		
	} // Fin de testDelete().______________________________________________
	
	
	
	/**
	 * method testDeleteById() :<br/>
	 * <ul>
	 * Teste la méthode deleteById(ID) :<br/>
	 * <li>garantit que deleteById(...) détruit l'instance 
	 * persistante.</li>
	 * <li>garantit que deleteById(...) détruit l'instance 
	 * persistante DESCENDANTE.</li>
	 * <li>garantit que deleteById(inexistant) ne fait rien.</li>
	 * </ul>
	 */
	@Test
	public void testDeleteById() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		
		try {
			
			/* Nombre initial d'objets en base. */
			final Long nombreInitial = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_INITIAL 
						+ nombreInitial);
			}

			final Book book1 
				= new Book(
						"title Book1 deleteById"
						, "Author Book1 deleteById");
			final SousBook book2 
				= new SousBook(
						"title SousBook2 deleteById"
						, "Author SousBook2 deleteById"
						, "Editor SousBook2 deleteById");
			final SousBook book3 
			= new SousBook(
					"title SousBook3 deleteById"
					, "Author SousBook3 deleteById"
					, "Editor SousBook3 deleteById");
			
			/* PERSISTENCE. */
			final Long iD1 = this.dao.createReturnId(book1);
			final Long iD2 = this.dao.createReturnId(book2);
			final Long iD3 = this.dao.createReturnId(book3);
			final Long iDInexistant = 20000L;
			
			/* Nombre final d'objets en base. */
			final Long nombreApresCreate = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println("NOMBRE APRES CREATION DE 3 BOOKS : " 
						+ nombreApresCreate);
			}

			/* DELETE. */
			this.dao.deleteById(iDInexistant);
			this.dao.deleteById(iD1);
			this.dao.deleteById(iD3);
			
			/* Nombre final d'objets en base. */
			final Long nombreFinal = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_FINAL 
						+ nombreFinal);
			}

			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				final List<Book> listeBooks = this.dao.findAll();
				
				System.out.println();
				System.out.println("ID DU BOOK2 : " + iD2);
				System.out.println(LISTE_BOOKS);
				System.out.println(this.dao.afficherListe(listeBooks));
				System.out.println();
				
			}
			
			/* garantit que delete(...) détruit l'instance persistante.*/
			/* garantit que delete(...) détruit l'instance persistante 
			 * DESCENDANTE.*/
			/* garantit que delete(inexistant) ne fait rien. */			
			assertTrue("nombreFinal == nombreApresCreate - 2 : "
					, nombreFinal == nombreApresCreate - 2);
			
			/* VIDAGE DE LA TABLE. */
			if (DELETE_APRES_TEST) {
				this.dao.deleteAll();
			}
						
		}
		catch (AbstractDaoException e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println(UTILISATEUR 
						+ e.getMessageUtilisateur());
				System.out.println(TECHNIQUE 
						+ e.getMessageTechnique());
				
			}
			
			assertNotNull(MESSAGE_UTILISATEUR
					, e.getMessageUtilisateur());
			assertNotNull(MESSAGE_TECHNIQUE
					, e.getMessageTechnique());
			
		}

	} // Fin de testDeleteById().__________________________________________
	

	
	/**
	 * method testDeleteByIdBoolean() :<br/>
	 * <ul>
	 * Teste la méthode deleteByIdBoolean(ID) :<br/>
	 * <li>garantit que deleteByIdBoolean(...) détruit l'instance 
	 * persistante et retourne true.</li>
	 * <li>garantit que deleteByIdBoolean(...) détruit l'instance 
	 * persistante DESCENDANTE et retourne true.</li>
	 * <li>garantit que deleteByIdBoolean(inexistant) ne fait rien 
	 * et retourne false.</li>
	 */
	@Test
	public void testDeleteByIdBoolean() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		boolean deleteInexistant = true;
		boolean deleteId1 = false;
		boolean deleteId3 = false;
		
		try {
			
			/* Nombre initial d'objets en base. */
			final Long nombreInitial = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_INITIAL 
						+ nombreInitial);
			}

			final Book book1 
				= new Book(
						"title Book1 deleteByIdBoolean"
						, "Author Book1 deleteByIdBoolean");
			final SousBook book2 
				= new SousBook(
						"title SousBook2 deleteByIdBoolean"
						, "Author SousBook2 deleteByIdBoolean"
						, "Editor SousBook2 deleteByIdBoolean");
			final SousBook book3 
			= new SousBook(
					"title SousBook3 deleteByIdBoolean"
					, "Author SousBook3 deleteByIdBoolean"
					, "Editor SousBook3 deleteByIdBoolean");
			
			/* PERSISTENCE. */
			final Long iD1 = this.dao.createReturnId(book1);
			final Long iD2 = this.dao.createReturnId(book2);
			final Long iD3 = this.dao.createReturnId(book3);
			final Long iDInexistant = 20000L;
			
			/* Nombre final d'objets en base. */
			final Long nombreApresCreate = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println("NOMBRE APRES CREATION DE 3 BOOKS : " 
						+ nombreApresCreate);
			}

			/* DELETE. */
			deleteInexistant = this.dao.deleteByIdBoolean(iDInexistant);
			deleteId1 = this.dao.deleteByIdBoolean(iD1);
			deleteId3 = this.dao.deleteByIdBoolean(iD3);
			
			/* Nombre final d'objets en base. */
			final Long nombreFinal = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_FINAL 
						+ nombreFinal);
			}

			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				final List<Book> listeBooks = this.dao.findAll();
				
				System.out.println();
				System.out.println("ID DU BOOK2 : " + iD2);
				System.out.println(LISTE_BOOKS);
				System.out.println(this.dao.afficherListe(listeBooks));
				System.out.println();
				
			}

			/* garantit que deleteByIdBoolean(...) détruit l'instance 
			 * persistante et retourne true.*/
			assertTrue("deleteId1 doit valoir true : "
					, deleteId1);
			
			/* garantit que deleteByIdBoolean(...) détruit l'instance 
			 * persistante DESCENDANTE et retourne true.*/
			assertTrue("deleteId3 doit valoir true : "
					, deleteId3);
			
			/* garantit que deleteByIdBoolean(inexistant) ne fait rien 
			 * et retourne false.*/
			assertFalse("deleteInexistant doit valoir false : "
					, deleteInexistant);
			
			assertTrue("nombreFinal == nombreApresCreate - 2 : "
					, nombreFinal == nombreApresCreate - 2);
			
			/* VIDAGE DE LA TABLE. */
			if (DELETE_APRES_TEST) {
				this.dao.deleteAll();
			}
			
		}
		catch (AbstractDaoException e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println(UTILISATEUR 
						+ e.getMessageUtilisateur());
				System.out.println(TECHNIQUE 
						+ e.getMessageTechnique());
				
			}
			
			assertNotNull(MESSAGE_UTILISATEUR
					, e.getMessageUtilisateur());
			assertNotNull(MESSAGE_TECHNIQUE
					, e.getMessageTechnique());
			
		}

	} // Fin de testDeleteByIdBoolean().___________________________________
	

	
	/**
	 * method testDeleteAll() :<br/>
	 * <ul>
	 * Teste la méthode deleteAll() :<br/>
	 * <li>garantit que deleteAll(...) détruit 
	 * toutes les instance persistantes.</li>
	 * <li>garantit que deleteAll(...) détruit 
	 * toutes les instance persistante DESCENDANTES.</li>
	 */
	@Test
	public void testDeleteAll() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		Book book1Persistant = null;
		Book book2Persistant = null;
		Book book3Persistant = null;
		Book book4Persistant = null;
		
		try {
			
			/* Nombre initial d'objets en base. */
			final Long nombreInitial = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_INITIAL 
						+ nombreInitial);
			}

			
			/* Création de 4 livres. */
			final Book book1 
				= new Book(
						"La maison rose deleteAll"
						, "Georges Gershwin deleteAll");
			final Book book2 
				= new Book(
						"La maison verte deleteAll"
						, "Georges Karam deleteAll");
			final Book book3 
				= new Book(
						"Ivanohe deleteAll"
						, "Walter Scott deleteAll");
			final SousBook book4 
				= new SousBook(
						"titre sousBook deleteAll"
						, "auteur sousBook deleteAll"
						, "editeur sousBook deleteAll");
					
			/* PERSISTENCE. ****/
			book1Persistant = this.dao.create(book1);
			book2Persistant = this.dao.create(book2);
			book3Persistant = this.dao.create(book3);
			book4Persistant = this.dao.create(book4);
			
			/* Nombre final d'objets en base. */
			final Long nombreApresCreate = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(QBOOKS 
						+ nombreApresCreate);
			}

			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println();
				System.out.println("CREATION DES LIVRES");
				System.out.println(book1Persistant.toString());
				System.out.println(book2Persistant.toString());
				System.out.println(book3Persistant.toString());
				System.out.println(book4Persistant.toString());
				System.out.println();
				
				final List<Book> listeLivres = this.dao.findAll();
				
				System.out.println();
				System.out.println("LIVRES EN BASE");
				System.out.println(this.dao.afficherListe(listeLivres));
				System.out.println();
				
			}

			/* DESTRUCTION. */
			this.dao.deleteAll();
			
			/* Nombre final d'objets en base. */
			final Long nombreFinal = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_FINAL 
						+ nombreFinal);
			}
			
			/* garantit que deleteAll(...) détruit toutes 
			 * les instance persistantes. */
			/* garantit que deleteAll(...) détruit toutes 
			 * les instance persistante DESCENDANTES. */
			assertEquals("0 livres en base : "
					, Long.valueOf(0L)
						, nombreFinal);
			
			/* VIDAGE DE LA TABLE. */
			if (DELETE_APRES_TEST) {
				this.dao.deleteAll();
			}
		
		}
		
		catch (AbstractDaoException e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println(UTILISATEUR 
						+ e.getMessageUtilisateur());
				System.out.println(TECHNIQUE 
						+ e.getMessageTechnique());
				
			}
			
			assertNotNull(MESSAGE_UTILISATEUR
					, e.getMessageUtilisateur());
			assertNotNull(MESSAGE_TECHNIQUE
					, e.getMessageTechnique());
			assertNull(MESSAGE_DOUBLON, book1Persistant);
			
		}
		
	} // Fin de testDeleteAll().___________________________________________
	

	
	/**
	 * method testDeleteAllBoolean() :<br/>
	 * <ul>
	 * Teste la méthode deleteAllBoolean() :<br/>
	 * <li>garantit que deleteAllBoolean(...) détruit 
	 * toutes les instance persistantes et retourne true.</li>
	 * <li>garantit que deleteAllBoolean(...) détruit 
	 * toutes les instance persistante DESCENDANTES 
	 * et retourne true.</li>
	 */
	@Test
	public void testDeleteAllBoolean() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		Book book1Persistant = null;
		Book book2Persistant = null;
		Book book3Persistant = null;
		Book book4Persistant = null;
		
		boolean deleteAllBool = false;
		
		try {
			
			/* Nombre initial d'objets en base. */
			final Long nombreInitial = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_INITIAL 
						+ nombreInitial);
			}

			
			/* Création de 4 livres. */
			final Book book1 
				= new Book(
						"La maison rose deleteAll"
						, "Georges Gershwin deleteAll");
			final Book book2 
				= new Book(
						"La maison verte deleteAll"
						, "Georges Karam deleteAll");
			final Book book3 
				= new Book(
						"Ivanohe deleteAll"
						, "Walter Scott deleteAll");
			final SousBook book4 
				= new SousBook(
						"titre sousBook deleteAll"
						, "auteur sousBook deleteAll"
						, "editeur sousBook deleteAll");
					
			/* PERSISTENCE. ****/
			book1Persistant = this.dao.create(book1);
			book2Persistant = this.dao.create(book2);
			book3Persistant = this.dao.create(book3);
			book4Persistant = this.dao.create(book4);
			
			/* Nombre final d'objets en base. */
			final Long nombreApresCreate = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(QBOOKS 
						+ nombreApresCreate);
			}

			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println();
				System.out.println("CREATION DES LIVRES");
				System.out.println(book1Persistant.toString());
				System.out.println(book2Persistant.toString());
				System.out.println(book3Persistant.toString());
				System.out.println(book4Persistant.toString());
				System.out.println();
				
				final List<Book> listeLivres = this.dao.findAll();
				
				System.out.println();
				System.out.println("LIVRES EN BASE");
				System.out.println(this.dao.afficherListe(listeLivres));
				System.out.println();
				
			}

			/* DESTRUCTION. */
			deleteAllBool = this.dao.deleteAllBoolean();
			
			/* Nombre final d'objets en base. */
			final Long nombreFinal = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_FINAL 
						+ nombreFinal);
			}
			
			/* garantit que deleteAll(...) détruit toutes 
			 * les instance persistantes. */
			/* garantit que deleteAll(...) détruit toutes 
			 * les instance persistante DESCENDANTES. */
			assertEquals("0 livres en base : "
					, Long.valueOf(0L)
						, nombreFinal);
			
			assertTrue("deleteAllBool doit valoir true : "
					, deleteAllBool);
			
			/* VIDAGE DE LA TABLE. */
			if (DELETE_APRES_TEST) {
				this.dao.deleteAll();
			}
		
		}
		
		catch (AbstractDaoException e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println(UTILISATEUR 
						+ e.getMessageUtilisateur());
				System.out.println(TECHNIQUE 
						+ e.getMessageTechnique());
				
			}
			
			assertNotNull(MESSAGE_UTILISATEUR
					, e.getMessageUtilisateur());
			assertNotNull(MESSAGE_TECHNIQUE
					, e.getMessageTechnique());
			
		}
		
	} // Fin de testDeleteAllBoolean().____________________________________
	

	
	/**
	 * method testDeleteIterable() :<br/>
	 * <ul>
	 * teste la méthode delete(Iterable&lt;? extends T&gt; pObjects) : <br/>
	 * <li>garantit que delete(...) détruit en base tous les éléments persistés de la collection.</li>
	 * <li>garantit que delete(...) ne plante pas si la collection contient un élément non persisté en base.</li>
	 * <li>garantit que delete(null) ne fait rien.<br/>
	 * </ul>
	 */
	@Test
	public void testDeleteIterable() {
		
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		Book book1Persistant = null;
		Book book2Persistant = null;
		Book book3Persistant = null;
		Book book4Persistant = null;
		
		try {
			
			/* Nombre initial d'objets en base. */
			final Long nombreInitial = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_INITIAL 
						+ nombreInitial);
			}

			/* Création de 5 livres. */
			final Book book1 
				= new Book(
						"La maison rose deleteIterable"
						, "Georges Gershwin deleteIterable");
			final Book book2 
				= new Book(
						"La maison verte deleteIterable"
						, "Georges Karam deleteIterable");
			final Book book3 
				= new Book(
						"Ivanohe deleteIterable"
						, "Walter Scott deleteIterable");
			final SousBook book4 
				= new SousBook(
						"titre sousBook deleteIterable"
						, "auteur sousBook deleteIterable"
						, "editeur sousBook deleteIterable");
			final SousBook bookInexistant 
			= new SousBook(
					"titre sousBook inexistant deleteIterable"
					, "auteur sousBook inexistant deleteIterable"
					, "editeur sousBook inexistant deleteIterable");
			
			/* PERSISTENCE. ****/
			book1Persistant = this.dao.create(book1);
			book2Persistant = this.dao.create(book2);
			book3Persistant = this.dao.create(book3);
			book4Persistant = this.dao.create(book4);
			
			/* Nombre final d'objets en base. */
			final Long nombreApresCreate = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(QBOOKS 
						+ nombreApresCreate);
			}

			/* Création d'une Collection Itérable. */
			final List<Book> listeIterable = new ArrayList<Book>();
			
			/* garantit que delete(...) détruit en base tous les éléments persistés de la collection.*/
			listeIterable.add(book1Persistant);
			listeIterable.add(book3Persistant);
			listeIterable.add(book4Persistant);
			/* garantit que delete(...) ne plante pas si la collection contient un élément non persisté en base. */
			listeIterable.add(bookInexistant);

			/* DESTRUCTION. */
			this.dao.delete(listeIterable);
			
			/* Nombre final d'objets en base. */
			final Long nombreFinal = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_FINAL 
						+ nombreFinal);
			}

			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				final List<Book> listeBooks = this.dao.findAll();
				
				System.out.println();
				System.out.println("BOOK2 : " + book2Persistant.toString());
				System.out.println(LISTE_BOOKS);
				System.out.println(this.dao.afficherListe(listeBooks));
				System.out.println();
				
			}
			
			/* garantit que delete(...) détruit l'instance persistante.*/
			/* garantit que delete(...) détruit l'instance persistante 
			 * DESCENDANTE.*/
			/* garantit que delete(inexistant) ne fait rien. */			
			assertTrue("nombreFinal == nombreApresCreate - 3 : "
					, nombreFinal == nombreApresCreate - 3);
			
			/* VIDAGE DE LA TABLE. */
			if (DELETE_APRES_TEST) {
				this.dao.deleteAll();
			}
			
		}
		catch (AbstractDaoException e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println(UTILISATEUR 
						+ e.getMessageUtilisateur());
				System.out.println(TECHNIQUE 
						+ e.getMessageTechnique());
				
			}
			
			assertNotNull(MESSAGE_UTILISATEUR
					, e.getMessageUtilisateur());
			assertNotNull(MESSAGE_TECHNIQUE
					, e.getMessageTechnique());
			
		}
		
	} // Fin de testDeleteIterable().______________________________________
	

	
	/**
	 * method testExistsT() :<br/>
	 * <ul>
	 * Teste la méthode exists(T pObject) : <br/>
	 * <li>garantit que exists(T pObject) retrouve les instances de T et retourne true.</li>
	 * <li>garantit que exists(T pObject) retrouve les instances de S DESCENDANT de T et retourne true.</li>
	 * <li>garantit que exists(inexistant) retourne false.</li>
	 * <li></li>
	 * </ul>
	 */
	@Test
	public void testExistsT() {
		
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		Book book1Persistant = null;
		Book book2Persistant = null;
		Book book3Persistant = null;
		Book book4Persistant = null;

		boolean existBook1 = false;
		boolean existBook4 = false;
		boolean existInexistant = false;
		
		try {
			
			/* Nombre initial d'objets en base. */
			final Long nombreInitial = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(NOMBRE_INITIAL 
						+ nombreInitial);
			}
			
			/* Création de 5 livres. */
			final Book book1 
				= new Book(
						"La maison rose testExistsT"
						, "Georges Gershwin testExistsT");
			final Book book2 
				= new Book(
						"La maison verte testExistsT"
						, "Georges Karam testExistsT");
			final Book book3 
				= new Book(
						"Ivanohe testExistsT"
						, "Walter Scott testExistsT");
			final SousBook book4 
				= new SousBook(
						"titre sousBook testExistsT"
						, "auteur sousBook testExistsT"
						, "editeur sousBook testExistsT");
			final SousBook bookInexistant 
			= new SousBook(
					"titre sousBook inexistant testExistsT"
					, "auteur sousBook inexistant testExistsT"
					, "editeur sousBook inexistant testExistsT");
			
			/* PERSISTENCE. ****/
			book1Persistant = this.dao.create(book1);
			book2Persistant = this.dao.create(book2);
			book3Persistant = this.dao.create(book3);
			book4Persistant = this.dao.create(book4);
			
			/* Nombre final d'objets en base. */
			final Long nombreApresCreate = this.dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(QBOOKS 
						+ nombreApresCreate);
			}

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				final List<Book> listeBooks = this.dao.findAll();
				
				System.out.println();
				System.out.println("BOOK2 : " + book2Persistant.toString());
				System.out.println("BOOK3 : " + book3Persistant.toString());
				System.out.println("LISTE DES BOOKS : ");
				System.out.println(this.dao.afficherListe(listeBooks));
				System.out.println();
				
			}
			existBook1 = this.dao.exists(book1Persistant);
			existBook4 = this.dao.exists(book4Persistant);
			existInexistant = this.dao.exists(bookInexistant);
			
			assertTrue("Book1 doit exister : ", existBook1);
			assertTrue("Book4 doit exister : ", existBook4);
			assertFalse("Inexistant ne doit pas exister : ", existInexistant);
			
			/* VIDAGE DE LA TABLE. */
			if (DELETE_APRES_TEST) {
				this.dao.deleteAll();
			}
			
		}
		catch (AbstractDaoException e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println(UTILISATEUR 
						+ e.getMessageUtilisateur());
				System.out.println(TECHNIQUE 
						+ e.getMessageTechnique());
				
			}
			
			assertNotNull(MESSAGE_UTILISATEUR
					, e.getMessageUtilisateur());
			assertNotNull(MESSAGE_TECHNIQUE
					, e.getMessageTechnique());
			
		}
		
	} // Fin de testExistsT()._____________________________________________
	


	/**
	 * 
	 * method testExistsT() :<br/>
	 * 
	 * <ul>
	 * 
	 * Teste la méthode exists(ID pId) : <br/>
	 * 
	 * <li>garantit que exists(ID pId) retrouve l'instances de la pk pID et
	 * 
	 * retourne true.</li>
	 * 
	 * <li>garantit que exists(id inexistant) retourne false.</li>
	 * 
	 * <li></li>
	 * 
	 * </ul>
	 * 
	 */

	@Test

	public void testExistsID() {

		// **********************************

		// AFFICHAGE DANS LE TEST ou NON

		final boolean affichage = false;

		// **********************************

		Book book1Persistant = null;

		boolean existBook1 = false;

		boolean existInexistant = false;

		try {

			/* Nombre initial d'objets en base. */

			final Long nombreInitial = this.dao.count();

			/* AFFICHAGE A LA CONSOLE. */

			if (AFFICHAGE_GENERAL && affichage) {

				System.out.println(NOMBRE_INITIAL + nombreInitial);

			}

			/* Création de 5 livres. */

			final Book book = new Book("La maison rose testExistsID", "Georges Gershwin testExistsID");

			final SousBook bookInexistant = new SousBook("titre sousBook inexistant testExistsID",

					"auteur sousBook inexistant testExistsID", "editeur sousBook inexistant testExistsID");

			/* PERSISTENCE. ****/

			book1Persistant = this.dao.create(book);

			/* AFFICHAGE A LA CONSOLE. */

			if (AFFICHAGE_GENERAL && affichage) {

				final List<Book> listeBooks = this.dao.findAll();

				System.out.println();

				System.out.println("LISTE DES BOOKS : ");

				System.out.println(this.dao.afficherListe(listeBooks));

				System.out.println();

			}

			existBook1 = this.dao.exists(book1Persistant.getId());

			existInexistant = this.dao.exists(bookInexistant);

			assertTrue("Book1 doit exister : ", existBook1);

			assertFalse("Inexistant ne doit pas exister : ", existInexistant);

			/* VIDAGE DE LA TABLE. */

			if (DELETE_APRES_TEST) {

				this.dao.deleteAll();

			}

		}

		catch (AbstractDaoException e) {

			/* AFFICHAGE A LA CONSOLE. */

			if (AFFICHAGE_GENERAL && affichage) {

				System.out.println(UTILISATEUR + e.getMessageUtilisateur());

				System.out.println(TECHNIQUE + e.getMessageTechnique());

			}

			assertNotNull(MESSAGE_UTILISATEUR, e.getMessageUtilisateur());

			assertNotNull(MESSAGE_TECHNIQUE, e.getMessageTechnique());

		}

	} // Fin de testExistsID().____________________________________________
	
	
	
} // FIN DE LA CLASSE BookDaoTest.-------------------------------------------

package levy.daniel.application;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dao.IDaoGeneric;
import levy.daniel.application.model.dao.metier.book.impl.BookDao;
import levy.daniel.application.model.metier.book.impl.Book;

/**
 * class Application :<br/>
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
 * @since 9 sept. 2017
 *
 */
public final class Application {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(Application.class);
	
	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR Application() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	private Application() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	/**
	 * method main() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pArgs : String[] :  .<br/>
	 */
	public static void main(
			final String[] pArgs) {
		
		final Book book1 = new Book("La maison rose", "Georges Gershwin");
		final Book book2 = new Book("La maison verte", "Georges Karam");
		
		final IDaoGeneric<Book, Long> dao = new BookDao();
		
		final Book book1Persistant = dao.create(book1);
		final Book book2Persistant = dao.create(book2);
		
		System.out.println();
		System.out.println("CREATION DES LIVRES");
		System.out.println(book1Persistant.toString());
		System.out.println(book2Persistant.toString());
		System.out.println();
		
		final List<Book> listeLivres = dao.findAll();
		
		System.out.println();
		System.out.println("LIVRES EN BASE");
		System.out.println(listeLivres);
		System.out.println();

	} // Fin de main(...)._________________________________________________
	


} // FIN DE LA CLASSE Application.-------------------------------------------

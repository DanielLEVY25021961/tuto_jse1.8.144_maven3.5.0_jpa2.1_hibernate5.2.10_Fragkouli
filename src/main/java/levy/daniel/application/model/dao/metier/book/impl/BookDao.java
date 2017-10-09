package levy.daniel.application.model.dao.metier.book.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dao.metier.book.AbstractDaoBook;
import levy.daniel.application.model.metier.book.impl.Book;

/**
 * class BookDao :<br/>
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
 * @since 10 sept. 2017
 *
 */
public class BookDao extends AbstractDaoBook {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(BookDao.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR BookDao() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public BookDao() {
		
		super();
		
		this.setClassObjetMetier(Book.class);
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	
		
} // FIn DE LA CLASSE BookDao.-----------------------------------------------

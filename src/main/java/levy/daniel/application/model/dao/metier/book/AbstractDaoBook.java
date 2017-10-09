package levy.daniel.application.model.dao.metier.book;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dao.AbstractDaoGeneric;
import levy.daniel.application.model.metier.book.impl.Book;

/**
 * class AbstractDaoBook :<br/>
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
public abstract class AbstractDaoBook 
			extends AbstractDaoGeneric<Book, Long> 
								implements IDaoBook {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(AbstractDaoBook.class);

	// *************************METHODES************************************/
	
	 /**
	 * method CONSTRUCTEUR AbstractDaoClient() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractDaoBook() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long createReturnId(
			final Book pBook) {
		
		/* retourne null si pBook == null. */
		if (pBook == null) {
			return null;
		}
		
		/* Crée le Book en base. */
		final Book bookPersistant = this.create(pBook);
		
		return bookPersistant.getId();
		
	} // Fin de createReturnId(...)._______________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Book retrieveByIdMetier(
			final Book pBook) {
		return null;
	} // Fin de retrieveByIdMetier(...).___________________________________

	
	
} // FIN DE LA CLASSE AbstractDaoBook.---------------------------------------

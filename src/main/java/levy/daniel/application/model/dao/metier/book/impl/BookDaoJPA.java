package levy.daniel.application.model.dao.metier.book.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dao.metier.book.AbstractDaoBookJPA;
import levy.daniel.application.model.metier.book.impl.Book;


/**
 * class BookDaoJPA :<br/>
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
 * @since 13 oct. 2017
 *
 */
public class BookDaoJPA extends AbstractDaoBookJPA {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(BookDaoJPA.class);


	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR BookDaoJPA() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public BookDaoJPA() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void renseignerClassObjetMetier() {

		this.setClassObjetMetier(Book.class);

	} // Fin de renseignerClassObjetMetier().______________________________
	
	

} // FIN DE LA CLASSE BookDaoJPA.--------------------------------------------

package levy.daniel.application.model.dao.metier.book.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dao.metier.book.AbstractDaoBookHibernate;
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
public class BookDaoHibernate extends AbstractDaoBookHibernate {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(BookDaoHibernate.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR BookDao() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public BookDaoHibernate() {		
		super();		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void renseignerClassObjetMetier() {

		this.setClassObjetMetier(Book.class);
		
	} // Fin de renseignerClassObjetMetier().______________________________

	
		
} // FIn DE LA CLASSE BookDao.-----------------------------------------------

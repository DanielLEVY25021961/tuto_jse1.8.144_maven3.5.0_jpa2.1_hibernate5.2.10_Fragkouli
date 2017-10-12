package levy.daniel.application.model.dao.metier.book;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.metier.book.impl.Book;

/**
 * class IDaoBook :<br/>
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
public interface IDaoBook {

	
	
	/**
	 * method retrieveByIdMetier(
	 * Book pBook) :<br/>
	 * <ul>
	 * <li>Recherche un Book pBook en base 
	 * via son identifiant métier.</li>
	 * <li>Retourne le Book trouvé en base.</li>
	 * </ul> 
	 * <br/>
	 *
	 * @param pBook : Book : Book à rechercher en base 
	 * via son identifiant métier.<br/>
	 * 
	 * @return : Book : Le Book trouvé en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	Book retrieveByIdMetier(Book pBook) throws AbstractDaoException;
	

	
} // FIN DE L'INTERFACE IDaoBook.------------------------------------------

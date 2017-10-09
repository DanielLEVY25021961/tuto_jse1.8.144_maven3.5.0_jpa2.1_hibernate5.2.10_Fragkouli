package levy.daniel.application.model.dao.metier.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dao.AbstractDaoGeneric;
import levy.daniel.application.model.metier.client.AbstractClient;

/**
 * class AbstractDaoClient :<br/>
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
 * @since 8 sept. 2017
 *
 */
public class AbstractDaoClient 
				extends AbstractDaoGeneric<AbstractClient, Long> 
												implements IDaoClient {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(AbstractDaoClient.class);

	
	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR AbstractDaoClient() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractDaoClient() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long createReturnId(
			final AbstractClient pClient) {
		
		/* retourne null si pClient == null. */
		if (pClient == null) {
			return null;
		}
		
		/* Crée le AbstractClient en base. */
		final AbstractClient clientPersistant = this.create(pClient);
		
		return clientPersistant.getId();
		
	} // Fin de createReturnId(...)._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractClient retrieveByIdMetier(
			final AbstractClient pClient) {
		return null;
	} // Fin de retrieveByIdMetier(...).___________________________________


	
} // FIN DE LA CLASSE AbstractDaoClient.-------------------------------------

package levy.daniel.application.model.services.metier.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.client.AbstractClient;
import levy.daniel.application.model.services.metier.AbstractServiceGeneric;
import levy.daniel.application.model.services.valideurs.metier.client.ValideurClient;

/**
 * class AbstractClientService :<br/>
 * CLASSE ABSTRAITE.<br/>
 * Abstraction des Services concrets pour les objets métier 
 * de type Client (héritant de AbstractClient).<br>
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
 * @since 25 août 2017
 *
 */
public abstract class AbstractClientService 
						extends AbstractServiceGeneric<AbstractClient> 
									implements IClientService {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_ABSTRACT_CLIENT_SERVICE : String :<br/>
	 * "Classe AbstractClientService".<br/>
	 */
	public static final String CLASSE_ABSTRACT_CLIENT_SERVICE 
		= "Classe AbstractClientService";
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(AbstractClientService.class);
	

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR AbstractClientService() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractClientService() {
		
		super();
		
		this.valideur = new ValideurClient();
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractClient retrieveByIdMetier(
			final AbstractClient pClient) {
		
		// TODO Auto-generated method stub
		return null;
		
	} // Fin de retrieveByIdMetier(...).___________________________________


			
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String founirNomClasse();
	

	
} // FIN DE LA CLASSE AbstractClientService.---------------------------------

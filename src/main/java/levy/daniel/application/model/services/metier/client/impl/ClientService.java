package levy.daniel.application.model.services.metier.client.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.client.impl.Client;
import levy.daniel.application.model.services.metier.client.AbstractClientService;

/**
 * class ClientService :<br/>
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
 * @since 25 août 2017
 *
 */
public class ClientService extends AbstractClientService {

	// ************************ATTRIBUTS************************************/


	/**
	 * CLASSE_CLIENT_SERVICE : String :<br/>
	 * "Classe ClientService".<br/>
	 */
	public static final String CLASSE_CLIENT_SERVICE 
		= "Classe ClientService";

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ClientService.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ClientService() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ClientService() {
		
		super();
				
		this.objetMetier = new Client();
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * "Classe ClientService".<br/>
	 */
	@Override
	public String founirNomClasse() {
		return CLASSE_CLIENT_SERVICE;
	} // Fin de founirNomClasse()._________________________________________

	
	
} // FIN DE LA CLASSE ClientService.-----------------------------------------

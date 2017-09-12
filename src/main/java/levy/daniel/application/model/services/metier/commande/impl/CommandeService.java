package levy.daniel.application.model.services.metier.commande.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.commande.impl.Commande;
import levy.daniel.application.model.services.metier.commande.AbstractCommandeService;

/**
 * class CommandeService :<br/>
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
public class CommandeService extends AbstractCommandeService {

	// ************************ATTRIBUTS************************************/


	/**
	 * CLASSE_COMMANDE_SERVICE : String :<br/>
	 * "Classe CommandeService".<br/>
	 */
	public static final String CLASSE_COMMANDE_SERVICE 
		= "Classe CommandeService";

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(CommandeService.class);


	// *************************METHODES************************************/
	

	
	 /**
	 * method CONSTRUCTEUR CommandeService() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public CommandeService() {
		
		super();
		
		this.objetMetier = new Commande();
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String founirNomClasse() {
		return CLASSE_COMMANDE_SERVICE;
	} // Fin de founirNomClasse()._________________________________________

	

} // FIN DE LA CLASSE CommandeService.---------------------------------------

package levy.daniel.application.model.services.metier.commande;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.commande.AbstractCommande;
import levy.daniel.application.model.services.metier.AbstractServiceGeneric;
import levy.daniel.application.model.services.valideurs.metier.commande.ValideurCommande;

/**
 * class AbstractCommandeService :<br/>
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
public abstract class AbstractCommandeService 
				extends AbstractServiceGeneric<AbstractCommande> 
											implements ICommandeService {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_ABSTRACT_COMMANDE_SERVICE : String :<br/>
	 * "Classe AbstractCommandeService".<br/>
	 */
	public static final String CLASSE_ABSTRACT_COMMANDE_SERVICE 
		= "Classe AbstractCommandeService";
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(AbstractCommandeService.class);


	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR AbstractCommandeService() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractCommandeService() {
		
		super();
		
		this.valideur = new ValideurCommande();
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractCommande retrieveByIdMetier(
			final AbstractCommande pCommande) {
		
		// TODO Auto-generated method stub
		return null;
		
	} // Fin de retrieveByIdMetier(...).___________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String founirNomClasse();


} // FIN DE LA CLASSE AbstractCommandeService.-------------------------------

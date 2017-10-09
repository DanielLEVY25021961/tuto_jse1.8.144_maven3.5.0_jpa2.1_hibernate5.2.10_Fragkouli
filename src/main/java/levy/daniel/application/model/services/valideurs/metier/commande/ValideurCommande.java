package levy.daniel.application.model.services.valideurs.metier.commande;

import java.net.MalformedURLException;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.commande.AbstractCommande;
import levy.daniel.application.model.services.valideurs.AbstractValideurGeneric;

/**
 * class ValideurCommande :<br/>
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
public class ValideurCommande 
					extends AbstractValideurGeneric<AbstractCommande> {

	// ************************ATTRIBUTS************************************/

	/**
	 * DATE_COMMANDE : String :<br/>
	 * "dateCommande".<br/>
	 */
	public static final String DATE_COMMANDE = "dateCommande";
	
	
	/**
	 * MONTANT : String :<br/>
	 * "montant".<br/>
	 */
	public static final String MONTANT = "montant";
	
	
	/**
	 * MODE_PAIEMENT : String :<br/>
	 * "modePaiement".<br/>
	 */
	public static final String MODE_PAIEMENT = "modePaiement";
	
	
	/**
	 * STATUT_PAIEMENT : String :<br/>
	 * "statutPaiement".<br/>
	 */
	public static final String STATUT_PAIEMENT = "statutPaiement";
	
	
	/**
	 * MODE_LIVRAISON : String :<br/>
	 * "modeLivraison".<br/>
	 */
	public static final String MODE_LIVRAISON = "modeLivraison";
	
	
	/**
	 * STATUT_LIVRAISON : String :<br/>
	 * "statutLivraison".<br/>
	 */
	public static final String STATUT_LIVRAISON = "statutLivraison";
	
	
	/**
	 * CLIENT : String :<br/>
	 * "client".<br/>
	 */
	public static final String CLIENT = "client";


	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ValideurCommande.class);

	
	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ValideurCommande() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ValideurCommande() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Map<String, String>> validate(
			final AbstractCommande pObject) 
							throws MalformedURLException {
		
		return this.erreurs;
		
	} // Fin de validate(...)._____________________________________________


			
} // FIN DE LA CLASSE ValideurCommande().------------------------------------

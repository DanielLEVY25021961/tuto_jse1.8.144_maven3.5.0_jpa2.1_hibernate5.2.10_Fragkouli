package levy.daniel.application.model.services.metier.client.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.client.impl.ClientACommandes;
import levy.daniel.application.model.metier.commande.impl.Commande;
import levy.daniel.application.model.services.metier.client.AbstractClientService;

/**
 * class ClientACommandesService :<br/>
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
public class ClientACommandesService extends AbstractClientService {

	// ************************ATTRIBUTS************************************/


	/**
	 * CLASSE_CLIENTACOMANDES_SERVICE : String :<br/>
	 * "Classe ClientACommandesService".<br/>
	 */
	public static final String CLASSE_CLIENTACOMANDES_SERVICE 
		= "Classe ClientACommandesService";


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ClientACommandesService.class);
	
	
	// *************************METHODES************************************/
	
	 /**
	 * method CONSTRUCTEUR ClientACommandesService() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ClientACommandesService() {
		
		super();
				
		this.objetMetier = new ClientACommandes();
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * method ajouterCommande(
	 * Commande pCommande) :<br/>
	 * Ajoute une Commande à this.listCommande.<br/>
	 * <br/>
	 * retourne false si pCommande == null.<br/>
	 * instancie une nouvelle si listCommandes si elle était null.<br/>
	 * <br/>
	 *
	 * @param pCommande : Commande.<br/>
	 * 
	 * @return : boolean : true si pCommande 
	 * a été ajouté à this.listCommandes.<br/>
	 */
	public final Commande ajouterCommande(
			final Commande pCommande) {
		
		return null;
		
	} // Fin de ajouterCommande(...).______________________________________
	

	
	
	/**
	 * method findCommande(Commande pCommande) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pCommande
	 * @return :  :  .<br/>
	 */
	public final Commande findCommande(
			final Commande pCommande) {
		return null;
	}
	
	
	
	/**
	 * method listerToutesCommandes() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @return :  :  .<br/>
	 */
	public final List<Commande> listerToutesCommandes() {
		return null;
	}
	
	
	
	/**
	 * method retirerCommande(
	 * Commande pCommande) :<br/>
	 * Retire une Commande à this.listCommande.<br/>
	 * <br/>
	 * retourne false si pCommande == null.<br/>
	 * retourne false si this.listCommandes == null.<br/>
	 * <br/>
	 *
	 * @param pCommande : Commande.<br/>
	 * 
	 * @return : boolean : true si pCommande 
	 * a été retiré à this.listCommandes.<br/>
	 */
	public final boolean retirerCommande(
			final Commande pCommande) {

		return false;
		
	} // Fin de retirerCommande(...).______________________________________
	

	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * "Classe ClientACommandesService".<br/>
	 */
	@Override
	public String founirNomClasse() {
		return CLASSE_CLIENTACOMANDES_SERVICE;
	} // Fin de founirNomClasse()._________________________________________


	
} // FIN DE LA CLASSE ClientACommandesService.-------------------------------

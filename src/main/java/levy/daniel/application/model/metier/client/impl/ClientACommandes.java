package levy.daniel.application.model.metier.client.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.client.AbstractClient;
import levy.daniel.application.model.metier.commande.impl.Commande;

/**
 * class ClientACommandes :<br/>
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
public class ClientACommandes extends AbstractClient {

	// ************************ATTRIBUTS************************************/

	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * POINT_VIRGULE : char :<br/>
	 * ';'.<br/>
	 */
	public static final char POINT_VIRGULE = ';';

	
	/**
	 * VIRGULE_SPACE : String :<br/>
	 * ", ".<br/>
	 */
	public static final String VIRGULE_SPACE = ", ";
	

	
	/**
	 * listCommandes : List&lt;Commande&gt; :<br/>
	 * Liste de Commandes du Client.<br/>
	 */
	private List<Commande> listCommandes;

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(ClientACommandes.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ClientACommandes() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ClientACommandes() {
		this(null, null, null, null, null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR ClientACommandes(CONSTRUCTEUR RAPIDE) :<br/>
	 * CONSTRUCTEUR RAPIDE.<br/>
	 * SANS ID en base.<br/>
	 * SANS listeCommandes.<br/>
	 * <br/>
	 *
	 * @param pNom : String : Nom du client.<br/>
	 * @param pPrenom : String : Prénom du client.<br/>
	 * @param pAdresseLivraison : String : 
	 * adresse de livraison du client.<br/>
	 * @param pTelephone : String : Numéro de téléphone du client.<br/>
	 * @param pEmail : String : email du client.<br/> 
	 */
	public ClientACommandes(
			final String pNom, final String pPrenom
			, final String pAdresseLivraison, final String pTelephone
			, final String pEmail) {
		
		this(null
				, pNom, pPrenom
				, pAdresseLivraison, pTelephone, pEmail
				, null);
		
	} // Fin de CONSTRUCTEUR RAPIDE._______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR ClientACommandes(CONSTRUCTEUR COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * SANS ID en base.<br/>
	 * AVEC listeCommandes.<br/>
	 * <br/>
	 *
	 * @param pNom : String : Nom du client.<br/>
	 * @param pPrenom : String : Prénom du client.<br/>
	 * @param pAdresseLivraison : String : 
	 * adresse de livraison du client.<br/>
	 * @param pTelephone : String : Numéro de téléphone du client.<br/>
	 * @param pEmail : String : email du client.<br/> 
	 * @param pListCommandes : List&lt;Commande&gt; : 
	 * Liste de Commandes du Client.<br/>
	 */
	public ClientACommandes(
				final String pNom, final String pPrenom
				, final String pAdresseLivraison, final String pTelephone
				, final String pEmail
				, final List<Commande> pListCommandes) {
		
		this(null
				, pNom, pPrenom
				, pAdresseLivraison
				, pTelephone, pEmail
				, pListCommandes);
		
	} // Fin de CONSTRUCTEUR COMPLET._______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR ClientACommandes(
	 * CONSTRUCTEUR COMPLET BASE) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * AVEC ID en base.<br/>
	 * AVEC listeCommandes.<br/>
	 * instancie une nouvelle listCommandes si pListCommandes == null.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base.<br/> 
	 * @param pNom : String : Nom du client.<br/>
	 * @param pPrenom : String : Prénom du client.<br/>
	 * @param pAdresseLivraison : String : 
	 * adresse de livraison du client.<br/>
	 * @param pTelephone : String : Numéro de téléphone du client.<br/>
	 * @param pEmail : String : email du client.<br/> 
	 * @param pListCommandes : List&lt;Commande&gt; : 
	 * Liste de Commandes du Client.<br/>
	 */
	public ClientACommandes(
			final Long pId
				, final String pNom, final String pPrenom
				, final String pAdresseLivraison, final String pTelephone
				, final String pEmail
				, final List<Commande> pListCommandes) {
		
		super(pId, pNom, pPrenom, pAdresseLivraison, pTelephone, pEmail);
		
		/* instancie une nouvelle listCommandes 
		 * si pListCommandes == null.  */
		if (pListCommandes == null) {
			this.listCommandes = new ArrayList<>();
		} else {
			this.listCommandes = pListCommandes;
		}
		
		
	} // Fin du CONSTRUCTEUR COMPLET BASE._________________________________
	

	
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
	public final boolean ajouterCommande(
			final Commande pCommande) {
		
		/* retourne false si pCommande == null. */
		if (pCommande == null) {
			return false;
		}
		
		/* instancie une nouvelle si listCommandes si elle était null. */
		if (this.listCommandes == null) {
			this.listCommandes = new ArrayList<Commande>();
		}
		
		return this.listCommandes.add(pCommande);
		
	} // Fin de ajouterCommande(...).______________________________________
	
	
		
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

		/* retourne false si pCommande == null. */
		if (pCommande == null) {
			return false;
		}
		
		/* retourne false si this.listCommandes == null. */
		if (this.listCommandes == null) {
			return false;
		}
		
		return this.listCommandes.remove(pCommande);

	} // Fin de retirerCommande(...).______________________________________
	
	
	
	/**
	 * method getListCommandes() :<br/>
	 * Getter de la Liste de Commandes du Client.<br/>
	 * <br/>
	 *
	 * @return listCommandes : List&lt;Commande&gt;.<br/>
	 */
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "IDCOMMANDE")
	public List<Commande> getListCommandes() {
		return this.listCommandes;
	} // Fin de getListCommandes().________________________________________


	
	/**
	* method setListCommandes(
	* List&lt;Commande&gt; pListCommandes) :<br/>
	* Setter de la Liste de Commandes du Client.<br/>
	* <br/>
	*
	* @param pListCommandes : List&lt;Commande&gt; :
	*  valeur à passer à listCommandes.<br/>
	*/
	public void setListCommandes(
			final List<Commande> pListCommandes) {
		this.listCommandes = pListCommandes;
	} // Fin de setListCommandes(...)._____________________________________

	
	
} // FIn DE LA CLASSE ClientACommandes.--------------------------------------

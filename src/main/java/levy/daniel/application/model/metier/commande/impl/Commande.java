package levy.daniel.application.model.metier.commande.impl;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;

import levy.daniel.application.model.metier.client.AbstractClient;
import levy.daniel.application.model.metier.commande.AbstractCommande;

/**
 * class Commande :<br/>
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
 * @since 21 août 2017
 *
 */
@Entity
@Table(name = "COMMANDES")
@PrimaryKeyJoinColumn(name = "IDCOMMANDE")
public class Commande extends AbstractCommande {

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
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(Commande.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR Commande() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public Commande() {
		this(null, null, null, null, null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR Commande(
	 * CONSTRUCTEUR COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pDateCommande : org.joda.time.DateTime : 
	 * date de la commande.<br/>
	 * @param pMontant : Double : montant de la commande.<br/>
	 * @param pModePaiement : String : 
	 * mode de paiement de la commande.<br/>
	 * @param pStatutPaiement : String : 
	 * statut du paiement de la commande.<br/>
	 * @param pModeLivraison : String : 
	 * mode de livraison de la commande.<br/>
	 * @param pStatutLivraison : String : 
	 * statut de la livraison de la commande.<br/>
	 * @param pClient : AbstractClient : client de la commande.<br/>
	 */
	public Commande(
			final DateTime pDateCommande
			, final Double pMontant
			, final String pModePaiement, final String pStatutPaiement
			, final String pModeLivraison, final String pStatutLivraison
			, final AbstractClient pClient) {
		
		this(null
				, pDateCommande
				, pMontant
				, pModePaiement, pStatutPaiement
				, pModeLivraison, pStatutLivraison
				, pClient);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR Commande(
	 * CONSTRUCTEUR COMPLET BASE) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pDateCommande : org.joda.time.DateTime : 
	 * date de la commande.<br/>
	 * @param pMontant : Double : montant de la commande.<br/>
	 * @param pModePaiement : String : 
	 * mode de paiement de la commande.<br/>
	 * @param pStatutPaiement : String : 
	 * statut du paiement de la commande.<br/>
	 * @param pModeLivraison : String : 
	 * mode de livraison de la commande.<br/>
	 * @param pStatutLivraison : String : 
	 * statut de la livraison de la commande.<br/>
	 * @param pClient : AbstractClient : client de la commande.<br/>
	 */
	public Commande(
			final Long pId
			, final DateTime pDateCommande
			, final Double pMontant
			, final String pModePaiement, final String pStatutPaiement
			, final String pModeLivraison, final String pStatutLivraison
			, final AbstractClient pClient) {
		
		super(pId, pDateCommande, pMontant
				, pModePaiement, pStatutPaiement
				, pModeLivraison, pStatutLivraison
				, pClient);
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________


} // FIN DE LA CLASSE Commande.----------------------------------------------

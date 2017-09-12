package levy.daniel.application.model.metier.commande;

import org.joda.time.DateTime;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;
import levy.daniel.application.model.metier.client.AbstractClient;

/**
 * class ICommande :<br/>
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
 * @since 20 août 2017
 *
 */
public interface ICommande extends IExportateurCsv, IExportateurJTable {

	/**
	 * method getId() :<br/>
	 * Getter de l'ID en base.<br/>
	 * <br/>
	 *
	 * @return id : Long.<br/>
	 */
	Long getId();
	
	

	/**
	* method setId(
	* Long pId) :<br/>
	* Setter de l'ID en base.<br/>
	* <br/>
	*
	* @param pId : Long : valeur à passer à id.<br/>
	*/
	void setId(Long pId);
	
	

	/**
	 * method getDateCommande() :<br/>
	 * Getter de la date de la commande.<br/>
	 * <br/>
	 *
	 * @return dateCommande : org.joda.time.DateTime.<br/>
	 */
	DateTime getDateCommande();

	
	
	/**
	* method setDateCommande(
	* DateTime pDateCommande) :<br/>
	* Setter de la date de la commande.<br/>
	* <br/>
	*
	* @param pDateCommande : org.joda.time.DateTime : 
	* valeur à passer à dateCommande.<br/>
	*/
	void setDateCommande(DateTime pDateCommande);

	
	
	/**
	 * method getMontant() :<br/>
	 * Getter du montant de la commande.<br/>
	 * <br/>
	 *
	 * @return montant : Double.<br/>
	 */
	Double getMontant();
	
	

	/**
	* method setMontant(
	* Double pMontant) :<br/>
	* Setter du montant de la commande.<br/>
	* <br/>
	*
	* @param pMontant : Double : valeur à passer à montant.<br/>
	*/
	void setMontant(Double pMontant);
	
	

	/**
	 * method getModePaiement() :<br/>
	 * Getter du mode de paiement de la commande.<br/>
	 * <br/>
	 *
	 * @return modePaiement : String.<br/>
	 */
	String getModePaiement();

	
	
	/**
	* method setModePaiement(
	* String pModePaiement) :<br/>
	* Setter du mode de paiement de la commande.<br/>
	* <br/>
	*
	* @param pModePaiement : String : valeur à passer à modePaiement.<br/>
	*/
	void setModePaiement(String pModePaiement);

	
	
	/**
	 * method getStatutPaiement() :<br/>
	 * Getter du statut du paiement de la commande.<br/>
	 * <br/>
	 *
	 * @return statutPaiement : String.<br/>
	 */
	String getStatutPaiement();

	
	
	/**
	* method setStatutPaiement(
	* String pStatutPaiement) :<br/>
	* Setter du statut du paiement de la commande.<br/>
	* <br/>
	*
	* @param pStatutPaiement : String : 
	* valeur à passer à statutPaiement.<br/>
	*/
	void setStatutPaiement(String pStatutPaiement);

	
	
	/**
	 * method getModeLivraison() :<br/>
	 * Getter du mode de livraison de la commande.<br/>
	 * <br/>
	 *
	 * @return modeLivraison : String.<br/>
	 */
	String getModeLivraison();

	
	
	/**
	* method setModeLivraison(
	* String pModeLivraison) :<br/>
	* Setter du mode de livraison de la commande.<br/>
	* <br/>
	*
	* @param pModeLivraison : String : 
	* valeur à passer à modeLivraison.<br/>
	*/
	void setModeLivraison(String pModeLivraison);

	
	
	/**
	 * method getStatutLivraison() :<br/>
	 * Getter du statut de la livraison de la commande.<br/>
	 * <br/>
	 *
	 * @return statutLivraison : String.<br/>
	 */
	String getStatutLivraison();

	
	
	/**
	* method setStatutLivraison(
	* String pStatutLivraison) :<br/>
	* Setter du statut de la livraison de la commande.<br/>
	* <br/>
	*
	* @param pStatutLivraison : String : 
	* valeur à passer à statutLivraison.<br/>
	*/
	void setStatutLivraison(String pStatutLivraison);

	
	
	/**
	 * method getClient() :<br/>
	 * Getter du client de la commande.<br/>
	 * <br/>
	 *
	 * @return client : AbstractClient.<br/>
	 */
	AbstractClient getClient();

	
	/**
	* method setClient(
	* AbstractClient pClient) :<br/>
	* Setter du client de la commande.<br/>
	* <br/>
	*
	* @param pClient : AbstractClient : 
	* valeur à passer à client.<br/>
	*/
	void setClient(AbstractClient pClient);
	
	
	
} // FIN DE L'INTERFACE ICommande.-------------------------------------------
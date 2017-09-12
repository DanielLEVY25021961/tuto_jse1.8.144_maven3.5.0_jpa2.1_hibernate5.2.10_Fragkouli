package levy.daniel.application.model.metier.client;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;

/**
 * class IClient :<br/>
 * .<br/>
 * <br/>
 * - Exemple d'utilisation :<br/>
 * <br/>
 * - Mots-clé :<br/>
 * <br/>
 * - Dépendances :<br/>
 * <br/>
 *
 * @author dan Lévy
 * @version 1.0
 * @since 20 août 2017
 */
public interface IClient extends IExportateurCsv, IExportateurJTable {

	/**
	 * method getId() :<br/>
	 * Getter de l'ID en base.<br/>
	 * <br/>
	 *
	 * @return id : Long.<br/>
	 */
	Long getId();

	/**
	 * method setId( Long pId) :<br/>
	 * Setter de l'ID en base.<br/>
	 * <br/>
	 *
	 * @param pId : Long : valeur à passer à id.<br/>
	 */
	void setId(Long pId);

	/**
	 * method getNom() :<br/>
	 * Getter du Nom du client.<br/>
	 * <br/>
	 *
	 * @return nom : String.<br/>
	 */
	String getNom();

	/**
	 * method setNom( String pNom) :<br/>
	 * Setter du Nom du client.<br/>
	 * <br/>
	 *
	 * @param pNom : String : valeur à passer à nom.<br/>
	 */
	void setNom(String pNom);

	/**
	 * method getPrenom() :<br/>
	 * Getter du Prénom du client.<br/>
	 * <br/>
	 *
	 * @return prenom : String.<br/>
	 */
	String getPrenom();

	/**
	 * method setPrenom( String pPrenom) :<br/>
	 * Setter du Prénom du client.<br/>
	 * <br/>
	 *
	 * @param pPrenom : String : valeur à passer à prenom.<br/>
	 */
	void setPrenom(String pPrenom);

	/**
	 * method getAdresseLivraison() :<br/>
	 * Getter de l'adresse de livraison du client.<br/>
	 * <br/>
	 *
	 * @return adresseLivraison : String.<br/>
	 */
	String getAdresseLivraison();

	/**
	 * method setAdresseLivraison( String pAdresseLivraison) :<br/>
	 * Setter de l'adresse de livraison du client.<br/>
	 * <br/>
	 *
	 * @param pAdresseLivraison : String : valeur à passer à adresseLivraison.<br/>
	 */
	void setAdresseLivraison(String pAdresseLivraison);

	/**
	 * method getTelephone() :<br/>
	 * Getter du Numéro de téléphone du client.<br/>
	 * <br/>
	 *
	 * @return telephone : String.<br/>
	 */
	String getTelephone();

	/**
	 * method setTelephone( String pTelephone) :<br/>
	 * Setter du Numéro de téléphone du client.<br/>
	 * <br/>
	 *
	 * @param pTelephone : String : valeur à passer à telephone.<br/>
	 */
	void setTelephone(String pTelephone);

	/**
	 * method getEmail() :<br/>
	 * Getter de l'email du client.<br/>
	 * <br/>
	 *
	 * @return email : String.<br/>
	 */
	String getEmail();

	/**
	 * method setEmail( String pEmail) :<br/>
	 * Setter de l'email du client.<br/>
	 * <br/>
	 *
	 * @param pEmail : String : valeur à passer à email.<br/>
	 */
	void setEmail(String pEmail);

		

} // FIN DE L'INTERFACE IClient.---------------------------------------------

package levy.daniel.application.model.metier.livre;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;

/**
 * interface ILivre :<br/>
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
 * @since 10 sept. 2017
 *
 */
public interface ILivre extends IExportateurCsv, IExportateurJTable {

	
	
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
	* @param pId : Long : 
	* valeur à passer à id.<br/>
	*/
	void setId(Long pId);

	
	
	/**
	 * method getTitre() :<br/>
	 * Getter du titre du livre.<br/>
	 * <br/>
	 *
	 * @return titre : String.<br/>
	 */
	String getTitre();

	
	
	/**
	* method setTitre(
	* String pTitre) :<br/>
	* Setter du titre du livre.<br/>
	* <br/>
	*
	* @param pTitre : String : 
	* valeur à passer à titre.<br/>
	*/
	void setTitre(String pTitre);
	
	

	/**
	 * method getAuteur() :<br/>
	 * Getter de l'auteur du livre.<br/>
	 * <br/>
	 *
	 * @return auteur : String.<br/>
	 */
	String getAuteur();
	
	
	
	/**
	* method setAuteur(
	* String pAuteur) :<br/>
	* Setter de l'auteur du livre.<br/>
	* <br/>
	*
	* @param pAuteur : String : 
	* valeur à passer à auteur.<br/>
	*/
	void setAuteur(String pAuteur);
	
	

} // FIN DE L'INTERFACE ILivre.--------------------------------------------
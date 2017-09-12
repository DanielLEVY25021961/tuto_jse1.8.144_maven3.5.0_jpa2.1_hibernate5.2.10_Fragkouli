package levy.daniel.application.model.metier.personne;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;

/**
 * Interface IPersonne :<br/>
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
 * @since 15 août 2017
 *
 */
public interface IPersonne extends IExportateurCsv, IExportateurJTable {
	

	  /**
	 * method getId() :<br/>
	 * Getter de l'ID en base.<br/>
	 * <br/>
	 *
	 * @return : Long : id en base .<br/>
	 */
	Long getId();

	
	
	/**
	 * method setId() :<br/>
	 * Setter de l'ID en base.<br/>
	 * <br/>
	 *
	 * @param pId : Long : valeur à passer à this.id.<br/>
	 */
	void setId(Long pId);
	 

	
	/**
	 * method getPrenom() :<br/>
	 * Getter du prénom de la personne.<br/>
	 * <br/>
	 *
	 * @return : String : prénom de la personne.<br/>
	 */
	String getPrenom();
	

	
	/**
	 * method setPrenom(
	 * String pPrenom) :<br/>
	 * Setter du prénom de la personne.<br/>
	 * <br/>
	 *
	 * @param pPrenom : String : prénom à passer à this.prenom.<br/>
	 */
	void setPrenom(String pPrenom);
	

	
	/**
	 * method getNom() :<br/>
	 * Getter du nom de la personne.<br/>
	 * <br/>
	 *
	 * @return : String : nom de la personne.<br/>
	 */
	String getNom();
	

	
	/**
	 * method setNom(
	 * String pNom) :<br/>
	 * Setter du nom de la personne.<br/>
	 * <br/>
	 *
	 * @param pNom :  : nom à passer à this.nom.<br/>
	 */
	void setNom(String pNom);
	

	
} // FIN DE L'INTERFACE IPersonne.-------------------------------------------

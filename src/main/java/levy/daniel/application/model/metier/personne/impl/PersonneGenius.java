package levy.daniel.application.model.metier.personne.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.personne.AbstractPersonne;

/**
 * class PersonneGenius :<br/>
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
 * @since 19 août 2017
 *
 */
public class PersonneGenius extends AbstractPersonne {
	
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
	 * genius : Boolean :<br/>
	 * Boolean qui spécifie si la Personne est géniale ou pas.<br/>
	 */
	private Boolean genius;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(PersonneGenius.class);


	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR PersonneGenius() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public PersonneGenius() {
		this(null, null, null, null);
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	 

	
	 /**
	 * method CONSTRUCTEUR PersonneGenius(
	 * CONSTRUCTEUR COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pPrenom String : prénom de la personne.<br/>
	 * @param pNom : String : nom de la personne.<br/>
	 * @param pGenius : boolean : boolean qui spécifie 
	 * si la Personne est géniale ou pas.<br/> 
	 */
	public PersonneGenius(
			final String pPrenom
				, final String pNom
					, final Boolean pGenius) {		
		this(null, pPrenom, pNom, pGenius);		
	} // Fin du CONSTRUCTEUR COMPLET.______________________________________

	
	
	 /**
	 * method CONSTRUCTEUR PersonneGenius(
	 * CONSTRUCTEUR COMPLET BASE) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pPrenom String : prénom de la personne.<br/>
	 * @param pNom : String : nom de la personne.<br/>
	 * @param pGenius : boolean : boolean qui spécifie 
	 * si la Personne est géniale ou pas.<br/> 
	 */
	public PersonneGenius(
			final Long pId
				, final String pPrenom
					, final String pNom
						, final Boolean pGenius) {
		
		super(pId, pPrenom, pNom);
		
		this.genius = pGenius;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		
		final int prime = 31;
		
		int result = super.hashCode();
		
		result = prime * result 
				+ ((this.genius == null) ? 0 : this.genius.hashCode());
		
		return result;
		
	} // Fin de hashCode().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(
			final Object pObj) {
		
		if (this == pObj) {
			return true;
		}
		
		if (!super.equals(pObj)) {
			return false;
		}
		
		if (!(pObj instanceof PersonneGenius)) {
			return false;
		}
		
		final PersonneGenius other = (PersonneGenius) pObj;
		
		if (this.genius == null) {
			if (other.genius != null) {
				return false;
			}
		} else if (!this.genius.equals(other.genius)) {
			return false;
		}
		
		return true;
		
	} // Fin de equals(...)._______________________________________________


	
	/**
	 * {@inheritDoc}
	 * @throws CloneNotSupportedException 
	 */
	@Override
	public PersonneGenius clone() throws CloneNotSupportedException {
		
		final PersonneGenius personneClone 
			= (PersonneGenius) super.clone();
		
		personneClone.setId(this.getId());
		personneClone.setPrenom(this.getPrenom());
		personneClone.setNom(this.getNom());
		personneClone.setGenius(this.getGenius());
		
		return personneClone;
		
	} // Fin de clone().___________________________________________________
	
	
		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("PersonneGenius [");
		
		if (this.id != null) {			
			builder.append("id = ");
			builder.append(this.id);
			builder.append(", ");
		}
		if (this.prenom != null) {
			builder.append("prenom=");
			builder.append(this.prenom);
			builder.append(", ");
		}
		if (this.nom != null) {
			builder.append("nom=");
			builder.append(this.nom);
		}
		if (this.genius != null) {
			builder.append("genius=");
			builder.append(this.genius);
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________


	
	/**
	 * method getEnTeteCsv() :<br/>
	 * "id;nom;prénom".<br/>
	 * <br/>
	 *
	 * @return : String : "id;nom;prénom".<br/>
	 */
//	@Transient
	@Override
	public String getEnTeteCsv() {
		return "id;nom;prénom;genie;";
	} // Fin de getEnTeteCsv().____________________________________________
	
	
	
	/**
	 * method toStringCsv() :<br/>
	 * "this.id;this.nom;this.prenom;".<br/>
	 * <br/>
	 *
	 * @return : String : "this.id;this.nom;this.prenom;".<br/>
	 */
	@Override
	public String toStringCsv() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append(this.id);
		builder.append(';');
		builder.append(this.nom);
		builder.append(';');
		builder.append(this.prenom);
		builder.append(';');
		builder.append(this.genius);
		builder.append(';');
		
		return builder.toString();
		
	} // Fin de toStringCsv()._____________________________________________
	
	
	/**
	 * {@inheritDoc}
	 */
//	@Transient
	@Override
	public String getEnTeteColonne(
			final int pI) {
		
		String entete = null;
		
		switch (pI) {

		case 0:
			entete = "id";
			break;

		case 1:
			entete = "nom";
			break;

		case 2:
			entete = "prénom";
			break;

		case 3:
			entete = "génie";
			break;

		default:
			entete = "invalide";
			break;

		} // Fin du Switch._________________________________
		
		return entete;
		
	} // Fin de getEnTeteColonne(...)._____________________________________



	/**
	 * {@inheritDoc}
	 */
//	@Transient
	@Override
	public Object getValeurColonne(
			final int pI) {
		
		Object valeur = null;
		
		switch (pI) {

		case 0:
			valeur = this.id;
			break;

		case 1:
			valeur = this.nom;
			break;

		case 2:
			valeur = this.prenom;
			break;

		case 3:
			valeur = this.genius;
			break;

		default:
			valeur = "invalide";
			break;

		} // Fin du Switch._________________________________
		
		return valeur;
		
	} // Fin de getValeurColonne(...)._____________________________________



	/**
	 * method getGenius() :<br/>
	 * Getter du Boolean qui spécifie 
	 * si la Personne est géniale ou pas.<br/>
	 * <br/>
	 *
	 * @return genius : Boolean.<br/>
	 */
	public final Boolean getGenius() {
		return this.genius;
	} // Fin de getGenius()._______________________________________________



	/**
	* method setGenius(
	* Boolean pGenius) :<br/>
	* Setter du Boolean qui spécifie 
	* si la Personne est géniale ou pas.<br/>
	* <br/>
	*
	* @param pGenius : Boolean : valeur à passer à genius.<br/>
	*/
	public final void setGenius(
			final Boolean pGenius) {
		this.genius = pGenius;
	} // Fin de setGenius(
	// Boolean pGenius).___________________________________________________
	

	
} // FIN DE LA CLASSE PersonneGenius.----------------------------------------

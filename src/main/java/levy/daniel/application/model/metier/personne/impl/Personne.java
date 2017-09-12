package levy.daniel.application.model.metier.personne.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.personne.AbstractPersonne;

/**
 * class Personne :<br/>
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
 * @since 17 août 2017
 *
 */
//@Entity
//@Table(name = "T_PERSONNES", schema = "PUBLIC")
//@PrimaryKeyJoinColumn(name = "ID_PERSONNE")
public class Personne extends AbstractPersonne {

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
	private static final Log LOG = LogFactory.getLog(Personne.class);
	

	// *************************METHODES************************************/
	
		
	 /**
	 * method CONSTRUCTEUR Personne() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public Personne() {
		this(null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR Personne(
	 * CONSTRUCTEUR COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pPrenom String : prénom de la personne.<br/>
	 * @param pNom : String : nom de la personne.<br/>
	 */
	public Personne(
			final String pPrenom
				, final String pNom) {
		
		this(null, pPrenom, pNom);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR Personne(
	 * CONSTRUCTEUR COMPLET BASE) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pPrenom String : prénom de la personne.<br/>
	 * @param pNom : String : nom de la personne.<br/>
	 */
	public Personne(
			final Long pId
				, final String pPrenom
					, final String pNom) {
		
		super(pId, pPrenom, pNom);

	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________
	

		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("Personne [");
		
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
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________
	
	
} // FIN DE LA CLASSE Personne.----------------------------------------------

package levy.daniel.application.model.metier.livre.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.livre.AbstractLivre;

/**
 * class Livre :<br/>
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
public class Livre extends AbstractLivre {

	// ************************ATTRIBUTS************************************/

	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * VIRGULE_SPACE : String :<br/>
	 * ", ".<br/>
	 */
	public static final String VIRGULE_SPACE = ", ";
	
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(Livre.class);
	

	// *************************METHODES************************************/
	
	
	
	 /**
	 * method CONSTRUCTEUR Livre() :<br/>
	 * CONCTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public Livre() {
		this(null, null, null);
	} // Fin de CONCTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR Livre( CONSTRUCTEUR COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * SANS ID en Base.<br/>
	 * <br/>
	 *
	 * @param pTitre : String : titre du livre.<br/>
	 * @param pAuteur : String : auteur du livre.<br/>
	 */
	public Livre(
			final String pTitre
				, final String pAuteur) {
		
		this(null, pTitre, pAuteur);
		
	} // Fin de  CONSTRUCTEUR COMPLET._____________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR Livre(CONSTRUCTEUR COMPLET BASE) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * AVEC ID en base.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pTitre : String : titre du livre.<br/>
	 * @param pAuteur : String : auteur du livre.<br/>
	 */
	public Livre(
			final Long pId
				, final String pTitre
					, final String pAuteur) {
		
		super(pId, pTitre, pAuteur);
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("Livre [");
		
		if (this.id != null) {
			builder.append("id=");
			builder.append(this.id);
			builder.append(VIRGULE_SPACE);
		}
		
		if (this.titre != null) {
			builder.append("titre=");
			builder.append(this.titre);
			builder.append(VIRGULE_SPACE);
		}
		
		if (this.auteur != null) {
			builder.append("auteur=");
			builder.append(this.auteur);
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________
	
	
	
	
} // FIN DE LA CLASSE Livre.-------------------------------------------------

package levy.daniel.application.model.metier.livre;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * class AbstractLivre :<br/>
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
@Entity
@Table(name = "ABSTRACT_LIVRES", schema = "public")
@Inheritance(strategy = InheritanceType.JOINED)
public class AbstractLivre 
		implements Serializable, Comparable<AbstractLivre>, Cloneable
							, ILivre {

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
	 * id : Long :<br/>
	 * ID en base.<br/>
	 */
	protected Long id;
	
	
	/**
	 * titre : String :<br/>
	 * titre du livre.<br/>
	 */
	protected String titre;
	
	
	/**
	 * auteur : String :<br/>
	 * auteur du livre.<br/>
	 */
	protected String auteur;
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(AbstractLivre.class);
	
	
	// *************************METHODES************************************/	
	
	
	 /**
	 * method CONSTRUCTEUR AbstractLivre() :<br/>
	 * CONCTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractLivre() {
		this(null, null, null);
	} // Fin de CONCTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR AbstractLivre( CONSTRUCTEUR COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * SANS ID en Base.<br/>
	 * <br/>
	 *
	 * @param pTitre : String : titre du livre.<br/>
	 * @param pAuteur : String : auteur du livre.<br/>
	 */
	public AbstractLivre(
			final String pTitre
				, final String pAuteur) {
		
		this(null, pTitre, pAuteur);
		
	} // Fin de  CONSTRUCTEUR COMPLET._____________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR AbstractLivre(CONSTRUCTEUR COMPLET BASE) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * AVEC ID en base.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pTitre : String : titre du livre.<br/>
	 * @param pAuteur : String : auteur du livre.<br/>
	 */
	public AbstractLivre(
			final Long pId
				, final String pTitre
					, final String pAuteur) {
		
		super();
		
		this.id = pId;
		this.titre = pTitre;
		this.auteur = pAuteur;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		
		final int prime = 31;
		
		int result = 1;
		result = prime * result 
				+ ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result 
				+ ((this.titre == null) ? 0 : this.titre.hashCode());
		result = prime * result 
				+ ((this.auteur == null) ? 0 : this.auteur.hashCode());
				
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
		
		if (pObj == null) {
			return false;
		}
		
		if (!(pObj instanceof AbstractLivre)) {
			return false;
		}
		
		final AbstractLivre other = (AbstractLivre) pObj;
		
		/* id. */
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		
		/* titre. */
		if (this.titre == null) {
			if (other.titre != null) {
				return false;
			}
		} else if (!this.titre.equals(other.titre)) {
			return false;
		}
		
		/* auteur. */
		if (this.auteur == null) {
			if (other.auteur != null) {
				return false;
			}
		} else if (!this.auteur.equals(other.auteur)) {
			return false;
		}
		
		return true;
		
	} // Fin de equals(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(
			final AbstractLivre pLivre) {
		
		if (this == pLivre) {
			return 0;
		}

		if (pLivre == null) {
			return -1;
		}

		int compareTitre = 0;
		int compareAuteur = 0;
		
		/* titre. */
		if (this.getTitre() == null) {
			if (pLivre.getTitre() != null) {
				return +1;
			}
		} else {

			if (pLivre.getTitre() == null) {
				return -1;
			}

			compareTitre = this.getTitre()
					.compareToIgnoreCase(pLivre.getTitre());

			if (compareTitre != 0) {
				return compareTitre;
			}

		}
		
		/* auteur. */
		if (this.getAuteur() == null) {
			if (pLivre.getAuteur() != null) {
				return +1;
			}
			
			return 0;
			
		}	

		if (pLivre.getAuteur() == null) {
			return -1;
		}

		compareAuteur = this.getAuteur()
				.compareToIgnoreCase(pLivre.getAuteur());
		
		return compareAuteur;
		
	} // Fin de compareTo()._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractLivre clone() throws CloneNotSupportedException {

		final AbstractLivre livreClone 
			= (AbstractLivre) super.clone();

		livreClone.setId(getId());
		livreClone.setTitre(this.getTitre());
		livreClone.setAuteur(this.getAuteur());
		
		return livreClone;

	} // Fin de clone().___________________________________________________
	

	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("AbstractLivre [");
		
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


	
	/**
	 * {@inheritDoc} <br/>
	 * retourne "id;titre;auteur;"
	 */
	@Transient
	@Override
	public String getEnTeteCsv() {
		return "id;titre;auteur;";
	} // Fin de getEnTeteCsv().____________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toStringCsv() {

		final StringBuilder builder = new StringBuilder();

		builder.append(this.id);
		builder.append(POINT_VIRGULE);
		builder.append(this.titre);
		builder.append(POINT_VIRGULE);
		builder.append(this.auteur);
		builder.append(POINT_VIRGULE);

		return builder.toString();

	} // Fin de toStringCsv()._____________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Transient
	@Override
	public String getEnTeteColonne(
			final int pI) {

		String entete = null;

		switch (pI) {

		case 0:
			entete = "id";
			break;

		case 1:
			entete = "titre";
			break;

		case 2:
			entete = "auteur";
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
	@Transient
	@Override
	public Object getValeurColonne(
			final int pI) {

		Object valeur = null;

		switch (pI) {

		case 0:
			valeur = this.id;
			break;

		case 1:
			valeur = this.titre;
			break;

		case 2:
			valeur = this.auteur;
			break;

		default:
			valeur = "invalide";
			break;

		} // Fin du Switch._________________________________

		return valeur;

	} // Fin de getValeurColonne(...)._____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@Override
	public Long getId() {
		return this.id;
	} // Fin de getId().___________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(
			final Long pId) {
		this.id = pId;
	} // Fin de setId(...).________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Column(name = "TITRE")
	@Override
	public String getTitre() {
		return this.titre;
	} // Fin de getTitre().________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTitre(
			final String pTitre) {
		this.titre = pTitre;
	} // Fin de setTitre(...)._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Column(name = "AUTEUR")
	@Override
	public String getAuteur() {
		return this.auteur;
	} // Fin de getAuteur()._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAuteur(
			final String pAuteur) {
		this.auteur = pAuteur;
	} // Fin de setAuteur(...).____________________________________________

	

} // FIN DE LA CLASSE AbstractLivre.---------------------------------------
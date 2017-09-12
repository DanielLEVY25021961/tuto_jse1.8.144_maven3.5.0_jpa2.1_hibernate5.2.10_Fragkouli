package levy.daniel.application.model.metier.personne;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * class AbstractPersonne :<br/>
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
//@Table(name = "T_ABSTRACT_PERSONNES"
//, schema = "PUBLIC"
//, uniqueConstraints={ @UniqueConstraint(name = "UNIQUE_NOM_PRENOM", columnNames={"NOM", "PRENOM"})}
//, indexes = { @Index(name = "INDEX_NOM_PRENOM", columnList = "NOM, PRENOM")})
//@Inheritance(strategy=InheritanceType.JOINED)
//@Access(AccessType.PROPERTY)
public class AbstractPersonne 
	implements IPersonne
		, Serializable, Comparable<AbstractPersonne>, Cloneable {

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
	 * prenom : String :<br/>
	 * prénom de la personne.<br/>
	 */
	protected String prenom;
	
	
	/**
	 * nom : String :<br/>
	 * nom de la personne.<br/>
	 */
	protected String nom;
	

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(AbstractPersonne.class);

	

	// *************************METHODES************************************/
	
		
	 /**
	 * method CONSTRUCTEUR AbstractPersonne() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractPersonne() {
		this(null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR AbstractPersonne(
	 * CONSTRUCTEUR COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pPrenom String : prénom de la personne.<br/>
	 * @param pNom : String : nom de la personne.<br/>
	 */
	public AbstractPersonne(
			final String pPrenom
				, final String pNom) {
		
		this(null, pPrenom, pNom);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR AbstractPersonne(
	 * CONSTRUCTEUR COMPLET BASE) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pPrenom String : prénom de la personne.<br/>
	 * @param pNom : String : nom de la personne.<br/>
	 */
	public AbstractPersonne(
			final Long pId
				, final String pPrenom
					, final String pNom) {
		
		super();
		
		this.id = pId;
		this.prenom = pPrenom;
		this.nom = pNom;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________
	

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		
		result = prime * result 
				+ ((this.nom == null) ? 0 : this.nom.hashCode());
		
		result = prime * result 
				+ ((this.prenom == null) ? 0 : this.prenom.hashCode());
		
		return result;
		
	} // Fin de hashCode().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(
			final Object pObjet) {
		
		if (this == pObjet) {
			return true;
		}
			
		if (pObjet == null) {
			return false;
		}
			
		if (this.getClass() != pObjet.getClass()) {
			return false;
		}
			
		final AbstractPersonne other = (AbstractPersonne) pObjet;
		
		if (this.getNom() == null) {
			if (other.getNom() != null) {
				return false;
			}				
		} else if (!this.getNom().equals(other.getNom())) {
			return false;
		}
			
		if (this.getPrenom() == null) {
			if (other.getPrenom() != null) {
				return false;
			}				
		} else if (!this.getPrenom().equals(other.getPrenom())) {
			return false;
		}
			
		return true;
		
	} // Fin de equals(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(
			final AbstractPersonne pPersonne) {
		
		if (this == pPersonne) {
			return 0;
		}
		
		if (pPersonne == null) {
			return -1;
		}
				
		int compareNom = 0;
		int comparePrenom = 0;
		
		/* nom. */
		if (this.getNom() == null) {
			if (pPersonne.getNom() != null) {
				return +1;
			}						
		} else {
			
			if (pPersonne.getNom() == null) {
				return -1;
			}
			
			compareNom = this.getNom().compareToIgnoreCase(pPersonne.getNom());
						
			if (compareNom != 0) {
				return compareNom;
			}
			
		}
		
		
		/* prenom. */
		if (this.getPrenom() == null) {
			
			if (pPersonne.getPrenom() != null) {
				return +1;
			}
			
			return 0;
		}
		
		if (pPersonne.getPrenom() == null) {
			return -1;
		}
		
		comparePrenom 
			= this.getPrenom().compareToIgnoreCase(pPersonne.getPrenom());
		
		return comparePrenom;
		
	} // Fin de compareTo(...).____________________________________________


	
	/**
	 * {@inheritDoc}
	 * @throws CloneNotSupportedException 
	 */
	@Override
	public AbstractPersonne clone() throws CloneNotSupportedException {
		
		final AbstractPersonne personneClone 
			= (AbstractPersonne) super.clone();
		
		personneClone.setId(this.getId());
		personneClone.setPrenom(this.getPrenom());
		personneClone.setNom(this.getNom());
		
		return personneClone;
		
	} // Fin de clone().___________________________________________________
	
	
		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("AbstractPersonne [");
		
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
		return "id;nom;prénom";
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

		default:
			valeur = "invalide";
			break;

		} // Fin du Switch._________________________________
		
		return valeur;
		
	} // Fin de getValeurColonne(...)._____________________________________


	
	/**
	 * {@inheritDoc}
	 */
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="ID_ABSTRACT_PERSONNE")
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
	} // Fin de setId(
	// Long pId).__________________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
//	@Column(name="PRENOM", length = 100
//			, nullable = false, updatable = true
//			, insertable = true, unique = false)
	@Override
	public String getPrenom() {
		return this.prenom;
	} // Fin de getPrenom()._______________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPrenom(
			final String pPrenom) {
		this.prenom = pPrenom;
	} // Fin de setPrenom(
	// String pPrenom).____________________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
//	@Column(name="NOM", length = 100
//			, nullable = false, updatable = true
//			, insertable = true, unique = false)
	@Override
	public String getNom() {
		return this.nom;
	} // Fin de getNom().__________________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setNom(
			final String pNom) {
		this.nom = pNom;
	} // Fin de setNom(
	// String pNom)._______________________________________________________



} // FIN DE LA CLASSE AbstractPersonne.--------------------------------------

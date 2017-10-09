package levy.daniel.application.model.metier.book.impl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * class Book :<br/>
 * .<br/>
 * <br/>
 * https://examples.javacodegeeks.com/enterprise-java/hibernate/hibernate-jpa-dao-example/<br/>
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
@Table(name="BOOKS", schema="public")
public class Book 
			implements Serializable, Comparable<Book>, Cloneable {

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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	
	/**
	 * title : String :<br/>
	 * titre du livre.<br/>
	 */
	@Column(name = "title")
	private String title;

	
	/**
	 * author : String :<br/>
	 * auteur du livre.<br/>
	 */
	@Column(name= "author")
	private String author;
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(Book.class);

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR Book() :<br/>
	 * CONCTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public Book() {
		this(null, null, null);
	} // Fin de CONCTRUCTEUR D'ARITE NULLE.________________________________


	
	 /**
	 * method CONSTRUCTEUR Book(CONSTRUCTEUR COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * SANS ID en Base.<br/>
	 * <br/>
	 *
	 * @param pTitle : String : titre du livre.<br/>
	 * @param pAuthor : String : auteur du livre.<br/>
	 */
	public Book(
			final String pTitle
				, final String pAuthor) {
		
		this(null, pTitle, pAuthor);
		
	} // Fin de  CONSTRUCTEUR COMPLET._____________________________________
	

	
	 /**
	 * method CONSTRUCTEUR Book(CONSTRUCTEUR COMPLET BASE) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * AVEC ID en base.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pTitle : String : titre du livre.<br/>
	 * @param pAuthor : String : auteur du livre.<br/>
	 */
	public Book(
			final Long pId
				, final String pTitle
					, final String pAuthor) {
		
		super();
		
		this.id = pId;
		this.title = pTitle;
		this.author = pAuthor;
		
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
				+ ((this.title == null) ? 0 : this.title.hashCode());
		result = prime * result 
				+ ((this.author == null) ? 0 : this.author.hashCode());
		
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
		
		if (!(pObj instanceof Book)) {
			return false;
		}
		
		final Book other = (Book) pObj;
		
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		
		if (this.title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!this.title.equals(other.title)) {
			return false;
		}
		
		if (this.author == null) {
			if (other.author != null) {
				return false;
			}
		} else if (!this.author.equals(other.author)) {
			return false;
		}

		return true;
		
	} // Fin de equals(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(
			final Book pBook) {

		if (this == pBook) {
			return 0;
		}

		if (pBook == null) {
			return -1;
		}

		int compareTitre = 0;
		int compareAuteur = 0;
		
		/* titre. */
		if (this.getTitle() == null) {
			if (pBook.getTitle() != null) {
				return +1;
			}
		} else {

			if (pBook.getTitle() == null) {
				return -1;
			}

			compareTitre = this.getTitle()
					.compareToIgnoreCase(pBook.getTitle());

			if (compareTitre != 0) {
				return compareTitre;
			}

		}
		
		/* auteur. */
		if (this.getAuthor() == null) {
			if (pBook.getAuthor() != null) {
				return +1;
			}
			
			return 0;
			
		}	

		if (pBook.getAuthor() == null) {
			return -1;
		}

		compareAuteur = this.getAuthor()
				.compareToIgnoreCase(pBook.getAuthor());
		
		return compareAuteur;
		
	} // Fin de compareTo()._______________________________________________

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Book clone() throws CloneNotSupportedException {

		final Book livreClone 
			= (Book) super.clone();

		livreClone.setId(getId());
		livreClone.setTitle(this.getTitle());
		livreClone.setAuthor(this.getAuthor());
		
		return livreClone;

	} // Fin de clone().___________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("Book [");
		
		if (this.id != null) {
			builder.append("id=");
			builder.append(this.id);
			builder.append(VIRGULE_SPACE);
		}
		
		if (this.title != null) {
			builder.append("title=");
			builder.append(this.title);
			builder.append(VIRGULE_SPACE);
		}
		
		if (this.author != null) {
			builder.append("author=");
			builder.append(this.author);
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________

	
	
	/**
	 * method getId() :<br/>
	 * Getter de l'ID en Base.<br/>
	 * <br/>
	 *
	 * @return : Long : ID en Base.<br/>
	 */
	public Long getId() {
		return this.id;
	} // Fin de getId().___________________________________________________

	
	
	/**
	 * method setId(
	 * Long pId) :<br/>
	 * Setter de l'ID en base.<br/>
	* <br/>
	*
	* @param pId : Long : 
	* valeur à passer à id.<br/>
	 */
	public void setId(
			final Long pId) {
		this.id = pId;
	} // Fin de setId(...).________________________________________________

	
	
	/**
	 * method getTitle() :<br/>
	 * Getter du titre du livre.<br/>
	 * <br/>
	 *
	 * @return : String : this.title.<br/>
	 */
	public String getTitle() {
		return this.title;
	} // Fin de getTitle().________________________________________________

	
	
	/**
	 * method setTitle(
	 * String pTitle) :<br/>
	 * Setter du titre du livre.<br/>
	 * <br/>
	 *
	 * @param pTitle : String : 
	 * valeur à passer à title.<br/>
	 */
	public void setTitle(
			final String pTitle) {
		this.title = pTitle;
	} // Fin de setTitle(...)._____________________________________________

	
	
	/**
	 * method getAuthor() :<br/>
	 * Getter de l'auteur du livre.<br/>
	 * <br/>
	 *
	 * @return : String : this.author.<br/>
	 */
	public String getAuthor() {
		return this.author;
	} // Fin de getAuthor()._______________________________________________

	
	
	/**
	 * method setAuthor(
	 * String pAuthor) :<br/>
	 * Setter de l'auteur du livre.<br/>
	 * <br/>
	 *
	 * @param pAuthor : String : 
	 * valeur à passer à author.<br/>
	 */
	public void setAuthor(
			final String pAuthor) {
		this.author = pAuthor;
	} // Fin de setAuthor(...).____________________________________________

	
	
} // FIN DE LA CLASSE Book.--------------------------------------------------

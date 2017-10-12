package levy.daniel.application.model.metier.book.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * class SousBook :<br/>
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
 * @since 16 sept. 2017
 *
 */
@Entity
@Table(name = "SOUS_BOOKS", schema="public")
@PrimaryKeyJoinColumn(name = "ID")
public class SousBook extends Book {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * editor : String :<br/>
	 * editor du Book.<br/>
	 */
	@Column(name = "EDITOR")
	private String editor;

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(SousBook.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR SousBook() :<br/>
	 * CONCTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public SousBook() {
		this(null, null, null, null);
	} // Fin de CONCTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR SousBook() :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * SANS ID en Base.<br/>
	 * <br/>
	 *
	 *  @param pTitle : String : titre du livre.<br/>
	 * @param pAuthor : String : auteur du livre.<br/>
	 * @param pEditor : String : editor du Book.<br/>
	 */
	public SousBook(
			final String pTitle
					, final String pAuthor
						, final String pEditor) {
		this(null, pTitle, pAuthor, pEditor);
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR SousBook() :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * AVEC ID en base.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pTitle : String : titre du livre.<br/>
	 * @param pAuthor : String : auteur du livre.<br/>
	 * @param pEditor : String : editor du Book.<br/>
	 */
	public SousBook(
			final Long pId
				, final String pTitle
					, final String pAuthor
						, final String pEditor) {
		
		super(pId, pTitle, pAuthor);
		
		this.editor = pEditor;
		
	} // Fin de  CONSTRUCTEUR COMPLET BASE.________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("SousBook [");
		
		if (this.getId() != null) {
			builder.append("id=");
			builder.append(this.getId());
			builder.append(VIRGULE_SPACE);
		}
		
		if (this.getTitle() != null) {
			builder.append("title=");
			builder.append(this.getTitle());
			builder.append(VIRGULE_SPACE);
		}
		
		if (this.getAuthor() != null) {
			builder.append("author=");
			builder.append(this.getAuthor());
			builder.append(VIRGULE_SPACE);
		}
		
		if (this.getEditor() != null) {
			builder.append("editor=");
			builder.append(this.getEditor());
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________

	
	
	/**
	 * method getEditor() :<br/>
	 * Getter de l'editor du Book.<br/>
	 * <br/>
	 *
	 * @return editor : String.<br/>
	 */
	public String getEditor() {	
		return this.editor;
	} // Fin de getEditor()._______________________________________________


	
	/**
	* method setEditor(
	* String pEditor) :<br/>
	* Detter de l'editor du Book.<br/>
	* <br/>
	*
	* @param pEditor : String : 
	* valeur à passer à editor.<br/>
	*/
	public void setEditor(
			final String pEditor) {	
		this.editor = pEditor;
	} // Fin de setEditor(...).____________________________________________
	
		
	
} // FIN DE LA CLASSE SousBook.----------------------------------------------

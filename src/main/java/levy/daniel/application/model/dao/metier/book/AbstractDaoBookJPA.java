package levy.daniel.application.model.dao.metier.book;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dao.AbstractDaoGenericJPA;
import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.metier.book.impl.Book;

/**
 * class AbstractDaoBook :<br/>
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
public abstract class AbstractDaoBookJPA 
			extends AbstractDaoGenericJPA<Book, Long> 
								implements IDaoBook {

	// ************************ATTRIBUTS************************************/

	/**
	 * SAUT_LIGNE_JAVA : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE_JAVA = '\n';
	
	/**
	 * SELECT_BOOK : String :<br/>
	 * "select book from Book as book ".<br/>
	 */
	public static final String SELECT_BOOK 
		= "select book from Book as book ";
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(AbstractDaoBookJPA.class);

	// *************************METHODES************************************/
	
	 /**
	 * method CONSTRUCTEUR AbstractDaoClient() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractDaoBookJPA() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long createReturnId(
			final Book pBook) throws AbstractDaoException {
		
		/* retourne null si pBook == null. */
		if (pBook == null) {
			return null;
		}
		
		/* Crée le Book en base. */
		final Book bookPersistant = this.create(pBook);
		
		if (bookPersistant != null) {
			return bookPersistant.getId();
		}
		
		return null;
		
	} // Fin de createReturnId(...)._______________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Book retrieve(
			final Book pBook) throws AbstractDaoException {
		
		/* return null si pBook == null. */
		if (pBook == null) {
			return null;
		}
		
		Book bookResultat = null;
		
		/* REQUETE HQL PARMETREE. */
		final String requeteString 
			= SELECT_BOOK
				+ "where book.title = :title and book.author = :author";
		
		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("title", pBook.getTitle());
		requete.setParameter("author", pBook.getAuthor());
		
		try {
			
			/* Execution de la requete HQL. */
			bookResultat = (Book) requete.getSingleResult();
			
		}
		catch (NoResultException noResultExc) {
			
			/* retourne null si l'Objet métier n'existe pas en base. */
			return null;
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(e);
		}
				
		return bookResultat;
		
	} // Fin de retrieve(...)._____________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Book retrieveByIdMetier(
			final Book pBook) throws AbstractDaoException {
		return this.retrieve(pBook);
	} // Fin de retrieveByIdMetier(...).___________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void deleteById(
			final Long pId) throws AbstractDaoException {
		
		/* ne fait rien si pId == null. */
		if (pId == null) {
			return;
		}

		Book bookPersistant = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
		= SELECT_BOOK 
		+ "where book.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			/* Execution de la requete HQL. */
			bookPersistant = (Book) requete.getSingleResult();
		}
		catch (NoResultException noResultExc) {
			bookPersistant = null;
		}
		
		/* Récupération d'une TransactionJPA 
		 * javax.persistence.EntityTransaction 
		 * auprès du entityManager. */
		final EntityTransaction transaction 
			= this.entityManager.getTransaction();

		try {
			
			if (bookPersistant != null) {
				
				/* Début de la Transaction. */
				if (!transaction.isActive()) {
					transaction.begin();
				}
				
				/* DESTRUCTION. */
				this.entityManager.remove(bookPersistant);
				
				/* Commit de la Transaction (Réalise le SQL INSERT). */
				transaction.commit();

			}

		}
		catch (Exception e) {
			
			/* Rollback de la transaction. */
			if (transaction != null) {
				transaction.rollback();
			}

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(e);
		}
//		finally {
//			
//			/* Clôture de la Session. */
//			if (this.session != null) {
//				this.session.close();
//			}
//								
//		}
		
	} // Fin de deleteById(...).___________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean deleteByIdBoolean(
			final Long pId) throws AbstractDaoException {

		/* retourne false si pId == null. */
		if (pId == null) {
			return false;
		}
		
		boolean resultat = false;
		
		Book bookPersistant = null;

		/* REQUETE HQL PARMETREE. */
		final String requeteString 
		= SELECT_BOOK 
		+ "where book.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			/* Execution de la requete HQL. */
			bookPersistant = (Book) requete.getSingleResult();
		}
		catch (NoResultException noResultExc) {
			bookPersistant = null;
			resultat = false;
		}
		

		/* Récupération d'une TransactionJPA 
		 * javax.persistence.EntityTransaction 
		 * auprès du entityManager. */
		final EntityTransaction transaction 
			= this.entityManager.getTransaction();

		try {

			if (bookPersistant != null) {
				
				/* Début de la Transaction. */
				if (!transaction.isActive()) {
					transaction.begin();
				}
				
				/* DESTRUCTION. */
				this.entityManager.remove(bookPersistant);
				
				/* Commit de la Transaction (Réalise le SQL INSERT). */
				transaction.commit();
				
				resultat = true;

			}

		}
		catch (Exception e) {
			
			/* Rollback de la transaction. */
			if (transaction != null) {
				transaction.rollback();
			}

			resultat = false;
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(e);
			
		}
//		finally {
//			
//			/* Clôture de la Session. */
//			if (this.session != null) {
//				this.session.close();
//			}
//								
//		}
		
		return resultat;
		
	} // Fin de deleteByIdBoolean(...).____________________________________

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final Book pBook) throws AbstractDaoException {
		
		/* retourne false si pBook == null. */
		if (pBook == null) {
			return false;
		}

		boolean resultat = false;
		Book bookResultat = null;
		
		/* REQUETE HQL PARMETREE. */
		final String requeteString 
			= SELECT_BOOK
				+ "where book.title = :title and book.author = :author";
		
		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("title", pBook.getTitle());
		requete.setParameter("author", pBook.getAuthor());
		
		try {
			
			/* Execution de la requete HQL. */
			bookResultat = (Book) requete.getSingleResult();
			
			/* retourne true si l'objet existe en base. */
			if (bookResultat != null) {
				resultat = true;
			}
		}
		catch (NoResultException noResultExc) {
			
			/* retourne false si l'Objet métier n'existe pas en base. */
			return false;
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(e);
		}
		
		return resultat;
		
	} // Fin de exists(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final Long pId) throws AbstractDaoException {
		
		/* retourne false si pId == null . */
		if (pId == null) {
			return false;
		}
		
		/* retourne true si l'objet métier existe en base. */
		if (this.findById(pId) != null) {
			return true;
		}
		
		return false;
		
	} // Fin de exists(...)._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String afficherListe(
			final List<Book> pListe) {
		
		/* retourne null si pListe == null. */
		if (pListe == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		for (final Book book : pListe) {
			stb.append(book.toString());
			stb.append(SAUT_LIGNE_JAVA);
		}
				
		return stb.toString();
		
	} // Fin de afficherListe(...).________________________________________
	
	
	
} // FIN DE LA CLASSE AbstractDaoBook.---------------------------------------

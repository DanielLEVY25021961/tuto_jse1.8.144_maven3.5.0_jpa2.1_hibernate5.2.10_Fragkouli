package levy.daniel.application.model.metier.commande;

import java.io.Serializable;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import levy.daniel.application.model.metier.client.AbstractClient;

/**
 * class AbstractCommande :<br/>
 * .<br/>
 * <br/>
 * - Exemple d'utilisation :<br/>
 * <br/>
 * - Mots-clé :<br/>
 * <br/>
 * - Dépendances :<br/>
 * <br/>
 *
 * @author dan Lévy
 * @version 1.0
 * @since 20 août 2017
 */
@Entity
@Table(name = "ABSTRACT_COMMANDES")
@Inheritance(strategy = InheritanceType.JOINED)
public class AbstractCommande
		implements Serializable, Comparable<AbstractCommande>, Cloneable
			, ICommande {

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
	 * dateCommande : DateTime :<br/>
	 * date de la commande.<br/>
	 */
	protected DateTime dateCommande;

	
	/**
	 * montant : Double :<br/>
	 * montant de la commande.<br/>
	 */
	protected Double montant;

	
	/**
	 * modePaiement : String :<br/>
	 * mode de paiement de la commande.<br/>
	 */
	protected String modePaiement;

	
	/**
	 * statutPaiement : String :<br/>
	 * statut du paiement de la commande.<br/>
	 */
	protected String statutPaiement;

	
	/**
	 * modeLivraison : String :<br/>
	 * mode de livraison de la commande.<br/>
	 */
	protected String modeLivraison;

	
	/**
	 * statutLivraison : String :<br/>
	 * statut de la livraison de la commande.<br/>
	 */
	protected String statutLivraison;

	
	/**
	 * client : AbstractClient :<br/>
	 * client de la commande.<br/>
	 */
	protected AbstractClient client;

	
	/**
	 * LOG : Log : Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG	
		= LogFactory.getLog(AbstractCommande.class);

	// *************************METHODES************************************/

	/**
	 * method CONSTRUCTEUR AbstractCommande() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractCommande() {
		this(null, null, null, null, null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
	/**
	 * method CONSTRUCTEUR AbstractCommande( CONSTRUCTEUR COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pDateCommande : org.joda.time.DateTime : 
	 * date de la commande.<br/>
	 * @param pMontant : Double : 
	 * montant de la commande.<br/>
	 * @param pModePaiement : String : 
	 * mode de paiement de la commande.<br/>
	 * @param pStatutPaiement : String : s
	 * tatut du paiement de la commande.<br/>
	 * @param pModeLivraison : String : 
	 * mode de livraison de la commande.<br/>
	 * @param pStatutLivraison : String : 
	 * statut de la livraison de la commande.<br/>
	 * @param pClient : AbstractClient : client de la commande.<br/>
	 */
	public AbstractCommande(
			final DateTime pDateCommande
			, final Double pMontant
			, final String pModePaiement
			, final String pStatutPaiement
			, final String pModeLivraison
			, final String pStatutLivraison
			, final AbstractClient pClient) {

		this(null
				, pDateCommande
				, pMontant
				, pModePaiement, pStatutPaiement
				, pModeLivraison, pStatutLivraison
				, pClient);

	} // Fin de CONSTRUCTEUR COMPLET.______________________________________

	
	
	/**
	 * method CONSTRUCTEUR AbstractCommande(
	 * CONSTRUCTEUR COMPLET BASE) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pDateCommande : org.joda.time.DateTime : 
	 * date de la commande.<br/>
	 * @param pMontant : Double : 
	 * montant de la commande.<br/>
	 * @param pModePaiement : String : 
	 * mode de paiement de la commande.<br/>
	 * @param pStatutPaiement : String : 
	 * statut du paiement de la commande.<br/>
	 * @param pModeLivraison : String : 
	 * mode de livraison de la commande.<br/>
	 * @param pStatutLivraison : String : 
	 * statut de la livraison de la commande.<br/>
	 * @param pClient : AbstractClient : client de la commande.<br/>
	 */
	public AbstractCommande(
			final Long pId
			, final DateTime pDateCommande
			, final Double pMontant
			, final String pModePaiement
			, final String pStatutPaiement
			, final String pModeLivraison
			, final String pStatutLivraison
			, final AbstractClient pClient) {

		super();

		this.id = pId;
		this.dateCommande = pDateCommande;
		this.montant = pMontant;
		this.modePaiement = pModePaiement;
		this.statutPaiement = pStatutPaiement;
		this.modeLivraison = pModeLivraison;
		this.statutLivraison = pStatutLivraison;
		this.client = pClient;

	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {

		final int prime = 31;

		int result = 1;

		result = prime * result 
				+ (this.client == null ? 0 : this.client.hashCode());
		result = prime * result 
		+ (this.dateCommande == null ? 0 : this.dateCommande.hashCode());
		result = prime * result 
				+ (this.montant == null ? 0 : this.montant.hashCode());

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

		if (!(pObj instanceof AbstractCommande)) {
			return false;
		}

		final AbstractCommande other = (AbstractCommande) pObj;

		if (this.client == null) {
			if (other.client != null) {
				return false;
			}
		} else if (!this.client.equals(other.client)) {
			return false;
		}

		if (this.dateCommande == null) {
			if (other.dateCommande != null) {
				return false;
			}
		} else if (!this.dateCommande
				.equals(other.dateCommande)) {
			return false;
		}

		if (this.montant == null) {
			if (other.montant != null) {
				return false;
			}
		} else if (!this.montant.equals(other.montant)) {
			return false;
		}

		return true;

	} // Fin de equals().__________________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(
			final AbstractCommande pCommande) {

		if (this == pCommande) {
			return 0;
		}

		if (pCommande == null) {
			return -1;
		}

		int compareClient = 0;
		int compareDate = 0;
		int compareMontant = 0;

		/* client. */
		if (this.client == null) {
			if (pCommande.getClient() != null) {
				return +1;
			}
		} else {

			if (pCommande.getClient() == null) {
				return -1;
			}

			compareClient =
					this.getClient().getNom()
					.compareToIgnoreCase(pCommande.getClient().getNom());

			if (compareClient != 0) {
				return compareClient;
			}
		}

		/* date. */
		if (this.getDateCommande() == null) {
			if (pCommande.getDateCommande() != null) {
				return +1;
			}
		} else {

			if (pCommande.getDateCommande() == null) {
				return -1;
			}

			compareDate = this.getDateCommande()
					.compareTo(pCommande.getDateCommande());

			if (compareDate != 0) {
				return compareDate;
			}

		}

		/* montant. */
		if (this.getMontant() == null) {
			if (pCommande.getMontant() != null) {
				return +1;
			}

			return 0;
		}
		if (pCommande.getMontant() == null) {
			return -1;
		}

		compareMontant 
			= this.getMontant().compareTo(pCommande.getMontant());

		return compareMontant;

	} // Fin de compareTo()._______________________________________________

	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractCommande clone() throws CloneNotSupportedException {

		final AbstractCommande commandeClone 
			= (AbstractCommande) super.clone();

		commandeClone.setId(getId());
		commandeClone.setDateCommande(getDateCommande());
		commandeClone.setMontant(getMontant());
		commandeClone.setModePaiement(getModePaiement());
		commandeClone.setStatutPaiement(getStatutPaiement());
		commandeClone.setModeLivraison(getModeLivraison());
		commandeClone.setStatutLivraison(getStatutLivraison());

		AbstractClient clientClone = null;
		if (this.client != null) {
			clientClone = this.client.clone();
		}

		commandeClone.setClient(clientClone);

		return commandeClone;

	} // Fin de clone().___________________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		final StringBuilder builder = new StringBuilder();

		builder.append("AbstractCommande [");

		if (this.id != null) {
			builder.append("id=");
			builder.append(this.id);
			builder.append(", ");
		}
		if (this.dateCommande != null) {
			builder.append("dateCommande=");
			builder.append(this.dateCommande);
			builder.append(", ");
		}
		if (this.montant != null) {
			builder.append("montant=");
			builder.append(this.montant);
			builder.append(", ");
		}
		if (this.modePaiement != null) {
			builder.append("modePaiement=");
			builder.append(this.modePaiement);
			builder.append(", ");
		}
		if (this.statutPaiement != null) {
			builder.append("statutPaiement=");
			builder.append(this.statutPaiement);
			builder.append(", ");
		}
		if (this.modeLivraison != null) {
			builder.append("modeLivraison=");
			builder.append(this.modeLivraison);
			builder.append(", ");
		}
		if (this.statutLivraison != null) {
			builder.append("statutLivraison=");
			builder.append(this.statutLivraison);
			builder.append(", ");
		}
		if (this.client != null) {
			builder.append("client=");
			builder.append(this.client.getNom());
			builder.append(' ');
			builder.append(this.client.getPrenom());
		}

		builder.append(']');

		return builder.toString();

	} // Fin de toString().________________________________________________

	
	
	/**
	 * {@inheritDoc} <br/>
	 * retourne "id;dateCommande;montant;modePaiement;statutPaiement;
	 * modeLivraison;statutLivraison;nomClient;prenomClient;"
	 */
	@Transient
	@Override
	public String getEnTeteCsv() {

		return "id;dateCommande;montant;modePaiement;statutPaiement;"
				+ "modeLivraison;statutLivraison;nomClient;prenomClient;";

	} // Fin de getEnTeteCsv().____________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toStringCsv() {

		final StringBuilder builder = new StringBuilder();

		final String dateCommandeString 
			= fournirDateFormatee(this.dateCommande);

		final String nomClient = fournirNomClient(this.client);
		final String prenomClient = fournirPrenomClient(this.client);

		builder.append(this.id);
		builder.append(';');

		builder.append(dateCommandeString);
		builder.append(';');

		builder.append(this.montant);
		builder.append(';');

		builder.append(this.modePaiement);
		builder.append(';');

		builder.append(this.statutPaiement);
		builder.append(';');

		builder.append(this.modeLivraison);
		builder.append(';');

		builder.append(this.statutLivraison);
		builder.append(';');

		builder.append(nomClient);
		builder.append(';');

		builder.append(prenomClient);
		builder.append(';');

		return builder.toString();

	} // Fin de toStringCsv()._____________________________________________

	
	
	/**
	 * {@inheritDoc} <br/>
	 * "id;dateCommande;montant;modePaiement;statutPaiement;
	 * modeLivraison;statutLivraison;nomClient;prenomClient;";
	 */
	@Override
	public String getEnTeteColonne(final int pI) {

		String entete = null;

		switch (pI) {

		case 0:
			entete = "id";
			break;

		case 1:
			entete = "dateCommande";
			break;

		case 2:
			entete = "montant";
			break;

		case 3:
			entete = "modePaiement";
			break;

		case 4:
			entete = "statutPaiement";
			break;

		case 5:
			entete = "modeLivraison";
			break;

		case 6:
			entete = "statutLivraison";
			break;

		case 7:
			entete = "nomClient";
			break;

		case 8:
			entete = "prenomClient";
			break;

		default:
			entete = "invalide";
			break;

		} // Fin du Switch._________________________________

		return entete;

	} // Fin de getEnTeteColonne().________________________________________

	
	
	/**
	 * {@inheritDoc} <br/>
	 * "id;dateCommande;montant;modePaiement;statutPaiement;
	 * modeLivraison;statutLivraison;nomClient;prenomClient;";
	 */
	@Override
	public Object getValeurColonne(final int pI) {
		Object valeur = null;

		switch (pI) {

		case 0:
			valeur = this.id;
			break;

		case 1:
			valeur = fournirDateFormatee(this.dateCommande);
			break;

		case 2:
			valeur = this.montant;
			break;

		case 3:
			valeur = this.modePaiement;
			break;

		case 4:
			valeur = this.statutPaiement;
			break;

		case 5:
			valeur = this.modeLivraison;
			break;

		case 6:
			valeur = this.statutLivraison;
			break;

		case 7:
			valeur = fournirNomClient(this.client);
			break;

		case 8:
			valeur = fournirPrenomClient(this.client);
			break;

		default:
			valeur = "invalide";
			break;

		} // Fin du Switch._________________________________

		return valeur;

	} // Fin de getValeurColonne().________________________________________

	
	
	/**
	 * method fournirDateFormatee( DateTime pDate) :<br/>
	 * Retourne une date formatée au format "dd/MM/yyyy HH:mm:ss".<br/>
	 * Par exemple, 25/02/1961 14:37:35 <br/>
	 *
	 * @param pDate : org.joda.time.DateTime
	 * @return : String : date au format "dd/MM/yyyy HH:mm:ss".<br/>
	 */
	private String fournirDateFormatee(final DateTime pDate) {

		String dateFormatee = null;

		/* Récupération de la Locale courante de la machine. */
		final Locale localeFr = Locale.getDefault();

		/* Instanciation d'un DateTimeFormatter. */
		final DateTimeFormatter dtformatterComplet =
				DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss").withLocale(localeFr);

		/* Formatage de la org.joda.time.DateTime. */
		dateFormatee = pDate.toString(dtformatterComplet);

		return dateFormatee;

	} // Fin de fournirDateFormatee(...).__________________________________

	
	
	/**
	 * method fournirNomClient(
	 * AbstractClient pClient) :<br/>
	 * Retourne le nom d'un Client.<br/>
	 * <br/>
	 *
	 * @param pClient : AbstractClient.<br/>
	 * @return : String : nom du Client.<br/>
	 */
	private String fournirNomClient(
			final AbstractClient pClient) {

		String nomClient = null;

		if (pClient != null) {
			nomClient = pClient.getNom();
		}

		return nomClient;

	} // Fin de fournirNomClient(...)._____________________________________
	
	

	/**
	 * method fournirPrenomClient(
	 * AbstractClient pClient) :<br/>
	 * Retourne le prénom d'un Client.<br/>
	 * <br/>
	 *
	 * @param pClient : AbstractClient.<br/>
	 * @return : String : prénom du Client.<br/>
	 */
	private String fournirPrenomClient(
			final AbstractClient pClient) {

		String prenomClient = null;

		if (pClient != null) {
			prenomClient = pClient.getPrenom();
		}

		return prenomClient;

	} // Fin de fournirPrenomClient(...).__________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCOMMANDE")
	@Override
	public Long getId() {
		return this.id;
	} // Fin de getId().___________________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(final Long pId) {
		this.id = pId;
	} // Fin de setId().___________________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Column(name = "DATE")
//	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	public DateTime getDateCommande() {
		return this.dateCommande;
	} // Fin de getDateCommande()._________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDateCommande(final DateTime pDateCommande) {
		this.dateCommande = pDateCommande;
	} // Fin de setDateCommande()._________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Column(name = "MONTANT")
	@Override
	public Double getMontant() {
		return this.montant;
	} // Fin de getMontant().______________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMontant(final Double pMontant) {
		this.montant = pMontant;
	} // Fin de setMontant().______________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Column(name = "MODE_DE_PAIEMENT")
	@Override
	public String getModePaiement() {
		return this.modePaiement;
	} // Fin de getModePaiement()._________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setModePaiement(final String pModePaiement) {
		this.modePaiement = pModePaiement;
	} // Fin de setModePaiement()._________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Column(name = "STATUT_PAIEMENT")
	@Override
	public String getStatutPaiement() {
		return this.statutPaiement;
	} // Fin de getStatutPaiement()._______________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStatutPaiement(final String pStatutPaiement) {
		this.statutPaiement = pStatutPaiement;
	} // Fin de setStatutPaiement()._______________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Column(name = "MODE_LIVRAISON")
	@Override
	public String getModeLivraison() {
		return this.modeLivraison;
	} // Fin de getModeLivraison().________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setModeLivraison(final String pModeLivraison) {
		this.modeLivraison = pModeLivraison;
	} // Fin de setModeLivraison().________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Column(name = "STATUT_LIVRAISON")
	@Override
	public String getStatutLivraison() {
		return this.statutLivraison;
	} // Fin de getStatutLivraison().______________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStatutLivraison(final String pStatutLivraison) {
		this.statutLivraison = pStatutLivraison;
	} // Fin de setStatutLivraison().______________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@ManyToOne()
	@JoinColumn(name = "IDCLIENT")
	public AbstractClient getClient() {
		return this.client;
	} // Fin de getClient()._______________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setClient(final AbstractClient pClient) {
		this.client = pClient;
	} // Fin de setClient()._______________________________________________

	
	
} // FIN DE LA CLASSE AbstractCommande.--------------------------------------

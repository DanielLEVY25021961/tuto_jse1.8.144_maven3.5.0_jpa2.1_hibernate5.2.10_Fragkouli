package levy.daniel.application.model.metier.adresse;

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
 * class Adress :<br/>
 * .<br/>
 * <br/>
 * Site du tutoriel : <br/>
 * https://sayemdb.wordpress.com/2014/08/15/jpa-tutorial-setting-up-jpa-in-a-java-se-environment/<br/>
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
 * @since 11 sept. 2017
 *
 */
@Entity
@Table(name="ADRESSES", schema="public")
public class Adress 
		implements Serializable, Comparable<Adress>, Cloneable {

	// ************************ATTRIBUTS************************************/

	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * id : Long :<br/>
	 * ID en base.<br/>
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	
	/**
	 * numero : String :<br/>
	 * Numéro de rue.<br/>
	 */
	@Column(name = "NUMERO")
	private String numero;
	
	
	/**
	 * street : String :<br/>
	 * Rue.<br/>
	 */
	@Column(name = "STREET")
	private String street;
	
	
	/**
	 * postcode : String :<br/>
	 * Code Postal.<br/>
	 */
	@Column(name = "POSTCODE")
	private String postcode;
	
	
	/**
	 * city : String :<br/>
	 * Ville.<br/>
	 */
	@Column(name = "CITY")
	private String city;
	
	
	/**
	 * province : String :<br/>
	 * Province ou Région.<br/>
	 */
	@Column(name = "PROVINCE")
	private String province;
	
	
	/**
	 * country : String :<br/>
	 * Pays.<br/>
	 */
	@Column(name = "COUNTRY")
	private String country;


	/**
	 * LOG : Log : Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(Adress.class);

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR Adress() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public Adress() {
		this(null, null, null, null, null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR Adress(CONSTRUCTEUR COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * SANS ID en Base.<br/>
	 * <br/>
	 *
	 * @param pNumero : String : Numéro de rue.<br/>
	 * @param pStreet : String : Rue.<br/>
	 * @param pPostcode : String : Code Postal.<br/>
	 * @param pCity : String : Ville.<br/>
	 * @param pProvince : String : Province ou Région.<br/> 
	 * @param pCountry : String : Pays.<br/>
	 */
	public Adress(
			final String pNumero, final String pStreet
			, final String pPostcode, final String pCity
			, final String pProvince, final String pCountry) {
		
		this(null
				, pNumero, pStreet
				, pPostcode, pCity
				, pProvince, pCountry);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________

	
	
	 /**
	 * method CONSTRUCTEUR Adress(CONSTRUCTEUR COMPLET BASE) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * AVEC ID en Base.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pNumero : String : Numéro de rue.<br/>
	 * @param pStreet : String : Rue.<br/>
	 * @param pPostcode : String : Code Postal.<br/>
	 * @param pCity : String : Ville.<br/>
	 * @param pProvince : String : Province ou Région.<br/> 
	 * @param pCountry : String : Pays.<br/>
	 */
	public Adress(
			final Long pId
			, final String pNumero, final String pStreet
			, final String pPostcode, final String pCity
			, final String pProvince, final String pCountry) {
		
		super();
		
		this.id = pId;
		this.numero = pNumero;
		this.street = pStreet;
		this.postcode = pPostcode;
		this.city = pCity;
		this.province = pProvince;
		this.country = pCountry;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int hashCode() {
		
		final int prime = 31;
		
		int result = 1;
		
		result = prime * result 
				+ ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result 
				+ ((this.numero == null) ? 0 : this.numero.hashCode());
		result = prime * result 
				+ ((this.street == null) ? 0 : this.street.hashCode());
		result = prime * result 
				+ ((this.postcode == null) ? 0 : this.postcode.hashCode());
		result = prime * result 
				+ ((this.city == null) ? 0 : this.city.hashCode());		
		result = prime * result 
				+ ((this.province == null) ? 0 : this.province.hashCode());
		result = prime * result 
				+ ((this.country == null) ? 0 : this.country.hashCode());
			
		return result;
		
	} // Fin de hashCode().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean equals(
			final Object pObj) {
		
		if (this == pObj) {
			return true;
		}
		if (pObj == null) {
			return false;
		}
		if (!(pObj instanceof Adress)) {
			return false;
		}
		
		final Adress other = (Adress) pObj;
		
		/* id. */
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		
		/* numero. */
		if (this.numero == null) {
			if (other.numero != null) {
				return false;
			}
		} else if (!this.numero.equals(other.numero)) {
			return false;
		}
		
		/* street. */
		if (this.street == null) {
			if (other.street != null) {
				return false;
			}
		} else if (!this.street.equals(other.street)) {
			return false;
		}
		
		/* postcode. */
		if (this.postcode == null) {
			if (other.postcode != null) {
				return false;
			}
		} else if (!this.postcode.equals(other.postcode)) {
			return false;
		}
		
		/* city. */
		if (this.city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!this.city.equals(other.city)) {
			return false;
		}
		
		/* province. */
		if (this.province == null) {
			if (other.province != null) {
				return false;
			}
		} else if (!this.province.equals(other.province)) {
			return false;
		}
		
		/* country. */
		if (this.country == null) {
			if (other.country != null) {
				return false;
			}
		} else if (!this.country.equals(other.country)) {
			return false;
		}
				
		return true;
		
	} // Fin de equals(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(
			final Adress pAdress) {

		if (this == pAdress) {
			return 0;
		}

		if (pAdress == null) {
			return -1;
		}

		int compareCountry = 0;
		int compareProvince = 0;
		int compareCity= 0;
		int comparePostCode = 0;
		int compareStreet = 0;
		int compareNumero = 0;
		
		/* country. */
		if (this.getCountry() == null) {
			if (pAdress.getCountry() != null) {
				return +1;
			}
		} else {

			if (pAdress.getCountry() == null) {
				return -1;
			}

			compareCountry = this.getCountry()
					.compareToIgnoreCase(pAdress.getCountry());

			if (compareCountry != 0) {
				return compareCountry;
			}

		}
		
		/* province. */
		if (this.getProvince() == null) {
			if (pAdress.getProvince() != null) {
				return +1;
			}
		}	

		if (pAdress.getProvince() == null) {
			return -1;
		}

		compareProvince = this.getProvince()
				.compareToIgnoreCase(pAdress.getProvince());
		
		if (compareProvince != 0) {
			return compareProvince;
		}
		
		/* city. */
		if (this.getCity() == null) {
			if (pAdress.getCity() != null) {
				return +1;
			}
		}	

		if (pAdress.getCity() == null) {
			return -1;
		}

		compareCity = this.getCity()
				.compareToIgnoreCase(pAdress.getCity());
		
		if (compareCity != 0) {
			return compareCity;
		}

		/* postcode. */
		if (this.getPostcode() == null) {
			if (pAdress.getPostcode() != null) {
				return +1;
			}
		}	

		if (pAdress.getPostcode() == null) {
			return -1;
		}

		comparePostCode = this.getPostcode()
				.compareToIgnoreCase(pAdress.getPostcode());
		
		if (comparePostCode != 0) {
			return comparePostCode;
		}

		/* street. */
		if (this.getCity() == null) {
			if (pAdress.getCity() != null) {
				return +1;
			}
		}	

		if (pAdress.getCity() == null) {
			return -1;
		}

		compareStreet = this.getCity()
				.compareToIgnoreCase(pAdress.getCity());
		
		if (compareStreet != 0) {
			return compareStreet;
		}
		
		/* numero. */
		if (this.getNumero() == null) {
			if (pAdress.getNumero() != null) {
				return +1;
			}
			
			return 0;
		}	

		if (pAdress.getNumero() == null) {
			return -1;
		}

		compareNumero = this.getNumero()
				.compareToIgnoreCase(pAdress.getNumero());
		
		return compareNumero;

	} // Fin de compareTo(...).____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Adress clone() throws CloneNotSupportedException {

		final Adress adressClone 
			= (Adress) super.clone();

		adressClone.setId(getId());
		adressClone.setNumero(this.getNumero());
		adressClone.setStreet(this.getStreet());
		adressClone.setPostcode(this.getPostcode());
		adressClone.setCity(this.getCity());
		adressClone.setProvince(this.getProvince());
		adressClone.setCountry(this.getCountry());
		
		return adressClone;

	} // Fin de clone().___________________________________________________
	


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("Adress [");
		if (this.id != null) {
			builder.append("id=");
			builder.append(this.id);
			builder.append(", ");
		}
		if (this.numero != null) {
			builder.append("numero=");
			builder.append(this.numero);
			builder.append(", ");
		}
		if (this.street != null) {
			builder.append("street=");
			builder.append(this.street);
			builder.append(", ");
		}
		if (this.postcode != null) {
			builder.append("postcode=");
			builder.append(this.postcode);
			builder.append(", ");
		}
		if (this.city != null) {
			builder.append("city=");
			builder.append(this.city);
			builder.append(", ");
		}
		if (this.province != null) {
			builder.append("province=");
			builder.append(this.province);
			builder.append(", ");
		}
		if (this.country != null) {
			builder.append("country=");
			builder.append(this.country);
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
	 * method setId() :<br/>
	 * Setter de l'ID en base.<br/>
	 * <br/>
	 *
	 * @param pId
	 *            : Long : valeur à passer à id.<br/>
	 */
	public void setId(final Long pId) {
		this.id = pId;
	} // Fin de setId(...).________________________________________________


	
	/**
	 * method getNumero() :<br/>
	 * Getter du Numéro de rue.<br/>
	 * <br/>
	 *
	 * @return numero : String.<br/>
	 */
	public String getNumero() {
		return this.numero;
	} // Fin de getNumero()._______________________________________________


	
	/**
	* method setNumero(
	* String pNumero) :<br/>
	* Setter du Numéro de rue.<br/>
	* <br/>
	*
	* @param pNumero : String : 
	* valeur à passer à numero.<br/>
	*/
	public void setNumero(
			final String pNumero) {
		this.numero = pNumero;
	} // Fin de setNumero(...).____________________________________________


	
	/**
	 * method getStreet() :<br/>
	 * Getter de la Rue.<br/>
	 * <br/>
	 *
	 * @return street : String.<br/>
	 */
	public String getStreet() {
		return this.street;
	} // Fin de getStreet()._______________________________________________


	
	/**
	* method setStreet(
	* String pStreet) :<br/>
	* Setter de la Rue.<br/>
	* <br/>
	*
	* @param pStreet : String : 
	* valeur à passer à street.<br/>
	*/
	public void setStreet(
			final String pStreet) {
		this.street = pStreet;
	} // Fin de setStreet(...).____________________________________________


	
	/**
	 * method getPostcode() :<br/>
	 * Getter du Code Postal.<br/>
	 * <br/>
	 *
	 * @return postcode : String.<br/>
	 */
	public String getPostcode() {
		return this.postcode;
	} // Fin de getPostcode()._____________________________________________


	
	/**
	* method setPostcode(
	* String pPostcode) :<br/>
	* Setter du Code Postal.<br/>
	* <br/>
	*
	* @param pPostcode : String : 
	* valeur à passer à postcode.<br/>
	*/
	public void setPostcode(
			final String pPostcode) {
		this.postcode = pPostcode;
	} // Fin de setPostcode(...).__________________________________________


	
	/**
	 * method getCity() :<br/>
	 * Getter de la Ville.<br/>
	 * <br/>
	 *
	 * @return city : String.<br/>
	 */
	public String getCity() {
		return this.city;
	} // Fin de getCity()._________________________________________________


	
	/**
	* method setCity(
	* String pCity) :<br/>
	* Setter de la Ville.<br/>
	* <br/>
	*
	* @param pCity : String : 
	* valeur à passer à city.<br/>
	*/
	public void setCity(
			final String pCity) {
		this.city = pCity;
	} // Fin de setCity(...).______________________________________________


	
	/**
	 * method getProvince() :<br/>
	 * Getter de Province ou Région.<br/>
	 * <br/>
	 *
	 * @return province : String.<br/>
	 */
	public String getProvince() {
		return this.province;
	} // Fin de getProvince()._____________________________________________


	
	/**
	* method setProvince(
	* String pProvince) :<br/>
	* Setter de Province ou Région.<br/>
	* <br/>
	*
	* @param pProvince : String : 
	* valeur à passer à province.<br/>
	*/
	public void setProvince(
			final String pProvince) {
		this.province = pProvince;
	} // Fin de setProvince(...).__________________________________________


	
	/**
	 * method getCountry() :<br/>
	 * Getter du Pays.<br/>
	 * <br/>
	 *
	 * @return country : String.<br/>
	 */
	public String getCountry() {
		return this.country;
	}


	
	/**
	* method setCountry(
	* String pCountry) :<br/>
	* Setter du Pays.<br/>
	* <br/>
	*
	* @param pCountry : String : 
	* valeur à passer à country.<br/>
	*/
	public void setCountry(
			final String pCountry) {
		this.country = pCountry;
	} // Fin de setCountry(...).___________________________________________
	
		
		
} // FIN DE LA CLASSE Adress.------------------------------------------------

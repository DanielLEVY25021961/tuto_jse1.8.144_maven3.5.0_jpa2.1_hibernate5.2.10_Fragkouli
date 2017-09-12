package levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.metier.client;

import java.net.MalformedURLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.GestionnaireRG;

/**
 * class GestionnaireRGClient :<br/>
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
 * @since 30 août 2017
 *
 */
public final class GestionnaireRGClient {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * validerNomClient : Boolean :<br/>
	 * Boolean activant globalement les contrôles 
	 * sur le nom du client.<br/>
	 */
	private static Boolean validerNomClient;

	
	/**
	 * validerRGClientNom01 : Boolean :<br/>
	 * Boolean activant la RG-Client-Nom-01 : 
	 * "le nom du client 
	 * doit être renseigné" sur le nom du client.<br/>
	 */
	private static Boolean validerRGClientNom01;
	

	/**
	 * validerRGClientNom02 : Boolean :<br/>
	 * Boolean activant la RG-Client-Nom-02 : 
	 * "le nom du client ne doit contenir 
	 * que des lettres" sur le nom du client.<br/>
	 */
	private static Boolean validerRGClientNom02;
	

	/**
	 * validerPrenomClient : Boolean :<br/>
	 * Boolean activant globalement les contrôles 
	 * sur le prénom du client.<br/>
	 */
	private static Boolean validerPrenomClient;
	
	
	/**
	 * validerRGClientPrenom03 : Boolean :<br/>
	 * Boolean activant la RG-Client-Prenom-03 : 
	 * "le prénom du client ne doit contenir 
	 * que des lettres" sur le nom du client.<br/>
	 */
	private static Boolean validerRGClientPrenom03;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(GestionnaireRGClient.class);
	
	
	static {
		
		try {
			
			/* nom. */
			lireControleNomActif();
			
			/* prénom. */
			lireControlePrenomActif();
			
		} catch (MalformedURLException malformedURLexc) {
			
			final String message 
			= "Impossible de lire le rg.properties";
		
			if (LOG.isFatalEnabled()) {
				LOG.fatal(message, malformedURLexc);
			}
		}
		
	}
	


	// *************************METHODES************************************/
	
	 /**
	 * method CONSTRUCTEUR GestionnaireRG() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	private GestionnaireRGClient() {
		
		super();
				
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method lireControleNomActif() :<br/>
	 * <ul>
	 * Lit dans rg.properties les valeurs de : 
	 * <li>validerNomClient</li>
	 * <li>validerRGClientNom01</li>
	 * <li>validerRGClientNom02</li>
	 * </ul>
	 * @throws MalformedURLException 
	 */
	private static void lireControleNomActif() 
			throws MalformedURLException {
		
		synchronized (GestionnaireRGClient.class) {
			
			/* validation globale sur le nom : validerNomClient. */
			if (validerNomClient == null) {
				
				final String validerNomClientString 
					= GestionnaireRG.getBundleExterneRG()
						.getString(fournirCleControleNom()); 
				
				validerNomClient 
					= Boolean.valueOf(validerNomClientString.trim());
				
			}
			
			/* validerRGClientNom01. */
			if (validerRGClientNom01 == null) {
				
				final String validerRGClient01String 
					= GestionnaireRG.getBundleExterneRG()
						.getString(fournirCleControleRGClientNom01());
				
				validerRGClientNom01 
					= Boolean.valueOf(validerRGClient01String.trim());
				
			}
			
			/* validerRGClientNom02. */
			if (validerRGClientNom02 == null) {
				
				final String validerRGClient02String 
					= GestionnaireRG.getBundleExterneRG()
						.getString(fournirCleControleRGClientNom02());
				
				validerRGClientNom02 
					= Boolean.valueOf(validerRGClient02String.trim());
				
			}
			
		} // Fin de bloc synchronized.__________________________
				
	} // Fin de lireControleNomActif().____________________________________


	
	/**
	 * method lireControlePrenomActif() :<br/>
	 * <ul>
	 * Lit dans rg.properties les valeurs de : 
	 * <li>validerPrenomClient</li>
	 * <li>validerRGClientPrenom03</lil>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireControlePrenomActif() 
			throws MalformedURLException {
		
		synchronized (GestionnaireRGClient.class) {
			
			/* validation globale sur le prénom : validerPrenomClient. */
			if (validerPrenomClient == null) {
				
				final String validerPrenomClientString 
					= GestionnaireRG.getBundleExterneRG()
						.getString(fournirCleControlePrenom()); 
				
				validerPrenomClient 
					= Boolean.valueOf(validerPrenomClientString.trim());
				
			}
			
			/* validerRGClientPrenom03. */
			if (validerRGClientPrenom03 == null) {
				
				final String validerRGClient03String 
					= GestionnaireRG.getBundleExterneRG()
						.getString(fournirCleControleRGClientPrenom03());
				
				validerRGClientPrenom03 
					= Boolean.valueOf(validerRGClient03String.trim());
				
			}
			
		} // Fin de bloc synchronized.__________________________
		
	} // Fin de lireControlePrenomActif()._________________________________
	
	
	
	/**
	 * method fournirCleControleNom() :<br/>
	 * Retourne la clé de validerNomClient dans rg.properties.<br/>
	 * "client.nom.actif".<br/>
	 * <br/>
	 *
	 * @return : String : "client.nom.actif".<br/>
	 */
	private static String fournirCleControleNom() {
		return "client.nom.actif";
	} // Fin de fournirCleControleNom().___________________________________
	

	
	/**
	 * method fournirCleControleRGClientNom01() :<br/>
	 * Retourne la clé de validerRGClientNom01 dans rg.properties.<br/>
	 * "client.nom.rgclientnom01.actif".<br/>
	 * <br/>
	 *
	 * @return : String : "client.nom.rgclientnom01.actif".<br/>
	 */
	private static String fournirCleControleRGClientNom01() {
		return "client.nom.rgclientnom01.actif";
	} // Fin de fournirCleControleRGClientNom01()._________________________
	
	

	/**
	 * method fournirCleControleRGClientNom02() :<br/>
	 * Retourne la clé de validerRGClientNom02 dans rg.properties.<br/>
	 * "client.nom.rgclientnom02.actif".<br/>
	 * <br/>
	 *
	 * @return : String : "client.nom.rgclientnom02.actif".<br/>
	 */
	private static String fournirCleControleRGClientNom02() {
		return "client.nom.rgclientnom02.actif";
	} // Fin de fournirCleControleRGClientNom02()._________________________
	

	
	/**
	 * method fournirCleControlePrenom() :<br/>
	 * Retourne la clé de validerPrenomClient dans rg.properties.<br/>
	 * "client.prenom.actif".<br/>
	 * <br/>
	 *
	 * @return : String : "client.prenom.actif".<br/>
	 */
	private static String fournirCleControlePrenom() {
		return "client.prenom.actif";
	} // Fin de fournirCleControlePrenom().________________________________

	
	
	/**
	 * method fournirCleControleRGClientPrenom03() :<br/>
	 * Retourne la clé de validerRGClientPrenom03 dans rg.properties.<br/>
	 * "client.prenom.rgclientprenom03.actif".<br/>
	 * <br/>
	 *
	 * @return : String : "client.prenom.rgclientprenom03.actif".<br/>
	 */
	private static String fournirCleControleRGClientPrenom03() {
		return "client.prenom.rgclientprenom03.actif";
	} // Fin de fournirCleControleRGClientPrenom03().______________________
	
	
	
	/**
	 * method getValiderNomClient() :<br/>
	 * Getter du Boolean activant globalement 
	 * les contrôles sur le nom du client.<br/>
	 * <br/>
	 *
	 * @return validerNomClient : Boolean.<br/>
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderNomClient() 
				throws MalformedURLException {
		
		if (validerNomClient == null) {
			lireControleNomActif();
		}
		
		return validerNomClient;
		
	} // Fin de getValiderNomClient()._____________________________________



	
	/**
	* method setValiderNomClient(
	* Boolean pValiderNomClient) :<br/>
	* Setter du Boolean activant globalement 
	 *les contrôles sur le nom du client.<br/>
	* <br/>
	*
	* @param pValiderNomClient : Boolean : 
	* valeur à passer à validerNomClient.<br/>
	*/
	public static void setValiderNomClient(
			final Boolean pValiderNomClient) {
		validerNomClient = pValiderNomClient;
	} // fin de setValiderNomClient(...).__________________________________


	
	/**
	 * method getValiderRGClientNom01() :<br/>
	 * Getter du Boolean activant la RG-Client-Nom-01 : "le nom du client 
	 * doit être renseigné" sur le nom du client.<br/>
	 * <br/>
	 *
	 * @return validerRGClientNom01 : Boolean.<br/>
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderRGClientNom01() 
			throws MalformedURLException {
		
		if (validerRGClientNom01 == null) {
			lireControleNomActif();
		}
		
		return validerRGClientNom01;
		
	} // Fin de getValiderRGClientNom01()._________________________________


	
	/**
	* method setValiderRGClientNom01(
	* Boolean pValiderRGClient01) :<br/>
	* Setter du Boolean activant la RG-Client-01 : "le nom du client 
	* doit être renseigné" sur le nom du client.<br/>
	* <br/>
	*
	* @param pValiderRGClientNom01 : Boolean : 
	* valeur à passer à validerRGClientNom01.<br/>
	*/
	public static void setValiderRGClientNom01(
			final Boolean pValiderRGClientNom01) {
		validerRGClientNom01 = pValiderRGClientNom01;
	} // Fin de setValiderRGClientNom01(...).______________________________


	
	/**
	 * method getValiderRGClientNom02() :<br/>
	 * Getter du Boolean activant la RG-Client-Nom-02 : 
	 * "le nom du client ne doit contenir 
	 * que des lettres" sur le nom du client.<br/>
	 * <br/>
	 *
	 * @return validerRGClientNom02 : Boolean.<br/>
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderRGClientNom02() 
			throws MalformedURLException {
		
		if (validerRGClientNom02 == null) {
			lireControleNomActif();
		}
		
		return validerRGClientNom02;
		
	} // Fin de getValiderRGClientNom02()._________________________________


	
	/**
	* method setValiderRGClientNom02(
	* Boolean pValiderRGClientNom02) :<br/>
	* Setter du Boolean activant la RG-Client-Nom-02 : 
	* "le nom du client ne doit contenir 
	* que des lettres" sur le nom du client.<br/>
	* <br/>
	*
	* @param pValiderRGClientNom02 : Boolean : 
	* valeur à passer à validerRGClientNom02.<br/>
	*/
	public static void setValiderRGClientNom02(
			final Boolean pValiderRGClientNom02) {
		validerRGClientNom02 = pValiderRGClientNom02;
	} // Fin de setValiderRGClientNom02(...).______________________________


	
	/**
	 * method getValiderPrenomClient() :<br/>
	 * Getter du Boolean activant globalement 
	 * les contrôles sur le prénom du client.<br/>
	 * <br/>
	 *
	 * @return validerPrenomClient : Boolean.<br/>
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderPrenomClient() 
			throws MalformedURLException {
		
		if (validerPrenomClient == null) {
			lireControlePrenomActif();
		}
		
		return validerPrenomClient;
		
	} // Fin de getValiderPrenomClient().__________________________________



	
	/**
	* method setValiderPrenomClient(
	* Boolean pValiderPrenomClient) :<br/>
	* Setter du Boolean activant globalement 
	* les contrôles sur le prénom du client.<br/>
	* <br/>
	*
	* @param pValiderPrenomClient : Boolean : 
	* valeur à passer à validerPrenomClient.<br/>
	*/
	public static void setValiderPrenomClient(
			final Boolean pValiderPrenomClient) {
		validerPrenomClient = pValiderPrenomClient;
	} // Fin de setValiderPrenomClient(...)._______________________________


	
	/**
	 * method getValiderRGClientPrenom03() :<br/>
	 * Getter du Boolean activant la RG-Client-Prenom-03 : 
	 * "le prénom du client ne doit contenir 
	 * que des lettres" sur le prénom du client.<br/>
	 * <br/>
	 *
	 * @return validerRGClientPrenom03 : Boolean.<br/>
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderRGClientPrenom03() 
			throws MalformedURLException {
		
		if (validerRGClientPrenom03 == null) {
			lireControlePrenomActif();
		}
		
		return validerRGClientPrenom03;
		
	} // Fin de getValiderRGClientPrenom03().______________________________



	
	/**
	* method setValiderRGClientPrenom03(
	* Boolean pValiderRGClientPrenom03) :<br/>
	* Setter du Boolean activant la RG-Client-Prenom-03 : 
	* "le prénom du client ne doit contenir 
	* que des lettres" sur le prénom du client.<br/>
	* <br/>
	*
	* @param pValiderRGClientPrenom03 : Boolean : 
	* valeur à passer à validerRGClientPrenom03.<br/>
	*/
	public static void setValiderRGClientPrenom03(
			final Boolean pValiderRGClientPrenom03) {
		validerRGClientPrenom03 = pValiderRGClientPrenom03;
	} // Fin de setValiderRGClientPrenom03(...).___________________________
	
	
	
	
} // FIN DE LA CLASSE GestionnaireRGClient.----------------------------------

package levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.metier.client.GestionnaireRGClient;

/**
 * class GestionnaireRG :<br/>
 * Classe utilitaire chargée de gérer en un point unique 
 * l'implémentation des règles de gestion (RG).<br/>
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
 * @since 26 août 2017
 *
 */
public final class GestionnaireRG {

	// ************************ATTRIBUTS************************************/

	
	/**
	 * RG_CLIENT_NOM_01 : String :<br/>
	 * Règle de Gestion.<br/>
	 * "RG_CLIENT_NOM_01 : le nom du client doit être renseigné.".<br/>
	 */
	public static final String RG_CLIENT_NOM_01 
		= "RG_CLIENT_NOM_01 : le nom du client doit être renseigné.";

	
	/**
	 * RG_CLIENT_NOM_01_MESSAGE : String :<br/>
	 * Message à l'attention de l'utilisateur.<br/>
	 * "Le nom n'est pas renseigné (obligatoire)."<br/>
	 */
	public static final String RG_CLIENT_NOM_01_MESSAGE 
		= "Le nom n'est pas renseigné (obligatoire).";
	
	
	/**
	 * RG_CLIENT_NOM_02 : String :<br/>
	 * Règle de Gestion.<br/>
	 * "RG_CLIENT_NOM_02 : le nom du client ne doit contenir 
	 * que des lettres.".<br/>
	 */
	public static final String RG_CLIENT_NOM_02 
		= "RG_CLIENT_NOM_02 : le nom du client ne doit contenir "
				+ "que des lettres.";

	
	/**
	 * RG_CLIENT_NOM_02_MESSAGE : String :<br/>
	 * Message à l'attention de l'utilisateur.<br/>
	 * "le nom du client ne doit contenir que des lettres 
	 * (pas de chiffres)."<br/>
	 */
	public static final String RG_CLIENT_NOM_02_MESSAGE 
		= "le nom du client ne doit contenir que des lettres "
				+ "(pas de chiffres).";

	
	/**
	 * RG_CLIENT_PRENOM_03 : String :<br/>
	 * Règle de Gestion.<br/>
	 * "RG_CLIENT_PRENOM_03 : le prénom du client ne doit contenir 
	 * que des lettres.".<br/>
	 */
	public static final String RG_CLIENT_PRENOM_03 
		= "RG_CLIENT_PRENOM_03 : le prénom du client ne doit contenir "
				+ "que des lettres.";

	
	/**
	 * RG_CLIENT_PRENOM_03_MESSAGE : String :<br/>
	 * Message à l'attention de l'utilisateur.<br/>
	 * "le prénom du client ne doit contenir que des lettres 
	 * (pas de chiffres)."<br/>
	 */
	public static final String RG_CLIENT_PRENOM_03_MESSAGE 
		= "le prénom du client ne doit contenir que des lettres "
				+ "(pas de chiffres).";
	

	/**
	 * SAUT_LIGNE : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE = '\n';
	
	
	/**
	 * bundleExterneRG : ResourceBundle :<br/>
	 * ResourceBundle encapsulant rg.properties.<br/>
	 */
	private static ResourceBundle bundleExterneRG;
	
	
	/**
	 * mapRG : Map&lt;String,LigneRG&gt; :<br/>
	 * <ul>
	 * Map contenant toutes les RG implémentées dans l'application avec :
	 * <li>String : nom de la RG</li>
	 * <li>LigneRG : Encapsulation des éléments relatifs à la RG</li>
	 * </ul>
	 */
	private static Map<String, LigneRG> mapRG 
		= new ConcurrentHashMap<String, LigneRG>();

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(GestionnaireRG.class);
	
	
static {
	
	try {
		
		remplirMapRG();
		
	} catch (MalformedURLException malformedURLexc) {
		
		final String message 
			= "Impossible de fournir la liste des RG implémentées";
		
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
	private GestionnaireRG() {
		
		super();
				
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	


	/**
	 * method getBundleExterneRG() :<br/>
	 * Fournit le ResourceBundle associé au fichier externe rg.properties 
	 * avec la Locale Locale_fr_FR.<br/>
	 * <br/>
	 *
	 * @return : ResourceBundle : rg.properties.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static ResourceBundle getBundleExterneRG() 
			throws MalformedURLException {
		
		synchronized (GestionnaireRG.class) {
			
			if (bundleExterneRG == null) {
				bundleExterneRG = getBundleExterneRG(Locale.getDefault());
			}
			
			return bundleExterneRG;
			
		} // Fin de bloc synchronized.__________________________
				
	} // Fin de getBundleExterneRG().______________________________________
	
	
	
	/**
	 * method getBundleExterneRG(
	 * Locale pLocale) :<br/>
	 * Fournit le ResourceBundle associé au fichier externe rg.properties 
	 * avec la Locale PLocale.<br/>
	 * <br/>
	 *
	 * @param pLocale : Locale.<br/>
	 * 
	 * @return : ResourceBundle.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	private static ResourceBundle getBundleExterneRG(
			final Locale pLocale) throws MalformedURLException {
		
		synchronized (GestionnaireRG.class) {
			
			ResourceBundle resourceBundle = null;
							
			/* Accède au répertoire externe contenant rg.properties. */
			final File repertoireRessourcesParametrables 
			= new File(fournirCheminRessourceExterneRG());
							
			final URL[] urlsRessourcesParametrables 
			= {repertoireRessourcesParametrables.toURI().toURL()};
		
			final ClassLoader loaderRessourcesParametrables 
				= new URLClassLoader(urlsRessourcesParametrables);
			
			resourceBundle 
				= ResourceBundle
					.getBundle("rg"
							, pLocale
								, loaderRessourcesParametrables);
														
			return resourceBundle;
			
		} // Fin de bloc synchronized.__________________________
				
	} // Fin de getBundleExterneRG(...).___________________________________
	

	
	/**
	 * method fournirCheminRessourceExterneRG() :<br/>
	 * fournit le chemin (externe au projet) du répertoire 
	 * contenant le fichier rg.properties.<br/>
	 * "./ressources_externes".<br/>
	 * <br/>
	 *
	 * @return : String : "./ressources_externes".<br/>
	 */
	private static String fournirCheminRessourceExterneRG() {
					
		return "D:/Donnees/eclipse/eclipseworkspace_neon/tuto_web_jee1.8.144/ressources_externes";
					
	} // Fin de fournirCheminRessourceExterneRG()._________________________
	
	
	
	/**
	 * method remplirMapRG() :<br/>
	 * <ul>
	 * remplit et retourne la Map&lt;String, LigneRG&gt; mapRG 
	 * contenant toutes 
	 * les Règles de Gestion (RG) implémentées 
	 * dans les services de l'application avec :
	 * <li>String : le nom de la RG.</li>
	 * <li>LigneRG : pure fabrication encapsulant 
	 * tous les éléments relatifs à la RG.</li>
	 * </ul>
	 * Une LigneRG encapsule :<br/>
	 * [id;Actif;activité des contrôles sur l'attribut;activité de la RG
	 * ;RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;].<br/>
	 * <br/>
	 *
	 * @return : Map&lt;String, LigneRG&gt; : mapRG.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	private static Map<String, LigneRG> remplirMapRG() 
			throws MalformedURLException {
		
		synchronized (GestionnaireRG.class) {
			
			/* RG_CLIENT_NOM_01. */
			final LigneRG ligneRgClient01 
				= new LigneRG(getValiderNomClient()
						, getValiderRGClientNom01()
						, RG_CLIENT_NOM_01
						, 1
						, RG_CLIENT_NOM_01_MESSAGE
						, "Client", "Nom"
						, "ValideurClient"
						, "validerRGClientNom01(...)");
			
			mapRG.put(
					GestionnaireRG.RG_CLIENT_NOM_01
						, ligneRgClient01);
			
			/* RG_CLIENT_NOM_02. */
			final LigneRG ligneRgClient02 
				= new LigneRG(getValiderNomClient()
						, getValiderRGClientNom02()
						, RG_CLIENT_NOM_02
						, 2
						, RG_CLIENT_NOM_02_MESSAGE
						, "Client", "Nom"
						, "ValideurClient"
						, "validerRGClientNom02(...)");
			
			mapRG.put(
					GestionnaireRG.RG_CLIENT_NOM_02
						, ligneRgClient02);
			
			/* RG_CLIENT_PRENOM_03. */
			final LigneRG ligneRgClient03 
				= new LigneRG(getValiderPrenomClient()
						, getValiderRGClientPrenom03()
						, RG_CLIENT_PRENOM_03
						, 2
						, RG_CLIENT_PRENOM_03_MESSAGE
						, "Client", "Prenom"
						, "ValideurClient"
						, "validerRGClientPrenom03(...)");
			
			mapRG.put(
					GestionnaireRG.RG_CLIENT_PRENOM_03
						, ligneRgClient03);
			
			return mapRG;
			
		} // Fin de bloc synchronized.__________________________
		
	} // Fin de remplirMapRG().____________________________________________
	
	
	
	/**
	 * method getMapRG() :<br/>
	 * <ul>
	 * Getter de la Map contenant toutes les RG implémentées 
	 * dans l'application avec :
	 * <li>String : nom de la RG</li>
	 * <li>LigneRG : Encapsulation des éléments relatifs à la RG</li>
	 * </ul>
	 * Une LigneRG encapsule :<br/>
	 * [id;Actif;activité des contrôles sur l'attribut;activité de la RG
	 * ;RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;].<br/>
	 * <br/>
	 * Trie la Map en fonction du nom des Règles de Gestion (RG).<br/>
	 * <br/>
	 *
	 * @return : Map&lt;String,LigneRG&gt; : 
	 * Map contenant toutes les RG implémentées dans l'application.<br/>
	 */
	public static Map<String, LigneRG> getMapRG() {
		
		/* Tri de la Map en fonction du nom des Règles de Gestion.*/
		final SortedMap<String, LigneRG> mapTriee 
			= new TreeMap<String, LigneRG>(mapRG);
		
		return mapTriee;
		
	} // Fin de getMapRG().________________________________________________
	

	
	/**
	 * method getEnTeteCsv() :<br/>
	 * "id;Actif;activité des contrôles sur l'attribut;activité de la RG;
	 * RG implémentée;clé du type de contrôle;type de contrôle;Message d'erreur;
	 * Objet Métier concerné;Attribut concerné;Classe implémentant la RG;
	 * Méthode implémentant la RG;".<br/>
	 * <br/>
	 *
	 * @return : String : "id;Actif;
	 * activité des contrôles sur l'attribut;activité de la RG;
	 * RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;
	 * Objet Métier concerné;Attribut concerné;Classe implémentant la RG;
	 * Méthode implémentant la RG;".<br/>
	 */
	public static String getEnTeteCsv() {
		
		return "id;Actif;activité des contrôles sur l'attribut;"
				+ "activité de la RG;RG implémentée;clé du type de contrôle;"
				+ "type de contrôle;"
				+ "Message d'erreur;Objet Métier concerné;"
				+ "Attribut concerné;Classe implémentant la RG;"
				+ "Méthode implémentant la RG;";
		
	} // Fin de getEnTeteCsv().____________________________________________
	
	
	
	/**
	 * method afficherListeRGImplementeesCsv() :<br/>
	 * <ul>
	 * <li>Retourne une String pour l'affichage de la liste 
	 * des RG implémentées dans l'application.</li>
	 * <li>La String contient la liste des LignesRG au format csv.</li>
	 * </ul>
	 * Trie la Map en fonction du nom des Règles de Gestion (RG).<br/>
	 * <br/>
	 * retourne null si mapRG == null.<br/>
	 * <br/>
	 *
	 * @return : String : liste csv des RG implémentées.<br/>
	 */
	public static String afficherListeRGImplementeesCsv() {
		
		synchronized (GestionnaireRG.class) {
			
			/* retourne null si mapRG == null. */
			if (mapRG == null) {
				return null;
			}
			
			/* Tri de la Map en fonction du nom des Règles de Gestion.*/
			final SortedMap<String, LigneRG> mapTriee 
				= new TreeMap<String, LigneRG>(mapRG);
			
			final StringBuilder stb = new StringBuilder();
			
			stb.append(getEnTeteCsv());
			stb.append(SAUT_LIGNE);
			
			final Set<Entry<String, LigneRG>> entrySet 
				= mapTriee.entrySet();
			
			final Iterator<Entry<String, LigneRG>> ite 
				= entrySet.iterator();
			
			final int nbreEntry = entrySet.size();
			
			int compteur = 0;
			
			while (ite.hasNext()) {
				
				compteur++;
				
				final Entry<String, LigneRG> entry = ite.next();
				final LigneRG ligneRG = entry.getValue();
				
				stb.append(ligneRG.toStringCsv());
				
				if (compteur < nbreEntry) {
					stb.append(SAUT_LIGNE);
				}				
			}
			
			return stb.toString();
			
		} // Fin de bloc synchronized.__________________________
		
	} // Fin de afficherListeRGImplementeesCsv().__________________________
	
	
	
	/**
	 * method getLigneRG(
	 * String pNomRG) :<br/>
	 * Retourne l'encapsulation LigneRG correspondant 
	 * à la RG de nom pNomRG dans la mapRG.<br/>
	 * <br/>
	 * Une LigneRG encapsule :<br/>
	 * [id;Actif;activité des contrôles sur l'attribut;activité de la RG
	 * ;RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;].<br/>
	 * <br/>
	 *
	 * @param pNomRG : String : Nom de la Règle de Gestion (RG).<br/>
	 * 
	 * @return : LigneRG : pure fabrication.<br/>
	 * @throws MalformedURLException 
	 */
	public static LigneRG getLigneRG(
			final String pNomRG) throws MalformedURLException {
		
		return mapRG.get(pNomRG);
		
	} // Fin de getLigneRG(...).___________________________________________


	
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
		
		return GestionnaireRGClient.getValiderNomClient();
		
	} // Fin de getValiderNomClient()._____________________________________


	
	/**
	 * method getValiderRGClientNom01() :<br/>
	 * Getter du Boolean activant la RG-Client-Nom-01 : 
	 * "le nom du client doit être renseigné" sur le nom du client.<br/>
	 * <br/>
	 *
	 * @return validerRGClientNom01 : Boolean.<br/>
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderRGClientNom01() 
			throws MalformedURLException {
		
		return GestionnaireRGClient.getValiderRGClientNom01();
		
	} // Fin de getValiderRGClientNom01()._________________________________


	
	/**
	 * method getValiderRGClientNom02() :<br/>
	 * Getter du Boolean activant la RG-Client-Nom-02 : 
	 * "le nom du client ne doit contenir que des lettres" 
	 * sur le nom du client.<br/>
	 * <br/>
	 *
	 * @return validerRGClientNom02 : Boolean.<br/>
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderRGClientNom02() 
			throws MalformedURLException {
		
		return GestionnaireRGClient.getValiderRGClientNom02();
		
	} // Fin de getValiderRGClientNom02()._________________________________


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
		
		return GestionnaireRGClient.getValiderPrenomClient();
		
	} // Fin de getValiderPrenomClient().__________________________________
	
	
	
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
		
		return GestionnaireRGClient.getValiderRGClientPrenom03();
		
	} // Fin de getValiderRGClientPrenom03().______________________________


	
} // FIN DE LA CLASSE GestionnaireRG.----------------------------------------

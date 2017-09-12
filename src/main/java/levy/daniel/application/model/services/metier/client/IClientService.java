package levy.daniel.application.model.services.metier.client;

import levy.daniel.application.model.metier.client.AbstractClient;
import levy.daniel.application.model.services.metier.IServiceGeneric;

/**
 * class IClientService :<br/>
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
 * @since 25 août 2017
 *
 */
public interface IClientService 
			extends IServiceGeneric<AbstractClient> {
	
	
	
	/**
	 * method retrieveByIdMetier(
	 * AbstractClient pClient) :<br/>
	 * <ul>
	 * <li>Recherche un AbstractClient pClient en base 
	 * via son identifiant métier 
	 * (en général, l'identifiant métier est constitué des 
	 * attributs de la méthode equals de l'objet métier).</li>
	 * <li>Retourne l'AbstractClient trouvé en base.</li>
	 * </ul> 
	 * <br/>
	 *
	 * @param pClient : AbstractClient : Client à rechercher en base.<br/>
	 * 
	 * @return : AbstractClient : 
	 * Le Client trouvé en base.<br/>
	 */
	AbstractClient retrieveByIdMetier(AbstractClient pClient);
	
	

} // FIN DE L'INTERFACE IClientService.--------------------------------------

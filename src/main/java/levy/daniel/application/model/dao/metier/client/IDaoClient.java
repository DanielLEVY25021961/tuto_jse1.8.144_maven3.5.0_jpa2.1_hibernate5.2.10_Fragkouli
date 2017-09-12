package levy.daniel.application.model.dao.metier.client;

import levy.daniel.application.model.metier.client.AbstractClient;

/**
 * class IDaoClient :<br/>
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
 * @since 8 sept. 2017
 *
 */
public interface IDaoClient {
	
	/**
	 * method retrieveByIdMetier(
	 * AbstractClient pClient) :<br/>
	 * <ul>
	 * <li>Recherche un AbstractClient pClient en base 
	 * <via son identifiant métier.</li>
	 * <li>Retourne l'AbstractClient trouvé en base.</li>
	 * </ul> 
	 * <br/>
	 *
	 * @param pClient : AbstractClient : Client à rechercher en base.<br/>
	 * 
	 * @return : AbstractClient : Le Client trouvé en base.<br/>
	 */
	AbstractClient retrieveByIdMetier(AbstractClient pClient);

	

} // FIN DE L'INTERFACE IDaoClient.----------------------------------------

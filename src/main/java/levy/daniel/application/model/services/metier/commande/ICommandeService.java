package levy.daniel.application.model.services.metier.commande;

import levy.daniel.application.model.metier.commande.AbstractCommande;
import levy.daniel.application.model.services.metier.IServiceGeneric;

/**
 * class ICommandeService :<br/>
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
 * @since 9 sept. 2017
 *
 */
public interface ICommandeService 
		extends IServiceGeneric<AbstractCommande> {
	
	/**
	 * method retrieveByIdMetier(
	 * AbstractCommande(pCommande) :<br/>
	 * <ul>
	 * <li>Recherche un AbstractCommande pCommande en base 
	 * via son identifiant métier 
	 * (en général, l'identifiant métier est constitué des 
	 * attributs de la méthode equals de l'objet métier).</li>
	 * <li>Retourne AbstractCommande trouvé en base.</li>
	 * </ul> 
	 * <br/>
	 *
	 * @param pCommande : AbstractCommande : 
	 * Commande à rechercher en base.<br/>
	 * 
	 * @return : AbstractCommande : La Commande trouvéeen base.<br/>
	 */
	AbstractCommande retrieveByIdMetier(AbstractCommande pCommande);
	
	

} // FIN DE L'INTERFACE ICommandeService.------------------------------------

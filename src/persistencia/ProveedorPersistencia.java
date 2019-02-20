
package persistencia;

import principal.Companyia;
import principal.GestioVolsExcepcio;

/**
 *
 * @author cesca
 */
public interface ProveedorPersistencia {
    public void desarDades(String nomFitxer, Companyia companyia) throws GestioVolsExcepcio;
    public Companyia carregarDades(String nomFitxer) throws GestioVolsExcepcio;
}

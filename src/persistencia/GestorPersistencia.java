package persistencia;

import principal.Companyia;
import principal.GestioVolsExcepcio;

/**
 *
 * @author cesca
 */
public class GestorPersistencia {
    private GestorXML gestor;

    public GestorXML getGestor() {
        return gestor;
    }

    public void setGestor(GestorXML pGestor) {
        gestor = pGestor;
    }

    public void desarCompanyia(String tipusPersistencia, String nomFitxer, Companyia companyia) throws GestioVolsExcepcio {
        if (tipusPersistencia.equals("XML")) {
            gestor = new GestorXML();
            gestor.desarDades(nomFitxer, companyia);
        }
    }

    public Companyia carregarCompanyia(String tipusPersistencia, String nomFitxer) throws GestioVolsExcepcio {
        ProveedorPersistencia gestor = null;
        Companyia companyia = null;

        if (tipusPersistencia.equals("XML")) {
            gestor = new GestorXML();
            companyia = gestor.carregarDades(nomFitxer);
        }

        return companyia;
    }
}

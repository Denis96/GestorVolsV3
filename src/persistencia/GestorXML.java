package persistencia;

import java.io.FileWriter;
import nu.xom.*;
import principal.Companyia;
import principal.GestioVolsExcepcio;

/**
 *
 * @author cesca
 */
public class GestorXML implements ProveedorPersistencia {
        private Document doc;
    private Companyia companyia;

    public Companyia getCompanyia() {
        return companyia;
    }

    public void setCompanyia(Companyia pCompanyia) {
        companyia = pCompanyia;
    }

    public void desarDades(String nomFitxer, Companyia pCompanyia) throws GestioVolsExcepcio {
        construirModel(pCompanyia);
        desarModel(nomFitxer);
    }

    public Companyia carregarDades(String nomFitxer) throws GestioVolsExcepcio {
        carregarFitxer(nomFitxer);
        obtenirDades();
        return companyia;
    }

    /*Paràmetres: Companyia a partir de la qual volem construir el model
     *
     *Acció: 
     *Llegir els atributs de l'objecte Companyia passat per paràmetre per construir
     *un model (document XML) sobre el Document doc (atribut de GestorXML).
     *L'arrel del document XML és "companyia" i heu d'afegir-ne els valors de 
     *codi i nom com atributs. Aquesta arrel, l'heu d'afegir a doc.
     *
     *Un cop fet això, heu de recórrer l'ArrayList elements de Companyia i per 
     *a cada element, afegir un fill a doc. Cada fill tindrà com atributs els 
     *atributs de l'objecte (codi, nom, fabricant, …)
     *
     *Si es tracta d'un avio, a més, heu d'afegir fills addicionals amb els 
     *valors de les classes d'aquest avio. 
     *
     *Si es tracta d'un vol, a més, heu d'afegir fills addicionals amb els 
     *valors dels tripulants d'aquest vol. En el cas de l'atribut avio, heu d'assignar-li
     *el codi de l'avio del vol, i en el cas del cap dels TCP, el passport del cap.
     *
     *Retorn: cap
     */
    private void construirModel(Companyia pCompanyia){
        
    }

    private void desarModel(String rutaFitxer) throws GestioVolsExcepcio {
        try {
            FileWriter fitxer = new FileWriter(rutaFitxer, false); //Obrim fitxer per sobreescriure
            fitxer.write(doc.toXML());
            fitxer.close();
        } catch (Exception e) {
            throw new GestioVolsExcepcio("GestorXML.desar");
        }
    }

    private void carregarFitxer(String rutaFitxer) throws GestioVolsExcepcio { 
        Builder builder = new Builder();
        try {
            doc = builder.build("/home/cesca/NetBeansProjects/ControlPlatsV4Solucio/"+rutaFitxer);
            System.out.println(doc.toXML());
        } catch (Exception e) {
            throw new GestioVolsExcepcio("GestorXML.carregar");
        }
    }

    /*Paràmetres: cap
     *
     *Acció: 
     *El mètode obtenirDades llegeix el fitxer del disc i el carrega sobre l'atribut 
     *doc de GestorXML.
     *
     *L'objectiu és llegir el document per assignar valors als atributs de Companyia
     *(i la resta d'objectes). Per llegir els valors dels atributs del document 
     *XML, heu de fer servir el mètode getAtributeValue(). 
     *Penseu que l'arrel conté els atributs de la companyia, per tant, al accedir 
     *a l'arrel del document ja podeu crear l'objecte Companyia amb el mètode constructor 
     *escaient de la classe companyia (fixeu-vos que s’ha afgeit un de nou).
     *
     *Un cop fet això, heu de recòrrer el document i per cada fill, haureu d'afegir un
     *element a l'ArrayList components de Companyia (nouXXX(.....)). Penseu que 
     *els mètodes de la classe companyia per afegir components, els hem modificat
     *perquè es pugui afegir un component passat er paràmetre.
     *
     *Si el fill (del document) que s'ha llegit és un avió o un vol, recordeu que a més
     *d'afegir-los a la companyia, també haureu d'afegir en el l'avió les seves classes
     *i en el vol la seva tripulació.
     *
     *Retorn: cap
     */
    private void obtenirDades() {
       
    }
}

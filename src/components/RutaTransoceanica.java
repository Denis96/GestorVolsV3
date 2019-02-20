/*
 * Una ruta transoceànica es defineix pel seu codi, aeroport d’origen, aeroport 
 * de destí, distància, país d’origen, país de destí, continent d’origen, continent 
 * de destí i oceà que sobrevola.
 */
package components;


/**
 *
 * @author root
 */
public class RutaTransoceanica extends RutaIntercontinental{
    
    private String ocea;

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     */
    public RutaTransoceanica(String codi, String aeroportOri, String aeroportDes, String paisOri, String paisDes, String continentOri, String continentDes, String ocea, double distancia) {
        super(codi, aeroportOri, aeroportDes, paisOri, paisDes, continentOri, continentDes, distancia);
        this.ocea = ocea;
    }

    /*
    Mètodes accessors
     */
    public String getOcea() {
        return ocea;
    }

    public void setOcea(String ocea) {
        this.ocea = ocea;
    }

    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear una nova ruta transcoceanica.
    Les dades a demanar són les que necessita el constructor.
    - Heu de tenir en compte que els aeroports i països no tene per què estar formats
    per una única paraula, per exemple, El Prat i Regne Unit.
     */
    public static RutaTransoceanica novaRutaTransoceanica() {

        String codi, aeroportOri, aeroportDes, paisOri, paisDes, continentOri, continentDes, ocea;
        double distancia;

        System.out.println("\nCodi de la ruta transoceànica:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja de buffer
        System.out.println("\nAeroport d'origen de la ruta transoceànica:");
        aeroportOri = DADES.nextLine();
        System.out.println("\nAeroport de destí de la ruta transoceànica:");
        aeroportDes = DADES.nextLine();
        System.out.println("\nPaís d'origen de la ruta transoceànica:");
        paisOri = DADES.nextLine();
        System.out.println("\nPaís de destí de la ruta transoceànica:");
        paisDes = DADES.nextLine();
        System.out.println("\nContinent d'origen de la ruta transoceànica:");
        continentOri = DADES.nextLine();
        System.out.println("\nContinent de destí de la ruta transoceànica:");
        continentDes = DADES.nextLine();
        System.out.println("\nOcea que sobrevola la ruta transoceànica:");
        ocea = DADES.nextLine();
        System.out.println("\nDistància de la ruta transoceànica:");
        distancia = DADES.nextDouble();

        return new RutaTransoceanica(codi, aeroportOri, aeroportDes, paisOri, paisDes, continentOri, continentDes, ocea, distancia);
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los.
    
     Retorn: cap
     */
    public void modificarComponent() {

        super.modificarComponent();
        
        System.out.println("\nL'oceà que sobrevola la ruta transoceànica és:"+ocea);
        ocea = String.valueOf(demanarDades("\nQuin és el nou oceà que sobrevola la ruta transoceànica?",4));
        
    }

    public void mostrarComponent() {
        super.mostrarComponent();
        
        System.out.println("\nOceà que sobrevola: " + ocea);
    }
}

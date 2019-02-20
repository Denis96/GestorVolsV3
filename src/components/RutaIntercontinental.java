/*
 * Una ruta intercontinental es defineix pel seu codi, aeroport d’origen, aeroport 
 * de destí, distància, país d’origen, país de destí, continent d’origen i continent 
 * de destí
 */
package components;


/**
 *
 * @author root
 */
public class RutaIntercontinental extends RutaInternacional{

    private String continentOri;
    private String continentDes;

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     */

    public RutaIntercontinental(String codi, String aeroportOri, String aeroportDes, String paisOri, String paisDes, String continentOri, String continentDes, double distancia) {
        super(codi, aeroportOri, aeroportDes, paisOri, paisDes, distancia);
        this.continentOri = continentOri;
        this.continentDes = continentDes;
    }
    
    /*
    Mètodes accessors
     */
    public String getContinentOri() {
        return continentOri;
    }

    public void setContinentOri(String continentOri) {
        this.continentOri = continentOri;
    }

    public String getContinentDes() {
        return continentDes;
    }

    public void setContinentDes(String continentDes) {
        this.continentDes = continentDes;
    }

    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear una nova ruta internacional.
    Les dades a demanar són les que necessita el constructor.
    - Heu de tenir en compte que els aeroports i països no tene per què estar formats
    per una única paraula, per exemple, El Prat i Regne Unit.
     */
    public static RutaIntercontinental novaRutaIntercontinental() {
        
        String codi, aeroportOri, aeroportDes, paisOri, paisDes, continentOri, continentDes;
        double distancia;

        System.out.println("\nCodi de la ruta intercontinental:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja de buffer
        System.out.println("\nAeroport d'origen de la ruta intercontinental:");
        aeroportOri = DADES.nextLine();
        System.out.println("\nAeroport de destí de la ruta intercontinental:");
        aeroportDes = DADES.nextLine();
        System.out.println("\nPaís d'origen de la ruta intercontinental:");
        paisOri = DADES.nextLine();
        System.out.println("\nPaís de destí de la ruta intercontinental:");
        paisDes = DADES.nextLine();
        System.out.println("\nContinent d'origen de la ruta intercontinental:");
        continentOri = DADES.nextLine();
        System.out.println("\nContinent de destí de la ruta intercontinental:");
        continentDes = DADES.nextLine();
        System.out.println("\nDistància de la ruta intercontinental:");
        distancia = DADES.nextDouble();

        return new RutaIntercontinental(codi, aeroportOri, aeroportDes, paisOri, paisDes, continentOri, continentDes, distancia);
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
        
        System.out.println("\nEl continent d'origen de la ruta intercontinental és:"+continentOri);
        continentOri = String.valueOf(demanarDades("\nQuin és el nou continent d'origen de la ruta intercontinental?",4));
        System.out.println("\nEl continent de destí de la ruta intercontinental és:"+continentDes);
        continentDes = String.valueOf(demanarDades("\nQuin és el nou continent de destí de la ruta intercontinental?",4));
    }

    public void mostrarComponent() {
        super.mostrarComponent();
        
        System.out.println("\nContinent d'origen: " + continentOri);
        System.out.println("\nContinent de destí: " + continentDes);
    }
}

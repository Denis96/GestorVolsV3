/*
 * Una ruta internacional es defineix pel seu codi, aeroport d’origen, aeroport 
 * de destí, distància, país d’origen i país de destí
 */
package components;

/**
 *
 * @author root
 */
public class RutaInternacional extends Ruta {

    private String paisOri;
    private String paisDes;

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     */
    public RutaInternacional(String codi, String aeroportOri, String aeroportDes, String paisOri, String paisDes, double distancia) {
        super(codi, aeroportOri, aeroportDes, distancia);
        this.paisOri = paisOri;
        this.paisDes = paisDes;
    }


    /*
    Mètodes accessors
     */
    public String getPaisOri() {
        return paisOri;
    }

    public void setPaisOri(String paisOri) {
        this.paisOri = paisOri;
    }

    public String getPaisDes() {
        return paisDes;
    }

    public void setPaisDes(String paisDes) {
        this.paisDes = paisDes;
    }


    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear una nova ruta internacional.
    Les dades a demanar són les que necessita el constructor.
    - Heu de tenir en compte que els aeroports països no tene per què estar formats per una única 
    paraula, per exemple, El Prat o Regne Unit.
     */
    public static RutaInternacional novaRutaInternacional() {

        String codi, aeroportOri, aeroportDes, paisOri, paisDes, continentOri, continentDes;
        double distancia;

        System.out.println("\nCodi de la ruta internacional:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja de buffer
        System.out.println("\nAeroport d'origen de la ruta internacional:");
        aeroportOri = DADES.nextLine();
        System.out.println("\nAeroport de destí de la ruta internacional:");
        aeroportDes = DADES.nextLine();
        System.out.println("\nPaís d'origen de la ruta internacional:");
        paisOri = DADES.nextLine();
        System.out.println("\nPaís de destí de la ruta internacional:");
        paisDes = DADES.nextLine();
        System.out.println("\nDistància de la ruta internacional:");
        distancia = DADES.nextDouble();

        return new RutaInternacional(codi, aeroportOri, aeroportDes, paisOri, paisDes, distancia);
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
        
        System.out.println("\nEl país d'origen de la ruta internacional és:" + paisOri);
        paisOri = String.valueOf(demanarDades("\nQuin és el nou país d'origen de la ruta internacional:",4));
        System.out.println("\nEl país de destí de la ruta internacional és:" + paisDes);
        paisDes = String.valueOf(demanarDades("\nQuin és el nou país de destí de la ruta internacional?",4));
    }

    public void mostrarComponent() {
        super.mostrarComponent();
        
        System.out.println("\nPaís d'origen: " + paisOri);
        System.out.println("\nPaís de destí: " + paisDes);
    }
}

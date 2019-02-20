package components;

import principal.Component;

/**
 *
 * @author root
 */
public abstract class Ruta implements Component {
    
    private String codi;
    private String aeroportOri;
    private String aeroportDes;
    private double distancia;

    /*
     CONSTRUCTOR
     */
    public Ruta(String codi, String aeroportOri, String aeroportDes, double distancia) {
        this.codi = codi;
        this.aeroportOri = aeroportOri;
        this.aeroportDes = aeroportDes;
        this.distancia = distancia;
    }

    /*
    Mètodes accessors
     */
    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getAeroportOri() {
        return aeroportOri;
    }

    public void setAeroportOri(String aeroportOri) {
        this.aeroportOri = aeroportOri;
    }

    public String getAeroportDes() {
        return aeroportDes;
    }

    public void setAeroportDes(String aeroportDes) {
        this.aeroportDes = aeroportDes;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
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

        System.out.println("\nEl codi de la ruta és:" + codi);
        codi = String.valueOf(demanarDades("\nQuin és el nou codi de la ruta?",2));
        demanarDades("",4); //Netejar buffer
        System.out.println("\nL'aeroport d'origen de la ruta és:" + aeroportOri);
        aeroportOri = String.valueOf(demanarDades("\nQuin és el nou l'aeroport d'origen de la ruta?",4));
        System.out.println("\nL'aeroport de destí de la ruta és:" + aeroportDes);
        aeroportDes = String.valueOf(demanarDades("\nQuin és el nou l'aeroport de destí de la ruta?",4));
        System.out.println("\nLa distància de la ruta és:");
        distancia = (double)demanarDades("\nQuina és la nova distància de la ruta?",3);
        
        demanarDades("",4); //Netejar buffer
    }

    public void mostrarComponent() {
        System.out.println("\nLes dades de la ruta amb codi " + codi + " són:");
        System.out.println("\nAeroport d'origen: " + aeroportOri);
        System.out.println("\nAeroport de destí: " + aeroportDes);
        System.out.println("\nDistància: " + distancia);
    }
    
}

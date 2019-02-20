/*
 * Defineix una classe d’un avió. Una classe d’un avió es defineix pel seu nom 
 * (no pot haver-hi un avió amb dues classes amb el mateix nom) i capacitat.
 * 
 */
package components;

import principal.Component;

/**
 *
 * @author root
 */
public class Classe implements Component{
       
    private String nom;
    private int capacitat;
    
     /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     */
    public Classe(String nom, int capacitat) {
        this.nom = nom;
        this.capacitat = capacitat;
    }

    /*
    Mètodes accessors    
    */
    public String getNom() {
        
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear una nova classe d'avió. 
      Les dades a demanar són les que necessita el constructor.
    - També heu de tenir en compte que el nom, no té perquè estar formt per una única
    paraula, per exemple, Turista Preferent.
    Retorn: La nova classe.
     */
    public static Classe novaClasse() {
        String nom;
        int capacitat;

        System.out.println("\nNom de la classe:");
        nom = DADES.nextLine();
        System.out.println("\nCapacitat de la classe:");
        capacitat = DADES.nextInt();

        return new Classe(nom,capacitat);
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los
     Retorn: cap
     */
    public void modificarComponent() {

        System.out.println("\nNom de la classe: " + nom);
        nom = String.valueOf(demanarDades("\nEntra el nou nom:",4));
        System.out.println("\nCapacitat de la classe: " + nom);
        capacitat = (int)demanarDades("\nEntra la nova capacitat:",1);
    }

    public void mostrarComponent() {
        System.out.println("\nLa classe " + nom + " té una capacitat de "+capacitat);
    }
    
}

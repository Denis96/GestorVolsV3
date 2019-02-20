/*
 * Un tripulant de cabina de passatgers (TCP) es defineix pel seu passaport, nom
 * , edat, data d’alta en la companyia, hores que porta de vol i rang
 */
package components;

/**
 *
 * @author root
 */
public class TCP extends Tripulant{

      /*
     CONSTRUCTOR
     */
    public TCP(String passaport, String nom, int edat, int horesVol) {
        super(passaport, nom, edat, horesVol);
    }


    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear un nou tripulant de cabina.
    Les dades a demanar són les que necessita el constructor.
    - Heu de tenir en compte que el nom no té per què estar format per una única 
    paraula, per exemple, Pep Gómez.
    - També heu de tenir en compte que les hores de vol són de tipus LocalTime, per
    tant heu de demanar a l'usuari les hores i minuts per crear el LocalTime. En aquest
    cas es considerarà que els segons i nanosegons, sempre són  0.
     */
    public static TCP nouTCP() {
        String passaport, nom;
        int edat, hores, minuts;

        System.out.println("\nPassaport del tripulant:");
        passaport = DADES.next();
        DADES.nextLine(); //Neteja de buffer
        System.out.println("\nNom del tripulant:");
        nom = DADES.nextLine();
        System.out.println("\nEdat del tripulant:");
        edat = DADES.nextInt();

        System.out.println("\nHores de vol del tripulant:");
        hores = DADES.nextInt();
        
        return new TCP(passaport, nom, edat, hores);
    }

}


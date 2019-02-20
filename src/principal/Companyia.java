/*
 * Classe que defineix una companyia. Una companyia es defineix per un codi i un 
 * nom. A més, contindrà vectors amb avions, rutes nacionals, rutes internacionals,
 * rutes intercontinentals, rutes transocèaniques, tripulants de cabina, TCPs i vols.
 */
package principal;

import components.Avio;
import components.Ruta;
import components.RutaIntercontinental;
import components.RutaInternacional;
import components.RutaNacional;
import components.RutaTransoceanica;
import components.TCP;
import components.Tripulant;
import components.TripulantCabina;
import java.text.ParseException;

/**
 *
 * @author root
 */
public class Companyia implements Component {

    private int codi;
    private static int properCodi = 1; //El proper codi a assignar
    private String nom;
    private Component[] components;
    private int posicioComponents; //Possició actual buida del vector components

    /*
     CONSTRUCTOR
     */
    public Companyia(String nom) {
        codi = properCodi;
        properCodi++;
        this.nom = nom;
        components = new Component[2945];
        posicioComponents = 0;
    }

    public Companyia(int codi, String nom) {
        this.codi = codi;
        this.nom = nom;
        components = new Component[2945];
        posicioComponents = 0;
    }

    /*
     Mètodes accessors    
     */
    public int getCodi() {
        return codi;
    }

    public void setCodi() {
        codi = properCodi;
    }

    public static int getProperCodi() {
        return properCodi;
    }

    public static void setProperCodi() {
        properCodi++;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Component[] getComponents() {
        return components;
    }

    public void setComponents(Component[] components) {
        this.components = components;
    }

    public int getPosicioComponents() {
        return posicioComponents;
    }

    public void setPosicioComponents(int posicioComponents) {
        this.posicioComponents = posicioComponents;
    }


    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear una nova Companyia. Les dades
     a demanar són les que necessita el constructor.
     - Heu de tenir en compte que el nom de la companyia, poden ser frases, per exemple,
     Singapore Airlines.
     Retorn: La nova companyia.
     */
    public static Companyia novaCompanyia() {

        System.out.println("\nNom de la companyia:");
        return new Companyia(DADES.nextLine());

    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte. En aquest cas
     no es pot modificar el contingut dels vectors, només el de l'atribut nom. 
     Evidentment, tampoc podeu modificar el codi.
     - Li heu de mostrar a l'usuari els valor actual del nom de l'objecte
     actual, abans de modificar-lo.
     Retorn: cap
     */
    public void modificarComponent() {

        System.out.println("\nNom de la companyia: " + nom);
        nom = String.valueOf(demanarDades("\nQuin és el nou nom de la companyia?", 4));

    }

    public void mostrarComponent() {
        System.out.println("\nLes dades de la companyia amb codi " + codi + " són:");
        System.out.println("\nNom:" + nom);
    }

    /*
     AVIÓ
     */
    public void afegirAvio(Avio avio) {

        if (avio == null) {
            avio = Avio.nouAvio();
        }

        if (seleccionarComponent(1, avio.getCodi()) == -1) {
            components[posicioComponents] = avio;
            posicioComponents++;
        } else {
            System.out.println("\nAquest avió ja existeix");
        }

    }

    /*
     RUTA NACIONAL
     */
    public void afegirRutaNacional(RutaNacional ruta) {

        if (ruta == null) {
            ruta = RutaNacional.novaRutaNacional();
        }

        if (seleccionarComponent(2, ruta.getCodi()) == -1) {
            components[posicioComponents] = ruta;
            posicioComponents++;
        } else {
            System.out.println("\nAquesta ruta ja existeix");
        }

    }

    /*
     RUTA INTERNACIONAL
     */
    public void afegirRutaInternacional(RutaInternacional ruta) {

        if (ruta == null) {
            ruta = RutaInternacional.novaRutaInternacional();
        }

        if (seleccionarComponent(2, ruta.getCodi()) == -1) {
            components[posicioComponents] = ruta;
            posicioComponents++;
        } else {
            System.out.println("\nAquesta ruta ja existeix");
        }

    }

    /*
     RUTA INTERCONTINENTAL
     */
    public void afegirRutaIntercontinental(RutaIntercontinental ruta){

        if (ruta == null) {
            ruta = RutaIntercontinental.novaRutaIntercontinental();
        }

        if (seleccionarComponent(2, ruta.getCodi()) == -1) {
            components[posicioComponents] = ruta;
            posicioComponents++;
        } else {
            System.out.println("\nAquesta ruta ja existeix");
        }

    }

    /*
     RUTA TRANSOCEÀNICA
     */
    public void afegirRutaTransoceanica(RutaTransoceanica ruta) {

        if (ruta == null) {
            ruta = RutaTransoceanica.novaRutaTransoceanica();
        }

        if (seleccionarComponent(2, ruta.getCodi()) == -1) {
            components[posicioComponents] = ruta;
            posicioComponents++;
        } else {
            System.out.println("\nAquesta ruta ja existeix");
        }

    }

    /*
     TRIPULACIÓ CABINA
     */
    public void afegirTripulantCabina(TripulantCabina tripulant) {

        if (tripulant == null) {
            tripulant = TripulantCabina.nouTripulantCabina();
        }

        if (seleccionarComponent(3, tripulant.getPassaport()) == -1) {
            components[posicioComponents] = tripulant;
            posicioComponents++;
        } else {
            System.out.println("\nAquest tripulant ja existeix");
        }

    }

    /*
     TCP
     */
    public void afegirTCP(TCP tripulant) {

        if (tripulant == null) {
            tripulant = TCP.nouTCP();
        }

        if (seleccionarComponent(3, tripulant.getPassaport()) == -1) {
            components[posicioComponents] = tripulant;
            posicioComponents++;
        } else {
            System.out.println("\nAquest tripulant ja existeix");
        }

    }

    /*
     VOL
     */
    public void afegirVol(Vol vol) throws ParseException {

        if (vol == null) {
            vol = Vol.nouVol();
        }

        if (seleccionarComponent(4, vol.getCodi()) == -1) {
            components[posicioComponents] = vol;
            posicioComponents++;
        } else {
            System.out.println("\nAquest vol ja existeix");
        }

    }

    public int seleccionarComponent(int tipus, String id) {

        int pos = -1;

        if (id == null) {
            switch (tipus) {
                case 1:
                    id = String.valueOf(demanarDades("\nCodi de l'avió?:", 2));
                    break;
                case 2:
                    id = String.valueOf(demanarDades("\nCodi de la ruta?:", 2));
                    break;
                case 3:
                    id = String.valueOf(demanarDades("\nPassaport del tripulant?:", 2));
                    break;
                default: //tipus 8 (Vol)
                    id = String.valueOf(demanarDades("\nCodi del vol?:", 2));
                    break;
            }
        }

        for (int i = 0; i < posicioComponents; i++) {

            if (tipus == 1 && components[i] instanceof Avio && ((Avio) components[i]).getCodi().equals(id)) {
                return i;
            } else if (tipus == 2 && components[i] instanceof Ruta && ((Ruta) components[i]).getCodi().equals(id)) {
                return i;
            } else if (tipus == 3 && components[i] instanceof Tripulant && ((Tripulant) components[i]).getPassaport().equals(id)) {
                return i;
            } else if (tipus == 4 && components[i] instanceof Vol && ((Vol) components[i]).getCodi().equals(id)) {
                return i;
            }
        }
        return pos;
    }

    public void afegirAvioVol() {
        Vol volSel;
        int pos = seleccionarComponent(4, null);

        if (pos >= 0) {

            volSel = (Vol) getComponents()[pos];

            pos = seleccionarComponent(1, null);

            if (pos >= 0) {
                volSel.setAvio((Avio) getComponents()[pos]);
            } else {
                System.out.println("\nNo existeix aquest avió");
            }

        } else {
            System.out.println("\nNo existeix aquest vol");
        }
    }

    public void afegirTripulantVol(int tipus) {
        Vol volSel;
        int pos = seleccionarComponent(4, null);

        if (pos >= 0) {

            volSel = (Vol) getComponents()[pos];

            pos = seleccionarComponent(3, null);

            if (pos >= 0 && ((tipus == 6 && getComponents()[pos] instanceof TripulantCabina) || (tipus == 7 && getComponents()[pos] instanceof TCP))) {
                volSel.afegirTripulant((Tripulant) getComponents()[pos]);
            } else {
                System.out.println("\nNo existeix aquest tripulant");
            }

        } else {
            System.out.println("\nNo existeix aquest vol");
        }
    }

    public void afegirRutaVol(int tipus) {
        Vol volSel;
        int pos = seleccionarComponent(4, null);

        if (pos >= 0) {

            volSel = (Vol) getComponents()[pos];

            pos = seleccionarComponent(2, null);

            if (pos >= 0 && ((tipus == 2 && getComponents()[pos] instanceof RutaNacional) || (tipus == 3 && getComponents()[pos] instanceof RutaInternacional) || (tipus == 4 && getComponents()[pos] instanceof RutaIntercontinental) || (tipus == 5 && getComponents()[pos] instanceof RutaTransoceanica))) {
                volSel.setRuta((Ruta) getComponents()[pos]);
            } else {
                System.out.println("\nNo existeix aquesta ruta");
            }

        } else {
            System.out.println("\nNo existeix aquest vol");
        }
    }

}

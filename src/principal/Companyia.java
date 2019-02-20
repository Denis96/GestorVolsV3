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
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class Companyia implements Component {

    private int codi;
    private static int properCodi = 1; //El proper codi a assignar
    private String nom;
    private ArrayList<Component> components;

    /*
     CONSTRUCTOR
     */
    public Companyia(String nom) {
        codi = properCodi;
        properCodi++;
        this.nom = nom;
        components = new ArrayList();
    }

    public Companyia(int codi, String nom) {
        this.codi = codi;
        this.nom = nom;
        components = new ArrayList();
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

	public ArrayList<Component> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<Component> components) {
		this.components = components;
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
			getComponents().add(avio);
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
			getComponents().add(ruta);
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
			getComponents().add(ruta);
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
			getComponents().add(ruta);
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
			getComponents().add(ruta);
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
			getComponents().add(tripulant);
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
			getComponents().add(tripulant);
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
			getComponents().add(vol);
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

        for (int i = 0; i < getComponents().size(); i++) {

            if (tipus == 1 && getComponents().get(i) instanceof Avio && ((Avio) getComponents().get(i)).getCodi().equals(id)) {
                return i;
            } else if (tipus == 2 && getComponents().get(i) instanceof Ruta && ((Ruta) getComponents().get(i)).getCodi().equals(id)) {
                return i;
            } else if (tipus == 3 && getComponents().get(i) instanceof Tripulant && ((Tripulant) getComponents().get(i)).getPassaport().equals(id)) {
                return i;
            } else if (tipus == 4 && getComponents().get(i) instanceof Vol && ((Vol) getComponents().get(i)).getCodi().equals(id)) {
                return i;
            }
        }
        return pos;
    }

    public void afegirAvioVol() {
        Vol volSel;
        int pos = seleccionarComponent(4, null);

        if (pos >= 0) {

            volSel = (Vol) getComponents().get(pos);

            pos = seleccionarComponent(1, null);

            if (pos >= 0) {
                volSel.setAvio((Avio) getComponents().get(pos));
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

            volSel = (Vol) getComponents().get(pos);

            pos = seleccionarComponent(3, null);

            if (pos >= 0 && ((tipus == 6 && getComponents().get(pos) instanceof TripulantCabina) || (tipus == 7 && getComponents().get(pos) instanceof TCP))) {
                volSel.afegirTripulant((Tripulant) getComponents().get(pos));
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

            volSel = (Vol) getComponents().get(pos);

            pos = seleccionarComponent(2, null);

            if (pos >= 0 && (	(tipus == 2 && getComponents().get(pos) instanceof RutaNacional) ||
								(tipus == 3 && getComponents().get(pos) instanceof RutaInternacional) ||
								(tipus == 4 && getComponents().get(pos) instanceof RutaIntercontinental) ||
								(tipus == 5 && getComponents().get(pos) instanceof RutaTransoceanica))) {
                volSel.setRuta((Ruta) getComponents().get(pos));
            } else {
                System.out.println("\nNo existeix aquesta ruta");
            }

        } else {
            System.out.println("\nNo existeix aquest vol");
        }
    }

}

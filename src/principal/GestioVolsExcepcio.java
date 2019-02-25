package principal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author root
 */
public class GestioVolsExcepcio extends Exception{

    private String codiCausa;
    private String missatge;

    public GestioVolsExcepcio(String pCodiCausa) {
        codiCausa = pCodiCausa;
        switch (codiCausa) {
            case "1":
                missatge = "La dada introduida no és un enter";
                break;
            case "2":
                missatge = "El codi de l'avió no és correcte";
                break;
            case "3":
                missatge = "El codi de la ruta no és correcte";
                break;
            case "4":
                missatge = "El codi del vol no és correcte";
                break;
            case "GestorXML.model":
                missatge = "No s'ha pogut crear el model XML per desar el contingut de la companyia";
                break;
            case "GestorXML.desar":
                missatge = "No s'ha pogut desar el contingut de la companyia a causa d'error d'entrada/sortida";
                break;
            case "GestorXML.carrega":
                missatge = "No s'ha pogut carregar el contingut de la companyia a causa d'error d'entrada/sortida";
                break;
            default:
                missatge = "Error desconegut";
                break;
        }
    }

    /*
    Paràmetres: codi d'un avió
    Accions:
    - Heu de comprovar si el format del codi de l'avió passat per paràmetre és 
    correcte. Recordeu que el codi de l'avió ha d'estar format per 3 dígits.
    - Per comprovar-ho, heu de fer servir expressions regulars.
    Retorn: verdader si el format és correcta, fals en cas contrari.
     */
    public static boolean comprovarCodiAvio(String codi) {
        String expressioRegular = "^\\d\\d\\d$";

        
        Pattern regles = Pattern.compile(expressioRegular);
        
        Matcher textAnalitzar = regles.matcher(codi);
        
        return textAnalitzar.find() == true;
    }

    /*
    Paràmetres: codi d'una ruta
    Accions:
    - Heu de comprovar si el format del codi de la ruta passat per paràmetre és 
    correcte. Recordeu que el codi d'una ruta ha d'estar format per 2 lletres
    seguides de 3 digits. Les lletres poden ser minúscules o majúscules.
    - Per comprovar-ho, heu de fer servir expressions regulars.
    Retorn: verdader si el format és correcta, fals en cas contrari.
     */
    public static boolean comprovarCodiRuta(String codi) {
        String expressioRegular = "^[a-zA-Z](2)\\d\\d\\d$";
        
        Pattern regles = Pattern.compile(expressioRegular);
        
        Matcher textAnalitzar = regles.matcher(codi);
        
        return textAnalitzar.find() == true; 
    }

    /*
    Paràmetres: codi d'un vol
    Accions:
    - Heu de comprovar si el format del codi del vol passat per paràmetre és 
    correcte. Recordeu que el codi d'un vol ha d'estar format per 2 o 3 lletres
    seguides de 4 digits. Les lletres poden ser minúscules o majúscules.
    - Per comprovar-ho, heu de fer servir expressions regulars.
    Retorn: verdader si el format és correcta, fals en cas contrari.
     */
    public static boolean comprovarCodiVol(String codi) {
        String expressioRegular = "^[a-zA-Z](2,3)\\d\\d\\d\\d$";
        
        Pattern regles = Pattern.compile(expressioRegular);
        
        Matcher textAnalitzar = regles.matcher(codi);
        
        return textAnalitzar.find() == true; 
    }
    
    /*
    Paràmetres: cap
    Accions:
    - Heu de sobreescriure el mètode getMessage() de la superclasse de la classe
    perquè retorni el codi i el missatge relacionat amb el codi d'una excepció.
    Retorn: El codi i missatge d'una excepció.
     */
    public String getMessage(){
        return codiCausa+": "+missatge;
    }

}

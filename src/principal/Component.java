/*
 * Interfície que implementarà qualsevol component de la companyia
 */
package principal;

import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author fta
 */
public interface Component {
    
    public Scanner DADES= new Scanner(System.in);
    
    public void modificarComponent() throws ParseException;
    
    public void mostrarComponent();
    
    public default Object demanarDades(String peticio, int tipus){
        System.out.println(peticio);
        switch(tipus){
            case 1:
                return DADES.nextInt();
            case 2:
                return DADES.next();
            case 3:
                return DADES.nextDouble();
            default:
                return DADES.nextLine();
        }
    }
}

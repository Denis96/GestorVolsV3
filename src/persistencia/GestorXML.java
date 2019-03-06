package persistencia;

import components.Avio;
import components.Classe;
import components.Ruta;
import components.RutaIntercontinental;
import components.RutaInternacional;
import components.RutaNacional;
import components.RutaTransoceanica;
import components.TCP;
import components.Tripulant;
import components.TripulantCabina;
import principal.Companyia;
import principal.GestioVolsExcepcio;
import principal.Vol;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import nu.xom.*;
import java.util.ArrayList;

/**
 *
 * @author cesca
 */
public class GestorXML implements ProveedorPersistencia {
    private Document doc;
    private Companyia companyia;

    public Companyia getCompanyia() {
        return companyia;
    }

    public void setCompanyia(Companyia pCompanyia) {
        companyia = pCompanyia;
    }

    public void desarDades(String nomFitxer, Companyia pCompanyia) throws GestioVolsExcepcio {
        construirModel(pCompanyia);
        desarModel(nomFitxer);
    }

    public Companyia carregarDades(String nomFitxer) throws GestioVolsExcepcio {
        carregarFitxer(nomFitxer);
        obtenirDades();
        return companyia;
    }

    /*Paràmetres: Companyia a partir de la qual volem construir el model
     *
     *Acció: 
     *Llegir els atributs de l'objecte Companyia passat per paràmetre per construir
     *un model (document XML) sobre el Document doc (atribut de GestorXML).
     *L'arrel del document XML és "companyia" i heu d'afegir-ne els valors de 
     *codi i nom com atributs. Aquesta arrel, l'heu d'afegir a doc.
     *
     *Un cop fet això, heu de recórrer l'ArrayList elements de Companyia i per 
     *a cada element, afegir un fill a doc. Cada fill tindrà com atributs els 
     *atributs de l'objecte (codi, nom, fabricant, …)
     *
     *Si es tracta d'un avio, a més, heu d'afegir fills addicionals amb els 
     *valors de les classes d'aquest avio. 
     *
     *Si es tracta d'un vol, a més, heu d'afegir fills addicionals amb els 
     *valors dels tripulants d'aquest vol. En el cas de l'atribut avio, heu d'assignar-li
     *el codi de l'avio del vol, i en el cas del cap dels TCP, el passport del cap.
     *
     *Retorn: cap
     */
    private void construirModel(Companyia pCompanyia){
        Element companyia = new Element("companyia");
			companyia.addAttribute(new Attribute("codi", Integer.toString(pCompanyia.getCodi())));
			companyia.addAttribute(new Attribute("nom", pCompanyia.getNom()));
			
			for (int i = 0; i < pCompanyia.getComponents().size(); i++) {
				
				if (pCompanyia.getComponents().get(i) instanceof Avio) {
					
					Element avio = new Element("avio");
						avio.addAttribute( new Attribute( "codi", ( (Avio)pCompanyia.getComponents().get(i) ).getCodi() ) );
						avio.addAttribute( new Attribute( "fabricant", ( (Avio) pCompanyia.getComponents().get(i)).getFabricant() ) );
						avio.addAttribute( new Attribute( "model", ( (Avio) pCompanyia.getComponents().get(i)).getModel() ) );
						avio.addAttribute( new Attribute( "capacitat", Integer.toString( ( (Avio) pCompanyia.getComponents().get(i)).getCapacitat() ) ) );
						
					for (int j = 0; j < ( (Avio)pCompanyia.getComponents().get(i) ).getClasses().size(); j++) {
						Element classe = new Element("classe");
							classe.addAttribute( new Attribute( "nom", (	(Classe)( (Avio)pCompanyia.getComponents().get(i) ).getClasses().get(j) ).getNom() ) );
							classe.addAttribute( new Attribute( "capacitat", Integer.toString(	(	(Classe)( (Avio)pCompanyia.getComponents().get(i) ).getClasses().get(j) ).getCapacitat() ) ) );
						
						avio.appendChild(classe);
					}
					
					companyia.appendChild(avio);

				} else if (pCompanyia.getComponents().get(i) instanceof Ruta) {
					Element ruta = new Element("");

						Attribute codi = new Attribute( "codi" , ( (Ruta)pCompanyia.getComponents().get(i) ).getCodi() );
						Attribute aeroportOri = new Attribute( "aeroportOri" , ( (Ruta)pCompanyia.getComponents().get(i) ).getAeroportOri() );
						Attribute aeroportDes = new Attribute( "aeroportDes" , ( (Ruta)pCompanyia.getComponents().get(i) ).getAeroportDes() );
						Attribute distancia = new Attribute( "distancia" , Double.toString( ( (Ruta)pCompanyia.getComponents().get(i) ).getDistancia() ) );
					
					if (pCompanyia.getComponents().get(i) instanceof RutaNacional ) {
						ruta = new Element("rutaNacional");
							Attribute pais = new Attribute( "pais" ,  ( (RutaNacional)pCompanyia.getComponents().get(i) ).getPais() );
							
							ruta.appendChild(codi);
							ruta.appendChild(aeroportOri);
							ruta.appendChild(aeroportDes);
							ruta.appendChild(distancia);
							ruta.appendChild(pais);
							
					} else if (pCompanyia.getComponents().get(i) instanceof RutaInternacional ) {
						ruta = new Element("rutaInternacional");
							Attribute paisOri = new Attribute( "paisOri" ,  ( (RutaInternacional)pCompanyia.getComponents().get(i) ).getPaisOri() );
							Attribute paisDes = new Attribute( "paisDes" ,  ( (RutaInternacional)pCompanyia.getComponents().get(i) ).getPaisDes() ); 
						
							ruta.appendChild(codi);
							ruta.appendChild(aeroportOri);
							ruta.appendChild(aeroportDes);
							ruta.appendChild(distancia);
							ruta.appendChild(paisOri);
							ruta.appendChild(paisDes);
							
					} else if (pCompanyia.getComponents().get(i) instanceof RutaIntercontinental ) {
						ruta = new Element("rutaIntercontinental");
							Attribute paisOri = new Attribute( "paisOri" ,  ( (RutaIntercontinental)pCompanyia.getComponents().get(i) ).getPaisOri() );
							Attribute paisDes = new Attribute( "paisDes" ,  ( (RutaIntercontinental)pCompanyia.getComponents().get(i) ).getPaisDes() ); 
							Attribute continentOri = new Attribute( "continentOri" ,  ( (RutaIntercontinental)pCompanyia.getComponents().get(i) ).getContinentOri() );
							Attribute continentDes = new Attribute( "continentDes" ,  ( (RutaIntercontinental)pCompanyia.getComponents().get(i) ).getContinentDes() ); 
						
							ruta.appendChild(codi);
							ruta.appendChild(aeroportOri);
							ruta.appendChild(aeroportDes);
							ruta.appendChild(distancia);
							ruta.appendChild(paisOri);
							ruta.appendChild(paisDes);
							ruta.appendChild(continentOri);
							ruta.appendChild(continentDes);
							
					} else if (pCompanyia.getComponents().get(i) instanceof RutaTransoceanica ) {
						ruta = new Element("rutaTransoceanica");
							Attribute paisOri = new Attribute( "paisOri" ,  ( (RutaTransoceanica)pCompanyia.getComponents().get(i) ).getPaisOri() );
							Attribute paisDes = new Attribute( "paisDes" ,  ( (RutaTransoceanica)pCompanyia.getComponents().get(i) ).getPaisDes() ); 
							Attribute continentOri = new Attribute( "continentOri" ,  ( (RutaTransoceanica)pCompanyia.getComponents().get(i) ).getContinentOri() );
							Attribute continentDes = new Attribute( "continentDes" ,  ( (RutaTransoceanica)pCompanyia.getComponents().get(i) ).getContinentDes() ); 
							Attribute ocea = new Attribute( "ocea" ,  ( (RutaTransoceanica)pCompanyia.getComponents().get(i) ).getOcea() ); 
						
							ruta.appendChild(codi);
							ruta.appendChild(aeroportOri);
							ruta.appendChild(aeroportDes);
							ruta.appendChild(distancia);
							ruta.appendChild(paisOri);
							ruta.appendChild(paisDes);
							ruta.appendChild(continentOri);
							ruta.appendChild(continentDes);
							ruta.appendChild(ocea);
					}
					
					companyia.appendChild(ruta);

				} else if (pCompanyia.getComponents().get(i) instanceof Tripulant) {
					Element tripulant = new Element("");

						Attribute passaport = new Attribute( "passaport" , ( (Tripulant)pCompanyia.getComponents().get(i) ).getPassaport() );
						Attribute nom = new Attribute( "nom" , ( (Tripulant)pCompanyia.getComponents().get(i) ).getNom() );
						Attribute edat = new Attribute( "edat" , Integer.toString( ( (Tripulant)pCompanyia.getComponents().get(i) ).getEdat() ) );
						
						String pattern = "MM-dd-yyyy";
						DateFormat df = new SimpleDateFormat(pattern);
						
						Attribute dataAlta = new Attribute( "dataAlta" , df.format( ( (Tripulant)pCompanyia.getComponents().get(i) ).getDataAlta() ) );
						Attribute horesVol = new Attribute( "horesVol" , Integer.toString( ( (Tripulant)pCompanyia.getComponents().get(i) ).getHoresVol() ) );
						Attribute rang = new Attribute( "rang" , ( (Tripulant)pCompanyia.getComponents().get(i) ).getRang() );
					
					if (pCompanyia.getComponents().get(i) instanceof TCP) {
							
						tripulant = new Element("TCP");	
							tripulant.appendChild(passaport);
							tripulant.appendChild(nom);
							tripulant.appendChild(edat);
							tripulant.appendChild(dataAlta);
							tripulant.appendChild(horesVol);
							tripulant.appendChild(rang);
					
					} else if (pCompanyia.getComponents().get(i) instanceof TripulantCabina) {
							
						tripulant = new Element("tripulantCabina");	
						
						Attribute barres = new Attribute( "barres" , Integer.toString( ( (TripulantCabina)pCompanyia.getComponents().get(i) ).getBarres() ) );
						
							tripulant.appendChild(passaport);
							tripulant.appendChild(nom);
							tripulant.appendChild(edat);
							tripulant.appendChild(dataAlta);
							tripulant.appendChild(horesVol);
							tripulant.appendChild(rang);
							tripulant.appendChild(barres);

					}
					
					companyia.appendChild(tripulant);
					
				} else if (pCompanyia.getComponents().get(i) instanceof Vol) {
					
				}
				
			}
			
        doc = new Document(companyia);
    }

    private void desarModel(String rutaFitxer) throws GestioVolsExcepcio {
        try {
            FileWriter fitxer = new FileWriter(rutaFitxer, false); //Obrim fitxer per sobreescriure
            fitxer.write(doc.toXML());
            fitxer.close();
        } catch (Exception e) {
            throw new GestioVolsExcepcio("GestorXML.desar");
        }
    }

    private void carregarFitxer(String rutaFitxer) throws GestioVolsExcepcio { 
        Builder builder = new Builder();
        try {
            doc = builder.build("/home/cesca/NetBeansProjects/ControlPlatsV4Solucio/"+rutaFitxer);
            System.out.println(doc.toXML());
        } catch (Exception e) {
            throw new GestioVolsExcepcio("GestorXML.carregar");
        }
    }

    /*Paràmetres: cap
     *
     *Acció: 
     *El mètode obtenirDades llegeix el fitxer del disc i el carrega sobre l'atribut 
     *doc de GestorXML.
     *
     *L'objectiu és llegir el document per assignar valors als atributs de Companyia
     *(i la resta d'objectes). Per llegir els valors dels atributs del document 
     *XML, heu de fer servir el mètode getAtributeValue(). 
     *Penseu que l'arrel conté els atributs de la companyia, per tant, al accedir 
     *a l'arrel del document ja podeu crear l'objecte Companyia amb el mètode constructor 
     *escaient de la classe companyia (fixeu-vos que s’ha afgeit un de nou).
     *
     *Un cop fet això, heu de recòrrer el document i per cada fill, haureu d'afegir un
     *element a l'ArrayList components de Companyia (nouXXX(.....)). Penseu que 
     *els mètodes de la classe companyia per afegir components, els hem modificat
     *perquè es pugui afegir un component passat er paràmetre.
     *
     *Si el fill (del document) que s'ha llegit és un avió o un vol, recordeu que a més
     *d'afegir-los a la companyia, també haureu d'afegir en el l'avió les seves classes
     *i en el vol la seva tripulació.
     *
     *Retorn: cap
     */
    private void obtenirDades() {
       
    }
}

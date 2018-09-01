package dominio.parte2.punto5;

import java.io.Serializable;
import java.util.ArrayList;

public class Libro extends Risorsa implements Serializable
{
	private static final long serialVersionUID = 1L;
	 
    private int numPagine;
    private String casaEditrice;
    
    public static final String DESCRIZIONE_LIBRO = "Titolo: %s\n\t\tAutore/i: %s\n\t\tNumero pagine: %d\n\t\tAnno di pubblicazione: %d\n\t\tCasa editrice: %s\n\t\tLingua: %s\n\t\tGenere: %s\n\t\tNumero licenze: %d\n";
    
    public Libro(String titolo, int licenze, String genere, int annoPub, String lingua, ArrayList <Persona> a, int np, String ce)
    {
    	 super(titolo, licenze, a, genere, annoPub, lingua);
    	 this.numPagine = np;
    	 this.casaEditrice = ce;
    }
        
    public String getCasaEditrice()
    {
    	 return casaEditrice;
    }
 
    public String toString()
    {
         StringBuffer ris = new StringBuffer();
         StringBuffer artisti = new StringBuffer();
         
         for(int i = 0; i < getArtisti().size(); i++)
         {
        	  artisti.append(getArtisti().get(i).toString());
        	  if(i < getArtisti().size()-1)
	       	          artisti.append(", ");
         }
         
         ris.append(String.format(DESCRIZIONE_LIBRO, getTitolo(), artisti, numPagine, getAnnoPub(), casaEditrice, getLingua(), getGenere(), getNumLicenze()));
         return ris.toString();
    }   
}
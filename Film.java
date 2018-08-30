package dominio.parte2.punto5;

import java.io.Serializable;
import java.util.ArrayList;

public class Film extends Risorsa implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Persona regista;
    private int durataInMinuti;
    
    public static final String DESCRIZIONE_FILM = "Titolo: %s\n\t\tRegista: %s\n\t\tAttore/i: %s\n\t\tGenere: %s\n\t\tLingua: %s\n\t\tDurata (in minuti): %d\n\t\tAnno di uscita: %d\n\t\tNumero licenze: %d\n";
   
    public Film(String titolo, int licenze, String genere, int annoPub, String lingua, Persona reg, ArrayList <Persona> a, int dm)
    {
    	 super(titolo, licenze, a, genere, annoPub, lingua);
    	 this.regista = reg;
    	 this.durataInMinuti =dm;
    }
   
    public Persona getRegista()
    {
    	 return regista;
    }
    
    public int getDurata()
    {
    	 return durataInMinuti;
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
       
        ris.append(String.format(DESCRIZIONE_FILM, getTitolo(), regista.toString(), artisti, getGenere(), getLingua(), durataInMinuti, getAnnoPub(), getNumLicenze()));
        return ris.toString();
    }
}
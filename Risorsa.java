package dominio.parte2.punto5;

import java.io.Serializable;
import java.util.ArrayList;
import logica.parte2.punto5.Persona;

public abstract class Risorsa implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String titolo;
	private int numLicenze;
	private ArrayList <Persona> artisti;
	private String genere;
	private int annoPub;
	private String lingua;
    

    public Risorsa(String t, int lic, ArrayList <Persona> a, String g, int ap, String l)
    {
    	 this.titolo = t;
    	 this.numLicenze = lic;
    	 this.artisti = a;
    	 this.genere = g;
    	 this.annoPub = ap;
    	 this.lingua = l;
    }
    
    public String getTitolo()
    {
    	 return titolo;
    }
    
    public int getNumLicenze() 
    {
    	 return numLicenze;
    }
    
    public ArrayList <Persona> getArtisti()
    {
    	return artisti;
    }
    
    public String getGenere()
    {
    	 return genere;
    }
    
    public int getAnnoPub()
    {
    	 return annoPub;
    }
    
    public String getLingua()
    {
    	 return lingua;
    }
    
    public boolean verificaPresenzaArtista(String t)
    {
    	for(int i = 0; i < artisti.size(); i++)
    	{
    		Persona p = artisti.get(i);
    		if(p.verificaPresenzaStringa(t))
    			 return true;	
    	}
    	return false;
    }
    
    public abstract String toString();
    
}

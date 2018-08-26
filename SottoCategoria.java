package dominio.parte2.punto5;

import java.io.Serializable;
import java.util.ArrayList;

import utility_2.SottoCategoriaException;

public class SottoCategoria extends Categoria implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String nomeSottoC;
    
    public static final String DESCRIZIONE_SOTTOCATEGORIA = "Nome sottocategoria: %s\n\t";
    public static final String ELENCO_RISORSE_VUOTO = "Al momento non sono presenti risorse\n";
    public static final String INTESTAZIONE_RISORSE = "Risorse in essa contenute:\n";
   
    public SottoCategoria(String ns)
    {
    	super();
    	this.nomeSottoC= ns;
    	inizializzaElencoRisorse();
    }
    
    public String getNome()
    {
    	return nomeSottoC;
    }
    
    public int getNumeroMaxGiorniPrestito()
	{
    	throw new SottoCategoriaException();
	}
	   
	public int getNumeroMaxGiorniProroga()
	{
		throw new SottoCategoriaException();   
	}
	
	public int getNumeroGiorniRichiestaProroga()
	{
	    throw new SottoCategoriaException();  
	}
	   
	public int getNumeroMaxRisorseInPrestito()
	{
		throw new SottoCategoriaException(); 
	}
	
    public void inizializzaElencoSottoCategorie()
    {
		throw new SottoCategoriaException(); 
    }
	
	public ArrayList <SottoCategoria> getElencoSottoCategorie() 
	{
		throw new SottoCategoriaException();
	}
    
    public void aggiungiSottoCategoria(SottoCategoria sc)
	{
    	throw new SottoCategoriaException();
	}
    
    public boolean verificaPresenza(String t)
	{
    	throw new SottoCategoriaException();
	}
    
    public String toString()
    {
 	   StringBuffer ris = new StringBuffer();
 	   ris.append(String.format(DESCRIZIONE_SOTTOCATEGORIA, nomeSottoC));
 	   
 	   if(getElencoRisorse().size() == 0)
 		   ris.append(ELENCO_RISORSE_VUOTO);
 	   else
 	   {
 	      ris.append(INTESTAZIONE_RISORSE);
 	      
 		  for(int i = 0; i < getElencoRisorse().size(); i++)
 	      {
 		     Risorsa r = getElencoRisorse().get(i);
 		     ris.append("\t\t" + (i+1) + ")"+ r.toString());
 	      }  
 	   }
 	   
 	   return ris.toString();
    }   
}
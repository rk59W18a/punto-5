package dominio.parte2.punto5;

import java.util.ArrayList;

public class RicercaPerArtistaStrategy implements IRicercaStrategy
{
	private String s;
	
	public RicercaPerArtistaStrategy(String s)
	{
		this.s = s;
	}
	
	public ArrayList <Risorsa> ricercaRisorsa(ArrayList <Risorsa> elencoris) 
	{
		 ArrayList <Risorsa> risorseCercate = new ArrayList <>();
	   	    
	   	 for(int i = 0; i < elencoris.size(); i++)
	   	 {
	   	     Risorsa ris = elencoris.get(i);
	   
	   	     if(ris.verificaPresenzaArtista(s))
					risorseCercate.add(ris);
	   	 }
	   	    	                    
	   	 return risorseCercate;
	}
}

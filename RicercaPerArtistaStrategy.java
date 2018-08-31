package dominio.parte2.punto5;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * Le due classi RicercaPerAttoreStrategy e RicercaPerAutoreStrategy sono
 * diventate un'unica classe in seguito all'introduzione della classe Persona
 */
public class RicercaPerArtistaStrategy implements IRicercaStrategy, Serializable
{
	//private static final long serialVersionUID = 1L;
	
	//private String s;
	
	/*
	public RicercaPerArtistaStrategy(String s)
	{
		this.s = s;
	}
	*/
	
	public ArrayList <Risorsa> ricercaRisorsa(ArrayList <Risorsa> elencoris) 
	{
		 //ArrayList <Risorsa> risorseCercate = new ArrayList <>();
	   	    
	   	 //for(int i = 0; i < elencoris.size(); i++)
	   	 {
	   	     //Risorsa ris = elencoris.get(i);
	   
	   	     if(ris.verificaPresenzaArtista(s))
					//risorseCercate.add(ris);
	   	 }
	   	    	                    
	   	 //return risorseCercate;
	}
}
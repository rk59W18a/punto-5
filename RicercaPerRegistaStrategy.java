package dominio.parte2.punto4;

import java.io.Serializable;
import java.util.ArrayList;

public class RicercaPerRegistaStrategy implements IRicercaStrategy, Serializable
{
	    //private static final long serialVersionUID = 1L;
	    
		//private String s;
		
	    /*
		public RicercaPerRegistaStrategy(String s)
		{
			this.s = s;
		}
		*/
		
		public ArrayList <Risorsa> ricercaRisorsa(ArrayList <Risorsa> elencoris) 
		{
			// ArrayList <Risorsa> risorseCercate = new ArrayList <>();
		   	    
		   	 //for(int i = 0; i < elencoris.size(); i++)
		   	 {
		   	     //Risorsa ris = elencoris.get(i);
		   	    	    
		   	     if(((Film)ris).getRegista().toLowerCase().indexOf((s).toLowerCase()) > -1)
						//risorseCercate.add(ris);
		   	 }
		   	    	                    
		   	 //return risorseCercate;
		}
}
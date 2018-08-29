package logica.parte2.punto5;

import java.io.Serializable;
import java.time.LocalDate;

import utility.parte2.Data;

public class AnagraficaFruitori extends Anagrafica implements Serializable
{
    private static final long serialVersionUID = 1L;
	
	public static final String INTESTAZIONE_ELENCO = "Elenco degli attuali fruitori: \n";
    public static final String ANAGRAFICA_VUOTA = "Al momento non sono presenti fruitori.\n";
	   
    public AnagraficaFruitori()
    {
   	    super();
    }
   
    public Fruitore getFruitore(String usef)
    {
      	for(int i = 0; i < getElenco().size(); i++)
	    {
	    	  Fruitore f = (Fruitore) getElenco().get(i);
	    	  
	    	  if(f.getUsername().equals(usef))
	    			   return f;
	    }
	    
	    return null;
    }
  
    public void aggiungiFruitore(Fruitore f)  
    {
   	    getElenco().add(f);
    }
   
    public boolean verificaPresenza(String n, String c, LocalDate dn)
    {
    	   for(int i = 0; i < getElenco().size(); i++)
    	   {
    		   Fruitore f = (Fruitore) getElenco().get(i);
    		   
    		   if((f.getNome()).equalsIgnoreCase(n) && (f.getCognome().equalsIgnoreCase(c)) && (Data.confrontaDate(dn, f.getDataDiNascita())))
                 return true;
    	   }
    	   
    	   return false;
    }
   
    public boolean verificaStessoUsername(String u) 
    {
   	    for(int i = 0; i < getElenco().size() ; i++)
   	    {
   	       Fruitore f = (Fruitore) getElenco().get(i);
   	    	   
   	    	   if((f.getUsername()).equals(u))
   	    		      return true;
   	    }
   	    
   	    return false;
    }
   
    public void decadenzaFruitore(ArchivioStorico as)
    {
   	 	for(int i = 0; i < getElenco().size() ; i++)
   	 	{
   	 		Fruitore f = (Fruitore) getElenco().get(i);	
   	 		
   	 	    if((LocalDate.now().equals(f.getDataDiScadenza())) || Data.verificaDataSuccessiva(f.getDataDiScadenza()))
   	 	    {
   	 	    	getElenco().remove(f);
   	 	      	as.getDecadenzeFruitoriStoriche().aggiungiFruitore(f);
   	 	    }
   	 	}
    }
       
    public String toString()		
    {
   	    StringBuffer ris = new StringBuffer();
   	    
   	    if(getElenco().size() == 0)
   	    {
   	    	    ris.append(ANAGRAFICA_VUOTA);
   	    }
   	    else
   	    {
   	   	    ris.append(INTESTAZIONE_ELENCO);

   	   	    for(int i = 0; i < getElenco().size(); i++)
   	   	    {
   	   	    	    Fruitore f = (Fruitore) getElenco().get(i);
   	   	    	    ris.append(i+1 + ")" + f.toString() + "\n");
   	   	    }
   	    }

   	    return ris.toString();
    }  
}
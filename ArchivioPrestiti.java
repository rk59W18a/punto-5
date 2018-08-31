package logica.parte2.punto5;

import java.io.Serializable;
import java.util.ArrayList;
import dominio.parte2.punto5.*;
import utility.parte2.Data;

public class ArchivioPrestiti implements Serializable
{
	//private static final long serialVersionUID = 1L;

	//private ArrayList <Prestito> elencoPrestiti;
	
	//public static final String INTESTAZIONE_ELENCO = "Elenco dei prestiti in corso: \n";
  
	/*
	public ArchivioPrestiti()
	{
		elencoPrestiti = new ArrayList <Prestito> ();
	}
	
	public ArrayList <Prestito> getElencoPrestiti()
	{
		return elencoPrestiti;
	}
	
    public ArrayList <Prestito> getPrestiti(String usef)   
    {
    	ArrayList <Prestito> prestitiInCorso = new ArrayList <Prestito> ();
   	    
      	for(int i = 0; i < elencoPrestiti.size(); i++)
	    {
	    	    Prestito p = elencoPrestiti.get(i);
	    	  
	    	    if(((p.getFruitoreAssociato().getUsername().equals(usef))))
	    			    prestitiInCorso.add(p);
	    }
	    
		return prestitiInCorso;
    }
   
    public boolean verificaPresenza(Risorsa r, String usef)
    {
    	   for(int i = 0; i < elencoPrestiti.size(); i++)
    	   {
    		   Prestito p  = elencoPrestiti.get(i);
    		   
    		   if(p.getRisorsaInPrestito().equals(r) && (p.getFruitoreAssociato().getUsername()).equals(usef))
    		          return true;
    	   }
    	   
    	   return false;
    }
    */
   
    public void scadenzaPrestito()
    {
      	//for(int i = 0; i < elencoPrestiti.size() ; i++)
   	 	{
   	 		//Prestito p = elencoPrestiti.get(i);	
   	 		
   	 	    //applicazione pattern 'Introduce Foreign Method' 
   	 	    if((Data.verificaDataCoincidente((p.getDataDiScadenzaPrestito()))) || (Data.verificaDataSuccessiva((p.getDataDiScadenzaPrestito()))))
	 	    {
	 			//elencoPrestiti.remove(p);
	 		}			
   	 	}  
    }
    
    /*
	public void aggiungiPrestito(Prestito p)
	{
		elencoPrestiti.add(p);
	}
	
	public void rimuoviPrestito(Prestito p)
	{
		elencoPrestiti.remove(p);
	}
	
	public boolean controlloPerUlteriorePrestito(Categoria c, String usef)
	{
		int num = 0;
		
      	for(int i = 0; i < elencoPrestiti.size(); i++)
	    {
	    	   Prestito p = elencoPrestiti.get(i);
	    	  
	    	   if(p.getCategoriaAssociata().equals(c) && (p.getFruitoreAssociato().getUsername()).equals(usef))
	    		  	 num++;
	    }
	    
	    if(c.getNumeroMaxRisorseInPrestito() > num)
	         return true;
	    else
	         return false;
	}
	
	public boolean controlloDisponibilitaRisorsa(Risorsa r)
	{
		int num = 0;
		
      	for(int i = 0; i < elencoPrestiti.size(); i++)
	    {
	    	   Prestito p = elencoPrestiti.get(i);
	    	  
	    	   if(p.getRisorsaInPrestito().equals(r))
	    		    	num++;
	    }
	    
	    if(r.getNumLicenze() > num)
	    	     return true;
	    else
	         return false;
	}
	
	public String toString()
	{
		StringBuffer s = new StringBuffer();
		
		for(int i = 0; i < elencoPrestiti.size(); i++)
		{
			s.append(i+1 + ")" + elencoPrestiti.get(i).toString() + "\n");
		}
		
		return s.toString();
	}
	*/
}
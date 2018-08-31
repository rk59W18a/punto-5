package logica.parte2.punto5;

import java.io.Serializable;

import java.time.*;
import java.util.ArrayList;
import utility.parte2.Data;

public class Fruitore extends Utente implements Serializable
{
    //private static final long serialVersionUID = 1L;
	
	//private LocalDate dataDiNascita;             
    //private LocalDate dataDiIscrizione;		
    //private LocalDate dataDiScadenza;
      
    //public static final String DESCRIZIONE_FRUITORE = "\nNome: %s\nCognome: %s\nUsername: %s\nPassword: %s\nData di nascita: %s\nData di iscrizione: %s\nData di scadenza: %s\n";
    //public static final int TERMINE_SCADENZA = 5;
    //public static final int DIECI_GIORNI = 10;
    //public static final String NO_PRESTITI_ATTIVI = "Al momento non ci sono prestiti\n";
    //public static final String PRESTITI_ATTIVI = "Elenco dei prestiti attivi:\n";
        
    public Fruitore(String n, String c, int an, int mn, int gn, String u, String p)
    {
   	     //super(n, c, u, p);
    	
    	 //applicazione pattern 'Introduce Foreign Method'
   	     this.dataDiNascita = Data.getDataImpostata(an, mn, gn);
   	     this.dataDiIscrizione = Data.getDataAttuale();
   	     this.dataDiScadenza = Data.aumentaNumeroAnni(dataDiIscrizione, TERMINE_SCADENZA);
    }
    
    /*
    public LocalDate getDataDiNascita()
    {
   	     return dataDiNascita;
    }
   
    public LocalDate getDataDiIscrizione()
    {
   	     return dataDiIscrizione;
    }
    
    public LocalDate getDataDiScadenza()
    {
   	     return dataDiScadenza;
    }
  
    public void setDataDiScadenza(LocalDate nuovads)
    {
   	 	dataDiScadenza = nuovads;
    }
    */
    
    public boolean rinnovaIscrizione()
    {
    	 //applicazione pattern 'Introduce Foreign Method'
    	 if((Data.verificaDataPrecedente(dataDiScadenza)))
		 {
    		 //applicazione pattern 'Introduce Foreign Method'	
    		 LocalDate ld = dataDiScadenza.minusDays(DIECI_GIORNI);
				
    		 //applicazione pattern 'Introduce Foreign Method'
			  if((Data.verificaDataCoincidente(ld)) || (Data.verificaDataSuccessiva(ld))) 
			  {
				//applicazione pattern 'Introduce Foreign Method'
				 setDataDiScadenza(Data.aumentaNumeroAnni(dataDiScadenza, TERMINE_SCADENZA));
				 //return true;
			  }
		 }
		 
		// return false;
    }
   
    /*
    public String prestitiInCorso(ArchivioPrestiti ap)
    {
    	ArrayList <Prestito> ris = new ArrayList <Prestito> ();
    	StringBuffer r = new StringBuffer();
        ris = ap.getPrestiti(this.getUsername());
   	    
   	    if(ris.size() == 0)
   	    	r.append(NO_PRESTITI_ATTIVI);
   	    else
        {
   	        r.append(PRESTITI_ATTIVI);
    	    for(int i = 0; i < ris.size(); i++)
    	    {
    	        Prestito p = ris.get(i);
    	   		r.append(i+1 + ")" + p.toString() +"\n");
    	    }
         }
    	    
      	return r.toString();
    }
    
    public void registraNuovoPrestito(ArchivioPrestiti ap, Prestito p)
    {
      	ap.aggiungiPrestito(p);
    }
   
    public boolean registraProrogaPrestito(Prestito p)
    {
    	return p.prorogaPrestito();
    }
    */
    
    public String toString()
    {
      	//StringBuffer ris = new StringBuffer();
         
        //applicazione pattern 'Introduce Foreign Method'
      	ris.append(String.format(DESCRIZIONE_FRUITORE, getNome(), getCognome(), getUsername(), getPassword(), Data.getDataFormattata(dataDiNascita), Data.getDataFormattata(dataDiIscrizione), Data.getDataFormattata(dataDiScadenza)));
        
      	//return ris.toString();
    }   
}
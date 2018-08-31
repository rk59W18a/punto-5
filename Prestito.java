package logica.parte2.punto5;

import java.io.Serializable;
import java.time.LocalDate;
import dominio.parte2.punto5.*;
import utility.parte2.Data;

public class Prestito implements Serializable
{
	//private static final long serialVersionUID = 1L;
	
	//private LocalDate dataDiInizioPrestito;
	//private LocalDate dataDiScadenzaPrestito;
	//private Categoria categoriaAssociata;
	//private Fruitore fruitoreAssociato;
	//private Risorsa risorsaInPrestito;
	//private boolean prorogaNonEffettuata;
	//private LocalDate dataProrogaEffettuata;
	
	//public static final String DESCRIZIONE_PRESTITO = "Categoria della risorsa in prestito: %s\nRisorsa presa in prestito:\n\t\t%s\nData inizio prestito:%s\nData scadenza prestito: %s\nProroga già effettuata: %s\n";
	
	public Prestito(Categoria c, Fruitore f, Risorsa r)
	{
		//applicazione pattern 'Introduce Foreign Method'
		this.dataDiInizioPrestito = Data.getDataAttuale();
		
		//this.categoriaAssociata = c;
		
		//applicazione pattern 'Introduce Foreign Method'
		this.dataDiScadenzaPrestito = Data.aumentaNumeroGiorni(dataDiInizioPrestito, categoriaAssociata.getNumeroMaxGiorniPrestito());
		
		//this.fruitoreAssociato = f;
		//this.risorsaInPrestito = r;
		//this.prorogaNonEffettuata = true;
	}
	
	/*
	public LocalDate getDataDiInizioPrestito()
	{
		return dataDiInizioPrestito;
	}
	
	public LocalDate getDataDiScadenzaPrestito()
	{
		return dataDiScadenzaPrestito;
	}
	
	public Categoria getCategoriaAssociata()
	{
		return categoriaAssociata;
	}
	
	public Fruitore getFruitoreAssociato()
	{
		return fruitoreAssociato;
	}
	
	public Risorsa getRisorsaInPrestito()
	{
		return risorsaInPrestito;
	}
	
	public boolean getProrogaNonEffettuata()
	{
		return prorogaNonEffettuata;
	}
	
	public LocalDate getDataProrogaEffettuata()
	{
		return dataProrogaEffettuata;
	}
	
	public void setProrogaNonEffettuata(LocalDate ld) 
	{
		prorogaNonEffettuata = false;
		this.dataProrogaEffettuata = ld;
	}
	
	public void setDataDiScadenzaPrestito(LocalDate nuovads)
	{
		dataDiScadenzaPrestito = nuovads;
	}
	*/
	
    public boolean prorogaPrestito()
    {
    	//if(prorogaNonEffettuata)
   	    {
   	        //applicazione pattern 'Introduce Foreign Method'
        	if(Data.verificaDataPrecedente(dataDiScadenzaPrestito))
   	 		{
        		//applicazione pattern 'Introduce Foreign Method'
        		LocalDate ld2 = Data.diminuisciNumeroGiorni(dataDiScadenzaPrestito, categoriaAssociata.getNumeroGiorniRichiestaProroga());
   	 			
        		//applicazione pattern 'Introduce Foreign Method'
        		if((Data.verificaDataCoincidente(ld2)) || Data.verificaDataSuccessiva(ld2))
       	 	    {
        		   //applicazione pattern 'Introduce Foreign Method'
        		   setDataDiScadenzaPrestito(Data.aumentaNumeroGiorni(dataDiScadenzaPrestito, categoriaAssociata.getNumeroMaxGiorniProroga()));
       	 		   setProrogaNonEffettuata(Data.getDataAttuale());
       	 		   //return true;
       	 		}
       	     }
   	 	}
	    //return false;
    }

    public String toString()
    {
        //StringBuffer ris = new StringBuffer();
	   
	    //String perProroga = "no";
  	    //if(!prorogaNonEffettuata)
  		     // perProroga = "si";
  	
    	//applicazione pattern 'Introduce Foreign Method'
  	    ris.append(String.format(DESCRIZIONE_PRESTITO, categoriaAssociata.getNome(), risorsaInPrestito.toString(), Data.getDataFormattata(dataDiInizioPrestito), Data.getDataFormattata(dataDiScadenzaPrestito), perProroga));
  	    
  	    //return ris.toString();
    }   
}
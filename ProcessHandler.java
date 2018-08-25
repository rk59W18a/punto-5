package interazione.parte2.punto5;

import java.io.Serializable;


import java.util.ArrayList;

import dominio.parte2.punto5.Categoria;
import dominio.parte2.punto5.IRicercaStrategy;
import dominio.parte2.punto5.RicercaPerAnnoPubblicazioneStrategy;
import dominio.parte2.punto5.RicercaPerArtistaStrategy;
import dominio.parte2.punto5.RicercaPerCasaEditriceStrategy;
import dominio.parte2.punto5.RicercaPerGenereStrategy;
import dominio.parte2.punto5.RicercaPerRegistaStrategy;
import dominio.parte2.punto5.RicercaPerTitoloStrategy;
import dominio.parte2.punto5.Risorsa;
import dominio.parte2.punto5.SottoCategoria;
import logica.parte2.punto5.Archivio;
import logica.parte2.punto5.ArchivioPrestiti;
import logica.parte2.punto5.Utente;
import utility_2.Costanti;
import utility_2.InputDati;

public abstract class ProcessHandler implements Serializable
{  
	private static final long serialVersionUID = 1L;
	
	private Archivio arc;
    private ArchivioPrestiti ap;
    
    /**
     * @pre: (arc != null) && (ap != null) 
     */
    public ProcessHandler(Archivio arc, ArchivioPrestiti ap)
    {  
    	this.arc = arc;
    	this.ap = ap;
    }
    
    public Archivio getArchivio()
    {
    	return arc;
    }
    
    public ArchivioPrestiti getArchivioPrestiti()
    {
    	return ap;
    }

    public abstract Utente accesso();
  
    /**
     * @pre: (ut != null) && (arc != null) && (arc.getElencoCategorie().size != 0)
     */
    public ArrayList <Risorsa> ricercaRisorsa(Utente ut)
    {
       	Categoria c = null;
       	
   	 	System.out.printf(Costanti.CONTENUTO_ARC, arc.stampaElencoCategorie());
   	 	
   	    int num1 = InputDati.leggiIntero(Costanti.INS_NUMERO_CAT_RICERCA, Costanti.NUM_MINIMO, (arc.getElencoCategorie()).size());
   	    c = (arc.getElencoCategorie()).get(num1-Costanti.NUM_MINIMO);
   	 		
   	 	if(c.getNome().equalsIgnoreCase("Libri"))
				return ricercaRisorsaLibri(ut, c);
   	 	else if(c.getNome().equalsIgnoreCase("Film"))
				return ricercaRisorsaFilm(ut, c);
   	 	else
   	 		return null;
    }
    
    /**
     * @pre: (ut != null) && (c != null)
     */
    public ArrayList <Risorsa> ricercaRisorsaLibri(Utente ut, Categoria c)
    {
   	    int numScelta = InputDati.leggiIntero(Costanti.AVVIO_RICERCA_LIBRI, Costanti.NUM_MINIMO, Costanti.NUM_MASSIMO_RICERCA);
   	    String s = "";
   	    IRicercaStrategy r = null;
   	
   	    switch(numScelta)
   	    {
	    	   case 1: s = InputDati.leggiStringa(Costanti.INS_PAROLA_TITOLO_RISORSA);
	    	           r = new RicercaPerTitoloStrategy(s);
	    			   break;
	    		
	    	   case 2: s = InputDati.leggiStringa(Costanti.INS_COGNOME_AUTORE_LIBRO); 
	    	           r = new RicercaPerArtistaStrategy(s);
	    		       break;
	       
	    	   case 3: s = InputDati.leggiStringa(Costanti.INS_GENERE_RISORSA);
	    	           r = new RicercaPerGenereStrategy(s);
	    		       break;
	    	   
	    	   case 4: s = Integer.toString(InputDati.leggiIntero(Costanti.INS_ANNOPUB_RISORSA));
	    	           r = new RicercaPerAnnoPubblicazioneStrategy(s);
	    	   		   break;
	    		
	    	   case 5: s = InputDati.leggiStringa(Costanti.INS_CASAED_LIBRO);
	    	           r = new RicercaPerCasaEditriceStrategy(s);
	    	   		   break;
   	    }  
	    
   	    return ut.ricercaRisorsa(c,r);
    }
   
    /** 
     * @pre: (ut != null) && (c != null)
     */
    public ArrayList <Risorsa> ricercaRisorsaFilm(Utente ut, Categoria c)
    {
   	    int numScelta = InputDati.leggiIntero(Costanti.AVVIO_RICERCA_FILM, Costanti.NUM_MINIMO, Costanti.NUM_MASSIMO_RICERCA);
   	    String s = "";
   	    IRicercaStrategy r = null;
   	
   	    switch(numScelta)
   	    {
   	     	case 1: s = InputDati.leggiStringa(Costanti.INS_PAROLA_TITOLO_RISORSA);
   	    			r = new RicercaPerTitoloStrategy(s);
	    			break;
	    		
   	      	case 2: s = InputDati.leggiStringa(Costanti.INS_COGNOME_REGISTA_FILM); 
   	                r = new RicercaPerRegistaStrategy(s);
	    		    break;
	       
   	        case 3: s = InputDati.leggiStringa(Costanti.INS_COGNOME_ATTORE_FILM);
   	                r = new RicercaPerArtistaStrategy(s);
	                break;
	    	   
   	      	case 4: s = Integer.toString(InputDati.leggiIntero(Costanti.INS_ANNOPUB_RISORSA));
   	                r = new RicercaPerAnnoPubblicazioneStrategy(s);
	                break;
	    		
   	       	case 5: s = InputDati.leggiStringa(Costanti.INS_GENERE_RISORSA);
   	                r = new RicercaPerGenereStrategy(s);
   	    			break;
   	    }  
	    
   	    return ut.ricercaRisorsa(c, r);
    }
    
   /**
    * @pre: (ut != null) && (arc != null) && (ap != null)
    */
   public String valutazioneDisponibilita(Utente ut)
   {
     	ArrayList <Risorsa> risorseTrovate = ricercaRisorsa(ut);
	    String s = "";
     	System.out.println(stampaRisorseDaRicerca(risorseTrovate));
   	    
     	if(risorseTrovate.size() != Costanti.VUOTO)
     	{
     	   int num = InputDati.leggiIntero(Costanti.RICHIESTA_DIGITAZIONE_VALUTAZIONE, Costanti.NUM_MINIMO, risorseTrovate.size());
     	   Risorsa r = risorseTrovate.get(num-Costanti.NUM_MINIMO);
      	
  	       if(ut.valutazioneDisponibilita(ap, r))
     	        s += Costanti.RISORSA_DISPONIBILE;
     	   else
   		    s += Costanti.RISORSA_NON_DISPONIBILE;
     	}
     	else 
     	      s += Costanti.NO_VALUTAZIONE;
     	
     	return s;
   }
   
   public boolean richiestaLogout()
   {
      	if(InputDati.leggiUpperChar(Costanti.RICHIESTA_LOGOUT, "SN") == 'S')
    		     return true;
      	else
    		     return false;
   }
   
   /**
    * Metodo per la creazione di una stringa descrittiva delle risorse che sono state trovate mediante 
    * una ricerca
    * 
    * @pre: elencoRisorse != null
    * 
    * @param elencoRisorse: il vettore contenente le risorse, risultato dalla ricerca, da stampare
    */
   public String stampaRisorseDaRicerca(ArrayList <Risorsa> elencoRisorse)
   {
  	    StringBuffer ris = new StringBuffer();
  	    ris.append(Costanti.INTESTAZIONE_RICERCA_RISORSE);
  	    
  	    if(elencoRisorse.size() == Costanti.VUOTO)
  	    	    ris.append(Costanti.RICERCA_VUOTA);
  	    
		for(int i = 0; i < elencoRisorse.size(); i++)
		{
			Risorsa r = elencoRisorse.get(i);
			ris.append("\t\t" + (i+1) + ")" + r.toString());
		}
		
		return ris.toString();
   }
   
   /**
    * @pre: elencoRisorse != null
    */
   public String stampaElencoRisorse(Categoria c)
   {
      StringBuffer ris = new StringBuffer();
 	   
 	   for(int i = 0; i < c.getElencoRisorse().size(); i++)
 	   {
 		   Risorsa r = c.getElencoRisorse().get(i);
 		   ris.append(i+1 + ")"+ r.getTitolo() + "\n");
 	   }
 	   
 	   return ris.toString();
   }
   
   /**
    * @pre: elencoSottoCategorie != null
    */
   public String stampaElencoSottocategorie(Categoria c)
   {
	   StringBuffer ris = new StringBuffer();
	   
	   for(int i = 0; i < c.getElencoSottoCategorie().size(); i++)
	   {
		   SottoCategoria sc = c.getElencoSottoCategorie().get(i);
		   ris.append(i+1 + ")" + sc.getNome() + "\n");
	   }
	   
	   return ris.toString();
   }
    
}

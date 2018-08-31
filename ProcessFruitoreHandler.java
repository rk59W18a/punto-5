package interazione.parte2.punto5;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.Period;
import dominio.parte2.punto5.Categoria;
import dominio.parte2.punto5.Risorsa;
import dominio.parte2.punto5.SottoCategoria;
import logica.parte2.punto5.Fruitore;
import logica.parte2.punto5.Prestito;
import logica.parte2.punto5.Utente;
import utility.parte2.Costanti;
import utility.parte2.Data;
import utility.parte2.InputDati;

public class ProcessFruitoreHandler extends ProcessHandler implements Serializable
{
	//private static final long serialVersionUID = 1L;
	
	//Applicazione dei pattern di Refactoring 'Preserve Whole Object' e
    //'Introduce Parameter Object': al costruttore viene passato l'intero oggetto RaccoltaDati.
    public ProcessFruitoreHandler(RaccoltaDati rd)
    {
    	super(rd);
    }
  
    /*
	public void iscrizione()
	{
		String nome = "";
		String cognome = "";
		String use = "";
		String pwd = "";
		int giorno = 0;
		int mese = 0;
		int anno = 0;

		boolean end = true;
		
		boolean ins_nome = true;
		boolean ins_cognome = true;
		boolean ins_use = true;
		boolean ins_pwd = true;
		boolean ins_data = true;
		
	    do
	    {
	      	if(ins_nome)
	    	{
				nome = InputDati.leggiStringaNonVuota(Costanti.INS_NOME);
	    	}
	    	
	    	if(ins_cognome)
	      	{
				cognome = InputDati.leggiStringaNonVuota(Costanti.INS_COGNOME);
	      	}
	    	
	      	if(ins_use)
	    	{
				use = InputDati.leggiStringaNonVuota(Costanti.INS_USERNAME);
	      	}
	     	
	      	if(ins_pwd)
	      	{
				pwd = InputDati.leggiStringaNonVuota(Costanti.INS_PASSWORD);
	      	}
	    	
			Fruitore f = null;	
			boolean exc = false;			
			end = true;
			
			while(!exc) {
			
				try 
				{
					if(ins_data)
					{
						giorno = InputDati.leggiIntero(Costanti.INS_GIORNO_NASCITA);
						mese = InputDati.leggiIntero(Costanti.INS_MESE_NASCITA);
						anno = InputDati.leggiIntero(Costanti.INS_ANNO_NASCITA);
					}
					
					f = new Fruitore(nome, cognome, anno, mese, giorno, use, pwd);
					
					exc = true;
				}
				catch(DateTimeException e)
				{
					System.out.println(Costanti.DATA_DI_NASCITA_ERRATA);
				}
				
			};
			
			ins_nome = false;
			ins_cognome = false;
			ins_use = false;
			ins_pwd = false;
			ins_data = false;

			if(getAnagraficaFruitori().verificaPresenza(f.getNome(), f.getCognome(), f.getDataDiNascita()))
			{
				System.out.println(Costanti.ISCRIZIONE_NON_OK_FRUITORE_GIA_ISCRITTO);
				ins_nome = true;
				ins_cognome = true;
				ins_data = true;
				end = false;
			}
			
			if(getAnagraficaFruitori().verificaStessoUsername(f.getUsername()))
			{
				System.out.println(Costanti.ISCRIZIONE_NON_OK_STESSO_USERNAME);
				ins_use = true;
				end = false;
			}
			*/
			
			//applicazione pattern 'Introduce Foreign Method' 
			if(Period.between(f.getDataDiNascita(), Data.getDataAttuale()).getYears() < Costanti.MAGGIORE_ETA)
			{
				//System.out.println(Costanti.ISCRIZIONE_NON_OK_MAGGIORE_ETA);
				//ins_nome = true;
				//ins_cognome = true;
				//ins_data = true;
				//end = false;
			}
			
		    /*
			if(end)
			{
				getAnagraficaFruitori().aggiungiFruitore(f);
				getArchivioStorico().getIscrizioniFruitoriStoriche().aggiungiFruitore(f);
				System.out.println(Costanti.ISCRIZIONE_OK);
			}
			else
			{
	
				if(InputDati.leggiUpperChar(Costanti.RICHIESTA_PROSECUZIONE, "SN") == 'N')
				{
					end = true;				
					System.out.println(Costanti.ISCRIZIONE_NON_OK);
				}	
			}
			
		}while(!end);
	    
	}
	
	public void rinnovaIscrizione(Fruitore f) 
	{
		if(f.rinnovaIscrizione())
        {
	        getArchivioStorico().getRinnovoIscrizioniFruitoriStorici().aggiungiFruitore(f);
	        System.out.println(Costanti.RINNOVO_OK);
        }
		else
			System.out.println(Costanti.RINNOVO_NON_OK);
	}
	
	 public Utente accesso()
	 {
	     String use = "";
	     String pwd = "";
		 boolean end = false;
		 Utente ut = null;
			
		  do
		  {
		      use = InputDati.leggiStringaNonVuota(Costanti.USERNAME);
		      pwd = InputDati.leggiStringaNonVuota(Costanti.PASSWORD);

			  if(getAnagraficaFruitori().accedi(use, pwd))
			  {
				  ut = getAnagraficaFruitori().getUtente(use, pwd);
				  end = true;
			  }
			  else
			  {
				   System.out.println(Costanti.CREDENZIALI_ERRATE);
					 
				   if(InputDati.leggiUpperChar(Costanti.RICHIESTA_PROSECUZIONE, "SN") == 'N')
				   {
					  end = true;
				   }	
			  }
			  
		    }while(!end);
			
		 return ut;
     }
	
	public void visualizzaPrestitiInCorso(Fruitore f)
	{
		System.out.println(f.prestitiInCorso(getArchivioPrestiti()));
	}
	*/

	//Metodo introdotto in seguito all'applicazione del pattern di Refactoring 'Extract Method'
	//al metodo registraPrestito.
	public void registraPrestitoSenzaSottoCategorie(Fruitore f, Categoria c, Risorsa r, Prestito nuovo) 
	{
		if(c.getElencoRisorse().size() != Costanti.VUOTO)  
	    {
  	    	     System.out.printf(Costanti.CONTENUTO_CAT_RISORSA, c.getNome(), stampaElencoRisorse(c));
	      	 
  	    	     if(InputDati.leggiUpperChar(Costanti.INS_PROCEDERE_PRESTITO, "SN") == 'S')
	    	     {
  	    	        int num = InputDati.leggiIntero(Costanti.INS_NUMERO_RISORSA_PRESTITO, Costanti.NUM_MINIMO, c.getElencoRisorse().size());
	                r = c.getElencoRisorse().get(num-Costanti.NUM_MINIMO);
	    	
	                if(getArchivioPrestiti().controlloDisponibilitaRisorsa(r) && getArchivioPrestiti().controlloPerUlteriorePrestito(c, f.getUsername()) && !(getArchivioPrestiti().verificaPresenza(r, f.getUsername())))
	   	            {
	   		               nuovo = new Prestito(c, f, r);
	   		               f.registraNuovoPrestito(getArchivioPrestiti(), nuovo);
	   		               getArchivioStorico().getPrestitiStorici().aggiungiPrestito(nuovo);
	    	               System.out.println(Costanti.OP_SUCCESSO);
	   	             }
	   	             else if(!(getArchivioPrestiti().controlloDisponibilitaRisorsa(r)))
	                           System.out.println(Costanti.OP_NO_SUCCESSO_PRESTITO_1);
                     else if(!(getArchivioPrestiti().controlloPerUlteriorePrestito(c, f.getUsername())))
	                           System.out.println(Costanti.OP_NO_SUCCESSO_PRESTITO_2);
                     else  
           	                   System.out.println(Costanti.OP_NO_SUCCESSO_PRESTITO_3);
	    	      }
	    	} 
  	        else
  	    	    System.out.printf(Costanti.CONTENUTO_ELENCO_RISORSE_CAT_VUOTO, c.getNome());
	}
	
	//Metodo introdotto in seguito all'applicazione del pattern di Refactoring 'Extract Method'
    //al metodo registraPrestito.
	public void registraPrestitoConSottoCategorie(Fruitore f, Categoria c, Risorsa r, Prestito nuovo, SottoCategoria sc) 
	{
		System.out.printf(Costanti.CONTENUTO_CAT_SOTTO, c.getNome(), stampaElencoSottocategorie(c));
		int num2 = InputDati.leggiIntero(Costanti.INS_NUMERO_SOTTOC_PRESTITO, Costanti.NUM_MINIMO, (c.getElencoSottoCategorie()).size());
	    sc = (c.getElencoSottoCategorie()).get(num2-Costanti.NUM_MINIMO);
	    	    	    	    	    
	    if((sc.getElencoRisorse()).size() != Costanti.VUOTO)
        {
           System.out.printf(Costanti.CONTENUTO_SOTTO, sc.getNome(), stampaElencoRisorse(sc));
           
           if(InputDati.leggiUpperChar(Costanti.INS_PROCEDERE_PRESTITO, "SN") == 'S')
           {
              int num = InputDati.leggiIntero(Costanti.INS_NUMERO_RISORSA_PRESTITO, Costanti.NUM_MINIMO, sc.getElencoRisorse().size());
       	      r = sc.getElencoRisorse().get(num-Costanti.NUM_MINIMO);
       
       	      if(getArchivioPrestiti().controlloDisponibilitaRisorsa(r) && getArchivioPrestiti().controlloPerUlteriorePrestito(c, f.getUsername()) && !(getArchivioPrestiti().verificaPresenza(r, f.getUsername())))
              {
	   		         nuovo = new Prestito(c, f, r);
	   		         f.registraNuovoPrestito(getArchivioPrestiti(), nuovo);
	   		         getArchivioStorico().getPrestitiStorici().aggiungiPrestito(nuovo);
      	             System.out.println(Costanti.OP_SUCCESSO);
              }
              else if(!(getArchivioPrestiti().controlloDisponibilitaRisorsa(r)))
      	                System.out.println(Costanti.OP_NO_SUCCESSO_PRESTITO_1);
              else if(!(getArchivioPrestiti().controlloPerUlteriorePrestito(c, f.getUsername())))
    	                System.out.println(Costanti.OP_NO_SUCCESSO_PRESTITO_2);
              else
            	        System.out.println(Costanti.OP_NO_SUCCESSO_PRESTITO_3);
           }
        } 
	    else
		    System.out.printf(Costanti.CONTENUTO_ELENCO_RISORSE_SOTTO_VUOTO, sc.getNome());	
	}
	
	//Metodo modificato sulla base dell'applicazione del pattern di Refactoring
	//'Extract Method'.
    public void registraPrestito(Fruitore f) 
    {
    	 Categoria c = null;
    	 SottoCategoria sc = null;
    	 Risorsa r = null;
    	 Prestito p = null;
    	
    	 System.out.printf(Costanti.CONTENUTO_ARC, stampaElencoCategorie());
    	 int num1 = InputDati.leggiIntero(Costanti.INS_NUMERO_CAT_PRESTITO, Costanti.NUM_MINIMO, (getArchivio().getElencoCategorie()).size());
    	 c = (getArchivio().getElencoCategorie()).get(num1-Costanti.NUM_MINIMO);

    	 if(c.getElencoSottoCategorie() == null)
    	 {
    		 registraPrestitoSenzaSottoCategorie(f,c,r,p);
    	 }
    	 else if((c.getElencoSottoCategorie()).size() == Costanti.VUOTO)
    	 {
    		System.out.printf(Costanti.CONTENUTO_ELENCO_SOTTO_VUOTO, c.getNome());
    	 }
    	 else
    	 {
    		 registraPrestitoConSottoCategorie(f,c,r,p,sc);
    	}	
    }
    
    /*
    public void richiediProroga(Fruitore f) 
    { 
   	    if(getArchivioPrestiti().getPrestiti(f.getUsername()).size() != Costanti.VUOTO)
   	    {
   	       System.out.println(f.prestitiInCorso(getArchivioPrestiti()));
   	
   	       if(InputDati.leggiUpperChar(Costanti.INS_PROCEDERE_PROROGA, "SN") == 'S')
   	       {
   	          int num = InputDati.leggiIntero(Costanti.INS_NUMERO_PRESTITO_PROROGA, Costanti.NUM_MINIMO, getArchivioPrestiti().getPrestiti(f.getUsername()).size());
   	          Prestito pr = getArchivioPrestiti().getPrestiti(f.getUsername()).get(num-Costanti.NUM_MINIMO);
   	      
   	          if(f.registraProrogaPrestito(pr))
   	          {
   	    	       getArchivioStorico().getPrestitiConProrogheStoriche().aggiungiPrestito(pr);;
   	    	       System.out.println(Costanti.OP_SUCCESSO);
   	          }
   	          else
   	          {
   	    	       System.out.println(Costanti.OP_NO_SUCCESSO_PROROGA_1);
   	          }
   	       }
   	    }
   	    else
   	    {
   		    System.out.println(Costanti.OP_NO_SUCCESSO_PROROGA_2);
   	    }  
    }
    
    public void controlloScadenzeAutomatiche()
    {
    	getAnagraficaFruitori().decadenzaFruitore(getArchivioStorico());
        getArchivioPrestiti().scadenzaPrestito();
    } 
    */  
}
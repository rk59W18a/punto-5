package logica.parte2.punto5;

import java.io.Serializable;
import java.util.ArrayList;
import dominio.parte2.punto5.*;

public class Utente extends Persona implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    
    public Utente(String n, String c, String u, String p)
    {
    	super(n,c);
    	this.username = u;
    	this.password = p;
    }
     
    public String getUsername()
    {
   	     return username;
    }
    
    public String getPassword()
    {
    	 return password; 
    }
  
    public ArrayList <Risorsa> ricercaRisorsa(Contenitore c, IRicercaStrategy r)
    {
       	 return c.ricercaRisorsa(r);
    }
   
    public boolean valutazioneDisponibilita(ArchivioPrestiti ap, Risorsa r)
    {
         return	ap.controlloDisponibilitaRisorsa(r);
    }
}
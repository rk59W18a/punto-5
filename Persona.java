package logica.parte2.punto5;

import java.io.Serializable;

public class Persona implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private final String nome;
    private final String cognome;
    
    public Persona(String nome, String cognome)
    {
    	this.nome = nome;
    	this.cognome = cognome;
    }
    
    public String getNome()
    {
    	return nome;
    }
    
    public String getCognome()
    {
    	return cognome;
    }
    
    public boolean verificaPresenzaStringa(String t)
    {
    	if((nome.toLowerCase().indexOf((t).toLowerCase()) > -1) || 
    	     (cognome.toLowerCase().indexOf((t).toLowerCase()) > -1) ||
    	        ((nome + " " + cognome).toLowerCase().indexOf((t).toLowerCase()) > -1))
               return true;
        else
        	   return false;
    }
    
    public String toString()
    {
    	StringBuffer ris = new StringBuffer();
    	ris.append(String.format("%s  %s", getNome(), getCognome()));
    	return ris.toString();
    }
}

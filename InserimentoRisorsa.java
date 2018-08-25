package interazione.parte2.punto5;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import dominio.parte2.punto5.*;
import logica.parte2.punto5.Persona;
import utility_2.*;


public class InserimentoRisorsa implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	public static final String INS_TITOLO = "Inserisci il titolo:\n";
    public static final String INS_NUMLICENZE = "Inserisci il numero delle licenze:\n";
    public static final String INS_NOME_AUTORE = "Inserisci il nome un autore:\n";
    public static final String INS_COGNOME_AUTORE = "Inserisci il cognome di un autore:\n";
    public static final String INS_ALTRO_AUTORE = "Vuoi inserire un altro autore (S/N)?\n";
    public static final String INS_NUMPAGINE = "Inserisci il numero delle pagine:\n";
    public static final String INS_ANNOP = "Inserisci l'anno di pubblicazione:\n";
    public static final String INS_CASAED = "Inserisci la casa editrice:\n";
    public static final String INS_LINGUA = "Inserisci la lingua:\n";
    public static final String INS_GENERE = "Inserisci il genere:\n";
    
    public static final String INS_NOME_REGISTA = "Inserisci il nome del regista:\n";
    public static final String INS_COGNOME_REGISTA = "Inserisci il cognome del regista:\n";
    public static final String INS_NOME_ATTORE = "Inserisci il nome di un attore:\n";
    public static final String INS_COGNOME_ATTORE = "Inserisci il cognome di un attore:\n";
    public static final String INS_ALTRO_ATTORE = "Vuoi inserire un altro attore (S/N)?\n";
    public static final String INS_DURATAMIN = "Inserisci la durata (in minuti):\n";
    
    public static final int ANNO_CORRENTE = LocalDate.now().getYear();
    public static final int MIN_LICENZE_LIBRI = 1;
    public static final int MAX_LICENZE_LIBRI = 10;
    public static final int MIN_LICENZE_FILM = 1;
    public static final int MAX_LICENZE_FILM = 20;
    public static final int MIN_ANNOP = 1900;
	
    
	public static Libro inserisciLibro()
    {
    	    String t = InputDati.leggiStringaNonVuota(INS_TITOLO);
    	    int nl = InputDati.leggiIntero(INS_NUMLICENZE, MIN_LICENZE_LIBRI, MAX_LICENZE_LIBRI); 
    	    boolean end = false;
    	    ArrayList <Persona> a = new ArrayList <Persona> ();
    	    
    	    do
    	    {
    	    	String nome = InputDati.leggiStringaNonVuota(INS_NOME_AUTORE);
    	    	String cognome = InputDati.leggiStringaNonVuota(INS_COGNOME_AUTORE);
    	    	
    	    	a.add(new Persona(nome, cognome));
    	    	    
    	    	if(InputDati.leggiUpperChar(INS_ALTRO_AUTORE, "SN") == 'N')
    	    	     end = true;
    	    	    
    	    }while(!end);
    	    
    	    int np = InputDati.leggiIntero(INS_NUMPAGINE);
    	    int ap = InputDati.leggiIntero(INS_ANNOP, MIN_ANNOP, ANNO_CORRENTE);   
    	    String ce = InputDati.leggiStringaNonVuota(INS_CASAED);
    	    String l = InputDati.leggiStringaNonVuota(INS_LINGUA);
    	    String g = InputDati.leggiStringaNonVuota(INS_GENERE);
    	    		
    	    Libro lib = new Libro(t, nl, g, ap, l, a, np, ce);
    	    
    	    return lib;
    }
	
	public static Film inserisciFilm()
    {
    	    String t = InputDati.leggiStringaNonVuota(INS_TITOLO);
    	    int nl = InputDati.leggiIntero(INS_NUMLICENZE, MIN_LICENZE_FILM, MAX_LICENZE_FILM); 
    	    boolean end = false;
    	    String nomeRegista = InputDati.leggiStringaNonVuota(INS_NOME_REGISTA);
    	    String cognomeRegista = InputDati.leggiStringaNonVuota(INS_COGNOME_REGISTA);
    	    ArrayList <Persona> a = new ArrayList <Persona> ();
    	    
    	    do
    	    {
    	    	 String nome = InputDati.leggiStringaNonVuota(INS_NOME_ATTORE);
    	    	 String cognome = InputDati.leggiStringaNonVuota(INS_COGNOME_ATTORE);
     	
    	    	 a.add(new Persona(nome, cognome));
    	    	    
    	    	 if(InputDati.leggiUpperChar(INS_ALTRO_AUTORE, "SN") == 'N')
    	    	      end = true;
    	    	    
    	    }while(!end);
    	    
    	    int d = InputDati.leggiIntero(INS_DURATAMIN);
    	    int ap = InputDati.leggiIntero(INS_ANNOP, MIN_ANNOP, ANNO_CORRENTE);   
    	    String l = InputDati.leggiStringaNonVuota(INS_LINGUA);
    	    String g = InputDati.leggiStringaNonVuota(INS_GENERE);
    	    		
    	    Film f = new Film(t, nl, g, ap, l, new Persona(nomeRegista, cognomeRegista), a, d);
    	    
    	    return f;
    }
	
}
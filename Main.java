package interazione.parte2.punto5;

public class Main 
{	
	public static void main(String[] args) 
	{
        //LoadClass.getinstance().inizializza();
		
		RaccoltaDati rd = LoadClass.getinstance().getRaccoltaDati();
	
		//Applicazione dei pattern di Refactoring 'Preserve Whole Object' e
		//'Introduce Parameter Object': al costruttore dei due process viene passato
		//l'intero oggetto RaccoltaDati.
		ProcessOperatoreHandler processOperatore = new ProcessOperatoreHandler(rd);  
        ProcessFruitoreHandler processFruitore = new ProcessFruitoreHandler(rd);    
		
		//MenuHandler gestore = new MenuHandler();
		//gestore.logicaMenu(processOperatore,processFruitore);

		//LoadClass.getinstance().salva();
	}
}
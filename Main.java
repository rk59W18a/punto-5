package interazione.parte2.punto5;

public class Main 
{	
	public static void main(String[] args) 
	{
		LoadClass.getinstance().inizializza();
		
		RaccoltaDati rd = LoadClass.getinstance().getRaccoltaDati();
	
		ProcessOperatoreHandler processOperatore = new ProcessOperatoreHandler(rd);  
        ProcessFruitoreHandler processFruitore = new ProcessFruitoreHandler(rd);    
		
		MenuHandler gestore = new MenuHandler();
		gestore.logicaMenu(processOperatore,processFruitore);

		LoadClass.getinstance().salva(processOperatore);
	}
	
}
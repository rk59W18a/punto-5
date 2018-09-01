package utility.parte2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Data {

	//foreign method, should be in LocalDate
	public static boolean confrontaDate(LocalDate d1, LocalDate d2) {
		return d1.isEqual(d2);
	}
	
	//foreign method, should be in LocalDate
	public static boolean verificaDataSuccessiva(LocalDate d) {
		return LocalDate.now().isAfter(d);
	}
	
	//foreign method, should be in LocalDate
	public static boolean verificaDataPrecedente(LocalDate d) {
		return LocalDate.now().isBefore(d);
	}
	
	//foreign method, should be in LocalDate
	public static boolean verificaDataCoincidente(LocalDate d) {
		return LocalDate.now().equals(d);
	}
	
	//foreign method, should be in LocalDate
	public static LocalDate aumentaNumeroAnni(LocalDate d, int numeroAnni) {
		return d.plusYears(numeroAnni);
	}
	
	//foreign method, should be in LocalDate
	public static LocalDate aumentaNumeroGiorni(LocalDate d, int numeroGiorni) {
		return d.plusDays(numeroGiorni);
	}
	
	//foreign method, should be in LocalDate
	public static LocalDate diminuisciNumeroGiorni(LocalDate d, int numeroGiorni) {
		return d.minusDays(numeroGiorni);
	}
	
	//foreign method, should be in LocalDate
	public static LocalDate aumentaDataAttualeNumeroAnni(int numeroAnni) {
	    return LocalDate.now().plusYears(numeroAnni);
	}
		
	//foreign method, should be in LocalDate
    public static LocalDate aumentaDataAttualeNumeroGiorni(int numeroGiorni) {
		return LocalDate.now().plusDays(numeroGiorni);
    }
		
	//foreign method, should be in LocalDate
    public static LocalDate diminuisciDataAttualeNumeroGiorni(int numeroGiorni) {
		return LocalDate.now().minusDays(numeroGiorni);
    }
		
    //foreign method, should be in LocalDate
	public static LocalDate diminuisciDataAttualeNumeroAnni(int numeroAnni) {
		return LocalDate.now().minusYears(numeroAnni);
	}
	
	//foreign method, should be in LocalDate
	public static LocalDate getDataAttuale() {
		return LocalDate.now();
	}
	
	//foreign method, should be in LocalDate
	public static LocalDate getDataImpostata(int anno, int mese, int giorno) {
		return LocalDate.of(anno, mese, giorno);
	}
	
	//foreign method, should be in LocalDate
	public static int getNumeroAnniDataAttuale() {
		return LocalDate.now().getYear();
	}
	
	//foreign method, should be in LocalDate
	public static int getNumeroAnniData(LocalDate d) {
		return d.getYear();
	}
	
	//foreign method, should be in LocalDate
	public static String getDataFormattata(LocalDate d) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Costanti.FORMATO_DATA);
	    return d.format(formatter);
	}
}

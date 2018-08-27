package utility_2;

import java.time.LocalDate;

public class Data {

	public static boolean confrontaDate(LocalDate d1, LocalDate d2) {
		return d1.isEqual(d2);
	}
	
	public static boolean verificaDataSuccessiva(LocalDate d) {
		return LocalDate.now().isAfter(d);
	}
	
	public static boolean verificaDataPrecedente(LocalDate d) {
		return LocalDate.now().isBefore(d);
	}
	
	public static boolean verificaDataCoincidente(LocalDate d) {
		return LocalDate.now().equals(d);
	}
	
	public static LocalDate aumentaNumeroAnni(LocalDate d, int numeroAnni) {
		return d.plusYears(numeroAnni);
	}
	
	public static LocalDate aumentaNumeroGiorni(LocalDate d, int numeroGiorni) {
		return d.plusDays(numeroGiorni);
	}
	
	public static LocalDate diminuisciNumeroGiorni(LocalDate d, int numeroGiorni) {
		return d.minusDays(numeroGiorni);
	}
	
	public static LocalDate getDataAttuale() {
		return LocalDate.now();
	}
	
	public static int getNumeroAnniDataAttuale() {
		return LocalDate.now().getYear();
	}
	
}

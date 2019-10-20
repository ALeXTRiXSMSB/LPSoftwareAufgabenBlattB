package b9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Alexander Karg
 *
 */
public class Program {

	/**
	 * Programmstartpunkt
	 * @param args
	 */
	public static void main(String[] args) {
		boolean nochmalbool = true;
		while(nochmalbool){
			try {
				//einlesen der Datei und filtern der "unwichtigen" Informationen
				BufferedReader in = new BufferedReader(new FileReader("DWS-TOP-DIVIDENDE.csv"));
				int cnt = 0;
				while (in.readLine() != null && cnt < 7) {
					in.readLine();
					cnt++;
				}

				//auf ein Datumsformat einigen
				SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
				Date jahresende = null;
				Date jahresanfang = null;
				try {
					//eingabe der Datumsdaten
					System.out.println("Jahresanfang?");
					jahresanfang = sdf.parse(tastaturEinlesen());
					System.out.println("Jahresende?");
					jahresende = sdf.parse(tastaturEinlesen());
				} catch (ParseException e) {
					Program.main(null);
					//e.printStackTrace();
				}


				String eingabe;
				//variablen für die jahreswerte
				double first = 0;
				double last = 0;
				boolean firstcheck = false;
				boolean lastcheck = false;
				while ((eingabe = in.readLine()) != null) {
					//String Operationen um die werte sinnvoll zu spliten
					String[] zeilenArray = eingabe.split(";");

					//Datum aus dem Arrayholen
					Date d = null;
					try {
						d = sdf.parse(zeilenArray[0]);
					} catch (ParseException e) {
						e.printStackTrace();
						break;
					}

					//abfrage ob jahresende oder jahresanfang mit dem jahr im array übereinstimmt
					//zusätzlich eine kontrolle um zu überprüfen ob sich das Datum auch in der liste befunden hat
					if(jahresanfang.equals(d)) {
						first = Double.valueOf(zeilenArray[1].replace(",", "."));
						firstcheck = true;
					}
					if (jahresende.equals(d)) {
						last = Double.valueOf(zeilenArray[1].replace(",","."));
						lastcheck = true;
					}
				}


				//wenn beide fälle eintreffen werden die daten ausgewertet
				if(firstcheck && lastcheck){
					//letzte abfrage ob wert größer kleiner oder gleich wie vom jahresanfang war
					if(first > last){
						System.out.println("bear");
					}
					if(first < last){
						System.out.println("bull");
					}
					if(first == last){
						System.out.println("gleicher wert");
					}
				}
				//"fehler" korrektur
				if(!firstcheck){
					System.out.println("Startdatum nicht gefunden");
				}
				if(!lastcheck){
					System.out.println("Enddatum nicht gefunden");
				}

			} catch (FileNotFoundException e) {
				Program.main(null);
			} catch (IOException e) {
				Program.main(null);
			}
			//neustart des Programmes
			System.out.println("Nochmal? (j/n): ");
			String text = tastaturEinlesen();
			if(!(text.equals("j"))){
				nochmalbool = false;
			}
		}
	}

	/**
	 * methode zum tastatur einlesen
	 * @return
	 */
	public static String tastaturEinlesen(){
		Scanner tastatur = new Scanner(System.in);
		String eingabe = tastatur.nextLine();
		return eingabe;
	}
}


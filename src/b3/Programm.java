package b3;

import java.io.*;
import java.util.Scanner;

/**
 * @author Alexander Karg
 */
public class Programm {


    public static void main(String[] args0) throws IOException {
        Scanner tastatur = new Scanner(System.in);
        //Nach dateinamen fragen
        System.out.println("Bitte den Dateinamen eingeben:");
        String auswahl = tastatur.nextLine();
        File datei = new File(auswahl);
        //Abbruchbedingung wenn datei nicht existiert
        if(datei.exists()){
            FileReader fr = new FileReader(datei);
            int i = 0;
            while((i=fr.read()) != -1){
                //Ausgabe des Dateiinhalts
                System.out.print(encodeChar(i));
            }
        }else{
            System.out.println("Datei Existiert nicht");
        }
    }

    /**
     * Methode zum Konvertieren der Zeichen in Bytes
     * @param c
     * @return
     */
    public static int decodeChar(char c){
        return ((int) c);
    }

    /**
     * Methode zum Konvertieren der Bytes in Zeichen
     * @param i
     * @return
     */
    public static char encodeChar(int i){
        return ((char) i);
    }
}

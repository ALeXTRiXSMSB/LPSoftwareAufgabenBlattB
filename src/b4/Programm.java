package b4;

import java.io.*;
import java.util.Scanner;

/**
 * @author Alexander Karg
 */

public class Programm {


    public static void main(String[] args0) {
        Scanner tastatur = new Scanner(System.in);
        //Nach datei namen fragen
        System.out.println("Bitte den Dateinamen eingeben:");
        String auswahl = tastatur.nextLine();
        File datei = new File(auswahl);
        try{
            FileReader fr = new FileReader(datei);
            int i = 0;
            while((i=fr.read()) != -1){
                //Inhalt der Datei ausgeben
                System.out.print(encodeChar(i));
            }
            fr.close();
        }catch(IOException e){
            System.out.println("Datei existiert nicht");
            //e.printStackTrace();

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

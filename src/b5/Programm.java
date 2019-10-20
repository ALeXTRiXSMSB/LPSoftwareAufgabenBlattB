package b5;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Unbekannt da in aufgaben stellung
 */
public class Programm {

    /**
     * Programmstartpunkt
     * @param args
     */
    public static void main(String[] args) {

        try (BufferedWriter out = new BufferedWriter(new FileWriter("test.txt"))){
            out.write("Lorem ipsum dolor sit amet");
            //Es werden erst die daten in die Datei geschrieben,
            //wenn die Methode flush() ausgeführt wird
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
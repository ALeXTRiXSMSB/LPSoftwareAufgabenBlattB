package b6;

import java.io.*;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author Alexander Karg
 */
public class Programm {

    /**
     * Programmstartpunkt
     * @param args0
     */
    public static void main(String[] args0){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("aufgabe6.txt"));
            //Daten in das BufferedWriter Objekt schreiben (In das Attribut char[] writeBuffer)
            bw.write("Die Welt kostet 17 €\r\n");
            // System unabhängig: bw.append(System.lineSeparator());
            // ansonsten Windows:\r\n Linux:\n MacOs:\r
            //Schreiben der Daten in die daten mittels flush
            bw.flush();
            //Schließen des Streams
            bw.close();
            //Eingabestream erstellen
            InputStream is = new FileInputStream("aufgabe6.txt");
            int i = 0;
            //Byteweise einlesen der Datei
            while((i=is.read()) != -1){
                System.out.print(i + " ");
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

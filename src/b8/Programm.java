package b8;

import java.io.*;

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
            //UTF8
            //InputStream fr = new FileInputStream(new File("Hausaufgabe Encodings UTF-8.txt"));
            //UTF16 Jedes Zeichen erhält nun 2 Byte Daher kommen die führenden 0en zustande
            InputStream fr = new FileInputStream(new File("Hausaufgabe Encodings UTF-16.txt"));
            int i = 0;
            //lesen vom Filestream
            while((i=fr.read()) != -1){
                System.out.print(i + " ");
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


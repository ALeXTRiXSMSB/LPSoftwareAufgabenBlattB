package b10;

import java.util.Scanner;

public class Programm {

    /**
     * Klassenattribute
     */
    private static int gelesen = 0;
    private static int ausgegeben = 0;
    private static int wegkomprimiert = 0;
    private static int konvertiert = 0;

    /**
     * Programmstartpunkt
     * @param args0
     */
    public static void main(String[] args0){
        //Tastatur eingabe
        Scanner tastatur = new Scanner(System.in);
        String text;
        //Abbruch kriterium definiert
        boolean nochmal = true;
        while(nochmal){
            System.out.println("Bitte einen zu korrigierenden Text Eingeben");
            text = tastatur.nextLine();
            gelesen = lesen(text);
            text = wegkomprimiert(text);
            ausgegeben = lesen(text);
            text = großschreiben(text);
            System.out.println(text);
            System.out.println(gelesen + " gelesen, " + ausgegeben + " ausgegeben, " + wegkomprimiert + " wegkomprimiert, " + konvertiert + " konvertiert");
            System.out.println("Noch eine umwandlung? (j/n): ");
            //Abbruchkriterium wird angefragt
            text = tastatur.nextLine();
            //Abbruchkriterium wird geprüft
            if(!(text.equals("j"))){
                nochmal = false;
            }
            //Zurücksetzen der Klassenattribute auf die anfangswerte
            gelesen = 0;
            ausgegeben = 0;
            wegkomprimiert = 0;
            konvertiert = 0;
        }
    }

    /**
     * Rückgabe des Textlänge
     * @param eingabeText
     * @return
     */
    private static int lesen(String eingabeText){
        return (eingabeText.length());
    }

    /**
     * Methode komprimiert leerzeichen und Tabulatoren die hintereinander stehen zu einem Leerzeichen oder Tabulator
     * @param eingabeText
     * @return
     */
    private static String wegkomprimiert(String eingabeText){
        StringBuilder sb = new StringBuilder(eingabeText);
        //Anfangsleerzeichen wegkomprimieren
        sb = anfangKomprimieren(sb);
        //Endleerzeichen Wegkomprimieren
        sb = anfangKomprimieren(sb.reverse());
        //leerzeichen Wegkomprimieren
        for(int i = 0; i < sb.length();i++){
            //Sobald zwichzen leerzeichen oder tabulatoren hintereinander auftreten wird eines davon wegkomprimiert
            if(Character.toString(sb.charAt(i)).equals(" ")|| Character.toString(sb.charAt(i)).equals("\t")){
                while (Character.toString(sb.charAt(i + 1)).equals(" ") || Character.toString(sb.charAt(i + 1)).equals("\t")) {
                    sb.deleteCharAt(i + 1);
                    wegkomprimiert++;
                }
            }
        }
        return sb.reverse().toString();
    }

    /**
     * privatemethode um am anfang leerezeichen zu eleminieren
     * @param sb
     * @return
     */
    private static StringBuilder anfangKomprimieren(StringBuilder sb) {
        boolean anfang = true;
        while(anfang){
            // \t = tabulatorzeichen
            //wenn das leerzeichen oder die tabulatortaste auftritt wird diese vom anfang weggenommen sonst brichte die schleife ab
            if(Character.toString(sb.charAt(0)).equals(" ") || Character.toString(sb.charAt(0)).equals("\t")){
                sb.deleteCharAt(0);
                wegkomprimiert++;
            }else{
                anfang = false;
            }
        }
        return sb;
    }

    /**
     * Methode Konvertiert den ersten Buchstaben sowie nach bestimmten Satzzeichen den nächsten buchstaben in einen
     * Großbuchstaben wenn zahlen kommen wird der nächste buchstabe auch konvertiert
     * @param eingabetext
     * @return
     */
    private static String großschreiben(String eingabetext){
        StringBuilder sb = new StringBuilder(eingabetext);
        //Abfrage ob satzanfang großgeschrieben ist + hochzählen von konvertiert
        if(Character.isLowerCase(sb.charAt(0))){
            sb.replace(0,1,String.valueOf(Character.toUpperCase(sb.charAt(0))));
            konvertiert++;
        }
        //Schleife zum absuchen nach Satzzeichen in der Zeichenkette
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '.' || sb.charAt(i) == '?' || sb.charAt(i) == '!' || sb.charAt(i) == ':' ||sb.charAt(i) == ';'){
                int j = i;
                //SChleife zum finden des nächsten Buchstaben nach einem Satzzeichen
                while(j < sb.length()){
                    if(Character.isAlphabetic(sb.charAt(j))){
                        //Konvertierung des Buchstaben und hochzählen von konvertiert
                        if(Character.isLowerCase(sb.charAt(j))){
                            sb.replace(j,j+1,String.valueOf(Character.toUpperCase(sb.charAt(j))));
                            konvertiert++;
                        }
                        //Abbruchkriterium der Schleife wird erfüllt
                        j = sb.length();
                    }
                    j++;
                }
            }
        }
        return sb.toString();
    }
}

package b1;

import b9.Program;

public class Programm {

    /**
     * Beispiel 1
     *
     * Einfache Ausgabe der z.b. Monatsnamen oder Wochentags namen
    public enum Monate{
        januar,februar,maerz,
        april,mai,juni,
        juli,august,september,
        oktober,november,dezember;
    }

    public static void main(String[] args){
        for(Monate m : Monate.values()){
            System.out.println(m);
        }
    }
    **/

    /**
     * Beispiel 2
     * Verwendung von Logischen ausdrücken
    public enum Geschlecht{
        maennlich,weiblich,divers
    }

    public static void main(String[] args){
        Geschlecht g = Geschlecht.weiblich;
        switch(g){
            case maennlich:{

                break;
            }
            case weiblich:{

                break;
            }
            case divers:{

                break;
            }
        }
    }
     **/

    /**
     * Beispiel 3
     * Suchen von Konstanten im Enum
     *
     *
    public enum Vornamen{
        Alexander,
        Moritz,
        Stephan,
        Jan,
        Nina;
    }

    public static void main(String args0[]){
        System.out.println(Enum.valueOf(Vornamen.class,"Jan")); // Schlägt nicht fehl weil die Konstante im Enum vorhanden
        System.out.println(Enum.valueOf(Vornamen.class,"Test")); // Schlägt fehl weil Test keine Konstante
    }
**/

}

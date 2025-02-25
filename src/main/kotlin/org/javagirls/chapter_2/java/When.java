package org.javagirls.chapter_2.java;


import static org.javagirls.chapter_2.java.EnumColor.BLUE;
import static org.javagirls.chapter_2.java.EnumColor.VIOLET;

public class When {

    private static String getMnemonic(EnumColor color) {
        String word = "";

        switch (color) {
            case RED:
                word = "Richard";
                break;
            case ORANGE:
                word = "Of";
                break;
            case YELLOW:
                word = "York";
                break;
            case GREEN:
                word = "Gave";
                break;
            case BLUE:
                word = "Battle";
                break;
            case INDIGO:
                word = "In";
                break;
            case VIOLET:
                word = "Vain";
                break;
        }
        return word;
    }


    private static String getMnemonicBetter(EnumColor color) {
        String word = "";
        switch (color) {
            case RED -> word = "Richard";
            case ORANGE -> word = "Of";
            case YELLOW -> word = "York";
            case GREEN -> word = "Gave";
            case BLUE -> word = "Battle";
            case INDIGO -> word = "In";
            case VIOLET -> word = "Vain";
        }

        return word;
    }

    public static void main(String[] args) {
        System.out.println(getMnemonic(BLUE));
        System.out.println(getMnemonic(VIOLET));
    }
}

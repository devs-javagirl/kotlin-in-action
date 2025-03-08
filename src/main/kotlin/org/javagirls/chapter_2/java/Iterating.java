package org.javagirls.chapter_2.java;

import java.util.HashMap;
import java.util.Map;


public class Iterating {
    private static void mapOfChars() {
        Map<Character, String> binaryReps = new HashMap();

        for (char outerChar = 'A'; outerChar <= 'F'; outerChar++) {
            String binary = Integer.toBinaryString(outerChar);
            binaryReps.put(outerChar, binary);
        }

        for(Map.Entry<Character, String> entry: binaryReps.entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }

    public static void main(String[] args) {
        mapOfChars();
    }
}

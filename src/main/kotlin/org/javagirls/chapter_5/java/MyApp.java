package org.javagirls.chapter_5.java;

import kotlin.Unit;
import org.javagirls.chapter_5._5_3_FunctionalTypeKt;

public class MyApp {
    public static void main(String[] args) {
        // utilizando functional interface
        _5_3_FunctionalTypeKt.consumeHello(s -> System.out.println(s.toUpperCase()));
        // utilizando functional type, precisa fazer return Unit, que é o mesmo que void
        _5_3_FunctionalTypeKt.consumeHelloFunctional(s -> {
            System.out.println(s.toUpperCase());
            return Unit.INSTANCE;
        });
    }
}

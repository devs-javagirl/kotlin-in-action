package org.javagirls.chapter_2.java.cast;

public class Expression {
    public int eval(Expr expr) {
        if (expr instanceof Num) {
            return ((Num)expr).value;
        } else if (expr instanceof Sum) {
            return eval(((Sum) expr).left) + eval(((Sum) expr).right);
        } else {
            throw new IllegalArgumentException("Unknown expression");
        }
    }

}

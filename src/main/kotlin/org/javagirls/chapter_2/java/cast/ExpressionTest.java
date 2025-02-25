package org.javagirls.chapter_2.java.cast;

public class ExpressionTest {
    public static void main(String[] args) {
        Expression expression = new Expression();
        System.out.println(expression.eval(
                new Sum(
                    new Sum(new Num(1), new Num(2)),
                    new Num(4)
                )
        ));
    }
}

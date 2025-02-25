package org.javagirls.chapter_2.java.cast;

public class Sum implements Expr {
    public Expr left;
    public Expr right;

    public Sum(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }

}

package org.javagirls.chapter_5.java;

public interface Computation {
    void postponeComputation(int delay, Runnable computation);
}

package Sequences;

import Core.NaturalNumber;

public abstract class Sequence<T> {
    public abstract T get(int i);

    public abstract NaturalNumber countOccurrences(T value);

    public abstract boolean contains(T value);
    
    public abstract T[] values();
    
    public int distinctValues(){
        return values().length;
    }
    
    public abstract String toString();
}

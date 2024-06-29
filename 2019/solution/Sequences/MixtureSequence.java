package Sequences;

import Core.NaturalNumber;

import java.util.Arrays;
import java.util.stream.Stream;

public class MixtureSequence<T> extends Sequence<T>{
    
    private final Sequence<T>[] sequences;
    
    public MixtureSequence(Sequence<T> sequence1, Sequence<T> sequence2){
        this.sequences = new Sequence[]{sequence1, sequence2};
    }
    
    @Override
    public T get(int i) {
       int index = i / 2;
       return sequences[i % 2].get(index);
    }

    @Override
    public NaturalNumber countOccurrences(T value) {
        return sequences[0].countOccurrences(value).add(sequences[1].countOccurrences(value));
    }

    @Override
    public boolean contains(T value) {
        return countOccurrences(value).isMoreThan(0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] values() {
        T[] values1 = sequences[0].values();
        T[] values2 = sequences[1].values();
        return (T[]) Stream.concat(Arrays.stream(values1), Arrays.stream(values2))
                .distinct()
                .toArray();
    }

    @Override
    public String toString(){
        return "(" +
                sequences[0].toString() +
                " * " +
                sequences[1].toString() +
                ")";
    }
}

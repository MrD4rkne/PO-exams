package Collectors;

import Sequences.Sequence;

import java.util.ArrayList;
import java.util.List;

public abstract class Collector<T> {
    private final List<Sequence<T>> ownedSequences;

    public Collector(){
        this.ownedSequences = new ArrayList<>();
    }

    public abstract boolean doesSequenceSeemInteresting(Sequence<T> sequence);

    public void giveSequence(Sequence<T> sequence){
        if(!doesSequenceSeemInteresting(sequence))
            throw new IllegalArgumentException("Sequence is not interesting for collector");
        ownedSequences.add(sequence);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Sequence<T> sequence : ownedSequences){
            sb.append(sequence);
            sb.append("\n");
        }
        return sb.toString();
    }
}

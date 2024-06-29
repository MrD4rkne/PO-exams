package Sequences;

import Core.NaturalNumber;

import java.util.Arrays;

public class CyclicSequence<T> extends Sequence<T>{
    protected final T[] cycle;

    public CyclicSequence(T[] cycle) {
        if(cycle.length==0)
            throw new IllegalArgumentException("Cycle cannot be empty");
        this.cycle = Arrays.copyOf(cycle, cycle.length);
    }

    @Override
    public T get(int index) {
        if(index<0)
            throw new IllegalStateException("Index must be a natural number");
        return cycle[index % cycle.length];
    }

    @Override
    public NaturalNumber countOccurrences(T value) {
        if(isInCycle(value))
            return NaturalNumber.infinite();
        return NaturalNumber.valueOf(0);
    }

    @Override
    public boolean contains(T value) {
        return Arrays.stream(cycle).anyMatch(val->val==value);
    }

    @Override
    public T[] values() {
        return Arrays.copyOf(cycle,cycle.length);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        for(int i=0; i<cycle.length; i++){
            sb.append(cycle[i]);
            if(i<cycle.length-1)
                sb.append(", ");
        }
        
        sb.append("]");
        return sb.toString();
    }

    protected boolean isInCycle(T value){
        for(T val : cycle){
            if(val == value)
                return true;
        }
        return false;
    }
}

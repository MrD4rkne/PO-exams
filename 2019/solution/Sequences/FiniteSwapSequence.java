package Sequences;

import Core.NaturalNumber;
import Core.Swap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FiniteSwapSequence<T> extends Sequence<T>{
    protected final Sequence<T> originalSequence;

    protected final List<Swap<T>> swaps;

    public FiniteSwapSequence(Sequence<T> originalSequence, List<Swap<T>> swaps) {
        super();
        this.originalSequence=originalSequence;
        this.swaps = new ArrayList<>();

        for(Swap<T> swap : swaps){
            if(swap.index() < 0)
                throw new IllegalArgumentException();
            if(originalSequence.get(swap.index()) == swap.value())
                continue;
            this.swaps.add(swap);
        }
    }

    @Override
    public T get(int i) {
        if(i<0)
            throw new IllegalStateException("Index must be a natural number");

        Optional<Swap<T>> possibleSwap = swaps.stream().filter(x->x.index()==i).findFirst();
        if(possibleSwap.isEmpty())
            return originalSequence.get(i);
        return possibleSwap.get().value();
    }

    @Override
    public NaturalNumber countOccurrences(T value) {
        NaturalNumber count = originalSequence.countOccurrences(value);
        if(count.isInfinite())
            return count;

        for(Swap<T> swap : swaps){
            if(originalSequence.get(swap.index()) == value){
                if(swap.value()!=value)
                    count.decrement();
            }
            else{
                if(swap.value()==value)
                    count.increment();
            }
        }
        return count;
    }

    @Override
    public boolean contains(T value) {
        NaturalNumber occurrencesCount = countOccurrences(value);
        return occurrencesCount.compareTo(0) > 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] values() {
        List<T> distinctValues = new ArrayList<>();
        for(T value : originalSequence.values()){
            if(countOccurrences(value).isMoreThan(0))
                distinctValues.add(value);
        }
        
        for(Swap<T> swap : swaps){
            if(!distinctValues.contains(swap.value()))
                distinctValues.add(swap.value());
        }

        return (T[]) distinctValues.toArray();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(originalSequence.toString());
        sb.append("{");
        
        for(int i=0; i<swaps.size(); i++){
            Swap<T> swap = swaps.get(i);
            sb.append(swap.index());
            sb.append("->");
            sb.append(swap.value());
            if(i<swaps.size()-1)
                sb.append(", ");
        }
        
        sb.append("}");
        return sb.toString();
    }
}

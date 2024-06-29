package Collectors;

import Sequences.Sequence;

public class CountingCollector<T> extends Collector<T> {
    private final int count;

    public CountingCollector(int distinctValuesCount){
        this.count=distinctValuesCount;
    }

    @Override
    public boolean doesSequenceSeemInteresting(Sequence<T> sequence) {
        return sequence.distinctValues() >= count;
    }
    
    @Override
    public String toString(){
        return "Counting collector: " + count + "\n" + super.toString();
    }
}

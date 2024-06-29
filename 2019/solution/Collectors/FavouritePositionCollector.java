package Collectors;

import Sequences.Sequence;

public class FavouritePositionCollector<T> extends Collector<T>{
    private final int favouritePosition;

    private final T value;

    public FavouritePositionCollector(int index, T value) {
        if(index<0)
            throw new IllegalArgumentException();
        this.favouritePosition = index;
        this.value = value;
    }

    @Override
    public boolean doesSequenceSeemInteresting(Sequence<T> sequence) {
        return sequence.get(favouritePosition) == value;
    }

    @Override
    public String toString(){
        return "Favourite position collector: " + favouritePosition + " value: " + value + "\n" + super.toString();
    }
}

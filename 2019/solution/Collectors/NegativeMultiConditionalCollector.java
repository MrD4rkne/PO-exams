package Collectors;

import Sequences.Sequence;

import java.util.List;

public class NegativeMultiConditionalCollector<T> extends MultiConditionsCollector<T> {
    public NegativeMultiConditionalCollector(List<Condition<T>> conditions) {
        super(conditions);
    }

    @Override
    protected boolean doSatisfyCondition(Sequence<T> sequence, Condition<T> condition) {
        return !sequence.contains(condition.value());
    }

    @Override
    public String toString(){
        return "Negative multi conditional collector: " + super.toString();
    }
}

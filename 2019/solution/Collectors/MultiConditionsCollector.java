package Collectors;

import Sequences.Sequence;

import java.util.List;

public abstract class MultiConditionsCollector<T> extends Collector<T>{
    protected final List<Condition<T>> conditions;

    protected MultiConditionsCollector(List<Condition<T>> conditions) {
        this.conditions = conditions;
    }
    
    protected abstract boolean doSatisfyCondition(Sequence<T> sequence,Condition<T> condition);
    
    public boolean doesSequenceSeemInteresting(Sequence<T> sequence) {
        return conditions.stream()
                .filter(condition -> sequence.get(0) == condition.value())
                .allMatch(condition -> doSatisfyCondition(sequence, condition));
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Condition<T> condition : conditions){
            sb.append(condition);
            sb.append(" ");
        }
        
        sb.append("\n");
        sb.append(super.toString());
        return sb.toString();
    }
}

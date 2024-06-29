package Sequences;

public class ExponentialCyclicSequence<T> extends CyclicSequence<T> {
    public ExponentialCyclicSequence(T[] cycle) {
        super(cycle);
    }

    @Override
    public T get(int index){
        if(index<0)
            throw new IllegalStateException("index must be a natural number");
        int i = 0;
        int curr = 1;
        while(index >= curr){
            index-=curr;
            curr*=2;
            i++;
        }

        return super.get(i);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("^[");

        for(int i=0; i<cycle.length; i++){
            sb.append(cycle[i]);
            if(i<cycle.length-1)
                sb.append(", ");
        }

        sb.append("]");
        return sb.toString();
    }
}

package Core;

public class NaturalNumber implements Comparable<NaturalNumber>  {
    private static final int INFINITE=-1;

    private int n;

    public NaturalNumber(){
        this.n=-INFINITE;
    }

    public NaturalNumber(int n){
        if(n<0)
            throw new IllegalArgumentException("N must be a natural number");
        this.n=n;
    }

    public boolean isInfinite(){
        return this.n==INFINITE;
    }

    public int getValue(){
        if(isInfinite())
            throw new IllegalStateException("Value is not finite");
        return n;
    }

    public void decrement(){
        if(isInfinite())
            return;
        if(n==0)
            throw new IllegalStateException("Cannot decrement at 0");
        n--;
    }

    public void increment(){
        if(isInfinite())
            return;
        n++;
    }

    public static NaturalNumber valueOf(int n){
        return new NaturalNumber(n);
    }

    public static NaturalNumber infinite(){
        return new NaturalNumber();
    }

    @Override
    public int compareTo(NaturalNumber naturalNumber) {
        if(isInfinite()) {
            return naturalNumber.isInfinite() ? 0 : 1;
        }
        if(naturalNumber.isInfinite())
            return -1;
        return Integer.compare(n, naturalNumber.getValue());
    }
    
    public int compareTo(int value){
        if(value<0)
            return 1;
        return compareTo(NaturalNumber.valueOf(value));
    }
    
    public boolean isEqual(int value){
        return compareTo(value)==0;
    }

    public NaturalNumber add(NaturalNumber naturalNumber) {
        if(isInfinite() || naturalNumber.isInfinite())
            return NaturalNumber.infinite();
        return NaturalNumber.valueOf(n + naturalNumber.getValue());
    }
    
    public boolean isMoreThan(int value){
        return compareTo(value)>0;
    }
}

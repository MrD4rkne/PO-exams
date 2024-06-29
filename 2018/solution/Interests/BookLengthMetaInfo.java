package Interests;

public class BookLengthMetaInfo extends MetaInfo {
    private final int length;
    
    public BookLengthMetaInfo(int length) {
        this.length = length;
    }
    
    @Override
    public String toString() {
        return "Length: " + length + " words";
    }
}

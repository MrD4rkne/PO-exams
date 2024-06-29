package Interests;

public class WordOccurrencesCount extends MetaInfo {
    private final int count;
    
    private final String word;
    
    public WordOccurrencesCount(String word, int count) {
        this.word = word;
        this.count = count;
    }
    
    @Override
    public String toString() {
        return "Word: " + word + " occurs " + count + " times";
    }
}

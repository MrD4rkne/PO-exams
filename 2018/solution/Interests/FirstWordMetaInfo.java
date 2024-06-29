package Interests;

public class FirstWordMetaInfo extends MetaInfo {
    private final String word;
    
    public FirstWordMetaInfo(String word) {
        this.word = word;
    }
    
    @Override
    public String toString() {
        return "First word: " + word;
    }
}

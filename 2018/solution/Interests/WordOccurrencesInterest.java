package Interests;

import Core.Book;

import java.util.Arrays;

public class WordOccurrencesInterest extends Interest{
    private final String word;
    
    public WordOccurrencesInterest(String word) {
        this.word = word;
    }
    
    @Override
    public MetaInfo read(Book book) {
        int count = Arrays.stream(book.getWords()).filter(word::equals).toArray().length;
        return new WordOccurrencesCount(this.word, count);
    }
}

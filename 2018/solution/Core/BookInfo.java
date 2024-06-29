package Core;

import Interests.MetaInfo;

import java.util.Arrays;
import java.util.Optional;

public class BookInfo {
    private final Optional<String> title;
    
    private final Optional<String> author;
    
    private final Optional<Integer> releaseYear;
    
    private final MetaInfo[] metaInformation;
    
    public BookInfo(Optional<String> title, Optional<String> author, Optional<Integer> releaseYear, MetaInfo[] metaInformation) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.metaInformation = Arrays.copyOf(metaInformation, metaInformation.length);
    }
    
    public Optional<String> getTitle() {
        return title;
    }
    
    public Optional<String> getAuthor() {
        return author;
    }
    
    public Optional<Integer> getReleaseYear() {
        return releaseYear;
    }
    
    /**
     * Checks if the given book matches the info of this BookInfo. 
     * In other words, checks if the book has the same title and author as this BookInfo.
     * @param book The book to check.
     * @return True if the book matches the criteria, false otherwise.
     */
    public boolean doesMatch(Book book) {
        if(title.isEmpty() || author.isEmpty())
            return false;
        return title.get().equals(book.getTitle()) && author.get().equals(book.getAuthor());
    }
    
    public MetaInfo[] getMetaInformation() {
        return Arrays.copyOf(metaInformation, metaInformation.length);
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        builder.append("Title: ").append(title.orElse("?")).append("\n");
        builder.append("Author: ").append(author.orElse("?")).append("\n");
        builder.append("Release year: ").append(releaseYear.isEmpty() ? "?" : releaseYear.get()).append("\n");
        for(MetaInfo meta : metaInformation)
            builder.append(meta.toString()).append("\n");
        
        return builder.toString();
    }
}

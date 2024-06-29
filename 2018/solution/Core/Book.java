package Core;

public class Book {
    private static final String SPLIT_OPERATOR = " ";
    
    private final String title;
    
    private final String author;
    
    private final int releaseYear;
    
    private final String[] content;
    
    public Book(String title, String author, int releaseYear, String content) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        
        if(content.isEmpty())
            throw new IllegalArgumentException("Content cannot be empty");
        this.content = content.split(SPLIT_OPERATOR);
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getReleaseYear() {
        return releaseYear;
    }
    
    public String[] getWords() {
        return content;
    }
}

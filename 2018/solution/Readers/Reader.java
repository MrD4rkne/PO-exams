package Readers;

import Core.Book;
import Core.BookInfo;
import Interests.Interest;
import Interests.MetaInfo;

import java.util.*;

public abstract class Reader {
    private final String name;
    
    private final Interest[] interests;
    
    protected final List<BookInfo> readBooks;
    
    private final Random random;
    
    private Optional<Book> currentBook;
    
    public Reader(String name, Interest[] interests) {
        this.name = name;
        this.interests = Arrays.copyOf(interests, interests.length);
        this.readBooks = new ArrayList<>();
        this.random = new Random();
        currentBook = Optional.empty();
    }
    
    public String getName() {
        return name;
    }
    
    public void giveBook(Book book){
        if(hasBook())
            throw new IllegalStateException("The reader already has a book to read.");

        currentBook = Optional.of(book);
        
        if(hasAlreadyRead(book))
            return;
        rememberBook(book);
    }
    
    public Book returnBook(){
        if(!hasBook())
            throw new IllegalStateException("The reader does not have a book to give back.");
        
        Book bookToReturn = currentBook.get();
        currentBook = Optional.empty();
        return bookToReturn;
    }

    public boolean hasBook(){
        return currentBook.isPresent();
    }
    
    public abstract void talk();
    
    public boolean doesWantToGoHome()
    {
        return random.nextBoolean();
    }
    
    private void rememberBook(Book book){
        Optional<String> title = randomOptional(book.getTitle());
        Optional<String> author = randomOptional(book.getAuthor());
        Optional<Integer> releaseYear = randomOptional(book.getReleaseYear());
        MetaInfo[] metaInformation = new MetaInfo[interests.length];
        for(int i = 0; i < interests.length; i++)
            metaInformation[i] = interests[i].read(book);

        BookInfo bookInfo = new BookInfo(title, author, releaseYear, metaInformation);
        readBooks.add(bookInfo);
    }
    
    private boolean hasAlreadyRead(Book book){
        return readBooks.stream().anyMatch(bookInfo -> bookInfo.doesMatch(book));
    }
    
    private <T> Optional<T> randomOptional(T value){
        return random.nextBoolean() ? Optional.of(value) : Optional.empty();
    }
    
    @Override
    public String toString() {
        return "I am a reader named " + name + ".";
    }
}

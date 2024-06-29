package Core;

import Readers.Reader;

import java.util.Arrays;
import java.util.Queue;

public class Library {
    private final Book[] books;
    
    private final Queue<Book> bookQueue;
    
    private final int n;
    
    public Library(Book[] books, int n) {
        this.books = Arrays.copyOf(books, books.length);
        this.n = n;
        this.bookQueue = new java.util.LinkedList<>();
    }
    
    /* Issue: Task content does not specify how to handle if there are no books left. I assume that the library should continue to the next reader.
     If reader does not have a book, he cannot decide to go home.
    */
    public void runDay(Queue<Reader> readers){
        // Prepare books queue.
        bookQueue.clear();
        bookQueue.addAll(Arrays.asList(books));
        
        int lentBooksCount = 0;
        while(!bookQueue.isEmpty()){
            Reader reader = readers.poll();
            
            if(reader.hasBook()){
                // Give back book.
                Book book = reader.returnBook();
                bookQueue.add(book);
                if(reader.doesWantToGoHome())
                    continue;
            }
            
            if(lentBooksCount == n)
                // Limit of lent books reached.
                continue;
            readers.add(reader);
            
            // Give book.
            if(bookQueue.isEmpty())
                // No more books.
                continue;
            Book book = bookQueue.poll();
            reader.giveBook(book);
            lentBooksCount++;
        }
    }
}

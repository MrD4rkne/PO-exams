package Readers;

import Interests.Interest;

public class TitleReader extends Reader{
    public TitleReader(String name, Interest[] interests) {
        super(name, interests);
    }

    @Override
    public void talk() {
        if(readBooks.stream().noneMatch(bookInfo->bookInfo.getTitle().isPresent())) {
            System.out.println("I have not remembered any book titles yet.");
            return;
        }
        
        System.out.println("I have read (and remember titles) of these books:");
        readBooks.stream().filter(
                        bookInfo->bookInfo.getTitle().isPresent())
                .forEach(bookInfo -> System.out.println(bookInfo.getTitle()));
    }
}

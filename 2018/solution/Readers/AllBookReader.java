package Readers;

import Interests.Interest;

public class AllBookReader extends Reader{
    public AllBookReader(String name, Interest[] interests) {
        super(name, interests);
    }

    @Override
    public void talk() {
        if(readBooks.isEmpty())
            System.out.println("I have not read any books yet.");
        else{
            System.out.println("I have read the following books:");
            readBooks.forEach(System.out::println);
        }
    }
}

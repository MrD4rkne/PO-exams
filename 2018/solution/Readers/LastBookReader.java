package Readers;

import Interests.Interest;

public class LastBookReader extends Reader{
    
    public LastBookReader(String name, Interest[] interests) {
        super(name, interests);
    }

    @Override
    public void talk() {
        if(readBooks.isEmpty())
            System.out.println("I have not read any books yet.");
        else
            System.out.println("The last book I read was: " + readBooks.get(readBooks.size() - 1));
    }
}

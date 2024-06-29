package Interests;

import Core.Book;

public class BookLengthInterest extends Interest{
    @Override
    public MetaInfo read(Book book) {
        return new BookLengthMetaInfo(book.getWords().length);
    }
}

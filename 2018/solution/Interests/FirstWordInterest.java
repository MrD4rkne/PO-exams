package Interests;

import Core.Book;

public class FirstWordInterest extends Interest{
    @Override
    public MetaInfo read(Book book) {
        return new FirstWordMetaInfo(book.getWords()[0]);
    }
}

package book;

import book.model.Book;
import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;

import static book.BookGenerator.createBook;

public class Main {
    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new PersistenceModule("test"));
        BookDao bookDao = injector.getInstance(BookDao.class);

        int n = 300;
        for(int i=0;i<n;i++){
            Book book = createBook();
            bookDao.persist(book);
        }

        bookDao.findAll().stream().forEach(System.out::println);
    }
}

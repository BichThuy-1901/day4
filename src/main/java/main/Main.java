package main;

import configuration.JPAConfig;
import entity.Book2Entity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.BookRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");

    public static void main (String[] args){
//       createNewBook();
//       readBook();
//        readBook(1);
//        updateBook();
//      deleteBook();
//        List<Book2Entity> bookList = bookRepository.findByAuthorAndPrice("Bruno", 12.6);
//        if (bookList.size() !=0) {
//            System.out.println("Found " + bookList.size() + "book(s) of Bruno");
//            System.out.println("They are: ");
//            for (Book2Entity book: bookList) {
//                System.out.println(book.toString());
//            }
//        }

    }
    private static void createNewBook(){
        ArrayList<Book2Entity> listBook = new ArrayList<>();

        Book2Entity book2Entity = new Book2Entity();
        book2Entity.setName("Java A-Z");
        book2Entity.setAuthor("Roger");
        book2Entity.setCategory("IT books");
        book2Entity.setIsbn("IDIBF1219323");
        book2Entity.setNumberOfPage(234);
        book2Entity.setPrice(20.5);
        book2Entity.setPublishDate(LocalDate.parse("2016-08-25"));
        listBook.add(book2Entity);

        Book2Entity book2Entity2 = new Book2Entity();
        book2Entity2.setName("Linsux shell programming");
        book2Entity2.setAuthor("Bruno");
        book2Entity2.setCategory("IT books");
        book2Entity2.setIsbn("IDIBF1223323");
        book2Entity2.setNumberOfPage(135);
        book2Entity2.setPrice(12.6);
        book2Entity2.setPublishDate(LocalDate.parse("2016-08-25"));
        listBook.add(book2Entity2);

        Book2Entity book2Entity3 = new Book2Entity();
        book2Entity3.setName("Math basic level 1");
        book2Entity3.setAuthor("Tommy");
        book2Entity3.setCategory("Math books");
        book2Entity3.setIsbn("IDIBF1219323");
        book2Entity3.setNumberOfPage(65);
        book2Entity3.setPrice(20.9);
        book2Entity3.setPublishDate(LocalDate.parse("2016-08-25"));
        listBook.add(book2Entity3);

        ArrayList<Book2Entity> result = (ArrayList<Book2Entity>) bookRepository.saveAll(listBook);

        for (Book2Entity objBook: result) {
            System.out.println(objBook.toString());
        }
    }
    private static void  readBook() {
        ArrayList<Book2Entity> bookList = (ArrayList<Book2Entity>) bookRepository.findAll();
        System.out.println("Found" + bookList.size() + "book(s) in the table book");
        System.out.println("They are: ");
        for (Book2Entity book: bookList) {
            System.out.println(book.toString());
        }
    }
    private static void readBook(int bookID) {
        Book2Entity bookEntity = bookRepository.findById(bookID);
        if (bookEntity != null) {
            System.out.println("Found a book with book ID = " + bookID);
            System.out.println(bookEntity.toString());
        } else {
            System.out.println("Not found any book with book ID = "+bookID);
        }
    }
    private static void updateBook() {
        Book2Entity book2Entity = bookRepository.findById(1);
        System.out.println("Book data before updating");
        System.out.println(book2Entity.toString());


        book2Entity.setAuthor("Jame");
        book2Entity.setNumberOfPage(199);
        book2Entity.setPrice(201);

        bookRepository.save(book2Entity);


        System.out.println("Book data after updating");
        System.out.println(book2Entity.toString());
    }
    private static void deleteBook() {
        bookRepository.deleteById(13);
        Book2Entity book2Entity = bookRepository.findById(2);
        if (book2Entity != null) {
            bookRepository.delete(book2Entity);
        }
//           bookRepository.deleteAll();
    }

}

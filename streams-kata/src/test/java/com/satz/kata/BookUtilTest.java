package com.satz.kata;

import static com.satz.kata.BookUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.satz.kata.pojo.Book;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BookUtilTest {
    Book b1 = new Book("Java Complete Reference", "Herb Schildt", 499);
    Book b2 = new Book("Design Patterns", "Eric Gamma", 399);
    Book b3 = new Book("Effective Java", "Joshua Bloch", 299);

    Book b4 = new Book("Java Concurrency in Practice", "Joshua Bloch", 199);

    @Test
    public void mapping(){
       
        List<Book> books = List.of(b1, b2, b3);
        List<String> names = getAllBookNames(books);

        List<String> bookNames = List.of("Java Complete Reference", "Design Patterns", "Effective Java");
        Assertions.assertTrue(bookNames.stream().allMatch( s -> names.contains(s)));
    }

    @Test
    public void filter(){
        List<Book> books = List.of(b1, b2, b3);
        List<Book> costly = getAllBooksCostsMoreThan(books, 300);

        List<Book> expected = List.of(b1,b2);
        Assertions.assertTrue(expected.stream().allMatch(s -> costly.contains(s)));
    }

    @Test
    public void grouping(){
        List<Book> books = List.of(b1, b2, b3, b4);
        Map<String, List<Book>> authors =  getAllBooksMappedToAuthor(books);

        Map<String, List<Book>> expected = Map.of(
                         b1.getAuthor(), List.of(b1)
                        ,b2.getAuthor(), List.of(b2)
                        ,b3.getAuthor(), List.of(b3,b4));
        
        assertTrue(Maps.difference(expected, authors).areEqual());
    }

    @Test
    public void avg(){
        List<Book> books = List.of(b1, b2, b3, b4);
        int avgCost = getAvgCostOfBooks(books);
        assertEquals(avgCost, (b1.getPrice()+b2.getPrice()+b3.getPrice()+b4.getPrice())/4);
    }

}

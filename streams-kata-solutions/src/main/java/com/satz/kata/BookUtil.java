package com.satz.kata;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.satz.kata.pojo.Book;

public class BookUtil {
    public static List<String> getAllBookNames(List<Book> books){
        return books.stream()
            .map(Book::getName)
            .collect(Collectors.toList());
    }

    public static List<Book> getAllBooksCostsMoreThan(List<Book> books, int cost){
        return books.stream()
            .filter( book -> book.getPrice() > cost)
            .collect(Collectors.toList());
    }

    public static Map<String, List<Book>> getAllBooksMappedToAuthor(List<Book> books){

        return books.stream()
            .collect(Collectors.groupingBy(
                Book::getAuthor,
                Collectors.mapping(book -> book, Collectors.toList())
            ));
    }
}

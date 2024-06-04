package com.example.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        IBookRepository bookRepository = new BookRepository();
//        IBookRepository bookRepository = new FakeRepositoryForTest();
        bookService = new BookService(bookRepository);
    }

    @Test
    public void testGetBooksByAuthor() {
        List<Book> books = bookService.getBooksByAuthor("Kent Beck");
        assertEquals(1, books.size());
        assertEquals("Test Driven Development", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthor_NoBooksFound() {
        List<Book> books = bookService.getBooksByAuthor("Unknown Author");
        assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByTitle_MatchExactlyOneBook() {
        List<Book> books = bookService.getBooksByTitle("Clean Code");
        assertEquals(1, books.size());
        assertEquals("Robert C. Martin", books.get(0).getAuthor());
        assertEquals("Clean Code", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByTitle_MatchMultipleBooks() {
        List<Book> books = bookService.getBooksByTitle("Refactoring");
        assertEquals(1, books.size());
        assertEquals("Martin Fowler", books.get(0).getAuthor());
        assertEquals("Refactoring", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByTitle_NoMatch() {
        List<Book> books = bookService.getBooksByTitle("Unknown Title");
        assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_MatchExactlyOneBook() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("Martin Fowler", "Refactoring");
        assertEquals(1, books.size());
        assertEquals("Martin Fowler", books.get(0).getAuthor());
        assertEquals("Refactoring", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_MatchMultipleBooks() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("Kent Beck", "Test Driven Development");
        assertEquals(1, books.size());
        assertEquals("Kent Beck", books.get(0).getAuthor());
        assertEquals("Test Driven Development", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_NoMatch() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("Unknown Author", "Unknown Title");
        assertEquals(0, books.size());
    }
}
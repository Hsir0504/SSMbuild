package com.service;

import com.Mapper.BooksMapper;
import com.pojo.Books;

import java.util.List;

public class BookServiceImpl implements Bookservice{



    private BooksMapper booksMapper;

    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    public int addBook(Books book) {
        return booksMapper.addBook(book);
    }

    public int deleteBookById(int id) {
        return booksMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return booksMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return booksMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return booksMapper.queryAllBook();
    }
}


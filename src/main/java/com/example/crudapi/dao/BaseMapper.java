package com.example.crudapi.dao;

import java.io.Serializable;

public interface BaseMapper<T, ID extends Serializable> {

    int getBook(ID id);

    int getBooks();

    int addBook(T book);

    int updateBookInfo(T book);

    int deleteBook(ID id);
}

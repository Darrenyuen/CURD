package com.example.crudapi.service;

import java.io.Serializable;

public interface BaseService<T, ID extends Serializable> {

    int getBook(ID id);

    int getBooks();

    int addBook(T book);

    int updateBookInfo(T book);

    int deleteBook(ID id);

}

package com.example.crudapi.dao;

import com.example.crudapi.bean.BookBean;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper extends BaseMapper<BookBean, Integer>{
    @Override
    int addBook(BookBean book);

    @Override
    int getBook(Integer integer);

    @Override
    int getBooks();

    @Override
    int updateBookInfo(BookBean book);

    @Override
    int deleteBook(Integer integer);
}

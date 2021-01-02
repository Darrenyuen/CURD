package com.example.crudapi.service.impl;

import com.example.crudapi.bean.BookBean;
import com.example.crudapi.dao.BaseMapper;
import com.example.crudapi.dao.BookMapper;
import com.example.crudapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookServiceImpl extends AbstractService<BookBean, Integer> implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    @Override
    public void setBaseMapper(BaseMapper<BookBean, Integer> baseMapper) {
        super.setBaseMapper(bookMapper);
    }

    @Override
    public int addBook(BookBean book) {
        return super.addBook(book);
    }

    @Override
    public int getBook(Integer integer) {
        return super.getBook(integer);
    }

    @Override
    public int getBooks() {
        return super.getBooks();
    }

    @Override
    public int updateBookInfo(BookBean book) {
        return super.updateBookInfo(book);
    }

    @Override
    public int deleteBook(Integer integer) {
        return super.deleteBook(integer);
    }
}

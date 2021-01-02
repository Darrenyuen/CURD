package com.example.crudapi.service.impl;

import com.example.crudapi.dao.BaseMapper;
import com.example.crudapi.service.BaseService;

import java.io.Serializable;

public abstract class AbstractService<T, ID extends Serializable> implements BaseService<T, ID> {

    private BaseMapper<T, ID> baseMapper;

    public void setBaseMapper(BaseMapper<T, ID> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public int addBook(T book) {
        return baseMapper.addBook(book);
    }

    @Override
    public int getBook(ID id) {
        return baseMapper.getBook(id);
    }

    @Override
    public int getBooks() {
        return baseMapper.getBooks();
    }

    @Override
    public int updateBookInfo(T book) {
        return baseMapper.updateBookInfo(book);
    }

    @Override
    public int deleteBook(ID id) {
        return baseMapper.deleteBook(id);
    }
}

package com.example.crudapi.service;

import com.example.crudapi.bean.BookBean;

public interface BookService {
    BookBean findById(long id);
}

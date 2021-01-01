package com.example.crudapi.service;

import com.example.crudapi.bean.BookBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookServiceImpl implements BookService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public BookBean findById(long id) {
        return jdbcTemplate.queryForObject("select * from commodity where id=?", new Object[] {id}, new BeanPropertyRowMapper<>(BookBean.class));
    }
}

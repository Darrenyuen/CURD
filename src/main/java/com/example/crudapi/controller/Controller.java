package com.example.crudapi.controller;

import com.example.crudapi.bean.BaseBean;
import com.example.crudapi.bean.BookBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1")
public class Controller {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/getBook/{id}", method = RequestMethod.GET)
    public BookBean get(@PathVariable long id) {
        // TODO: 2020/1/22 要返回id
        String sql = "select * from commodity where id=" + id;
         return jdbcTemplate.query(sql, new ResultSetExtractor<BookBean>() {
            @Override
            public BookBean extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                BookBean bookBean = new BookBean();
                while (resultSet.next()) {
                    for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                        switch (resultSet.getMetaData().getColumnName(i)) {
                            case "id": bookBean.setId((long) resultSet.getObject(i)); break;
                            case "name": bookBean.setName((String) resultSet.getObject(i)); break;
                            case "price": bookBean.setPrice((float) resultSet.getObject(i)); break;
                            case "description": bookBean.setDescription((String) resultSet.getObject(i)); break;
                        }
                    }
                }
                return bookBean;
            }
        });
    }

    @RequestMapping(value = "/getAllBooks", method = RequestMethod.GET)
    public List<BookBean> get() {
        String sql = "select * from commodity";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<BookBean>>() {
            @Override
            public List<BookBean> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<BookBean> books = new ArrayList<>();
                while (resultSet.next()) {
                    BookBean bookBean = new BookBean();
                    for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                        switch (resultSet.getMetaData().getColumnName(i)) {
                            case "id": bookBean.setId((long) resultSet.getObject(i)); break;
                            case "name": bookBean.setName((String) resultSet.getObject(i)); break;
                            case "price": bookBean.setPrice((float) resultSet.getObject(i)); break;
                            case "description": bookBean.setDescription((String) resultSet.getObject(i)); break;
                        }
                    }
                    books.add(bookBean);
                }
                return books;
            }
        });
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public BaseBean post(@RequestParam("name") String name, @RequestParam("price") String price, @RequestParam("description") String des) {
        String sql = "insert into commodity (name, price, description) values ('" + name + "','" + price + "','" + des + "')";
        jdbcTemplate.update(sql);
        BaseBean baseBean = new BaseBean();
        baseBean.setCode(0);
        baseBean.setMessage("success");
        return baseBean;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public BaseBean put(@RequestParam(value = "id", required = true) int id, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "price", required = false) String price, @RequestParam(value = "des", required = false) String des) {
        String sql = "update commodity set ";
        if (name != null) {
            sql += "name = '" + name + "' ";
        }
        if (price != null) {
            if (name != null) sql += ", ";
            sql += "price = '" + price + "' ";
        }
        if (des != null) {
            if (name != null || price != null) sql += ", ";
            sql += "description = '" + des + "' ";
        }
        sql += "where id = " + id;
        jdbcTemplate.update(sql);
        BaseBean baseBean = new BaseBean();
        baseBean.setCode(0);
        baseBean.setMessage("success");
        return baseBean;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public BaseBean delete(@RequestParam("id") int id) {
        String sql = "delete from commodity where id = " + id;
        jdbcTemplate.update(sql);
        BaseBean baseBean = new BaseBean();
        baseBean.setCode(0);
        baseBean.setMessage("success");
        return baseBean;
    }


}

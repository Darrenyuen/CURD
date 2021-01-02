package com.example.crudapi.controller;

import com.example.crudapi.bean.BookBean;
import com.example.crudapi.service.BookService;
import com.example.crudapi.service.impl.BookServiceImpl;
import com.example.crudapi.util.ResponseResult;
import com.example.crudapi.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/v2")
public class V2Controller {

    @Autowired
    private BookService bookService;

//    @RequestMapping(value = "getBook/{id}", method = RequestMethod.GET)
//    public BookBean get(@PathVariable long id) {
//
//    }

//    @RequestMapping(value = "/getAllBooks", method = RequestMethod.GET)
//    public List<BookBean> get() {
//
//    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public Map<String, Object> post(@RequestParam("name") String name, @RequestParam("price") float price, @RequestParam("description") String des) {
        BookBean bookBean = new BookBean(name, price, des);
        return bookService.addBook(bookBean) > 0 ? ResultUtil.success() : ResultUtil.error();
    }

//    @RequestMapping(value = "/update", method = RequestMethod.PUT)
//    public BaseBean put(@RequestParam(value = "id", required = true) int id, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "price", required = false) String price, @RequestParam(value = "des", required = false) String des) {
//
//    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@RequestParam("id") int id) {
        return bookService.deleteBook(id) > 0 ? ResultUtil.success() : ResultUtil.error();
    }
}

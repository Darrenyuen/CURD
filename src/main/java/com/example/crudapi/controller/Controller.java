package com.example.crudapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/v1")
public class Controller {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get() {
        // TODO: 2020/1/22 要返回id 
        return "GET";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String post(@RequestParam("name") String name, @RequestParam("price") String price, @RequestParam("des") String des) {
        String sql = "insert into commodity (id, name, price, description) values ('" + name + "','" + price + "','" + des + "')";
        jdbcTemplate.update(sql);
        return "POST";
    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public String put(@RequestParam(value = "id", required = true) int id, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "price", required = false) String price, @RequestParam(value = "des", required = false) String des) {
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
        return "PUT";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(@RequestParam("id") int id) {
        String sql = "delete from commodity where id = " + id;
        jdbcTemplate.update(sql);
        return "DELETE";
    }


}

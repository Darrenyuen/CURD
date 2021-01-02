package com.example.crudapi.util;

import java.util.Map;

public class ResultUtil {

    public static Map<String, Object> error() { return new ResponseResult().error(); }

    public static Map<String, Object> success() {
        return new ResponseResult().success();
    }

    public static Map<String, Object> error(String message) {
        return new ResponseResult().error(message);
    }

    public static Map<String, Object> success(String message) {
        return new ResponseResult().success(message);
    }

    public static Map<String, Object> successWitPath(String path) {
        return new ResponseResult().successWithPath(path);
    }

}

package com.springboot.common.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class R extends HashMap<String, Object> {
    public R() {
        put("code", 0);
        put("msg", "success");
        put("data", "");
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(10000, msg);
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.put("data", map);
        return r;
    }
    public static R ok(List list) {
        R r = new R();
        r.put("data", list);
        return r;
    }


    public static R ok() {
        return new R();
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }


}

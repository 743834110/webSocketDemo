package com.example.demo.bean;

import java.util.List;

public class Pager<T> {

    private T param;

    private List<T> result;

    private Integer start = 1;

    private Integer length = 10;

    public Integer getStart() {
        return (start - 1) * length;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}

package com.hellozjf.test.poi;

import java.util.Date;

public class Example {

    private String id;
    private String name;
    private Date date;
    private double value;
    private String combo;
    private String string;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public String getCombo() {
        return combo;
    }
    public void setCombo(String combo) {
        this.combo = combo;
    }
    public String getString() {
        return string;
    }
    public void setString(String string) {
        this.string = string;
    }
    @Override
    public String toString() {
        return "Example [id=" + id + ", name=" + name + ", date=" + date + ", value=" + value + ", combo=" + combo + ", string=" + string + "]";
    }
    
}

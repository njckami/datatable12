package com.example.datatable12;

import java.util.UUID;

public class MyObject {
    private UUID id;
    private String str;

    public MyObject(UUID id, String str) {
        this.id = id;
        this.str = str;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "id=" + id +
                ", str='" + str + '\'' +
                '}';
    }
}

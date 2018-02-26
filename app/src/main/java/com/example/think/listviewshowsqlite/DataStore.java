package com.example.think.listviewshowsqlite;

/**
 * Created by Think on 2017/12/3.
 */

public class DataStore {
    private String name;
    private String sex;
    private String phone;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String age) {
        this.sex = sex;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return name+","+sex+","+phone;
    }
    public DataStore(String name, String sex, String phone) {
        super();
        this.name = name;
        this.sex = sex;
        this.phone = phone;

    }
}


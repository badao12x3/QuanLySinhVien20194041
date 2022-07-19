package com.example.qunlsinhvin20194041;

public class Student {
    private int mssv;
    private String name;
    private String email;
    private String birthday;

    public Student(int mssv, String name, String email, String birthday) {
        this.mssv = mssv;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    public Student() {

    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getMssv() {
        return mssv;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthday() {
        return birthday;
    }
}

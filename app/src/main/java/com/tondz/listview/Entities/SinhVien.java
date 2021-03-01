package com.tondz.listview.Entities;

import java.io.Serializable;

public class SinhVien implements Serializable {
    String name,className,teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public SinhVien(String name, String className, String teacher) {
        this.name = name;
        this.className = className;
        this.teacher = teacher;
    }
}

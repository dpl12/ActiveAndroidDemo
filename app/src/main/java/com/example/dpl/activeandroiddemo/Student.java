package com.example.dpl.activeandroiddemo;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by dpl on 2017/10/2 0002.
 */
@Table(name = "Students")
public class Student extends Model{
    @Column(name = "Name")
    public String name;
    @Column(name = "Age")
    public Integer age;
}

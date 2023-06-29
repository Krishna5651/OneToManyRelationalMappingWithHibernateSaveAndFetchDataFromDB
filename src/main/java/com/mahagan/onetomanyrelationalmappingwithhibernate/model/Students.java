/**
 * Created By Krishna Shinde
 * Date : 29-06-2023
 * Time : 14:52
 * Project: OneToManyRelationalMappingWithHibernate
 **/

package com.mahagan.onetomanyrelationalmappingwithhibernate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stud")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String student_Name;
    private String student_Address;
    private String roll_No;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_Name() {
        return student_Name;
    }

    public void setStudent_Name(String student_Name) {
        this.student_Name = student_Name;
    }

    public String getStudent_Address() {
        return student_Address;
    }

    public void setStudent_Address(String student_Address) {
        this.student_Address = student_Address;
    }

    public String getRoll_No() {
        return roll_No;
    }

    public void setRoll_No(String roll_No) {
        this.roll_No = roll_No;
    }
}



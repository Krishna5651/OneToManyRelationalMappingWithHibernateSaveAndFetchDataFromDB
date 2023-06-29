/**
 * Created By Krishna Shinde
 * Date : 29-06-2023
 * Time : 14:52
 * Project: OneToManyRelationalMappingWithHibernate
 **/

package com.mahagan.onetomanyrelationalmappingwithhibernate.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "classroom")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String classroom_Floor;
    private String total_Count;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "class_No")
    @OrderColumn(name = "type")
    private List<Students> students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassroom_Floor() {
        return classroom_Floor;
    }

    public void setClassroom_Floor(String classroom_Floor) {
        this.classroom_Floor = classroom_Floor;
    }

    public String getTotal_Count() {
        return total_Count;
    }

    public void setTotal_Count(String total_Count) {
        this.total_Count = total_Count;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }
}



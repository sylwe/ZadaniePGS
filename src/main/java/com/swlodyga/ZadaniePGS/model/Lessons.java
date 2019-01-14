package com.swlodyga.ZadaniePGS.model;

import javax.persistence.*;

@Entity
@Table(name = "lessons")
public class Lessons {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String userPresence;

    @Column
    private String teacher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserPresence() {
        return userPresence;
    }

    public void setUserPresence(String userPresence) {
        this.userPresence = userPresence;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}

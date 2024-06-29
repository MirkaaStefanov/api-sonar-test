package com.example.spring.boot.API;

import jakarta.persistence.*;

@Entity
@Table(name = "libraries")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private int usersCount;

    public Library(){}

    public Library(Long id, String name, String location, int users) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.usersCount = users;
    }
    public Library(String name, String location, int users) {
        this.name = name;
        this.location = location;
        this.usersCount = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getUsers() {
        return usersCount;
    }

    public void setUsers(int usersCount) {
        this.usersCount = usersCount;
    }
}

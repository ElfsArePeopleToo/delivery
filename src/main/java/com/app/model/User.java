package com.app.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@EqualsAndHashCode
@Table(name = "USERS")
public class User {
    @Id
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ENABLED", nullable = false)
    private boolean enabled;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Authorities> authorities = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
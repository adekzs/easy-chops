package com.easychops.easychops.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_dt")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @NonNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NonNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NonNull
    @Column(name = "email", nullable = false)
    private String email;

    @NonNull
    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

    @NonNull
    @Column(name = "role", nullable = false)
    private String role;

    @NonNull
    @Column(name = "address",  nullable = false)
    private String address;

    @NonNull
    @Column(name = "image")
    private String imageUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Authority> authorities;

}

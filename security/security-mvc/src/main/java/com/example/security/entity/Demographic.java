package com.example.security.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_demographic_sec")
@EqualsAndHashCode(exclude = "user")
@ToString(exclude = "user")
public class Demographic {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "contact")
    private String contact;

    @ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;
}

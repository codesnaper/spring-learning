package com.example.security.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_role_sec")
@EqualsAndHashCode(exclude = {"users","role"})
@ToString(exclude = {"user","role"})
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne( fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "role_id")
    private Role role;
}

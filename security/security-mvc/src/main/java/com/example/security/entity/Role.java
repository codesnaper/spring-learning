package com.example.security.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "role_sec")
@EqualsAndHashCode(exclude = "userRole")
@ToString(exclude = "userRole")
public class Role implements GrantedAuthority, Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}

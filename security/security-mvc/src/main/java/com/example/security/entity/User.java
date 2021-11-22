package com.example.security.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "user_sec")
@EqualsAndHashCode(exclude = "userRoleList")
@ToString(exclude = "userRoleList")
public class User implements UserDetails {

    @Id
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "accountNonExpired")
    private boolean accountNonExpired;

    @Column(name = "accountNonLocked")
    private boolean accountNonLocked;

    @Column(name = "credentialsNonExpired")
    private boolean credentialsNonExpired;

    @Column(name = "enable")
    private boolean enabled;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<UserRole> userRoleList = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userRoleList.stream().map(userRole -> new SimpleGrantedAuthority(userRole.getRole().getName())).collect(Collectors.toList());
    }
}

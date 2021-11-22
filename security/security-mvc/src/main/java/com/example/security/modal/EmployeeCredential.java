package com.example.security.modal;

import lombok.*;

import java.util.List;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCredential {

    private String userName;

    private String password;

    private List<Role> role;
}

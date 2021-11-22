package com.example.security.modal;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends EmployeeCredential {

    private long id;

    private String name;

    private String contact;

    private String fname;

    private String lname;

}

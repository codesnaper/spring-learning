package com.example.security.mappper;

import com.example.security.config.Constant;
import com.example.security.entity.Demographic;
import com.example.security.entity.Role;
import com.example.security.entity.User;
import com.example.security.entity.UserRole;
import com.example.security.modal.Employee;
import lombok.extern.slf4j.Slf4j;

import javax.management.relation.RoleList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class EmployeeMapper {

    public static Employee getUserEmployee(Demographic demographic) {
        for (UserRole role : demographic.getUser().getUserRoleList()) {
            if (role.getRole().getAuthority().contains(Constant.USER_ROLE_PREFIX)) {
                return setEmployee(demographic);
            }
        }
        return null;
    }

    public static Employee setEmployee(Demographic demographic){
        Employee employee = new Employee();
        employee.setId(demographic.getId());
        employee.setContact(demographic.getContact());
        employee.setName(demographic.getFirstName().concat(" ").concat(demographic.getLastName()));
        employee.setFname(demographic.getFirstName());
        employee.setLname(demographic.getLastName());
        return employee;
    }

    public static Employee convertDemographicToEmployee(Demographic demographic){
        Employee employee = new Employee();
        employee.setId(demographic.getId());
        employee.setContact(demographic.getContact());
        employee.setName(demographic.getFirstName().concat(" ").concat(demographic.getLastName()));
        employee.setFname(demographic.getFirstName());
        employee.setLname(demographic.getLastName());
        return employee;
    }

    public static Employee addRole(Employee employee, Demographic demographic) {
        List<com.example.security.modal.Role> roles =
                demographic.getUser().getUserRoleList()
                        .stream()
                        .map(role -> com.example.security.modal.Role.getRole(role.getRole().getName()))
                        .collect(Collectors.toList());
        if(employee == null){
            employee = new Employee();
        }
        employee.setRole(roles);
        return employee;
    }

    public static Demographic getDemographic(Employee employee, List<Role> roles, Role emptyRole){
        Demographic demographic = new Demographic();
        User user = new User();
        user.setAccountNonExpired(Boolean.valueOf(true));
        user.setEnabled(Boolean.valueOf(true));
        user.setPassword(employee.getPassword());
        user.setCredentialsNonExpired(Boolean.valueOf(true));
        user.setUsername(employee.getUserName());
        user.setAccountNonLocked(Boolean.valueOf(true));
        demographic.setUser(user);
        List<UserRole> roleList = employee.getRole().
                stream().
                map(role -> {
                    Role role1 = EmployeeMapper.getRoleFromDb(roles,role,emptyRole);
                    UserRole userRole = new UserRole();
                    userRole.setUser(user);
                    userRole.setRole(role1);
                    return userRole;
                }).
                collect(Collectors.toList());
        user.setUserRoleList(roleList);
        demographic.setContact(employee.getContact());
        demographic.setFirstName(employee.getFname());
        demographic.setLastName(employee.getLname());
        return demographic;
    }

    private static Role getRoleFromDb(List<Role> roles , com.example.security.modal.Role role, Role emptyRole){
        return roles.
                stream().
                filter(role1 -> role1.getName().equals(role.getValue())).
                findFirst().
                orElse(emptyRole);
    }

    public static Demographic demographicUpdate(Demographic demographic, Employee employee){
        demographic.setLastName(employee.getLname());
        demographic.setFirstName(employee.getFname());
        demographic.setContact(employee.getContact());
        demographic.getUser().setUsername(employee.getUserName());
//        demographic.getUser().getRoles()
        return demographic;
    }
}

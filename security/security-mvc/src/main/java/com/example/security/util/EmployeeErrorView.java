package com.example.security.util;

import com.example.security.config.Constant;
import com.example.security.modal.Alert;
import com.example.security.modal.AlertCode;
import com.example.security.modal.Employee;
import com.example.security.service.IEmployeeService;
import org.springframework.web.servlet.ModelAndView;

public class EmployeeErrorView {

    public static ModelAndView errorEmpModalAndView(Employee employee, ModelAndView modelAndView, Throwable e) {
        modelAndView = new ModelAndView();
        modelAndView.addObject(employee);
        Alert alert = new Alert();
        alert.setMessage("Error while save employee. Error " + e.getLocalizedMessage());
        alert.setAlertCode(AlertCode.ALERTDANDER);
        modelAndView.addObject("alert", alert);
        modelAndView.setViewName(Constant.VIEW_EMPLOYEE);
        return modelAndView;
    }

    public static ModelAndView errorEmployeeList(IEmployeeService employeeService, ModelAndView modelAndView, long id){
        modelAndView = new ModelAndView();
        modelAndView.addObject(employeeService.userEmployees());
        Alert alert = new Alert();
        alert.setAlertCode(AlertCode.ALERTDANDER);
        alert.setMessage("Error :: No Employee found using employee id " + id);
        modelAndView.addObject("alert", alert);
        modelAndView.setViewName(Constant.VIEW_EMPLOYEE_LIST);
        return modelAndView;
    }
}

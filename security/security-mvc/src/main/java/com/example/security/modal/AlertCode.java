package com.example.security.modal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AlertCode {
    ALERTPRIMARY("alert-primary"),
    ALERTSUCCESS("alert-success"),
    ALERTDANDER("alert-danger"),
    ALERTWARNING("alert-warning");

    String value;
}

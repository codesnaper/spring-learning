package com.example.security.modal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class Alert {

    private String message;

    private AlertCode alertCode;
}

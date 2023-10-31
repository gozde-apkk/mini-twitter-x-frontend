package com.workintech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationMember {
    private String email;
    private String password;
    private String username;
    private Date birthOfDate;
}

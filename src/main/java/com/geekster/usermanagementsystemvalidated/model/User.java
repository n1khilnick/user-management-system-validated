package com.geekster.usermanagementsystemvalidated.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotBlank
    @NotEmpty
    @NotNull(message = "Id cannot be blank !")
    private String userID;


    @NotBlank(message = "username must not be blank")
    @NotNull(message = "username must not be null")
    @Size(min=5,message = "username must have at least 5 characters ")
    @Size(max=12, message = "username should not be greater than 12 characters")
    private String userName;

    @NotEmpty(message = "Date of birth cannot be empty")
    @Pattern(regexp = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$", message = "Date of Birth must be in format of 'yyyy-mm-dd' ")
    private String dob;

    @Email(message = "Please enter a valid e-mail address")
    private String emailID;

    @Size(min = 13,message = "Mobile Number must not be less than 10 digits")
    @Size(max = 13,message = "Mobile Number must not be greater than 10 digits")
    @Pattern(regexp = "^[+]{1}(?:[0-9\\-\\(\\)\\/\\.]\\s?){6,11}[0-9]{1}$",message = "Please Enter 10 Digit Mobile Number")
    private String phoneNum;

    @Pattern(regexp = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$", message = "Date of Birth must be in format of 'yyyy-mm-dd' ")
    private String date;

    @Pattern(regexp = "^((([0]?[1-9]|1[0-2])(:|\\.)[0-5][0-9]((:|\\.)[0-5][0-9])?( )?(AM|am|aM|Am|PM|pm|pM|Pm))|(([0]?[0-9]|1[0-9]|2[0-3])(:|\\.)[0-5][0-9]((:|\\.)[0-5][0-9])?))$",message = "Please insert the time in 12 Hour Format HH:MM A")
    private String time ;


}

package com.esther.facebookclone.dataTransferObj;

import lombok.Data;


@Data
public class UserDto {
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String password;
    private final String dateOfBirth;
    private final String gender;


}

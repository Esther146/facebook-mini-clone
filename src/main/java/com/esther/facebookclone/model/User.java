package com.esther.facebookclone.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String dateOfBirth;
    private String gender;
}

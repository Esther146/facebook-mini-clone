package com.esther.facebookclone.model;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ThePost {
    private int post_id;
    private  String post_content;
    private String firstname;
    private String lastname;
    private LocalDate time;
    private int likes;
}

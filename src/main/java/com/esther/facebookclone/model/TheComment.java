package com.esther.facebookclone.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class TheComment {
    private int comment_id;
    private int post_id;
    private String comment_content;
    private int like;
}

package com.my.maven.project.dto.requests;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddCommentRequests {
    private Integer id;
    private LocalDateTime timeCommented;
    private String commenter;
    private String comment;

}

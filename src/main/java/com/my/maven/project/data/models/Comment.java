package com.my.maven.project.data.models;

@EqualsAndHashCode(callSuper = true)
@Data
public class Comment extends Storable{
    private Integer id;
    private Integer postId;
    private String comment;
    private String commenter;
    private LocalDateTime time;

}

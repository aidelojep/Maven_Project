package com.my.maven.project.data.models;


@EqualsAndHashCode(callSuper = true)
@Data
public class Post extends Storable {
    private Integer id;
    private String title;
    private LocalDateTime time;
    private String body;
    private List<Comment> comments = new ArrayList<> ();

}

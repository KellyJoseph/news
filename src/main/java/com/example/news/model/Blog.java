package com.example.news.model;

import javax.persistence.*;
import javax.persistence.Column;
import java.util.Optional;


@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name="title", nullable = false)
    private String title;
    @Column(name="content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Blog() {  }

    public Blog(User user, String title, String content) {
        this.setUser(user);
        this.setTitle(title);
        this.setContent(content);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    @Override
//    public String toString() {
//        return "Blog{" +
//                "id=" + id +
//                ", title='" + title + ''' +
//        ", content='" + content + ''' +
//        '}';
//    }
}

package com.br.geek.theories.postsservice.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "posts")
public class PostModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    
    @Column(name = "title", nullable = false, length = 255)
    private String title;
    
    @Column(name = "body", nullable = false)
    private String body;
    
    @Column(name = "user_id", nullable = false, length = 255)
    private String user_id;
    
    @Column(name = "status", nullable = false, length = 255)
    private String status;
    
    @Column(name = "created_at", nullable = false)
    private Date created_at;
    
    @Column(name = "updated_at", nullable = false)
    private Date updated_at;

    public PostModel() { }

    public PostModel(String id, String title, String body, String user_id, String status, Date created_at, Date updated_at) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user_id = user_id;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }
    
}

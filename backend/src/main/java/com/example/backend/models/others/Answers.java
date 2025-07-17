package com.example.backend.models.others;

import com.example.backend.auth.Models.Usermodel;
import com.example.backend.models.universal.Timestamp;
import jakarta.persistence.*;
import jdk.jfr.DataAmount;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Answers extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body;
    private boolean isaccepted;
    private int votecount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usermodel_id")
    private Usermodel usermodel;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "comments")
    private List<Comments> comments = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "reactions")
    private List<Reactions> reactions = new ArrayList<>();

    public Answers(String body, boolean isaccepted, int votecount, Question question, Usermodel usermodel) {
        this.body = body;
        this.isaccepted = isaccepted;
        this.votecount = votecount;
        this.question = question;
        this.usermodel = usermodel;
    }

    public Answers() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isIsaccepted() {
        return isaccepted;
    }

    public void setIsaccepted(boolean isaccepted) {
        this.isaccepted = isaccepted;
    }

    public int getVotecount() {
        return votecount;
    }

    public void setVotecount(int votecount) {
        this.votecount = votecount;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Usermodel getUsermodel() {
        return usermodel;
    }

    public void setUsermodel(Usermodel usermodel) {
        this.usermodel = usermodel;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public List<Reactions> getReactions() {
        return reactions;
    }

    public void setReactions(List<Reactions> reactions) {
        this.reactions = reactions;
    }
}

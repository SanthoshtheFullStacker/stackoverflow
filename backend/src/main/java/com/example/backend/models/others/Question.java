package com.example.backend.models.others;

import com.example.backend.auth.Models.Usermodel;
import com.example.backend.models.universal.Timestamp;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Questions")
public class Question extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String body;
    private int viewcount;
    private int votecount;
    private boolean isacceptedanswered;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tags",joinColumns = @JoinColumn(name = "question_id"),inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tags> tags;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Usermodel user;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "answers")
    private List<Answers> answers = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "comments")
    private List<Comments> comments = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "reactions")
    private List<Reactions> reactions = new ArrayList<>();


    public Question(String title, String body, int viewcount, int votecount, boolean isacceptedanswered, Usermodel user) {
        this.title = title;
        this.body = body;
        this.viewcount = viewcount;
        this.votecount = votecount;
        this.isacceptedanswered = isacceptedanswered;
        this.user = user;
    }

    public Question() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getViewcount() {
        return viewcount;
    }

    public void setViewcount(int viewcount) {
        this.viewcount = viewcount;
    }

    public int getVotecount() {
        return votecount;
    }

    public void setVotecount(int votecount) {
        this.votecount = votecount;
    }

    public boolean isIsacceptedanswered() {
        return isacceptedanswered;
    }

    public void setIsacceptedanswered(boolean isacceptedanswered) {
        this.isacceptedanswered = isacceptedanswered;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public Usermodel getUser() {
        return user;
    }

    public void setUser(Usermodel user) {
        this.user = user;
    }

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
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

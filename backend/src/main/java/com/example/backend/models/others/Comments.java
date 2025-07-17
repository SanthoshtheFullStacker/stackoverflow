package com.example.backend.models.others;

import com.example.backend.auth.Models.Usermodel;
import com.example.backend.models.universal.Timestamp;
import jakarta.persistence.*;

@Entity
@Table
public class Comments extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String body;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Usermodel user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id")
    private Answers answers;

    public Comments(long id, String body, Usermodel user, Question question, Answers answers) {
        this.id = id;
        this.body = body;
        this.user = user;
        this.question = question;
        this.answers = answers;
    }

    public Comments() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Usermodel getUser() {
        return user;
    }

    public void setUser(Usermodel user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers answers) {
        this.answers = answers;
    }
}

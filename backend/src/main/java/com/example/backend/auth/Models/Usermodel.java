package com.example.backend.auth.Models;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table
public class Usermodel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String email;
    private String password;
    private String displayname;
    private String profileimageurl;
    private String bio;
    private Instant createdat;
    private Instant updatedat;

    public Usermodel(String username, String email, String password, String displayname, String profileimageurl, String bio) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.displayname = displayname;
        this.profileimageurl = profileimageurl;
        this.bio = bio;
        this.createdat = Instant.now();
        this.updatedat = Instant.now();
    }

    public Usermodel(long id, String username, String email, String password, String displayname, String profileimageurl, String bio) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.displayname = displayname;
        this.profileimageurl = profileimageurl;
        this.bio = bio;
        this.createdat = Instant.now();
        this.updatedat = Instant.now();
    }

    public Usermodel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getProfileimageurl() {
        return profileimageurl;
    }

    public void setProfileimageurl(String profileimageurl) {
        this.profileimageurl = profileimageurl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Instant getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Instant createdat) {
        this.createdat = createdat;
    }

    public Instant getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Instant updatedat) {
        this.updatedat = updatedat;
    }
}

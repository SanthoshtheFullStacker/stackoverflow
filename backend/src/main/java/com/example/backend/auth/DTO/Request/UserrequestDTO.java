package com.example.backend.auth.DTO.Request;

public class UserrequestDTO {
    private String username;
    private String email;
    private String password;
    private String displayname;
    private String profileimageurl;
    private String bio;

    public UserrequestDTO(String username, String email, String password, String displayname, String profileimageurl, String bio) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.displayname = displayname;
        this.profileimageurl = profileimageurl;
        this.bio = bio;
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
}

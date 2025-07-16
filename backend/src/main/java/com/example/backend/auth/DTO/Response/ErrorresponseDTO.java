package com.example.backend.auth.DTO.Response;

public class ErrorresponseDTO {
    private String message;
    private int status;

    public ErrorresponseDTO(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public static Object Errorconsole(int status,String message){
        ErrorresponseDTO errorresponseDTO = new ErrorresponseDTO(message,status);
        return errorresponseDTO;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

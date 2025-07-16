package com.example.backend.auth.DTO.Response;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.security.sasl.SaslClient;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessresponseDTO {
    private String message;
    private int status;
    private Object data;

    public SuccessresponseDTO(String message, int status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public static Object successconsole(Object data,int status,String message){
        SuccessresponseDTO successresponseDTO = new SuccessresponseDTO(message,status,data);
        return successresponseDTO;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

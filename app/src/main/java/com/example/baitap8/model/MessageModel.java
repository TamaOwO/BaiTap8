package com.example.baitap8.model;

import java.io.Serializable;
import java.util.List;

public class MessageModel implements Serializable {
    private Boolean success;
    private String message;
    private List<ImageSlider> result;

    public MessageModel(Boolean success, String message, List<ImageSlider> result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ImageSlider> getResult() {
        return result;
    }

    public void setResult(List<ImageSlider> result) {
        this.result = result;
    }
}

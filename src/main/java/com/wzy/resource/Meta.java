package com.wzy.resource;

/*
**  请求的元数据
 */
public class Meta {

    public boolean success;

    public String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Meta(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}

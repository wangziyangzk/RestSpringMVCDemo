package com.wzy.exception;

/*
**  自定义运行时异常
 */
public class TokenException extends RuntimeException{
    private String msg;

    public TokenException(String msg){
        super();
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

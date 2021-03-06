package com.wzy.resource;

public class Response {

    private static final String OK = "ok";
    private static final String ERROR = "error";

    private Meta meta;
    private Object data;

    public Response success(){
        this.meta = new Meta(true,OK);
        return this;
    }

    /*
    **  携带参数的success返回
     */
    public Response success(Object data){
        this.meta = new Meta(false,ERROR);
        return this;
    }

    /*
    **  失败的构造器
     */
    public Response failure(String message){
        this.meta = new Meta(false,message);
        return this;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

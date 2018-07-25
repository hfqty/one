package me.ning.pro.doubanbook.entity;

public class MsgResult<T> {
    private String msg = "操作成功！";
    private T data;
    private String code = "0";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public MsgResult() {
    }

    public MsgResult(String msg, String code) {
        this.msg = msg;
        this.data = data;
        this.code = code;
    }
}

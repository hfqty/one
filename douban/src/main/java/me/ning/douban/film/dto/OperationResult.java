package me.ning.douban.film.dto;

public class OperationResult<T> {
    private String msg = "操作成功";
    private int code = 0;
    private T data;

    public OperationResult(){

    }
    public OperationResult(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public OperationResult(T data){
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static OperationResult ok(){
        return new OperationResult<>();
    }
}

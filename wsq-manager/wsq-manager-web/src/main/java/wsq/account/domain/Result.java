package wsq.account.domain;

import com.alibaba.fastjson.annotation.JSONField;

public class Result<T> {
    private T data;
    private Integer resultCode;
    private String msg;

    public Result() {}

    public Result(T data, Integer resultCode, String msg) {
        this.data = data;
        this.resultCode = resultCode;
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @JSONField(name = "result_code")
    public Integer getResultCode() {
        return resultCode;
    }

    @JSONField(name = "result_code")
    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

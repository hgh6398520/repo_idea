package com.hgy.gobal;

/**
 * 响应报文实体类
 * @author hgy
 */
public class ResponseResult {
    /**是否请求成功*/
    private boolean success;
    /**状态码*/
    private Integer state;
    /**响应信息*/
    private String message;
    /**响应内容*/
    private Object content;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "success=" + success +
                ", state=" + state +
                ", message='" + message + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

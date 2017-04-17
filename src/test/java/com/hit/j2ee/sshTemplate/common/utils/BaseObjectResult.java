package com.hit.j2ee.sshTemplate.common.utils;

/**
 * Created by Du on 2016-12-29.
 */
public class BaseObjectResult<T> {
    private String message;
    private boolean isSuccess;
    private T data;

    public BaseObjectResult() {
    	
    }

    public BaseObjectResult(boolean isSuccess, String message, T data) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.data = data;
    }


    public BaseObjectResult(T data, String isSuccessMessage, String failedMessage) {
        if (data != null){
            this.isSuccess = true;
            this.message = isSuccessMessage;
        } else {
            this.isSuccess = false;
            this.message = failedMessage;
        }
        this.data = data;
    }

    public BaseObjectResult(T data) {
        if (data != null){
            this.isSuccess = true;
            this.message = "查询成功";
            this.data = data;
        } else {
            this.isSuccess = false;
            this.message = "查询失败";
            this.data = null;
        }
    }

    public BaseObjectResult(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public void construct(T data){
        if (data != null){
            this.isSuccess = true;
            this.message = "查询成功";
            this.data = data;
        } else {
            this.isSuccess = false;
            this.message = "查询失败";
            this.data = null;
        }
    }

    public void construct(T data,boolean isSuccess){
        if (isSuccess){
            this.isSuccess = isSuccess;
            this.message = "查询成功";
            this.data = data;
        } else {
            this.isSuccess = isSuccess;
            this.message = "查询失败";
            this.data = null;
        }
    }

    public void construct(T data, String isSuccessMessage, String failedMessage) {
        if (data != null){
            this.isSuccess = true;
            this.message = isSuccessMessage;
        } else {
            this.isSuccess = false;
            this.message = failedMessage;
        }
        this.data = data;
    }

    public void construct(T data,boolean isSuccess, String message){
        this.isSuccess = isSuccess;
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

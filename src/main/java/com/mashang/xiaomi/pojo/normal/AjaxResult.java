package com.mashang.xiaomi.pojo.normal;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AjaxResult<T>{
    /**
     * 状态码
     */
    @ApiModelProperty(value = "消息状态码")
    private Integer code;
    /**
     * 提示信息，如果有错误时，前端可以获取该字段进行提示
     */
    @ApiModelProperty(value = "消息内容")
    private String msg;
    /**
     * 查询到的结果数据，
     */
    @ApiModelProperty(value = "结果数据")
    private T data;


    public AjaxResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }



    public AjaxResult(Integer code,String msg,T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public AjaxResult(Integer code,T data) {
        this.code = code;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

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



}
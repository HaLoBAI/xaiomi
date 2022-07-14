package com.mashang.xiaomi.pojo.normal;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AjaxResultRow<T>{
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
    @ApiModelProperty(value = "列表数据")
    private T rows;
    @ApiModelProperty(value = "总记录数")
    private Long total;
    public AjaxResultRow(Integer code, String msg, T rows, Long total) {
        this.code = code;
        this.msg  =  msg;
        this.rows = rows;
        this.total = total;
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

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
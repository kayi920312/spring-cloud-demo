package com.example.demo.bean;

public class JsonResult {

	private boolean success;
	private Object data;
	private String msg;
	
	public JsonResult(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}
	
	public JsonResult(Object data) {
		this.success = true;
		this.data = data;
		this.msg = "调用成功！";
	}
	
	public JsonResult() {
		this.success = true;
		this.msg = "调用成功！";
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}

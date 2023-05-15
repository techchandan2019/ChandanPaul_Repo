package com.neosoft.msproj.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;


public class ErrorMessage {

	private String msg;
	private LocalDateTime ldt;
	private HttpStatus status;
	
	public ErrorMessage() {
		// TODO Auto-generated constructor stub
	}

	public ErrorMessage(String msg, LocalDateTime ldt, HttpStatus status) {
		super();
		this.msg = msg;
		this.ldt = ldt;
		this.status =status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LocalDateTime getLdt() {
		return ldt;
	}

	public void setLdt(LocalDateTime ldt) {
		this.ldt = ldt;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProductResException [msg=" + msg + ", ldt=" + ldt + ", status=" + status + "]";
	}
	
}

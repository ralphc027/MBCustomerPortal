package com.mb.application.bankservice.model;

import java.io.Serializable;

public class Response implements Serializable{

	private static final long serialVersionUID = 139239919204829458L;
	
	private Object payload;
	
	Response (){}

	public Response(Object payload) {
		super();
		this.payload = payload;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "Response [payload=" + payload + "]";
	}
	
	

}

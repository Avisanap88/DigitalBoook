package com.digitalbook.Payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Response {

	public Response(String message, boolean sucess) {
		// TODO Auto-generated constructor stub
		this.message=message;
		this.success=sucess;
	}
	private String message;
	private Boolean success;
	
	
}
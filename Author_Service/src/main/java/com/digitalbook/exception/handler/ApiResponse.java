package com.digitalbook.exception.handler;
public class ApiResponse {
	 private int statusCode;
	    private String message;
	 
	    public ApiResponse(String message)
	    {
	        super();
	        this.message = message;
	    }

		public ApiResponse(int statusCode, String message) {
			super();
			this.statusCode = statusCode;
			this.message = message;
		}

		public int getStatusCode() {
			return statusCode;
		}

		public void setStatusCode(int statusCode) {
			this.statusCode = statusCode;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}


}


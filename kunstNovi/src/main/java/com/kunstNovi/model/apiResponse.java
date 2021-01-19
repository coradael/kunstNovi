package com.kunstNovi.model;

public class apiResponse<T> {

    private int status;
    private String message;
    private Object result;
    private Boolean success;
 
  

    public apiResponse(Boolean success, String message ) {
		super();
		this.message = message;
		this.success = success;
	}

	public apiResponse(int status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
    
    
}

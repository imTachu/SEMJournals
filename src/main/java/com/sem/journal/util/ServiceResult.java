package com.sem.journal.util;

public class ServiceResult {

	private Object result;
	
	private int pageNumber;
	
	private long totalObjects;
	
	private String actionMessage;
	
	private String checkMessage;

    private Status status;

	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}

	/**
	 * @return the pageNumber
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * @return the totalObjects
	 */
	public long getTotalObjects() {
		return totalObjects;
	}

	/**
	 * @param totalObjects the totalObjects to set
	 */
	public void setTotalObjects(long totalObjects) {
		this.totalObjects = totalObjects;
	}

	/**
	 * @return the actionMessage
	 */
	public String getActionMessage() {
		return actionMessage;
	}

	/**
	 * @param actionMessage the actionMessage to set
	 */
	public void setActionMessage(String actionMessage) {
		this.actionMessage = actionMessage;
	}

	/**
	 * @return the checkMessage
	 */
	public String getCheckMessage() {
		return checkMessage;
	}

	/**
	 * @param checkMessage the checkMessage to set
	 */
	public void setCheckMessage(String checkMessage) {
		this.checkMessage = checkMessage;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

}
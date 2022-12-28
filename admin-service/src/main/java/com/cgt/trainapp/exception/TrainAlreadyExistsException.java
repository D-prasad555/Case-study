package com.cgt.trainapp.exception;
/**Custom exception class*/
@SuppressWarnings("serial")
public class TrainAlreadyExistsException extends Exception {

	/**
	 * @param message
	 */
	public TrainAlreadyExistsException(String message){
		super(message);
	}
}

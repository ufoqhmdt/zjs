package com.jung.exception;

public class SkeletonSystemException extends SkeletonException {

	private static final long serialVersionUID = 5530615548044589484L;

	public SkeletonSystemException() {
	}
	
	public SkeletonSystemException(String msg) {
		super(msg);
	}
	
	public SkeletonSystemException(Throwable e) {
		super(e);
	}
	
	public SkeletonSystemException(String msg, Throwable e) {
		super(msg, e);
	}
}

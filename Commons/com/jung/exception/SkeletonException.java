package com.jung.exception;

public class SkeletonException extends Exception {

	private static final long serialVersionUID = 5530615548044589484L;

	public SkeletonException() {
	}

	public SkeletonException(String msg) {
		super(msg);
	}

	public SkeletonException(Throwable e) {
		super(e);
	}

	public SkeletonException(String msg, Throwable e) {
		super(msg, e);
	}
}

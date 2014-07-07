package com.dooioo.mobile.push;

/**
 * øÕªß∂À“Ï≥£
 */
public class PushClientException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public PushClientException(String message)
	{
		super(message);
	}

	public PushClientException(String message, Throwable t)
	{
		super(message, t);
	}
}

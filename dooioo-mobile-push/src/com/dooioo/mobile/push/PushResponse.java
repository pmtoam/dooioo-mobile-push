package com.dooioo.mobile.push;

public class PushResponse<T>
{
	private T result;
	/**
	 * ���ֶε�ֵ��Webserver���ɣ����ظ��û���������׷���붨λ��
	 */
	private String requestId;

	public String getRequestId()
	{
		return this.requestId;
	}

	public T getResult()
	{
		return this.result;
	}

	public void setRequestId(String requestId)
	{
		this.requestId = requestId;
	}

	public void setResult(T result)
	{
		this.result = result;
	}

	@Override
	public String toString()
	{
		return "PushResponse [result=" + result + ", requestId=" + requestId
				+ "]";
	}
}

package com.dooioo.mobile.push;

public class PagableRequest extends BaiduPushRequest
{
	/**
	 * ��ѯ��ʼҳ�룬Ĭ��Ϊ0��
	 */
	private int start = DEFAULT_START;
	/**
	 * һ�β�ѯ������Ĭ��Ϊ10��
	 */
	private int limit = DEFAULT_LIMIT;

	public PagableRequest()
	{
	}

	public int getStart()
	{
		return start;
	}

	public void setStart(int start)
	{
		this.start = start;
	}

	public int getLimit()
	{
		return limit;
	}

	public void setLimit(int limit)
	{
		this.limit = limit;
	}
}

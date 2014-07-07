package com.dooioo.mobile.push;

public class FetchTagRequest extends PagableRequest
{
	/**
	 * ±êÇ©Ãû³Æ
	 */
	private String name;

	public FetchTagRequest()
	{
		super.methodName = Constants.fetch_tag;
		super.httpMethod = HttpMethodName.POST;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}

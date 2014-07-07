package com.dooioo.mobile.push;

public class IosCertRequest extends BaiduPushRequest
{
	private IosCert isoCert;

	public IosCertRequest()
	{
	}

	public IosCertRequest(IosCert IosCert)
	{
		super.setHttpMethod(HttpMethodName.POST);
		this.isoCert = IosCert;
	}

	public IosCert getIsoCert()
	{
		return isoCert;
	}

	public void setIsoCert(IosCert isoCert)
	{
		this.isoCert = isoCert;
	}
}

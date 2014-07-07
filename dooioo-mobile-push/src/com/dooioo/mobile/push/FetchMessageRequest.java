package com.dooioo.mobile.push;

public class FetchMessageRequest extends UserRelatedRequest
{
	public FetchMessageRequest(String userId)
	{
		super.setHttpMethod(HttpMethodName.POST);
		super.setMethodName(Constants.fetch_msg);
		super.setUserId(userId);
	}
}

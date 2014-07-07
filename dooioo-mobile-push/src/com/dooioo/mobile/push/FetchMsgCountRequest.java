package com.dooioo.mobile.push;

public class FetchMsgCountRequest extends UserRelatedRequest
{
	public FetchMsgCountRequest(String userId)
	{
		super.setHttpMethod(HttpMethodName.POST);
		super.setMethodName(Constants.fetch_msgcount);
		super.setUserId(userId);
	}
}

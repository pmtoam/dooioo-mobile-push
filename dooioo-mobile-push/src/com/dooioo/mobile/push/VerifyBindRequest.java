package com.dooioo.mobile.push;

public class VerifyBindRequest extends UserRelatedRequest
{
	public VerifyBindRequest(String userId)
	{
		super.setHttpMethod(HttpMethodName.POST);
		super.setMethodName(Constants.verify_bind);
		super.setUserId(userId);
	}
}
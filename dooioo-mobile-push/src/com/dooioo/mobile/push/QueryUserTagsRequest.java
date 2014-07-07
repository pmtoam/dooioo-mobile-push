package com.dooioo.mobile.push;

public class QueryUserTagsRequest extends UserRelatedRequest
{

	public QueryUserTagsRequest(String userId)
	{
		super.setHttpMethod(HttpMethodName.POST);
		super.setMethodName(Constants.query_user_tags);
		super.setUserId(userId);
	}
}

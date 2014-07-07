package com.dooioo.mobile.push;

public class QueryDeviceTypeRequest extends BaiduPushRequest
{
	public QueryDeviceTypeRequest(String channelId)
	{
		super.setHttpMethod(HttpMethodName.POST);
		super.setMethodName(Constants.query_device_type);

		super.setChannelId(channelId);
	}
}

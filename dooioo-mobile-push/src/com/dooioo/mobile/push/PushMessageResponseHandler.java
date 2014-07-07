package com.dooioo.mobile.push;

import com.alibaba.fastjson.JSONObject;

/**
 * 推送消息的处理类
 */
public class PushMessageResponseHandler extends HttpResponseHandler<Integer>
{
	@Override
	protected boolean hasResponseParams()
	{
		return true;
	}

	@Override
	public PushResponse<Integer> handleResponseParams(JSONObject paramsObj)
	{
		PushResponse<Integer> response = new PushResponse<Integer>();

		Integer pushCount = paramsObj.getInteger("success_amount");

		response.setResult(pushCount);

		return response;
	}
}

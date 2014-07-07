package com.dooioo.mobile.push;

import com.alibaba.fastjson.JSONObject;

/**
 * ������Ϣ�Ĵ�����
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

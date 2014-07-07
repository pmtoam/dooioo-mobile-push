package com.dooioo.mobile.push;

import com.alibaba.fastjson.JSONObject;

/**
 * ��ѯ������Ϣ�ĸ���������
 */
public class FetchMessageCountResponseHandler extends
		HttpResponseHandler<Integer>
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

		int msgCount = paramsObj.getIntValue("total_num");
		response.setResult(msgCount);

		return response;
	}
}

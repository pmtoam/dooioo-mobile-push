package com.dooioo.mobile.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * ɾ����Ϣ�Ĵ�����
 */
public class DeleteMessageHandler extends
		HttpResponseHandler<DeleteMessageResponseBean>
{
	@Override
	protected boolean hasResponseParams()
	{
		return true;
	}

	@Override
	public PushResponse<DeleteMessageResponseBean> handleResponseParams(
			JSONObject paramsObj)
	{
		PushResponse<DeleteMessageResponseBean> response = new PushResponse<DeleteMessageResponseBean>();

		DeleteMessageResponseBean responseBean = new DeleteMessageResponseBean();

		int msgCount = paramsObj.getIntValue("success_amount");
		responseBean.setSuccessCount(msgCount);

		JSONArray detailsArray = paramsObj.getJSONArray("details");
		if (detailsArray.isEmpty())
		{
			responseBean.setStatusList(Collections
					.<MessageOperationDetail> emptyList());
			response.setResult(responseBean);
			return response;
		}

		List<MessageOperationDetail> details = new ArrayList<MessageOperationDetail>();
		Iterator<Object> iter = detailsArray.iterator();
		while (iter.hasNext())
		{
			JSONObject obj = (JSONObject) iter.next();

			MessageOperationDetail detail = new MessageOperationDetail();

			detail.setMessageId(obj.getString("msg_id"));
			detail.setStatus(OperationStatus.values()[obj.getIntValue("result")]);

			details.add(detail);
		}
		responseBean.setStatusList(details);
		response.setResult(responseBean);

		return response;
	}
}

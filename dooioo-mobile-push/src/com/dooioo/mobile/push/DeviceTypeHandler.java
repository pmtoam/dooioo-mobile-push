package com.dooioo.mobile.push;

import com.alibaba.fastjson.JSONObject;

/**
 * ����channel_id��ѯ�豸���͵Ĵ�����
 */
public class DeviceTypeHandler extends HttpResponseHandler<DeviceType>
{
	@Override
	protected boolean hasResponseParams()
	{
		return true;
	}

	@Override
	public PushResponse<DeviceType> handleResponseParams(JSONObject paramsObj)
	{
		PushResponse<DeviceType> response = new PushResponse<DeviceType>();

		int deviceType = paramsObj.getIntValue("device_type");
		response.setResult(DeviceType.valueOf(deviceType));

		return response;
	}
}

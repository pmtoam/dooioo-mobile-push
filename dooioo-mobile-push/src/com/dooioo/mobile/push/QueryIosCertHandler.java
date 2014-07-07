package com.dooioo.mobile.push;

import com.alibaba.fastjson.JSONObject;

/**
 * ��ѯ��App server��Ӧ��iOS֤��Ĵ�����
 */
public class QueryIosCertHandler extends HttpResponseHandler<IosCert>
{
	@Override
	protected boolean hasResponseParams()
	{
		return true;
	}

	@Override
	public PushResponse<IosCert> handleResponseParams(JSONObject paramsObj)
	{
		PushResponse<IosCert> response = new PushResponse<IosCert>();

		IosCert iosCert = new IosCert();
		iosCert.setName(paramsObj.getString("name"));
		iosCert.setDescription(paramsObj.getString("description"));
		iosCert.setReleaseCert(paramsObj.getString("release_cert"));
		iosCert.setDevCert(paramsObj.getString("dev_cert"));

		response.setResult(iosCert);

		return response;
	}
}

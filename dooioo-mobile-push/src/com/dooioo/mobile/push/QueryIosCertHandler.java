package com.dooioo.mobile.push;

import com.alibaba.fastjson.JSONObject;

/**
 * 查询与App server对应的iOS证书的处理类
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

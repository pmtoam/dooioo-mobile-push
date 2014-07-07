package com.dooioo.mobile.push;

import java.util.Map;

/**
 * httpRequest��ʵ��
 */
public interface PushHttpRequest
{
	void addHeader(String name, String value);

	Map<String, String> getHeaders();

	void addParameter(String name, String value);

	void addParameter(String name, Object value);

	Map<String, String> getParameters();

	HttpMethodName getHttpMethod();

	void setHttpMethod(HttpMethodName httpMethod);

	BaiduPushRequest getOriginalRequest();
}

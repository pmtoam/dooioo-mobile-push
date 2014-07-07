package com.dooioo.mobile.push;

import java.util.List;

public abstract class BaiduPushRequest
{
	public final static int DEFAULT_EXPIRES = 0;
	public final static int DEFAULT_START = 0;
	public final static int DEFAULT_LIMIT = 10;
	/**
	 * API����Դ����������
	 */
	protected String methodName = null;
	/**
	 * ͨ����ʶ
	 */
	protected String channelId = null;
	/**
	 * Http����ķ�ʽ������GET��POST
	 */
	protected HttpMethodName httpMethod = null;

	/**
	 * ʹ��http����https����
	 */
	protected boolean needSsl;

	/**
	 * ������ڴ��ֶΣ���ֻ���ظ��豸���͵İ󶨹�ϵ�� Ĭ�ϲ������豸���͡�
	 * �ٶ�Channel֧�ֶ����豸�������豸�����ͱ�����£���֧��ĳ����ϣ��磺1,2,4:��
	 * 
	 * @see DeviceType
	 */
	private List<DeviceType> deviceTypes = null;

	/**
	 * �û�ָ����������ǩ����ʧЧʱ�䡣��ʽΪunixʱ�����ʽ��
	 */
	private int expires = DEFAULT_EXPIRES;

	public BaiduPushRequest()
	{
	}

	public BaiduPushRequest(String methodName, String channelId,
			HttpMethodName httpMethod)
	{
		this.methodName = methodName;
		this.channelId = channelId;
		this.httpMethod = httpMethod;
	}

	public String getMethodName()
	{
		return methodName;
	}

	public void setMethodName(String methodName)
	{
		this.methodName = methodName;
	}

	public String getChannelId()
	{
		return channelId;
	}

	public void setChannelId(String channelId)
	{
		this.channelId = channelId;
	}

	public HttpMethodName getHttpMethod()
	{
		return httpMethod;
	}

	public void setHttpMethod(HttpMethodName httpMethod)
	{
		this.httpMethod = httpMethod;
	}

	public List<DeviceType> getDeviceTypes()
	{
		return deviceTypes;
	}

	public void setDeviceTypes(List<DeviceType> deviceTypes)
	{
		this.deviceTypes = deviceTypes;
	}

	public int getExpires()
	{
		return expires;
	}

	public void setExpires(int expires)
	{
		this.expires = expires;
	}

	public boolean isNeedSsl()
	{
		return needSsl;
	}

	public void setNeedSsl(boolean needSsl)
	{
		this.needSsl = needSsl;
	}
}

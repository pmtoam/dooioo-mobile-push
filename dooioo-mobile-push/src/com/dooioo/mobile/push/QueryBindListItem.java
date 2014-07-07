package com.dooioo.mobile.push;

import java.io.Serializable;

/**
 * ��ѯ�豸�󶨹�ϵ�ķ���ʵ��
 */
public class QueryBindListItem implements Serializable
{
	private static final long serialVersionUID = -1151427103313143297L;

	/**
	 * ͨ����ʶ��ϵͳ���ص�channel_id��
	 */
	private String channelId;
	/**
	 * channel�󶨵�user��ʶ��
	 */
	private String userId;
	/**
	 * channel�󶨵��豸��š�
	 */
	private String deviceId;
	/**
	 * channel�󶨵��豸���͡�
	 */
	private int deviceType;
	/**
	 * channel�󶨵��豸������
	 */
	private String deviceName;
	/**
	 * channel�����ơ�
	 */
	private String bindName;
	/**
	 * channel��ʱ�䡣
	 */
	private String bindTime;
	/**
	 * channel�󶨸�����Ϣ��
	 */
	private String infoString;
	/**
	 * ��״̬��0�������ߣ� 1�������ߡ�
	 */
	private int bindStatus;
	/**
	 * Ӧ������״̬��on:���ߣ�off:���ߡ�
	 */
	private String onlineStatus;
	/**
	 * ���Ӵ���ʱ�䣬��������״̬ʱ���ء�
	 */
	private long onlineTimestamp;
	/**
	 * ���ӳ�ʱʱ����������״̬ʱ���ء�
	 */
	private long onlineExpires;

	public String getChannelId()
	{
		return channelId;
	}

	public void setChannelId(String channelId)
	{
		this.channelId = channelId;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getDeviceId()
	{
		return deviceId;
	}

	public void setDeviceId(String deviceId)
	{
		this.deviceId = deviceId;
	}

	public int getDeviceType()
	{
		return deviceType;
	}

	public void setDeviceType(int deviceType)
	{
		this.deviceType = deviceType;
	}

	public String getDeviceName()
	{
		return deviceName;
	}

	public void setDeviceName(String deviceName)
	{
		this.deviceName = deviceName;
	}

	public String getBindName()
	{
		return bindName;
	}

	public void setBindName(String bindName)
	{
		this.bindName = bindName;
	}

	public String getBindTime()
	{
		return bindTime;
	}

	public void setBindTime(String bindTime)
	{
		this.bindTime = bindTime;
	}

	public String getInfoString()
	{
		return infoString;
	}

	public void setInfoString(String infoString)
	{
		this.infoString = infoString;
	}

	public int getBindStatus()
	{
		return bindStatus;
	}

	public void setBindStatus(int bindStatus)
	{
		this.bindStatus = bindStatus;
	}

	public String getOnlineStatus()
	{
		return onlineStatus;
	}

	public void setOnlineStatus(String onlineStatus)
	{
		this.onlineStatus = onlineStatus;
	}

	public long getOnlineTimestamp()
	{
		return onlineTimestamp;
	}

	public void setOnlineTimestamp(long onlineTimestamp)
	{
		this.onlineTimestamp = onlineTimestamp;
	}

	public long getOnlineExpires()
	{
		return onlineExpires;
	}

	public void setOnlineExpires(long onlineExpires)
	{
		this.onlineExpires = onlineExpires;
	}

	@Override
	public String toString()
	{
		return "QueryBindListItem [channelId=" + channelId + ", userId="
				+ userId + ", deviceId=" + deviceId + ", deviceType="
				+ deviceType + ", deviceName=" + deviceName + ", bindName="
				+ bindName + ", bindTime=" + bindTime + ", infoString="
				+ infoString + ", bindStatus=" + bindStatus + ", onlineStatus="
				+ onlineStatus + ", onlineTimestamp=" + onlineTimestamp
				+ ", onlineExpires=" + onlineExpires + "]";
	}
}

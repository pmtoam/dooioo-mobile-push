package com.dooioo.mobile.push;

import java.util.List;

import org.apache.commons.codec.binary.Base64;

public class PushUtil
{
	public static String toBase64(String data)
	{
		byte[] b64 = Base64.encodeBase64(data.getBytes());
		return new String(b64);
	}

	public static String generateDeviceType(List<DeviceType> deviceTypes)
	{
		if (deviceTypes == null || deviceTypes.isEmpty())
		{
			return "";
		}

		StringBuffer buffer = new StringBuffer();
		for (DeviceType deviceType : deviceTypes)
		{
			buffer.append(deviceType.ordinal()).append(",");
		}
		if (buffer.length() > 0)
		{
			buffer.deleteCharAt(buffer.length() - 1);
		}

		return buffer.toString();
	}

}

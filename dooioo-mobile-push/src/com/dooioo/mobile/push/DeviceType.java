package com.dooioo.mobile.push;

/**
 * 设备类型 <br>
 * 百度Channel支持多种设备，各种设备的类型编号如下：<br>
 * 1：浏览器设备；<br>
 * 2：PC设备；<br>
 * 3：Andriod设备；<br>
 * 4：iOS设备；<br>
 * 5：Windows Phone设备；<br>
 */
public enum DeviceType
{
	empty, browser, pc, android, iso, win_phone;

	public static DeviceType valueOf(int value)
	{
		DeviceType[] types = DeviceType.values();
		for (DeviceType type : types)
		{
			if (value == type.ordinal())
			{
				return type;
			}
		}
		return empty;
	}
}
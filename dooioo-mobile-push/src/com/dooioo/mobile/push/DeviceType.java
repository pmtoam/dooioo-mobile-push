package com.dooioo.mobile.push;

/**
 * �豸���� <br>
 * �ٶ�Channel֧�ֶ����豸�������豸�����ͱ�����£�<br>
 * 1��������豸��<br>
 * 2��PC�豸��<br>
 * 3��Andriod�豸��<br>
 * 4��iOS�豸��<br>
 * 5��Windows Phone�豸��<br>
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
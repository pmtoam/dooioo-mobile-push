package com.dooioo.mobile.push;

/**
 * �������ͣ�ȡֵ��ΧΪ��1��3<br>
 * 1�������ˣ�����ָ��user_id �� channel_id ��ָ���û���ָ���豸������user_id��ָ���û��������豸��<br>
 * 2��һȺ�ˣ�����ָ�� tag<br>
 * 3�������ˣ�����ָ��tag��user_id��channel_id<br>
 */
public enum PushType
{
	empty, single_user, tag_user, all_user;
}

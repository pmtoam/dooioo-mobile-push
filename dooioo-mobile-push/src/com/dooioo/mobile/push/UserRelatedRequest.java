package com.dooioo.mobile.push;

public class UserRelatedRequest extends BaiduPushRequest
{
	/**
	 * �û���ʶ��������256�ֽڡ�������ڴ��ֶΣ���ֻ��������û���صİ󶨹�ϵ
	 */
	private String userId = null;

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}
}

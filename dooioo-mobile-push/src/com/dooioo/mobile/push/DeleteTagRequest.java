package com.dooioo.mobile.push;

public class DeleteTagRequest extends BaiduPushRequest
{
	/**
	 * ��ǩ�����128�ֽڡ�
	 */
	private String tag;

	public DeleteTagRequest(String tag)
	{
		super.setHttpMethod(HttpMethodName.POST);
		super.setMethodName(Constants.delete_tag);
		this.tag = tag;
	}

	public String getTag()
	{
		return tag;
	}

	public void setTag(String tag)
	{
		this.tag = tag;
	}
}
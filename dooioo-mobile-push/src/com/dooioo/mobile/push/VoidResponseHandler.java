package com.dooioo.mobile.push;

/**
 * �շ��ؽ���Ĵ�����
 */
public class VoidResponseHandler extends HttpResponseHandler<Empty>
{
	@Override
	protected boolean hasResponseParams()
	{
		return false;
	}

}

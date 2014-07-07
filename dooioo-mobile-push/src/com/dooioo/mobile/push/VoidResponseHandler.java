package com.dooioo.mobile.push;

/**
 * 空返回结果的处理类
 */
public class VoidResponseHandler extends HttpResponseHandler<Empty>
{
	@Override
	protected boolean hasResponseParams()
	{
		return false;
	}

}

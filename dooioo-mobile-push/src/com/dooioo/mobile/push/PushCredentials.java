package com.dooioo.mobile.push;

/**
 * AK��SK��Ӧ�÷�����Դ������Ψһƾ֤�� �鿴AK��SK��Ϣ
 * 
 * @see <a
 *      href="http://developer.baidu.com/wiki/index.php?title=docs/cplat/push/guide">�ٷ��ĵ�</a>
 */
public class PushCredentials
{

	private String accessKey;
	private String secretKey;

	public PushCredentials(String accessKey, String secretKey)
	{
		this.accessKey = accessKey;
		this.secretKey = secretKey;
	}

	public String getAccessKey()
	{
		return this.accessKey;
	}

	public String getSecretKey()
	{
		return this.secretKey;
	}
}

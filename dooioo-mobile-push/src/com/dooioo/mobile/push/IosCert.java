package com.dooioo.mobile.push;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Ios֤����Ϣ
 */
public class IosCert
{
	private static final Log log = LogFactory.getLog(IosCert.class);

	/**
	 * ֤�����ƣ��128�ֽڡ�
	 */
	private String name;
	/**
	 * ֤���������256�ֽڡ�
	 */
	private String description;
	/**
	 * ��ʽ��֤�����ݡ�
	 */
	private String releaseCert;
	/**
	 * ������֤�����ݡ�
	 */
	private String devCert;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getReleaseCert()
	{
		return releaseCert;
	}

	public void setReleaseCert(String releaseCert)
	{
		this.releaseCert = releaseCert;
	}

	public void setReleaseCert(InputStream in)
	{
		String desc = "";
		try
		{
			desc = IOUtils.toString(in, Constants.DEFAULT_ENCODING);
		}
		catch (IOException e)
		{
			log.equals("read release cert error, reason:" + e.getMessage());
		}
		this.releaseCert = desc;
	}

	public String getDevCert()
	{
		return devCert;
	}

	public void setDevCert(String devCert)
	{
		this.devCert = devCert;
	}

	public void setDevCert(InputStream in)
	{
		String desc = "";
		try
		{
			desc = IOUtils.toString(in, Constants.DEFAULT_ENCODING);
		}
		catch (IOException e)
		{
			log.equals("read release cert error, reason:" + e.getMessage());
		}
		this.devCert = desc;
	}

	@Override
	public String toString()
	{
		return "IosCert [name=" + name + ", description=" + description
				+ ", releaseCert=" + releaseCert + ", devCert=" + devCert + "]";
	}
}

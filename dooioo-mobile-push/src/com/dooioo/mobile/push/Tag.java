package com.dooioo.mobile.push;

/**
 * �����ǩʵ��
 */
public class Tag
{
	/**
	 * ��ǩid
	 */
	private String tid;
	/**
	 * ��ǩ����
	 */
	private String name;
	/**
	 * ��ǩ��Ϣ
	 */
	private String info;
	/**
	 * ��ǩ����
	 */
	private int type;
	/**
	 * ��ǩ����ʱ��
	 */
	private long createTime;

	public String getTid()
	{
		return tid;
	}

	public void setTid(String tid)
	{
		this.tid = tid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getInfo()
	{
		return info;
	}

	public void setInfo(String info)
	{
		this.info = info;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public long getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(long createTime)
	{
		this.createTime = createTime;
	}

	@Override
	public String toString()
	{
		return "Tag [tid=" + tid + ", name=" + name + ", info=" + info
				+ ", type=" + type + ", createTime=" + createTime + "]";
	}
}

package com.dooioo.mobile.push;

import java.util.List;

/**
 * ��ȡtag�ķ��ؽ������
 */
public class FetchTagBean
{
	/**
	 * ϵͳ���ص���Ϣ������
	 */
	private int totalNum;
	/**
	 * ���β�ѯ��������
	 */
	private int count;
	/**
	 * ��ǩ������Ϣ
	 */
	private List<Tag> tags;

	public int getTotalNum()
	{
		return totalNum;
	}

	public void setTotalNum(int totalNum)
	{
		this.totalNum = totalNum;
	}

	public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}

	public List<Tag> getTags()
	{
		return tags;
	}

	public void setTags(List<Tag> tags)
	{
		this.tags = tags;
	}

	@Override
	public String toString()
	{
		return "FetchTagBean [totalNum=" + totalNum + ", count=" + count
				+ ", tags=" + tags + "]";
	}
}

package com.dooioo.mobile.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ��ѯ�豸�󶨹�ϵ�ķ���ʵ��
 */
public class QueryBindListResponseBean implements Serializable
{

	private static final long serialVersionUID = 6029588215087717152L;

	/**
	 * ����������
	 */
	private int totalNum;
	/**
	 * ���β�ѯ��������
	 */
	private int amount;

	/**
	 * ����ϸ
	 */
	private List<QueryBindListItem> bindItems = new ArrayList<QueryBindListItem>();

	public void addItem(QueryBindListItem item)
	{
		bindItems.add(item);
	}

	public int getTotalNum()
	{
		return totalNum;
	}

	public void setTotalNum(int totalNum)
	{
		this.totalNum = totalNum;
	}

	public int getAmount()
	{
		return amount;
	}

	public void setAmount(int amount)
	{
		this.amount = amount;
	}

	public List<QueryBindListItem> getBindItems()
	{
		return bindItems;
	}

	public void setBindItems(List<QueryBindListItem> bindItems)
	{
		this.bindItems = bindItems;
	}

	@Override
	public String toString()
	{
		return "QueryBindListResponseBean [totalNum=" + totalNum + ", amount="
				+ amount + ", bindItems=" + bindItems + "]";
	}
}

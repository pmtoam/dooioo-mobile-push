package com.dooioo.mobile.push;

import java.util.List;

/**
 * ɾ����Ϣ�ķ��ؽ��ʵ�壬��������ɹ���������ɾ��״̬
 */
public class DeleteMessageResponseBean
{
	private int successCount;
	private List<MessageOperationDetail> statusList;

	public int getSuccessCount()
	{
		return successCount;
	}

	public void setSuccessCount(int successCount)
	{
		this.successCount = successCount;
	}

	public List<MessageOperationDetail> getStatusList()
	{
		return statusList;
	}

	public void setStatusList(List<MessageOperationDetail> statusList)
	{
		this.statusList = statusList;
	}

	@Override
	public String toString()
	{
		return "DeleteMessageResponseBean [successCount=" + successCount
				+ ", statusList=" + statusList + "]";
	}

}

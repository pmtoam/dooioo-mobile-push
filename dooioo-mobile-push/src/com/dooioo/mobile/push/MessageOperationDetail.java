package com.dooioo.mobile.push;

/**
 * ɾ����Ϣ��Ĳ���״̬ʵ��
 */
public class MessageOperationDetail
{
	/**
	 * ��Ϣ��ʶ
	 */
	private String messageId;
	/**
	 * ���������ʶ
	 */
	private OperationStatus status;

	public String getMessageId()
	{
		return messageId;
	}

	public void setMessageId(String messageId)
	{
		this.messageId = messageId;
	}

	public OperationStatus getStatus()
	{
		return status;
	}

	public void setStatus(OperationStatus status)
	{
		this.status = status;
	}

	@Override
	public String toString()
	{
		return "MessageOperationDetail [messageId=" + messageId + ", status="
				+ status + "]";
	}
}

package com.dooioo.mobile.push;

/**
 * ��Ϣʵ��
 */
public class Message
{
	/**
	 * ͨ����ʶ
	 */
	private String channelId;
	/**
	 * ϵͳ���ص���Ϣid
	 */
	private String messageId;
	/**
	 * ��Ϣ��ʶ�����ڸ�����Ϣ����
	 */
	private String messageKey;
	/**
	 * ��Ϣ����
	 */
	private String message;
	/**
	 * ϵͳ���ص���Ϣ����
	 */
	private int messageLength;
	/**
	 * ��Ϣ����
	 */
	private MessageType messageType;

	/**
	 * ��Ϣ����ʱ��
	 */
	private int messageExpires;

	public String getChannelId()
	{
		return channelId;
	}

	public void setChannelId(String channelId)
	{
		this.channelId = channelId;
	}

	public String getMessageId()
	{
		return messageId;
	}

	public void setMessageId(String messageId)
	{
		this.messageId = messageId;
	}

	public String getMessageKey()
	{
		return messageKey;
	}

	public void setMessageKey(String messageKey)
	{
		this.messageKey = messageKey;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public int getMessageLength()
	{
		return messageLength;
	}

	public void setMessageLength(int messageLength)
	{
		this.messageLength = messageLength;
	}

	public MessageType getMessageType()
	{
		return messageType;
	}

	public void setMessageType(MessageType messageType)
	{
		this.messageType = messageType;
	}

	public int getMessageExpires()
	{
		return messageExpires;
	}

	public void setMessageExpires(int messageExpires)
	{
		this.messageExpires = messageExpires;
	}

	@Override
	public String toString()
	{
		return "Message [channelId=" + channelId + ", messageId=" + messageId
				+ ", messageKey=" + messageKey + ", message=" + message
				+ ", messageLength=" + messageLength + ", messageType="
				+ messageType + ", messageExpires=" + messageExpires + "]";
	}
}

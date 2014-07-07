package com.dooioo.mobile.push;

public class DooiooMobilePush
{
	/**
	 * 
	 * @param userId
	 * @param channelId
	 * @param message
	 * @param messageKeys
	 */
	public static PushResponse<Integer> pushMessageOneOnlyUser(String userId,
			String channelId, String message, String messageKeys)
	{
		PushClient client = new DefaultPushClient();
		PushMessageRequest request = new PushMessageRequest();
		request.setUserId(userId);
		request.setChannelId(channelId);
		request.setMessageType(MessageType.notify);
		request.setMessages(message);
		request.setPushType(PushType.single_user);
		request.setMessageKeys(messageKeys);
		PushResponse<Integer> response = client.pushMessage(request);
		return response;
	}
}

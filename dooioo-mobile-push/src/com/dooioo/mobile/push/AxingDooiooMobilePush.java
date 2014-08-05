package com.dooioo.mobile.push;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 德佑基于百度云服务的消息推送工具类(仅支持推送到Android手机)
 * 
 * @author 王月星 | 德佑工号：104409 | 手机：18116136307
 * @category 德佑-经纪研发中心-研发部-移动开发部
 */
public final class AxingDooiooMobilePush
{

	/**
	 * 推送一条消息到【我的客户】
	 * @param employeeCode 员工号
	 * @param msgCode 消息类型代号,如100001,200001...用于判断是什么类型的消息
	 * @return
	 */
	public static PushResponse<Integer> pushMessageOneOnlyUser(String employeeCode, String msgCode)
	{
		String[] ids = getEmployeeIds(employeeCode);
		
		if (ids != null && ids.length == 2)
		{
			String userId = ids[0];
			String channelId = ids[1];
			
			PushClient client = new DefaultPushClient();
			PushMessageRequest request = new PushMessageRequest();
			request.setUserId(userId);
			request.setChannelId(channelId);
			request.setMessageType(MessageType.notify);
			String message = String.format("{'title':'%s'," + "'description':'%s',"
					+ "'notification_builder_id':0,"
					+ "'notification_basic_style':7," + "'open_type':0,"
					+ "'custom_content':{'msgCode':'" + msgCode + "'}}", "消息提醒", "您收到一条新消息");
			request.setMessages(message);
			request.setPushType(PushType.single_user);
			request.setMessageKeys("neverKeys");
			PushResponse<Integer> response = client.pushMessage(request);
			return response;
		}
		return null;
	}
	
	private static String[] getEmployeeIds(String employeeCode)
	{
		String urlStr = "http://myclients.duapp.com/mysqlquery/employeeinfo?employeeCode=" + employeeCode;
		String[] ids = null;
		try
		{
			URL url = new URL(urlStr);
			InputStreamReader isr = new InputStreamReader(url.openStream());
			BufferedReader br = new BufferedReader(isr);
			
			String str = null;
			while((str = br.readLine()) != null)
			{
				ids = str.split(" ");
			}
			
			br.close();
			isr.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ids;
	}
	
//	/**
//	 * 
//	 * @param userId
//	 * @param channelId
//	 * @param message
//	 * @param messageKeys
//	 */
//	public static PushResponse<Integer> pushMessageOneOnlyUser(String userId,
//			String channelId, String message, String messageKeys)
//	{
//		PushClient client = new DefaultPushClient();
//		PushMessageRequest request = new PushMessageRequest();
//		request.setUserId(userId);
//		request.setChannelId(channelId);
//		request.setMessageType(MessageType.notify);
//		request.setMessages(message);
//		request.setPushType(PushType.single_user);
//		request.setMessageKeys(messageKeys);
//		PushResponse<Integer> response = client.pushMessage(request);
//		return response;
//	}
}

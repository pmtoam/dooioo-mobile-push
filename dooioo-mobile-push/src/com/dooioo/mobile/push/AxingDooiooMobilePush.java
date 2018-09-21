package com.dooioo.mobile.push;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.commons.lang.StringUtils;

/**
 * 基于百度云服务的德佑消息推送工具类(仅支持推送到Android手机)
 * 
 * @author 王月星 | 德佑工号：104409
 * @category 德佑-经纪研发中心-研发部-移动开发部
 */
public final class AxingDooiooMobilePush
{

	/**
	 * 推送一条消息到Android客户端
	 * @param employeeCode 员工号
	 * @param msgCode 消息类型代号,用于判断是什么类型的消息
	 * @return 返回值只作为调试，实际调用中，直接调用此方法，可忽略任何返回值：<br>
	 * 1：推送成功<br>
	 * -1：推送失败 [查询不到绑定的ID]<br>
	 * -2：推送失败 [客户端没有绑定]<br>
	 * -3：推送失败 [employeeCode null]<br>
	 */
	public static int pushMessageOneOnlyUser(String employeeCode, MessageCode msgCode)
	{
		if (StringUtils.isEmpty(employeeCode.trim()))
		{
			return -3;
		}
		
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
			request.setMessageKeys("nonKeys");
			try
			{
				client.pushMessage(request);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				return -2;
			}
			return 1;
		}
		
		return -1;
	}
	
	/**
	 * 推送一条消息到Android客户端
	 * @param employeeCode 员工号
	 * @param msgCode 消息类型代号,用于判断是什么类型的消息
	 * @param msgContent 消息内容(限制120字)
	 * @return 返回值只作为调试，实际调用中，直接调用此方法，可忽略任何返回值：<br>
	 * 1：推送成功<br>
	 * -1：推送失败 [查询不到绑定的ID]<br>
	 * -2：推送失败 [客户端没有绑定]<br>
	 * -3：推送失败 [employeeCode null]<br>
	 * -4：推送失败 [msgContent null]<br>
	 * -5：推送失败 [msgContent长度  > 120]<br>
	 */
	public static int pushMessageOneOnlyUser(String employeeCode, MessageCode msgCode, String msgContent)
	{
		if (StringUtils.isEmpty(msgContent))
		{
			return -4;
		}
		
		if (msgContent.length() > 120)
		{
			return -5;
		}
		
		if (StringUtils.isEmpty(employeeCode.trim()))
		{
			return -3;
		}
		
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
					+ "'custom_content':{'msgCode':'" + msgCode + "','msgContent':' " + msgContent + " '}}", "消息提醒", "您收到一条新消息");
			request.setMessages(message);
			request.setPushType(PushType.single_user);
			request.setMessageKeys("nonKeys");
			try
			{
				client.pushMessage(request);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				return -2;
			}
			return 1;
		}
		
		return -1;
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
	
}

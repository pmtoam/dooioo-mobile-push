package com.dooioo.mobile.push;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.commons.lang.StringUtils;

/**
 * ���ӻ��ڰٶ��Ʒ������Ϣ���͹�����(��֧�����͵�Android�ֻ�)
 * 
 * @author ������ | ���ӹ��ţ�104409 | �ֻ���18116136307
 * @category ����-�����з�����-�з���-�ƶ�������
 */
public final class AxingDooiooMobilePush
{

	/**
	 * ����һ����Ϣ�����ҵĿͻ���
	 * @param employeeCode Ա����
	 * @param msgCode ��Ϣ���ʹ���,�����ж���ʲô���͵���Ϣ
	 * @return ����ֵֻ��Ϊ���ԣ�ʵ�ʵ����У�ֱ�ӵ��ô˷������ɺ����κη���ֵ��<br>
	 * 1�����ͳɹ�<br>
	 * -1������ʧ�� [��ѯ�����󶨵�ID]<br>
	 * -2������ʧ�� [�ͻ���û�а�]<br>
	 * -3������ʧ�� [employeeCode null]<br>
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
					+ "'custom_content':{'msgCode':'" + msgCode + "'}}", "��Ϣ����", "���յ�һ������Ϣ");
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

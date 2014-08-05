package com.dooioo.mobile.push;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import junit.framework.TestCase;

public class TestDooiooMobilePush extends TestCase
{

	// 名称：TestMyApp
	// Icon：
	// ID：2617484
	// API Key： xkSUHLeEtD53eHKhQgoFllRl
	// Secret Key：1SRrRHuRHcxqm8pWkoA6rPtGdIUmAaO4 重置
	// 创建时间：2014-04-25 14:28:29
	// 更新时间：2014-06-26 16:33:24

	// private final static String API_KEY = "xkSUHLeEtD53eHKhQgoFllRl";
	// private final static String SECRIT_KEY =
	// "1SRrRHuRHcxqm8pWkoA6rPtGdIUmAaO4";

	// |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	// ||||||||||||||以下为基于百度SDK消息推送功能测试||||||||||||||||||||||
	// |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

	// String userId = "1100418511754361074";
	// String channelId = "4107857102730233350";

	/**
	 * 推送消息给单个用户
	 */
	public void pushMessageOneOnlyUser()
	{
		// PushClient client = new DefaultPushClient();
		// PushMessageRequest request = new PushMessageRequest();
//		String userId = "1100418511754361074";
//		String channelId = "4107857102730233350";
		
		//onBind errorCode=0 appid=2617484 userId=836728182485935917 
		//channelId=4538636888713755467 requestId=652663895

		String userId = "836728182485935917";
		String channelId = "4538636888713755467";
		// request.setUserId(userId);
		// request.setChannelId(channelId);
		// request.setMessageType(MessageType.notify);
		String message = String.format("{'title':'%s'," + "'description':'%s',"
				+ "'notification_builder_id':0,"
				+ "'notification_basic_style':7," + "'open_type':0,"
				+ "'custom_content':{'test':'test'}}", "标题", "您收到一条新消息");
		// request.setMessages(message);
		// request.setPushType(PushType.single_user);
		// request.setMessageKeys("aaa");
		// PushResponse<Integer> response = client.pushMessage(request);
		// System.out.println(response);

		DooiooMobilePush.pushMessageOneOnlyUser(userId, channelId, message,
				"testKey");
	}

	public void pushMessageOne()
	{
		PushClient client = new DefaultPushClient();
		PushMessageRequest request = new PushMessageRequest();
		request.setMessageType(MessageType.message);
		request.setMessages("北京百度网讯科技有限公司");
		request.setPushType(PushType.all_user);
		request.setMessageKeys("aaa");
		PushResponse<Integer> response = client.pushMessage(request);
		System.out.println(response);
	}

	public void queryBindList()
	{
		PushClient client = new DefaultPushClient();
		QueryBindRequest request = new QueryBindRequest();
		PushResponse<QueryBindListResponseBean> response = client
				.queryBind(request);
		System.out.println(response);
	}

	public void pushNotify()
	{
		PushClient client = new DefaultPushClient();
		PushMessageRequest request = new PushMessageRequest();
		request.setMessageType(MessageType.notify);
		String msg = String
				.format("{'title':'%s','description':'%s','notification_builder_id':1,'notification_basic_style':1,'open_type':2,'custom_content':{'test':'test'}}",
						"aaaa",
						"北京百度网讯科技有限公司北京百度网讯科技有限公司北京百度网讯科技有限公司北京百度网讯科技有限公司!");

		request.setMessages(msg);
		request.setPushType(PushType.all_user);
		request.setMessageKeys("msgkeys");

		PushResponse<Integer> response = client.pushMessage(request);

		System.out.println(response);
	}

	public void queryDeviceType()
	{
		PushClient client = new DefaultPushClient();

		String channelId = "4107857102730233350";
		QueryDeviceTypeRequest request = new QueryDeviceTypeRequest(channelId);

		PushResponse<DeviceType> response = client.queryDeviceType(request);

		System.out.println(response);
	}

	public void testFrist()
	{
		System.out.println("ssssss");
	}
	
	public void testReqUrl()
	{
		String urlStr = "http://myclients.duapp.com/mysqlbind/deviceinfo?userId=617943248495163974&channelId=3688022906336843532";
		try
		{
			URL url=new URL(urlStr);
			InputStreamReader isr=new InputStreamReader(url.openStream());
			BufferedReader br=new BufferedReader(isr);
			
			String str;
			while((str=br.readLine())!=null)
			{
				System.out.println(str);
			}
			
			br.close();
			isr.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

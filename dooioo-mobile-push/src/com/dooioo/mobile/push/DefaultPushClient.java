package com.dooioo.mobile.push;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * ���Ϳͻ���ʵ��
 */
public class DefaultPushClient implements PushClient
{
	private final static String API_KEY = "xkSUHLeEtD53eHKhQgoFllRl";
	private final static String SECRIT_KEY = "1SRrRHuRHcxqm8pWkoA6rPtGdIUmAaO4";
	private PushHttpClient pushHttpClient;
	private PushCredentials credentials;

	public DefaultPushClient()
	{
		this.credentials = new PushCredentials(API_KEY, SECRIT_KEY);
		pushHttpClient = new PushHttpClient(credentials);
	}

	public DefaultPushClient(PushCredentials credentials)
	{
		this.credentials = credentials;
		pushHttpClient = new PushHttpClient(credentials);
	}

	@Override
	public PushResponse<QueryBindListResponseBean> queryBind(
			QueryBindRequest request)
	{
		PushHttpRequest httpRequest = createHttpRequest(request);

		if (StringUtils.isNotBlank(request.getUserId()))
		{
			httpRequest.addParameter("user_id", request.getUserId());
		}

		int start = request.getStart();
		if (start != QueryBindRequest.DEFAULT_START)
		{
			httpRequest.addParameter("start", start);
		}

		int limit = request.getLimit();
		if (limit != QueryBindRequest.DEFAULT_LIMIT)
		{
			httpRequest.addParameter("limit", limit);
		}

		return this.pushHttpClient.execute(httpRequest,
				new QueryBindListResponseHandler());
	}

	@Override
	public PushResponse<Integer> pushMessage(PushMessageRequest pushMsgReq)
	{
		PushHttpRequest httpRequest = createHttpRequest(pushMsgReq);
		PushType pushType = pushMsgReq.getPushType();

		httpRequest.addParameter("message_type", pushMsgReq.getMessageType()
				.ordinal());
		httpRequest.addParameter("messages", pushMsgReq.getMessages());
		httpRequest.addParameter("push_type", pushType.ordinal());
		httpRequest.addParameter("msg_keys", pushMsgReq.getMessageKeys());

		String tag = pushMsgReq.getTag();
		if (PushType.tag_user.equals(pushType))
		{
			if (StringUtils.isBlank(tag))
			{
				throw new PushClientException("���͸�һȺ��ʱ����ָ�� tag!");
			}
			httpRequest.addParameter("tag", tag);
		}

		if (!PushMessageRequest.DEFAULT_MSG_EXPIRES.equals(pushMsgReq
				.getMessageExpires()))
		{
			httpRequest.addParameter("message_expires",
					pushMsgReq.getMessageExpires());
		}

		if (StringUtils.isNotBlank(pushMsgReq.getUserId()))
		{
			httpRequest.addParameter("user_id", pushMsgReq.getUserId());
		}

		return this.pushHttpClient.execute(httpRequest,
				new PushMessageResponseHandler());
	}

	@Override
	public PushResponse<Empty> veryBind(VerifyBindRequest req)
	{
		// PushHttpRequest httpRequest = createHttpRequest(req);
		// httpRequest.addParameter("user_id", req.getUserId());
		//
		// return this.pushHttpClient.execute(httpRequest,
		// new VoidResponseHandler());

		return null;
	}

	@Override
	public PushResponse<List<Message>> fetchMessage(FetchMessageRequest req)
	{
		PushHttpRequest httpRequest = createHttpRequest(req);
		httpRequest.addParameter("user_id", req.getUserId());

		return this.pushHttpClient.execute(httpRequest,
				new FetchMessageResponseHandler());
	}

	@Override
	public PushResponse<Integer> fetchMessageCount(FetchMsgCountRequest req)
	{
		PushHttpRequest httpRequest = createHttpRequest(req);
		httpRequest.addParameter("user_id", req.getUserId());

		return this.pushHttpClient.execute(httpRequest,
				new FetchMessageCountResponseHandler());
	}

	@Override
	public PushResponse<DeleteMessageResponseBean> deleteMessage(
			DeleteMsgRequest req)
	{
		PushHttpRequest httpRequest = createHttpRequest(req);
		httpRequest.addParameter("user_id", req.getUserId());

		List<String> msgIds = req.getMsgIds();
		if (msgIds.size() == 1)
		{
			httpRequest.addParameter("msg_ids", msgIds.get(0));
		}
		else
		{
			httpRequest.addParameter("msg_ids", JSONObject.toJSON(msgIds)
					.toString());
		}

		return this.pushHttpClient.execute(httpRequest,
				new DeleteMessageHandler());
	}

	@Override
	public PushResponse<Empty> setTag(SetTagRequest req)
	{
		PushHttpRequest httpRequest = createHttpRequest(req);
		httpRequest.addParameter("tag", req.getTag());

		return this.pushHttpClient.execute(httpRequest,
				new VoidResponseHandler());
	}

	@Override
	public PushResponse<FetchTagBean> fetchTag(FetchTagRequest request)
	{
		PushHttpRequest httpRequest = createHttpRequest(request);
		if (StringUtils.isNotBlank(request.getName()))
		{
			httpRequest.addParameter("name", request.getName());
		}

		return this.pushHttpClient.execute(httpRequest, new FetchTagHandler());
	}

	@Override
	public PushResponse<Empty> deleteTag(DeleteTagRequest request)
	{
		PushHttpRequest httpRequest = createHttpRequest(request);
		httpRequest.addParameter("tag", request.getTag());

		return this.pushHttpClient.execute(httpRequest,
				new VoidResponseHandler());
	}

	@Override
	public PushResponse<FetchTagBean> queryUserTags(QueryUserTagsRequest request)
	{
		PushHttpRequest httpRequest = createHttpRequest(request);
		httpRequest.addParameter("user_id", request.getUserId());

		return this.pushHttpClient.execute(httpRequest, new FetchTagHandler());
	}

	@Override
	public PushResponse<DeviceType> queryDeviceType(
			QueryDeviceTypeRequest request)
	{
		PushHttpRequest httpRequest = createHttpRequest(request);
		httpRequest.addParameter("channel_id", request.getChannelId());

		return this.pushHttpClient
				.execute(httpRequest, new DeviceTypeHandler());
	}

	@Override
	public PushResponse<Empty> initIosCert(IosCertRequest request)
	{
		request.setMethodName("init_app_ioscert");
		PushHttpRequest httpRequest = createHttpRequest(request);

		IosCert cert = request.getIsoCert();

		httpRequest.addParameter("name", cert.getName());
		httpRequest.addParameter("description", cert.getDescription());
		httpRequest.addParameter("release_cert", cert.getReleaseCert());
		httpRequest.addParameter("dev_cert", cert.getDevCert());

		return this.pushHttpClient.execute(httpRequest,
				new VoidResponseHandler());
	}

	@Override
	public PushResponse<Empty> updateIosCert(IosCertRequest request)
	{
		request.setMethodName("update_app_ioscert");
		PushHttpRequest httpRequest = createHttpRequest(request);

		setCert(request.getIsoCert(), httpRequest);

		return this.pushHttpClient.execute(httpRequest,
				new VoidResponseHandler());
	}

	@Override
	public PushResponse<Empty> deleteIosCert(IosCertRequest request)
	{
		request.setHttpMethod(HttpMethodName.POST);
		request.setMethodName("delete_app_ioscert");

		PushHttpRequest httpRequest = createHttpRequest(request);

		return this.pushHttpClient.execute(httpRequest,
				new VoidResponseHandler());
	}

	@Override
	public PushResponse<IosCert> queryIosCert(IosCertRequest request)
	{
		request.setHttpMethod(HttpMethodName.POST);
		request.setMethodName("query_app_ioscert");

		PushHttpRequest httpRequest = createHttpRequest(request);
		return this.pushHttpClient.execute(httpRequest,
				new QueryIosCertHandler());
	}

	private void setCert(IosCert cert, PushHttpRequest httpRequest)
	{
		httpRequest.addParameter("name", cert.getName());
		httpRequest.addParameter("description", cert.getDescription());
		httpRequest.addParameter("release_cert",
				PushUtil.toBase64(cert.getReleaseCert()));
		httpRequest.addParameter("dev_cert",
				PushUtil.toBase64(cert.getDevCert()));
	}

	private PushHttpRequest createHttpRequest(BaiduPushRequest request)
	{
		PushHttpRequest httpRequest = new DefaultPushHttpRequest(request);

		httpRequest.addParameter("method", request.getMethodName());
		httpRequest.addParameter("apikey", credentials.getAccessKey());
		httpRequest
				.addParameter("timestamp", System.currentTimeMillis() / 1000);

		httpRequest.setHttpMethod(request.getHttpMethod());

		setDefaultParam(request, httpRequest);

		return httpRequest;
	}

	private void setDefaultParam(BaiduPushRequest request,
			PushHttpRequest httpRequest)
	{
		String channelId = request.getChannelId();
		if (StringUtils.isNotBlank(channelId))
		{
			httpRequest.addParameter("channel_id", channelId);
		}

		List<DeviceType> deviceTypes = request.getDeviceTypes();
		String deviceTypeStr = PushUtil.generateDeviceType(deviceTypes);
		if (StringUtils.isNotBlank(deviceTypeStr))
		{
			httpRequest.addParameter("device_type", deviceTypeStr);
		}

		int expires = request.getExpires();
		if (expires != QueryBindRequest.DEFAULT_EXPIRES)
		{
			httpRequest.addParameter("expires", expires);
		}

		if (request instanceof PagableRequest)
		{
			PagableRequest pagableReq = (PagableRequest) request;
			int start = pagableReq.getStart();
			if (start != QueryBindRequest.DEFAULT_START)
			{
				httpRequest.addParameter("start", start);
			}

			int limit = pagableReq.getLimit();
			if (limit != QueryBindRequest.DEFAULT_LIMIT)
			{
				httpRequest.addParameter("limit", limit);
			}
		}
	}
}
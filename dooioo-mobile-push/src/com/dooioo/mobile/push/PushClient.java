package com.dooioo.mobile.push;

import java.util.List;

/**
 * ����Facade�ӿ�
 * 
 * @see <a href="http://developer.baidu.com/wiki/index.php?title=docs/cplat/push/api/list">�ٷ��ĵ�</a>
 *
 */
public interface PushClient 
{
	/**
	 * ��ѯ�豸��Ӧ�á��û���ٶ�Channel�İ󶨹�ϵ��
	 * �����ѯ�İ󶨹�ϵ��channel_id�޹أ�����Ҫ����channel_id����
	 * @see <a href="http://developer.baidu.com/wiki/index.php?title=docs/cplat/push/api/list#query_bindlist">�ٷ��ĵ�</a>
	 * @param request ��ѯ��״̬���������
	 * @return �豸���û�����channelֱ�ӵ�bind��ϵ�б�
	 */
	PushResponse<QueryBindListResponseBean> queryBind(QueryBindRequest request);

	/**
	 * ������Ϣ���ýӿڿ��������͵����ˡ�һȺ�ˡ��������Լ��̶��豸��ʹ�ó�����
	 * Ŀǰiosֻ֧�ֵ�����Ϣ, ֻ֧��notify��������Ϣ����Ҫ�ϸ����apple��apns��ʽ
	 * @see <a href="http://developer.baidu.com/wiki/index.php?title=docs/cplat/push/api/list#push_msg">�ٷ��ĵ�</a>
	 * @param request ������Ϣ����
	 * @return
	 */
	PushResponse<Integer> pushMessage(PushMessageRequest request);

	/**
	 * �ж��豸��Ӧ�á��û���Channel�İ󶨹�ϵ�Ƿ���ڡ�
	 * �����ѯ�İ󶨹�ϵ��channel_id�޹أ�����Ҫ����channel_id����
	 * 
	 * @see <a href="http://developer.baidu.com/wiki/index.php?title=docs/cplat/push/api/list#verify_bind">�ٷ��ĵ�</a>
	 * @param request ��ѯ�󶨹�ϵ����
	 * @return ����ط�������׳��쳣����������request_id�ͱ����󶨹�ϵ����
	 */
	PushResponse<Empty> veryBind(VerifyBindRequest request);

	/**
	 * ��ѯ������Ϣ��
	 * �����ѯ�İ󶨹�ϵ��channel_id�޹أ�����Ҫ����channel_id����
	 * 
	 * @see <a href="http://developer.baidu.com/wiki/index.php?title=docs/cplat/push/api/list#fetch_msg">�ٷ��ĵ�</a>
	 * @param request ��ѯ������Ϣ����
	 * @return ������Ϣ��һ������
	 */
	PushResponse<List<Message>> fetchMessage(FetchMessageRequest request);

	/**
	 * ��ѯ������Ϣ�ĸ�����
	 * �����ѯ�İ󶨹�ϵ��channel_id�޹أ�����Ҫ����channel_id����
	 * @see <a href="http://developer.baidu.com/wiki/index.php?title=docs/cplat/push/api/list#fetch_msgcount">�ٷ��ĵ�</a>
	 * @param request ��ѯ������Ϣ��Ŀ����
	 * @return ������Ϣ��Ŀ
	 */
	PushResponse<Integer> fetchMessageCount(FetchMsgCountRequest request);

	/**
	 * ɾ��������Ϣ��
	 * �����ѯ�İ󶨹�ϵ��channel_id�޹أ�����Ҫ����channel_id����
	 * @see <a href="http://developer.baidu.com/wiki/index.php?title=docs/cplat/push/api/list#delete_msg">�ٷ��ĵ�</a>
	 * @param request ɾ��������Ϣ����
	 * @return ɾ��������Ϣ�ɹ��ĸ���
	 */
	PushResponse<DeleteMessageResponseBean> deleteMessage(DeleteMsgRequest request);

	/**
	 * �������������û���ǩ�����ñ�ǩ������ʱ������˽��ᴴ���ñ�ǩ��
	 * �ر�أ���user_id���ύʱ������˽�������û���tag�İ󶨲�����
	 * @see <a href="http://developer.baidu.com/wiki/index.php?title=docs/cplat/push/api/list#set_tag">�ٷ��ĵ�</a>
	 * @param request ����tag����
	 * @return ����ط�������׳��쳣����������request_id�ͱ����󶨹�ϵ����
	 */
	PushResponse<Empty> setTag(SetTagRequest request);

	/**
	 * ��ѯӦ�õ����б�ǩ
	 * @see <a href="http://developer.baidu.com/wiki/index.php?title=docs/cplat/push/api/list#fetch_tag">�ٷ��ĵ�</a>
	 * @param request ��ѯ�û���ǩ����
	 * @return ��ǩ�б�
	 */
	PushResponse<FetchTagBean> fetchTag(FetchTagRequest request);
	
	/**
	 * ɾ����ǩ������tag�����Ǳ�����
	 * @see <a href="http://developer.baidu.com/wiki/index.php?title=docs/cplat/push/api/list#delete_tag">�ٷ��ĵ�</a>
	 * @param request ɾ����ǩ����
	 * @return ����ط�������׳��쳣����������request_id�ͱ���ɾ���ɹ�
	 */
	PushResponse<Empty> deleteTag(DeleteTagRequest request);

	/**
	 * ��ѯ�û������ı�ǩ�б�����user_id�Ǳ�����
	 * @see <a href="http://developer.baidu.com/wiki/index.php?title=docs/cplat/push/api/list#query_user_tags">�ٷ��ĵ�</a>
	 * @param request ��ѯ�û�������ǩ����
	 * @return ���û���صı�ǩ�б�
	 */
	PushResponse<FetchTagBean> queryUserTags(QueryUserTagsRequest request);

	/**
	 * ��ʼios֤����Ϣ
	 * @see <a href="http://developer.baidu.com/wiki/index.php?title=docs/cplat/push/api/list#init_app_ioscert">�ٷ��ĵ�</a>
	 * @param request ��ʼ֤����Ϣ������
	 * @return ����ط�������׳��쳣����������request_id�ͱ�����ʼ���ɹ�
	 */
	PushResponse<Empty> initIosCert(IosCertRequest request);
	
	/**
	 * ����ios֤����Ϣ
	 * @see <a href="http://developer.baidu.com/wiki/index.php?title=docs/cplat/push/api/list#update_app_ioscert">�ٷ��ĵ�</a>
	 * @param request ����֤����Ϣ������
	 * @return ����ط�������׳��쳣����������request_id�ͱ�����ʼ���ɹ�
	 */
	PushResponse<Empty> updateIosCert(IosCertRequest request);

	
	/**
	 * ��ѯios֤����Ϣ
	 * �����ѯ�İ󶨹�ϵ��channel_id�޹أ�����Ҫ����channel_id����
	 * �������iosCert�������ᱻ����
	 * @see <a href="http://developer.baidu.com/wiki/index.php?title=docs/cplat/push/api/list#query_app_ioscert">�ٷ��ĵ�</a>
	 * @param request ��ѯ֤����Ϣ������
	 * @return ����ط�������׳��쳣����������request_id�ͱ�����ʼ���ɹ�
	 */
	PushResponse<IosCert> queryIosCert(IosCertRequest request);

	/**
	 * ɾ��ios֤��
	 * @see <a href="http://developer.baidu.com/wiki/index.php?title=docs/cplat/push/api/list#delete_app_ioscert">�ٷ��ĵ�</a>
	 * @param request ɾ��ios֤�������
	 * @return ����ط�������׳��쳣����������request_id�ͱ�����ʼ���ɹ�
	 */
	PushResponse<Empty> deleteIosCert(IosCertRequest request);

	/**
	 * ����channel_id��ѯ�豸���͡�
	 * �������channel_id�Ǳ�����
	 * @see <a href="http://developer.baidu.com/wiki/index.php?title=docs/cplat/push/api/list#query_device_type">�ٷ��ĵ�</a>
	 * @param request ��ѯ�豸���͵�����
	 * @return ���ذ󶨵��豸����
	 */
	PushResponse<DeviceType> queryDeviceType(QueryDeviceTypeRequest request);

}

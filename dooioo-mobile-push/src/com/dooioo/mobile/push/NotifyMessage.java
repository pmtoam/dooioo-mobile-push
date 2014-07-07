package com.dooioo.mobile.push;

/**
 * ����Ϣ����Ϊnotify��ʱ����Ҫ�������õ�һЩֵ
 * http://developer.baidu.com/wiki/index.php?title=docs/cplat/push/faq $message
 * = "{ 'title': 'title', 'description': 'description',
 * 'notification_builder_id': 0, 'notification_basic_style': 0x04,
 * 'open_type':2, 'custom_content':{'type_code':'1','type_content':'7448969'}
 * }";
 * 
 */
public class NotifyMessage
{
	/**
	 * ֪ͨ���⣬����Ϊ�գ����Ϊ������Ϊappid��Ӧ��Ӧ����;
	 */
	private String title;
	/**
	 * ֪ͨ�ı����ݣ�����Ϊ��;
	 */
	private String description;

	/**
	 * android�ͻ����Զ���֪ͨ��ʽ�����û������Ĭ��Ϊ0;
	 */
	private int notification_builder_id;
	/**
	 * ֻ��notification_builder_idΪ0ʱ����Ч������Ҫ���ã� �����������ͣ�ÿһλ����һ�ֻ�����ʽ��������ʽ�ö�����λ��ʾ����
	 * ���壺0100B=0x04 �񶯣�0010B=0x02 �������0001B=0x01
	 * �����Ҫͬʱ���ö��ֻ�����ʽ�����Զ��������ֻ�����ʽ���������㣬����Ҫ����֪ͨΪ���塢�񶯺Ϳ������
	 * ��notification_basic_style ֵΪ�� notification_basic_style=0100B | 0010B |
	 * 0001B= 0111B=0x07
	 */
	private int notification_basic_style = 7;

	/**
	 * ���֪ͨ�����Ϊ(1: ��Url;2: �Զ�����Ϊ;3������ֵ��Ĭ�ϴ�Ӧ��);
	 */
	private OpenType openType;

	/**
	 * urlֻ��open_typeΪ1ʱ����Ч������Ҫ���ã����open_typeΪ1�����������Ҫ�򿪵�Url��ַ;
	 */
	private String url;

	/**
	 * ֻ��open_typeΪ1ʱ����Ч������Ҫ����,(��Ҫ�����û���Ȩ��1��Ĭ��ֱ�Ӵ򿪣�0),
	 */
	private UserConfirm userConfirm;

	/**
	 * ֻ��open_typeΪ2ʱ����Ч������Ҫ����, ���open_typeΪ2����������Զ������Ϊ(����ο��������̨�ĵ�);
	 */
	private String pkgContet;

	/**
	 * �Զ������ݣ���ֵ�ԣ�Json������ʽ(��ѡ)����android�ͻ��ˣ���Щ��ֵ�Խ���Intent�е�extra���д��ݡ�
	 */
	private String customConent;

	public NotifyMessage(String description)
	{
		this.description = description;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getNotification_builder_id()
	{
		return notification_builder_id;
	}

	public void setNotification_builder_id(int notification_builder_id)
	{
		this.notification_builder_id = notification_builder_id;
	}

	public int getNotification_basic_style()
	{
		return notification_basic_style;
	}

	public void setNotification_basic_style(int notification_basic_style)
	{
		this.notification_basic_style = notification_basic_style;
	}

	public OpenType getOpenType()
	{
		return openType;
	}

	public void setOpenType(OpenType openType)
	{
		this.openType = openType;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public UserConfirm getUserConfirm()
	{
		return userConfirm;
	}

	public void setUserConfirm(UserConfirm userConfirm)
	{
		this.userConfirm = userConfirm;
	}

	public String getPkgContet()
	{
		return pkgContet;
	}

	public void setPkgContet(String pkgContet)
	{
		this.pkgContet = pkgContet;
	}

	public String getCustomConent()
	{
		return customConent;
	}

	public void setCustomConent(String customConent)
	{
		this.customConent = customConent;
	}
}

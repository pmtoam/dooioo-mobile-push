package com.dooioo.mobile.push;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

/**
 * ����http����
 */
@SuppressWarnings("deprecation")
public class HttpClientFactory
{

	private static final String CHARSET = HTTP.UTF_8;
	private static HttpClient httpClient;
	// �����ӳ���ȡ���ӵĳ�ʱʱ��
	public static int TIME_OUT = 6000;
	// ���ӳ�ʱʱ��
	public static int CONNECTION_TIME_OUT = 6000;
	// ����ʱʱ��
	public static int SO_TIME_OUT = 6000;

	static
	{
		HttpParams params = new BasicHttpParams();
		// ����һЩ��������
		HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
		HttpProtocolParams.setContentCharset(params, CHARSET);
		HttpProtocolParams.setUseExpectContinue(params, true);
		HttpProtocolParams
				.setUserAgent(
						params,
						"Mozilla/5.0(Linux;U;Android;en-us;Nexus One Build.FRG83) "
								+ "AppleWebKit/553.1(KHTML,like Gecko) Version/4.0 Mobile Safari/533.1");
		ConnManagerParams.setTimeout(params, TIME_OUT);
		HttpConnectionParams.setConnectionTimeout(params, CONNECTION_TIME_OUT);
		HttpConnectionParams.setSoTimeout(params, SO_TIME_OUT);
		// �������ǵ�HttpClient֧��HTTP��HTTPS����ģʽ
		SchemeRegistry schReg = new SchemeRegistry();
		schReg.register(new Scheme("http", PlainSocketFactory
				.getSocketFactory(), 80));
		schReg.register(new Scheme("https",
				SSLSocketFactory.getSocketFactory(), 443));
		// ʹ���̰߳�ȫ�����ӹ���������HttpClient
		ClientConnectionManager conMgr = new ThreadSafeClientConnManager(
				params, schReg);
		httpClient = new DefaultHttpClient(conMgr, params);
	}

	public HttpClient createHttpClient()
	{
		return httpClient;
	}

}

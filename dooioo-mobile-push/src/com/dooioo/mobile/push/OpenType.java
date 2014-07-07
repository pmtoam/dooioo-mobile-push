package com.dooioo.mobile.push;

/**
 * 点击通知后的行为:<br>
 * 1: 打开Url;<br>
 * 2: 自定义行为;<br>
 * 3：其它值则默认打开应用<br>
 */
public enum OpenType
{
	empty, open_url, user_define, open_app;
}

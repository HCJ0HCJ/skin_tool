package com.hcj.skin_tool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.FormBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**HTTP请求帮助类
 * @author   HCJ
 * @date     2020年1月6日 上午10:01:16
 */
public class HttpHelper {

	private final OkHttpClient client = new OkHttpClient();


	/**@author HCJ
	 * http同步请求，参数存在时要求MAP，键为参数名，值为参数值
	 * @date 2018年9月25日 下午5:50:01
	 */
	public String requestHttpString(String action, Map<String, String> args) throws IOException {
		String result;
		if (args != null) {
			Builder requestBuilder = new FormBody.Builder();
			for (Map.Entry<String, String> entry : args.entrySet()) {
				requestBuilder.add(entry.getKey(), entry.getValue());
			}
			RequestBody requestBody = requestBuilder.build();
			Request request = new Request.Builder().url(action).post(requestBody).build();
			Call call = client.newCall(request);
			result = call.execute().body().string();
		} else {
			Request request = new Request.Builder().url(action).build();
			Call call = client.newCall(request);
			result = call.execute().body().string();
		}
		return result;
	}


	/**@author HCJ
	 * http同步请求，参数存在时要求MAP，键为参数名，值为参数值
	 * @date 2018年9月25日 下午5:50:01
	 */
	public InputStream requestHttpInputStream(String action, Map<String, String> args) throws IOException {
		InputStream result;
		if (args != null) {
			Builder requestBuilder = new FormBody.Builder();
			for (Map.Entry<String, String> entry : args.entrySet()) {
				requestBuilder.add(entry.getKey(), entry.getValue());
			}
			RequestBody requestBody = requestBuilder.build();
			Request request = new Request.Builder().url(action).post(requestBody).build();
			Call call = client.newCall(request);
			result = call.execute().body().byteStream();
		} else {
			Request request = new Request.Builder().url(action).build();
			Call call = client.newCall(request);
			result = call.execute().body().byteStream();
		}
		return result;
	}


	/**@author HCJ
	 * http异步请求，参数存在时要求MAP，键为参数名，值为参数值
	 * @date 2018年9月25日 下午5:50:31
	 */
	public void requestHttp(String action, Map<String, String> args, Callback callback) throws IOException {
		Builder requestBuilder = new FormBody.Builder();
		if (args != null) {
			for (Map.Entry<String, String> entry : args.entrySet()) {
				requestBuilder.add(entry.getKey(), entry.getValue());
			}
		}
		RequestBody requestBody = requestBuilder.build();
		Request request = new Request.Builder().url(action).post(requestBody).build();
		Call call = client.newCall(request);
		call.enqueue(callback);
	}

}

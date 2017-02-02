package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * HTTP 요청 클래스
 *
 * @author devetude
 */
public class HTTPRequest {
	// 기본 인코딩 문자열 상수
	private static final String DEFAULT_CHARACTER_SET = "UTF-8";

	private static HttpClient httpClient = null;

	static {
		if (httpClient == null) {
			httpClient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
		}
	}

	/**
	 * post 메소드
	 * 
	 * @param url
	 * @param params
	 * @param enc
	 * @return
	 * @throws Exception
	 */
	public static String post(String url, Map<String, String> params, String enc) throws Exception {
		HttpPost httpPost = new HttpPost(url);

		if (params != null) {
			httpPost.setEntity(new UrlEncodedFormEntity(convertParam(params), enc));
		}

		return EntityUtils.toString(httpClient.execute(httpPost).getEntity(), enc);
	}

	/**
	 * post 메소드 (기본 인코딩 : UTF-8)
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String post(String url, Map<String, String> params) throws Exception {
		return post(url, params, DEFAULT_CHARACTER_SET);
	}

	/**
	 * get 메소드
	 * 
	 * @param url
	 * @param params
	 * @param enc
	 * @return
	 * @throws Exception
	 */
	public static String get(String url, Map<String, String> params, String enc) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append(url);

		if (params != null) {
			sb.append("?").append(URLEncodedUtils.format(convertParam(params), enc));
		}
		
		HttpGet httpGet = new HttpGet(sb.toString());

		return EntityUtils.toString(httpClient.execute(httpGet).getEntity(), enc);
	}

	/**
	 * get 메소드 (기본 인코딩 : UTF-8)
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String get(String url, Map<String, String> params) throws Exception {
		return get(url, params, DEFAULT_CHARACTER_SET);
	}

	/**
	 * map 파라메터를 key, value 형태의 리스트로 변환하는 메소드
	 * 
	 * @param params
	 * @return
	 */
	private static List<NameValuePair> convertParam(Map<String, String> params) {
		List<NameValuePair> paramList = new ArrayList<NameValuePair>();
		Iterator<String> keys = params.keySet().iterator();

		while (keys.hasNext()) {
			String key = keys.next();
			paramList.add(new BasicNameValuePair(key, params.get(key).toString()));
		}

		return paramList;
	}
}
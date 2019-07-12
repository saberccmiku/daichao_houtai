package com.daichao.loans.basic.sms;

import java.util.HashMap;
import java.util.Map;

import com.daichao.loans.basic.sms.request.SmsSingleRequest;
import com.daichao.loans.basic.sms.response.SmsResponse;
import com.daichao.loans.basic.sms.util.AES;
import com.daichao.loans.basic.sms.util.GZIPUtils;
import com.daichao.loans.basic.sms.util.http.HttpClient;
import com.daichao.loans.basic.sms.util.http.HttpRequest;
import com.daichao.loans.basic.sms.util.http.HttpRequestBytes;
import com.daichao.loans.basic.sms.util.http.HttpRequestParams;
import com.daichao.loans.basic.sms.util.http.HttpResponseBytes;
import com.daichao.loans.basic.sms.util.http.HttpResponseBytesPraser;
import com.daichao.loans.basic.sms.util.http.HttpResultCode;
import com.daichao.loans.basic.sms.util.http.HttpsRequestBytes;


public class Example {

	/**
	 * 发送单条短信
	 * 
	 * @param isGzip
	 *            是否压缩
	 */
	public static void setSingleSms(String appId, String secretKey, String host, String algorithm, String content, String customSmsId, String extendCode, String mobile, boolean isGzip, String encode) {
		System.out.println("=============begin setSingleSms==================");
		SmsSingleRequest pamars = new SmsSingleRequest();
		pamars.setContent(content);
		pamars.setCustomSmsId(customSmsId);
		pamars.setExtendedCode(extendCode);
		pamars.setMobile(mobile);
		ResultModel result = request(appId, secretKey, algorithm, pamars, host + "/inter/sendSingleSMS", isGzip, encode);
		System.out.println("result code :" + result.getCode());
		if ("SUCCESS".equals(result.getCode())) {
			SmsResponse response = JsonHelper.fromJson(SmsResponse.class, result.getResult());
			if (response != null) {
				System.out.println("data : " + response.getMobile() + "," + response.getSmsId() + "," + response.getCustomSmsId());
			}
		}
		System.out.println("=============end setSingleSms==================");
	}


	/**
	 * 公共请求方法
	 */
	public static ResultModel request(String appId, String secretKey, String algorithm, Object content, String url, final boolean isGzip, String encode) {
		Map<String, String> headers = new HashMap<String, String>();
		HttpRequest<byte[]> request = null;
		try {
			headers.put("appId", appId);
			headers.put("encode", encode);
			String requestJson = JsonHelper.toJsonString(content);
			System.out.println("result json: " + requestJson);
			byte[] bytes = requestJson.getBytes(encode);
			System.out.println("request data size : " + bytes.length);
			if (isGzip) {
				headers.put("gzip", "on");
				bytes = GZIPUtils.compress(bytes);
				System.out.println("request data size [com]: " + bytes.length);
			}
			byte[] parambytes = AES.encrypt(bytes, secretKey.getBytes(), algorithm);
			System.out.println("request data size [en] : " + parambytes.length);
			HttpRequestParams<byte[]> params = new HttpRequestParams<byte[]>();
			params.setCharSet("UTF-8");
			params.setMethod("POST");
			params.setHeaders(headers);
			params.setParams(parambytes);
			params.setUrl(url);
			if (url.startsWith("https://")) {
				request = new HttpsRequestBytes(params, null);
			} else {
				request = new HttpRequestBytes(params);
			}
		} catch (Exception e) {
			System.out.println("加密异常");
			e.printStackTrace();
		}
		HttpClient client = new HttpClient();
		String code = null;
		String result = null;
		try {
			HttpResponseBytes res = client.service(request, new HttpResponseBytesPraser());
			if (res == null) {
				System.out.println("请求接口异常");
				return new ResultModel(code, result);
			}
			if (res.getResultCode().equals(HttpResultCode.SUCCESS)) {
				if (res.getHttpCode() == 200) {
					code = res.getHeaders().get("result");
					if (code.equals("SUCCESS")) {
						byte[] data = res.getResult();
						System.out.println("response data size [en and com] : " + data.length);
						data = AES.decrypt(data, secretKey.getBytes(), algorithm);
						if (isGzip) {
							data = GZIPUtils.decompress(data);
						}
						System.out.println("response data size : " + data.length);
						result = new String(data, encode);
						System.out.println("response json: " + result);
					}
				} else {
					System.out.println("请求接口异常,请求码:" + res.getHttpCode());
				}
			} else {
				System.out.println("请求接口网络异常:" + res.getResultCode().getCode());
			}
		} catch (Exception e) {
			System.out.println("解析失败");
			e.printStackTrace();
		}
		ResultModel re = new ResultModel(code, result);
		return re;
	}

}

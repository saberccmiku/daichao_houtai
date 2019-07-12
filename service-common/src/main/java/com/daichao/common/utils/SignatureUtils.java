package com.daichao.common.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.Map;
import java.util.TreeMap;


import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

public class SignatureUtils {
	
	static final Logger logger = LoggerFactory.getLogger(SignatureUtils.class);
	
	//生产key
	private static String key = "MIGA0GSqGSIb3DQA";
//	private static String key = Global.getConfig("md5key");
//	private static String key = "2cAK6PIAVVEJQJXU";
	
	/**
	 * 校验签名
	 * @param signature
	 * @return
	 */
	public static boolean verifySign(Map<String,String> map){
		//获取响应的签名字符串
		String signStr = map.get("sign");
		map.remove("sign");
		map.put("key", key);
		//组装签名字符串
		String str = coverMapToString(map);
		String localSign = null;
	    try {
	    	localSign = DigestUtils.md5Hex(str);
	    	logger.info("签名====原文:{} 渠道方:{} 本地:{}", str, signStr ,localSign);
	    } catch (Exception e) {
	    	logger.info("数据签名失败！");
	        e.printStackTrace();
	        throw new RuntimeException("数据签名失败");
	    }
		//签名校验
		if(!signStr.equals(localSign)){			
			logger.info("返回数据签名校验失败！");
			return false;
		}
		return true;
	};
	
	/**
	 * 校验签名
	 * @param signature
	 * @return
	 */
	public static boolean verifySignature(Map<String,String> map){
		//获取响应的签名字符串
		String signatureStr = map.get("signature");
		map.remove("signature");
		//对响应参数进行签名并获取本地签名串
		String respStr = JSONObject.fromObject(signature(map)).toString();
		JSONObject respJson = JSONObject.fromObject(respStr);
		String localSignature = respJson.get("signature").toString();
		
		//签名校验
		if(!signatureStr.equals(localSignature)){			
			logger.info("返回数据签名校验失败！");
			return false;
		}
		return true;
	};
	
	
	/**
	 * 参数签名
	 * @param signMap(不含签名字段)
	 * @return respStr(含签名字段)
	 */
	public static String signature(Map<String,String> signMap){
		//加入签名参数key
		signMap.put("key", key);
		//组装签名字符串
		String str = coverMap2String(signMap);
		String signature = null;
	    try {
	        // 生成一个MD5加密计算摘要
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        // 计算md5函数
	        md.update(str.getBytes());
	        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
	        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
	        //BigInteger会将数值开始为0的抹去，需要判断补0
	        signature = fillMD5(new BigInteger(1, md.digest()).toString(16));
	    } catch (Exception e) {
	    	logger.info("数据签名失败！");
	        e.printStackTrace();
	        throw new RuntimeException("数据签名失败");
	    }
	    //移除签名参数，添加签名域
	    signMap.remove("key");
	    signMap.put("signature", signature.toUpperCase());
    	//参数排序
    	TreeMap<String, String> treeMap = new TreeMap<String, String>(signMap);
    	//获取签名json串
    	JSONObject jsonParam = JSONObject.fromObject(treeMap);
    	
		return jsonParam.toString();
	};
		
	/**
	 * 参数签名
	 * @param signMap(不含签名字段)
	 * @return treeMap(含签名字段)
	 */
	public static Map<String,String> signatureForMap(Map<String,String> signMap){
		//加入签名参数key
		signMap.put("key", key);
		//组装签名字符串
		String str = coverMap2String(signMap);
		String signature = null;
	    try {
	        // 生成一个MD5加密计算摘要
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        // 计算md5函数
	        md.update(str.getBytes());
	        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
	        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
	        //BigInteger会将数值开始为0的抹去，需要判断补0
	        signature = fillMD5(new BigInteger(1, md.digest()).toString(16));
	    } catch (Exception e) {
	    	logger.info("数据签名失败！");
	        e.printStackTrace();
	        throw new RuntimeException("数据签名失败");
	    }
	    //移除签名参数，添加签名域
	    signMap.remove("key");
	    signMap.put("signature", signature.toUpperCase());
	    //参数排序
    	TreeMap<String, String> treeMap = new TreeMap<String, String>(signMap);
		return treeMap;
	};
	
	
	/**
     * 数据map转换为String(含签名字段)
     * @param data
     * @return
     */
	public static String coverMap2String(Map<String, String> data) {
		TreeMap<String, String> tree = new TreeMap<String, String>();
		for (Map.Entry<String, String> ent : data.entrySet()) {
			tree.put((String) ent.getKey(), (String) ent.getValue());
		}
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, String> ent : tree.entrySet()) {
			sb.append((String) ent.getKey())
					.append('=')
					.append(ent.getValue() != null ? (String) ent.getValue()
							: "").append(',');
		}
		return sb.substring(0, sb.length() - 1);
	}
	
	/**
     * 数据map转换为String(含签名字段)
     * @param data
     * @return
     */
	public static String coverMapToString(Map<String, String> data) {
		TreeMap<String, String> tree = new TreeMap<String, String>();
		for (Map.Entry<String, String> ent : data.entrySet()) {
			if(StringUtils.isNotBlank(ent.getValue())) {
				tree.put((String) ent.getKey(), (String) ent.getValue());
			}
		}
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, String> ent : tree.entrySet()) {
			sb.append((String) ent.getKey())
					.append('=')
					.append(ent.getValue() != null ? (String) ent.getValue()
							: "").append('&');
		}
		return sb.substring(0, sb.length() - 1);
	}
	
	/**
	 * 
	 * @param md5
	 * @return
	 */
	public static String fillMD5(String md5){
	    return md5.length()==32?md5:fillMD5("0"+md5);
	}
	
	/**
     * URL请求参数解码
     * @param params
     * @return
     */
	public static String urlDecoderUtil(String params){
		String respStr = null;
		try {
			respStr = URLDecoder.decode(params, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return respStr;
	}
	
}

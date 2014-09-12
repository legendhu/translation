package com.xinguan.shasha.web.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;
//MD5+Base64
public class Encryption {
	public static String md5(String str){
		
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte rs[] = md.digest(str.getBytes());
			BASE64Encoder base64= new BASE64Encoder();
			String code = base64.encode(rs);
			return code;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}

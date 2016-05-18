package com.nine;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//数据库相关的util类
public class DBUtil {
	public static void setUserInfo(int ID, String name, Set favSet, Set labelSet, double latitude, double longtitude){
		
	}
	
	public static Map getUserInfo(int ID){
		HashMap<String, Object> userInfo = null;
		userInfo.put("name", "name");
		userInfo.put("favSet", "name");
		userInfo.put("labelSet", "name");
		userInfo.put("latitude", 1.0);
		userInfo.put("longtitude", 1.0);
		return userInfo;
	}
	
	public static String getName(int ID){
		return "Jack";
	}
	
	public static Set getFavSet(int ID){
		return null;
	}
	
	public static Set getLabelSet(int ID){
		return null;
	}
	
	public static double getLatitude(int ID){
		return 0.0;
	}
	
	public static double getLongtitude(int ID){
		return 0.0;
	}
}

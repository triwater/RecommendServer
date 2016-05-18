package com.nine;

import java.util.Set;

public class User {
	private String ID;
	private String name;
	private Set<String> favList;
	private Set<String> labelList;
	private double latitude;
	private double longtitude;
	
	private static double MaxDistance = 1000;//随便设置的
	
	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<String> getFavList() {
		return favList;
	}


	public void setFavList(Set<String> favList) {
		this.favList = favList;
	}


	public Set<String> getLabelList() {
		return labelList;
	}


	public void setLabelList(Set<String> labelList) {
		this.labelList = labelList;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongtitude() {
		return longtitude;
	}


	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}


	public double getSimilarity(int otherID){
		double similarity = this.getFavSimilarity(otherID)*0.3 + this.getLabelSimilarity(otherID)*0.3 + this.getLocationSimilarity(otherID)*0.4;
		return similarity;
	}
	
	private double getFavSimilarity(int otherID){
		Set<String> otherFavSet = DBUtil.getFavSet(otherID);
		return this.compareSets(this.favList, otherFavSet);
	}
	
	private double getLabelSimilarity(int otherID){
		Set<String> otherLabelSet = DBUtil.getLabelSet(otherID);
		return this.compareSets(this.labelList, otherLabelSet);
	}
	
	private double getLocationSimilarity(int otherID){
		double otherLatitude = DBUtil.getLatitude(otherID);
		double otherLongtitude = DBUtil.getLongtitude(otherID);
		double distance = Math.sqrt((this.latitude - otherLatitude)*(this.latitude - otherLatitude) + (this.longtitude - otherLongtitude)*(this.longtitude - otherLongtitude));
		return distance/MaxDistance;
	}
	
	//通过比较两个set中相同元素的个数得出相似度
	private double compareSets(Set<String> set1, Set<String> set2){
		int same = 0;
		for(String s:set1){
			if(set2.contains(s))
				same++;
		}
		switch(same){
		case 0:
			return 0.2;
		case 1:
			return 0.4;
		case 2:
			return 0.6;
		case 3:
			return 0.7;
		case 4:
			return 0.8;
		default:
			return 1.0;
		}
	}
}

package com.orange.Bean;

/**
 * @Author wff
 */

public class Tourism_Line {
	String route_num;//路线号
	String origin;// 起点
	String destination;//终点
	String day_num;//旅程天数
	String attractions;//主要景点
	@Override
	public String toString() {
		return "Tourism_Line [route_num=" + route_num + ", origin=" + origin + ", destination=" + destination
				+ ", day_num=" + day_num + ", attractions=" + attractions + "]";
	}
	public Tourism_Line(String route_num, String origin, String destination, String day_num, String attractions) {
		super();
		this.route_num = route_num;
		this.origin = origin;
		this.destination = destination;
		this.day_num = day_num;
		this.attractions = attractions;
	}
	public Tourism_Line() {
		super();
	}
	public String getRoute_num() {
		return route_num;
	}
	public void setRoute_num(String route_num) {
		this.route_num = route_num;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDay_num() {
		return day_num;
	}
	public void setDay_num(String day_num) {
		this.day_num = day_num;
	}
	public String getAttractions() {
		return attractions;
	}
	public void setAttractions(String attractions) {
		this.attractions = attractions;
	}
	
}

package com.orange.Bean;



/**
 * @Author wff
 */

public class Tourist {
	String tourist_num;//游客编号
	String user_id;//用户ID
	String tourist_name;//姓名
	String tourist_sex;//性别
	String tourist_age;//年龄
	String tourist_idCard;//身份证号码
	String tourist_address;//地址
	String tourist_phone;//联系电话
	String group_num;//旅游团号
	String accompanied;//陪同
	String accommodation;//食宿
	@Override
	public String toString() {
		return "Tourist [tourist_num=" + tourist_num + ", user_id=" + user_id + ", tourist_name=" + tourist_name
				+ ", tourist_sex=" + tourist_sex + ", tourist_age=" + tourist_age + ", tourist_idCard=" + tourist_idCard
				+ ", tourist_address=" + tourist_address + ", tourist_phone=" + tourist_phone + ", group_num="
				+ group_num + ", acompanied=" + accompanied + ", accommdation=" + accommodation + "]";
	}
	public Tourist(String tourist_num, String user_id, String tourist_name, String tourist_sex, String tourist_age,
			String tourist_idCard, String tourist_address, String tourist_phone, String group_num, String acompanied,
			String accommdation) {
		super();
		this.tourist_num = tourist_num;
		this.user_id = user_id;
		this.tourist_name = tourist_name;
		this.tourist_sex = tourist_sex;
		this.tourist_age = tourist_age;
		this.tourist_idCard = tourist_idCard;
		this.tourist_address = tourist_address;
		this.tourist_phone = tourist_phone;
		this.group_num = group_num;
		this.accompanied = acompanied;
		this.accommodation = accommdation;
	}
	public Tourist() {
		super();
	}
	public String getTourist_num() {
		return tourist_num;
	}
	public void setTourist_num(String tourist_num) {
		this.tourist_num = tourist_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTourist_name() {
		return tourist_name;
	}
	public void setTourist_name(String tourist_name) {
		this.tourist_name = tourist_name;
	}
	public String getTourist_sex() {
		return tourist_sex;
	}
	public void setTourist_sex(String tourist_sex) {
		this.tourist_sex = tourist_sex;
	}
	public String getTourist_age() {
		return tourist_age;
	}
	public void setTourist_age(String tourist_age) {
		this.tourist_age = tourist_age;
	}
	public String getTourist_idCard() {
		return tourist_idCard;
	}
	public void setTourist_idCard(String tourist_idCard) {
		this.tourist_idCard = tourist_idCard;
	}
	public String getTourist_address() {
		return tourist_address;
	}
	public void setTourist_address(String tourist_address) {
		this.tourist_address = tourist_address;
	}
	public String getTourist_phone() {
		return tourist_phone;
	}
	public void setTourist_phone(String tourist_phone) {
		this.tourist_phone = tourist_phone;
	}
	public String getGroup_num() {
		return group_num;
	}
	public void setGroup_num(String group_num) {
		this.group_num = group_num;
	}
	public String getAccompanied() {
		return accompanied;
	}
	public void setAccompanied(String accompanied) {
		this.accompanied = accompanied;
	}
	public String getAccommodation() {
		return accommodation;
	}
	public void setAccommodation(String accommdation) {
		this.accommodation = accommdation;
	}
	
}

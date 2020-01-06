package com.hcj.skin_tool;

/**皮肤大小枚举类
 * @author   HCJ
 * @date     2020年1月6日 上午9:57:36
 */
public enum SkinSize {

	ONE(1,"sProdImgNo_1", "215x120"), 
	TWO(2,"sProdImgNo_2", "1024x768"), 
	THREE(3,"sProdImgNo_3", "1280x720"), 
	FOUR(4,"sProdImgNo_4", "1280x1024"), 
	FIVE(5,"sProdImgNo_5", "1440x900"), 
	SIX(6,"sProdImgNo_6", "1920x1080"), 
	SEVEN(7,"sProdImgNo_7", "1920x1200"), 
	EIGHT(8, "sProdImgNo_8", "1920x1440");

	private Integer id;

	private String name;

	private String size;


	public Integer getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getSize() {
		return size;
	}


	private SkinSize(Integer id, String name, String size) {
		this.id = id;
		this.name = name;
		this.size = size;
	}

}

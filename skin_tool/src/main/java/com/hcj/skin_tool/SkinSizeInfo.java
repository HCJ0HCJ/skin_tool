package com.hcj.skin_tool;

import java.net.URLDecoder;

/**皮肤大小信息
 * @author   HCJ
 * @date     2020年1月6日 上午9:54:07
 */
public class SkinSizeInfo {

	/**
	 * sProdName : 皮肤名称
	 */
	private String sProdName;

	/**
	 * sProdImgNo_1 : 皮肤链接的字段
	 */
	private String sProdImgNo_1;

	/**
	 * sProdImgNo_2 : 皮肤链接的字段
	 */
	private String sProdImgNo_2;

	private String sProdImgNo_3;

	private String sProdImgNo_4;

	private String sProdImgNo_5;

	private String sProdImgNo_6;

	private String sProdImgNo_7;

	private String sProdImgNo_8;


	public String getsProdImgNo_1() throws Exception {
		return replaceCharacter(sProdImgNo_1);
	}


	public void setsProdImgNo_1(String sProdImgNo_1) {
		this.sProdImgNo_1 = sProdImgNo_1;
	}


	public String getsProdImgNo_2() throws Exception {
		return replaceCharacter(sProdImgNo_2);
	}


	public void setsProdImgNo_2(String sProdImgNo_2) {
		this.sProdImgNo_2 = sProdImgNo_2;
	}


	public String getsProdImgNo_3() throws Exception {
		return replaceCharacter(sProdImgNo_3);
	}


	public void setsProdImgNo_3(String sProdImgNo_3) {
		this.sProdImgNo_3 = sProdImgNo_3;
	}


	public String getsProdImgNo_4() throws Exception {
		return replaceCharacter(sProdImgNo_4);
	}


	public void setsProdImgNo_4(String sProdImgNo_4) {
		this.sProdImgNo_4 = sProdImgNo_4;
	}


	public String getsProdImgNo_5() throws Exception {
		return replaceCharacter(sProdImgNo_5);
	}


	public void setsProdImgNo_5(String sProdImgNo_5) {
		this.sProdImgNo_5 = sProdImgNo_5;
	}


	public String getsProdImgNo_6() throws Exception {
		return replaceCharacter(sProdImgNo_6);
	}


	public void setsProdImgNo_6(String sProdImgNo_6) {
		this.sProdImgNo_6 = sProdImgNo_6;
	}


	public String getsProdImgNo_7() throws Exception {
		return replaceCharacter(sProdImgNo_7);
	}


	public void setsProdImgNo_7(String sProdImgNo_7) {
		this.sProdImgNo_7 = sProdImgNo_7;
	}


	public String getsProdImgNo_8() throws Exception {
		return replaceCharacter(sProdImgNo_8);
	}


	public void setsProdImgNo_8(String sProdImgNo_8) {
		this.sProdImgNo_8 = sProdImgNo_8;
	}


	public String getsProdName() throws Exception {
		return URLDecoder.decode(sProdName, "UTF-8");
	}


	public void setsProdName(String sProdName) {
		this.sProdName = sProdName;
	}


	/**@author HCJ
	 * 根据传入的信息和大小获取链接
	 * @date 2020年1月6日 上午9:55:21
	 */
	public static String getSkinUrl(SkinSizeInfo skinSizeInfo, SkinSize skinSize) throws Exception {
		switch (skinSize) {
		case ONE:
			return skinSizeInfo.getsProdImgNo_1();
		case TWO:
			return skinSizeInfo.getsProdImgNo_2();
		case THREE:
			return skinSizeInfo.getsProdImgNo_3();
		case FOUR:
			return skinSizeInfo.getsProdImgNo_4();
		case FIVE:
			return skinSizeInfo.getsProdImgNo_5();
		case SIX:
			return skinSizeInfo.getsProdImgNo_6();
		case SEVEN:
			return skinSizeInfo.getsProdImgNo_7();
		case EIGHT:
			return skinSizeInfo.getsProdImgNo_8();
		default:
			break;
		}
		return null;
	}


	/**@author HCJ
	 * 还原链接特殊字符
	 * @date 2020年1月6日 上午9:56:00
	 */
	private String replaceCharacter(String content) {
		return content.replace("%3A", ":").replace("%2F", "/").replace("%2E", ".").replace("%5F", "_").replace("%2D", "-").replace("200", "0");
	}

}

package com.hcj.skin_tool;

/**存储多种大小皮肤的线程
 * @author   HCJ
 * @date     2020年1月6日 上午9:52:16
 */
public class getOptionalSkinThread extends Thread {

	/**
	 * number : 当前页的页码
	 */
	private int number;


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public getOptionalSkinThread(int number) {
		super();
		this.number = number;
	}


	@Override
	public void run() {
		try {
			getOptionalSkin getOptionalSkin = new getOptionalSkin();
			getOptionalSkin.savePicture(number);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

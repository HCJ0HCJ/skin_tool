package com.hcj.skin_tool;

import static com.hcj.skin_tool.Constant.*;

public class Main {

	public static void main(String[] args) throws Exception {
		/*for (int i = 0; i < PAGE_SIZE; i++) {
			getOptionalSkinThread getOptionalSkinThread = new getOptionalSkinThread(i);
			getOptionalSkinThread.start();
		}*/

		getOrdinarySkin getOrdinarySkin = new getOrdinarySkin();
		getOrdinarySkin.savePicture();
	}

}

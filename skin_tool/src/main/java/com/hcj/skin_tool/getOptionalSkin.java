package com.hcj.skin_tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import com.alibaba.fastjson.JSONObject;

import static com.hcj.skin_tool.Constant.*;

/**存储多种大小皮肤类
 * @author   HCJ
 * @date     2020年1月6日 上午9:58:41
 */
public class getOptionalSkin {

	private HttpHelper httpHelper = new HttpHelper();


	public getOptionalSkin() throws Exception {
		File path = new File(SKIN_PATH);
		if (!path.exists()) {
			path.mkdir();
		}
	}


	public void savePicture(int pageNum) throws Exception {
		List<SkinSizeInfo> skinSizeInfos = JSONObject.parseArray(JSONObject.parseObject(getPageInfo(pageNum)).getString("List"), SkinSizeInfo.class);
		for (SkinSizeInfo skinSizeInfo : skinSizeInfos) {
			File file = new File(SKIN_PATH + skinSizeInfo.getsProdName() + ".jpg");
			String action = SkinSizeInfo.getSkinUrl(skinSizeInfo, SKIN_SIZE);
			InputStream is = httpHelper.requestHttpInputStream(action, null);
			byte[] buffer = new byte[2048];
			int len;
			try (FileOutputStream os = new FileOutputStream(file)) {
				while ((len = is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
				os.flush();
				System.out.println(file.getName() + "已完成");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	private String getPageInfo(int pageNum) throws Exception {
		return httpHelper.requestHttpString(PREFIX_URL + pageNum + SUFFIX_URL, null);
	}

}

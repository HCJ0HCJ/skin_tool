package com.hcj.skin_tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.hcj.skin_tool.Constant.*;

/**获取皮肤大小为1920x882的类
 * @author   HCJ
 * @date     2020年1月6日 上午10:04:05
 */
public class getOrdinarySkin {

	private HttpHelper httpHelper = new HttpHelper();

	private List<HeroInfo> heroInfos;


	public getOrdinarySkin() throws Exception {
		heroInfos = JSONObject.parseArray(getHeroList(), HeroInfo.class);
		File path = new File(SKIN_PATH);
		if (!path.exists()) {
			path.mkdir();
		}
	}


	private String getHeroList() throws Exception {
		return httpHelper.requestHttpString(HERO_LIST_URL, null);
	}


	public void savePicture() throws Exception {
		for (HeroInfo heroInfo : heroInfos) {
			if (heroInfo.getSkinName() == null || "".equals(heroInfo.getSkinName())) {
				continue;
			}
			String[] skinName = heroInfo.getSkinName().split("\\|");
			for (int i = 1; i <= skinName.length; i++) {
				File file = new File(SKIN_PATH + heroInfo.getCname() + "-" + skinName[i - 1] + ".jpg");
				String action = SKIN_URL + heroInfo.getEname() + "/" + heroInfo.getEname() + "-bigskin-" + i + ".jpg";
				httpHelper.requestHttp(action, null, new Callback() {

					@Override
					public void onResponse(Call call, Response response) throws IOException {
						InputStream is = response.body().byteStream();
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


					@Override
					public void onFailure(Call call, IOException e) {

					}
				});
			}
		}
	}
}

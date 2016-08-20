package com.itlaborer.res;

import java.util.ArrayList;

import com.itlaborer.model.ApiDoc;
import com.itlaborer.model.ApiItem;
import com.itlaborer.model.ApiList;
import com.itlaborer.model.ApiPar;

public class XinzhiWeather {

	private ApiDoc apidoc;

	public XinzhiWeather() {

		this.apidoc = new ApiDoc();
		// 第一个接口
		ApiItem nowWeather = new ApiItem();
		nowWeather.setAddress("now.json");
		nowWeather.setName("天气实况");
		ArrayList<ApiPar> nowWeatherPars = new ArrayList<>();
		nowWeatherPars.add(new ApiPar("key", "API密钥", "lo5ujaa0pv5jtrkv"));
		nowWeatherPars.add(new ApiPar("location", "城市中文名 例如：location=北京", "北京"));
		nowWeather.setParameters(nowWeatherPars);
		// 第二个接口
		ApiItem daily = new ApiItem();
		daily.setAddress("daily.json");
		daily.setName("逐日预报和历史");
		ArrayList<ApiPar> hourly_historyPars = new ArrayList<>();
		hourly_historyPars.add(new ApiPar("key", "API密钥", "lo5ujaa0pv5jtrkv"));
		hourly_historyPars.add(new ApiPar("location", "城市中文名 例如：location=北京", "上海"));
		daily.setParameters(hourly_historyPars);
		
		// 加入接口列表
		ArrayList<ApiItem> apiItems = new ArrayList<ApiItem>();
		apiItems.add(nowWeather);
		apiItems.add(daily);

		// 心知分组
		ApiList xinzhi = new ApiList();
		xinzhi.setName("心知天气");
		xinzhi.setApi(apiItems);

		// 加入分组列表
		ArrayList<ApiList> apiList = new ArrayList<ApiList>();
		apiList.add(xinzhi);

		// 加入接口文档
		apidoc.setApilist(apiList);
		apidoc.setApi_version("V3");
		apidoc.setDecode_version("1.0");
	}

	public ApiDoc getApidoc() {
		return apidoc;
	}
}

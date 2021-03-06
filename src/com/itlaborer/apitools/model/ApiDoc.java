package com.itlaborer.apitools.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.itlaborer.apitools.utils.PubUtils;

/**
 * API文档类
 * 
 * @author liudewei[793554262@qq.com]
 * @version 1.1
 * @since 1.0
 */

public class ApiDoc {

	@JSONField(ordinal = 1)
	private Double decodeversion;
	@JSONField(ordinal = 2)
	private String name;
	@JSONField(ordinal = 3)
	private String version;
	@JSONField(ordinal = 4)
	private LinkedHashMap<String, String> publicpars;
	@JSONField(ordinal = 5)
	private String serverlist;
	@JSONField(ordinal = 6)
	private ArrayList<ApiMod> item;

	public ApiDoc() {

	}

	public Double getDecodeversion() {
		return decodeversion;
	}

	public void setDecodeversion(Double decode_version) {
		this.decodeversion = decode_version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getServerlist() {
		return serverlist;
	}

	public void setServerlist(String serverlist) {
		this.serverlist = serverlist;
	}

	public LinkedHashMap<String, String> getPublicpars() {
		return publicpars;
	}

	public void setPublicpars(LinkedHashMap<String, String> publicpars) {
		this.publicpars = publicpars;
	}

	public void setItem(ArrayList<ApiMod> item) {
		this.item = item;
	}

	public ArrayList<ApiMod> getItem() {
		return item;
	}

	public String toString() {
		return PubUtils.jsonFormat(JSON.toJSONString(this));
	}
}

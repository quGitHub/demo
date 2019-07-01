package cn.itcast.springboot.mybatis.entity;

import javax.persistence.Column;

public class ProvinceVo {

	private String pid;

	private String province;

	private String provinceTypes;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvinceTypes() {
		return provinceTypes;
	}

	public void setProvinceTypes(String provinceTypes) {
		this.provinceTypes = provinceTypes;
	}

}

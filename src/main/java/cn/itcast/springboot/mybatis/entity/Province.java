package cn.itcast.springboot.mybatis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="province")
public class Province  extends Bean{

	@Id
	@Column(name="pid")
	private String pid;
	
	@Column(name="province")
	private String province;
	
	@Column(name="provinceType")
	@NotEmpty
	private String provinceTypes;

	@Transient
	private String admin;
	
	
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
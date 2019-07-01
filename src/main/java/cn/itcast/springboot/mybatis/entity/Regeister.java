package cn.itcast.springboot.mybatis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="regeister")
public class Regeister {
	
	@Column(name="id")
	@NotEmpty
	private String id;

	@Column(name="tel",length=11)
	@NotEmpty
	private String tel;
	
	@Column(name="userName")
	@NotEmpty
	private String userName;
	
	@Column(name="passWord")
	@NotEmpty
	private String passWord;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}

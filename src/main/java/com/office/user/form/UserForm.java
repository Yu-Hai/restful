package com.office.user.form;

import com.office.common.form.CommonBaseForm;
import com.office.common.util.Bean2String;

public class UserForm extends CommonBaseForm {

	private String idUser;

	private String userName;

	private String password;

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return Bean2String.bean2String(this);
	}

}

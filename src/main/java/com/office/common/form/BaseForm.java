package com.office.common.form;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class BaseForm implements Form {

	private String returnFlag;

	private String returnMsg;

	public String getReturnFlag() {
		return returnFlag;
	}

	public void setReturnFlag(String returnFlag) {
		this.returnFlag = returnFlag;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub

	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

}

package com.office.common.form;

import com.office.common.constants.BusinessConstants;
import com.office.common.constants.ResponseCode;

/**
 * 公共类
 * 
 * @author Neo 2017-4-30
 */
public class CommonBaseForm extends BaseForm {
	
	
	public void setSuccess(){
		this.setReturnFlag(ResponseCode.RESPONSE_OK);
		this.setReturnMsg(BusinessConstants.RESPONSE_OK_MSG);
	}
	
	public void setError(){
		this.setReturnFlag(ResponseCode.RESPONSE_ERROR);
		this.setReturnMsg(BusinessConstants.RESPONSE_ERROR_MSG);
	}
	
	public void setError(String returnMsg){
		this.setReturnFlag(ResponseCode.RESPONSE_ERROR);
		this.setReturnMsg(returnMsg);
	}
	
	public void setValidate(){
		this.setReturnFlag(ResponseCode.VALIDATE_NOT_PASS);
		this.setReturnMsg(BusinessConstants.RESPONSE_VALIDATE_NOT_PASS_MSG);
	}
	
	public void setValidate(String returnMsg){
		this.setReturnFlag(ResponseCode.VALIDATE_NOT_PASS);
		this.setReturnMsg(returnMsg);
	}
	


}

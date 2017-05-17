package com.gdpu.controller.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gdpu.controller.rootcontroller.VoteRoot;
import com.gdpu.util.StringUtil;

public class NewVoteValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return VoteRoot.class.equals(clazz);
	}

	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "title", null, "必须输入投票标题！");
		VoteRoot voteRoot = (VoteRoot) obj;
		if (voteRoot.getContextcount()==null) {
			errors.rejectValue("contextcount", null, "必须输入投票选项个数！");
		}else if(voteRoot.getContextcount()<2||voteRoot.getContextcount()>10){
			errors.rejectValue("contextcount", null, "投票选项个数个数应在2~10");
		}
	}
}
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
		ValidationUtils.rejectIfEmpty(errors, "title", null, "��������ͶƱ���⣡");
		VoteRoot voteRoot = (VoteRoot) obj;
		if (voteRoot.getContextcount()==null) {
			errors.rejectValue("contextcount", null, "��������ͶƱѡ�������");
		}else if(voteRoot.getContextcount()<2||voteRoot.getContextcount()>10){
			errors.rejectValue("contextcount", null, "ͶƱѡ���������Ӧ��2~10");
		}
	}
}
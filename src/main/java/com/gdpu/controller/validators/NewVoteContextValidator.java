package com.gdpu.controller.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.gdpu.controller.rootcontroller.VoteContextRoot;


public class NewVoteContextValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return VoteContextRoot.class.equals(clazz);
	}

	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		VoteContextRoot voteContextRoot = (VoteContextRoot) obj;
		String[] context = voteContextRoot.getContext();
		 boolean flag = true;
		 for(int i=0;i<context.length;i++){
			 for(int j=i+1;j<context.length;j++){
				 if(context[i].equals(context[j])){
					 flag = false;
					 break;
				 }
			 }
			 if(flag==false){break;}
		 }
		 if(flag==false){
			 errors.rejectValue("context", null, "ͶƱѡ����ظ�");
		 }
		 for(int i =0;i<context.length;i++){
			 if(context[i].getBytes().length>30){
				 errors.rejectValue("context", null, "��ǸͶƱѡ��������Ҫ����10������");
			 };
		 }
		
	}
}
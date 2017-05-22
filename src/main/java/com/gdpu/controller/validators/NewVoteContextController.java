package com.gdpu.controller.validators;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdpu.controller.rootcontroller.VoteContextRoot;
import com.gdpu.util.repeat_form_validator.FormToken;


@Controller
public class NewVoteContextController {
	@InitBinder  
    public void initBinder(DataBinder binder) {  
       binder.setValidator(new NewVoteContextValidator());  
    }  
	
	@RequestMapping("vote/newVoteContextValidate")
	public String newVoteContextValidate(@Valid VoteContextRoot voteContextRoot,BindingResult result,HttpServletRequest request){
		 if (result.hasErrors()){
			 request.setAttribute("error", result.getFieldError("context").getDefaultMessage());
	           return "vote/newvote";} 
	     return "forward:/vote/newVoteContext.do"; 
	}
	

}

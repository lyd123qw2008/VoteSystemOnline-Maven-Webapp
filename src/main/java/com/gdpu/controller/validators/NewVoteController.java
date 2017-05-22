package com.gdpu.controller.validators;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdpu.controller.rootcontroller.VoteRoot;



@Controller
public class NewVoteController {
	@InitBinder  
    public void initBinder(DataBinder binder) {  
       binder.setValidator(new NewVoteValidator());  
    }  
	@RequestMapping("vote/newVoteValidate")
	public String newvoteValidate(@Valid VoteRoot voteRoot,BindingResult result,HttpServletRequest request){
		 if (result.hasErrors()){
	           return "/vote/newvote";}
		 int Contextcount = voteRoot.getContextcount();
		 List<String> list = new ArrayList<String>();
		 for(int i = 1;i<=Contextcount;i++){
			 list.add(String.valueOf(i));
		 }
		 request.setAttribute("list", list);
	     return "forward:/vote/newVote.do"; 
	}
	

}

package com.main.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ActorOperationController 
{
	
    @GetMapping("/getWish/{name}/{id}")
	public ResponseEntity<String> getWishMessage(@PathVariable String name, @PathVariable Integer id)
	{
    	String wish = null;
    	LocalDateTime ldt = LocalDateTime.now();
    	int hour = ldt.getHour();
    	wish = hour<12?"Good Morning-"+name+" and  your id is-: "+id:hour<16?"Good Afternoon-"+name+" and your id is- : "+id:
    		   hour<18?"Good Evening-"+name+" and your id is- : "+id:"Good Night-"+name+" and your id is- : "+id;
		
    	return new ResponseEntity<String>(wish,HttpStatus.OK);
	}
}

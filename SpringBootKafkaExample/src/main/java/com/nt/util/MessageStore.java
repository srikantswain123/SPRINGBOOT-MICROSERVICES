package com.nt.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MessageStore {
	
	List<String> ls=new ArrayList();
	
	public void storeMsg(String msg) {
		ls.add(msg);
	}
	
	public String readMsg() {
		return ls.toString();
	}

}

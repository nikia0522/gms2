package com.gms.web.command;

import com.gms.web.constants.Extension;
import com.gms.web.constants.Path;

import lombok.Getter;
import lombok.Setter;

public class Command implements Commandable{
	@Getter 
	protected String action, pageNumber, view;
	
	@Getter @Setter
	protected String dir, startRow, endRow, page, column, search;
	
	public void setPageNumber(String pageNumber){
		this.pageNumber=(pageNumber==null)?"1":pageNumber;
		System.out.println("페이지번호:"+pageNumber);
	}
	public void setAction(String action){
		this.action=(action==null)?"move":action;
		System.out.println("액션:"+action);
		
	}
	@Override
	public void process() {
		this.view= 
				(dir.equals("home"))?"/WEB-INF/view/common/home.jsp":Path.VIEW +dir+Path.SEPARATOR+page+Extension.JSP;
		System.out.println("이동페이지:"+view);
	}
	
	@Override
	public String toString() {
		return "Command [DEST="+dir+"/"+page+".jsp"+",ACTION="+action+ "]";
	}

}

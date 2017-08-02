package com.gms.web.command;

import com.gms.web.constants.Extension;
import com.gms.web.constants.Path;

public class Command implements Commandable{
	protected String dir, action, page, view;

	public String getView() {
		return view;
	}

	public String getDirectory() {
		return dir;
	}

	public void setDirectory(String directory) {
		this.dir = directory;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@Override
	public void process() {
		this.view= Path.VIEW +dir+Path.SEPARATOR+page+Extension.JSP;
	}
	
	@Override
	public String toString() {
		return "Command [DEST="+dir+"/"+page+".jsp"+",ACTION="+action+ "]";
	}

}

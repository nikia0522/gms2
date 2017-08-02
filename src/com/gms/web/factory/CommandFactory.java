package com.gms.web.factory;

import com.gms.web.command.*;
import com.gms.web.constants.Action;

public class CommandFactory {
	public static Command createCommand(
		String dir,String action,String page){
		Command cmd=null;
		switch (action) {
		case Action.MOVE: case Action.LOGIN: 
			cmd=new MoveCommand(dir,action,page);break;
		
			
		default:System.out.println("Command Fail");
			break;
		}
		return cmd;
	}
}

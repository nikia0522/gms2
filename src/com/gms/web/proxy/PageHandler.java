package com.gms.web.proxy;
//이벤트를 처리하는 기능

public class PageHandler {


	public static int[] attr(PageProxy pxy){
		int[]result=new int[2];
		int startRow = 0, endRow = 0;
		if (pxy.getPageNumber() <= pxy.getTheNumberOfRows() / pxy.getPageSize() +1){
			if (pxy.getPageNumber() ==1){
				startRow=1;
				endRow=pxy.getPageSize();
			}else{
				startRow=(pxy.getPageNumber()-1) * pxy.getPageSize() +1;
				endRow=pxy.getPageNumber()*pxy.getPageSize();
			}
		}
		result[0]=startRow;
		result[1]=endRow;
		
		return result;
	}
}

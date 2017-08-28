package com.gms.web.dao;

import java.util.List;
import java.util.Map;

import com.gms.web.domain.MemberBean;

public interface MemberDAO {
	public String insert(Map<?, ?>map); // 객체에 대한 setter (void, parameter 있음)
	public String countMembers(); //getter (return type 있고 parameter 없음)
	public List<?> selectAll(Object o); //getter (return type 있고 parameter 없음)
	public MemberBean selectById(String id); //보안사항이 아니기때문에 public으로..
	public List<?> selectByName(String name);
	public String updatePass(MemberBean member);
	public String deleteMember(String id); //int- 성공여부를 알려주는것임
}

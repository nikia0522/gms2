package com.gms.web.service;

import java.util.List;
import java.util.Map;

import com.gms.web.domain.MemberBean;

public interface MemberService {
	public String addMember(Map<String, Object> map); // 객체에 대한 setter (void, parameter 있음)
	public String countMembers(); //getter (return type 있고 parameter 없음)
	public List<?> list(Object o); //getter (return type 있고 parameter 없음)
	public MemberBean findById(String id); //보안사항이 아니기때문에 public으로..
	public List<?> findByName(String name);
	public String modify(MemberBean member);
	public String remove(String id);
	public Map<String,Object> login(MemberBean member);

}

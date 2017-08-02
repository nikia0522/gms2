package com.gms.web.service;

import java.util.List;

import com.gms.web.domain.MemberBean;

public interface MemberService {
	public String addMember(MemberBean member); // 객체에 대한 setter (void, parameter 있음)
	public String countMembers(); //getter (return type 있고 parameter 없음)
	public List<MemberBean> getMembers(); //getter (return type 있고 parameter 없음)
	public MemberBean findById(String id); //보안사항이 아니기때문에 public으로..
	public List<MemberBean> findByName(String name);
	public String modify(MemberBean member);
	public String remove(String id);
	public String login(MemberBean member);
}

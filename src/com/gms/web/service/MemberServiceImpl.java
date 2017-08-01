package com.gms.web.service;
import java.util.ArrayList;
import java.util.List;

import com.gms.web.dao.MemberDAOImpl;
import com.gms.web.domain.MemberBean;
import com.gms.web.service.MemberService;

public class MemberServiceImpl implements MemberService{
	public static MemberServiceImpl getInstance(){
		return new MemberServiceImpl();
	}
	private MemberServiceImpl(){}
	
	@Override
	public String addMember(MemberBean member) {
		return (MemberDAOImpl.getInstance().insert(member).equals("1"))? "성공":"실패";
	}
		
	@Override
	public List<MemberBean> getMembers() {		
		return (MemberDAOImpl.getInstance().selectAll());
	}
	
	@Override
	public String countMembers() {
		return String.valueOf(MemberDAOImpl.getInstance().countMembers());
	}
	
	@Override
	public MemberBean findById(String id) {	
		return MemberDAOImpl.getInstance().selectById(id);
	}

	@Override
	public List<MemberBean> findByName(String name) {
		return MemberDAOImpl.getInstance().selectByName(name);
	}

	@Override
	public String modify(MemberBean member) {		
		int rs=Integer.parseInt(MemberDAOImpl.getInstance().updatePass(member));
		return (rs==1)?"성공":"실패";
	}
	
	@Override
	public String remove(String id) {
		int rs=Integer.parseInt(MemberDAOImpl.getInstance().deleteMember(id));
		return (rs==1)?"실패":"성공";
	}
}


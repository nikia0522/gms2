package com.gms.web.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gms.web.dao.MemberDAOImpl;
import com.gms.web.domain.MajorBean;
import com.gms.web.domain.MemberBean;
import com.gms.web.service.MemberService;

public class MemberServiceImpl implements MemberService{
	public static MemberServiceImpl getInstance(){
		return new MemberServiceImpl();
	}
	private MemberServiceImpl(){}
	
	@Override
	public String addMember(Map<String, Object> map) {
		System.out.println("member service 진입");
		MemberBean m=(MemberBean)map.get("member");
		System.out.println("넘어온 회원 정보:"+m.toString());
		@SuppressWarnings("unchecked")
		List<MajorBean>list=(List<MajorBean>)map.get("major");
		System.out.println("넘어온 수강과목:"+list);
		
		return null;
	}
	//(MemberDAOImpl.getInstance().insert(member).equals("1"))? "성공":"실패"
		
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
	@Override
	public Map<String,Object> login(MemberBean member) {
		Map<String,Object> map=new HashMap<>();
		MemberBean mem=findById(member.getId());
		System.out.println("아이디야~~" + member.getId());
		String page=(mem!=null)?((member.getPassword().equals(mem.getPassword()))?"main":"login_fail"):"join";
		System.out.println("비번:::::"+member.getPassword());
		/*3항 2번 쓴거*/	
		map.put("page", page);
		map.put("user", mem);
		return map;
		}
}


package com.gms.web.dao;
import java.util.ArrayList;
import java.util.List;

import com.gms.web.constants.DB;
import com.gms.web.constants.SQL;
import com.gms.web.constants.Vendor;
import com.gms.web.dao.MemberDAO;
import com.gms.web.domain.MemberBean;
import com.gms.web.factory.DatabaseFactory;

import java.sql.*;

public class MemberDAOImpl implements MemberDAO{
	public static MemberDAOImpl getInstance() {
		return new MemberDAOImpl();}
	private MemberDAOImpl(){} 
	@Override
	public String insert(MemberBean member) {
		int rs=0;
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_INSERT);
			pstmt.setString(1,member.getId());
			pstmt.setString(2,member.getName());
			pstmt.setString(3,member.getPassword());
			pstmt.setString(4,member.getSsn());
			rs=pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.valueOf(rs);	
	}

	@Override
	public String countMembers() {
		int count=0;
		try {
			ResultSet rs=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_COUNT).executeQuery();			
			if(rs.next()){
				count=rs.getInt("count");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.valueOf((count));
	}

	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean>list=new ArrayList<>();
		try {
			ResultSet rs=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_LIST).executeQuery();
			MemberBean member=null; //지역변수는 반드시 초기화
			while(rs.next()){ //여러개 호출하기 때문에 while loop
				member=new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				list.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}

	@Override
	public MemberBean selectById(String id) {
		MemberBean member=null;
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_FINDBYID);
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				member=new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setPassword(rs.getString(DB.MEMBER_PASS));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}

	@Override
	public List<MemberBean> selectByName(String name) {
		List<MemberBean> nameList=new ArrayList<>();
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_FINDBYNAME);
			pstmt.setString(1,name);
			ResultSet rs=pstmt.executeQuery();
			MemberBean member=null; //지역변수는 반드시 초기화
			while(rs.next()){ //여러개 호출하기 때문에 while loop
				member=new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				nameList.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return nameList;
	}

	@Override
	public String updatePass(MemberBean member) {
		String rs="";;
		try {
			PreparedStatement psmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_UPDATE);
			psmt.setString(1, member.getPassword());
			psmt.setString(2, member.getId());
			rs=String.valueOf(psmt.executeUpdate());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.valueOf(rs);

		
	}

	@Override
	public String deleteMember(String id) {
		String rs="";
		try {
			PreparedStatement psmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_DELETE);
			psmt.setString(1,id);
			rs=String.valueOf(psmt.executeUpdate());		
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.valueOf(rs);
	}

}

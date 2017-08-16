package com.gms.web.constants;

public class SQL {
	public static final String MEMBER_INSERT=String.format("INSERT INTO %s(%s,%s,%s,%s,%s)VALUES(?,?,?,?,SYSDATE)", DB.TABLE_MEMBER,DB.MEMBER_ID, DB.MEMBER_NAME, DB.MEMBER_PASS, DB.MEMBER_SSN,DB.REGDATE);
	public static final String MEMBER_LIST=String.format("SELECT * FROM %s",DB.TABLE_MEMBER);
	public static final String MEMBER_FINDBYNAME=String.format("SELECT * FROM %s WHERE %s?", DB.TABLE_MEMBER, DB.MEMBER_NAME);
	public static final String MEMBER_FINDBYID=String.format("SELECT * FROM %s WHERE %s=?", DB.TABLE_MEMBER, DB.MEMBER_ID);
	public static final String MEMBER_COUNT=String.format(String.format("SELECT COUNT(*) AS	%s FROM %s","count", DB.TABLE_MEMBER));
	public static final String MEMBER_UPDATE=String.format("UPDATE %s SET %s=? WHERE %s=?", DB.TABLE_MEMBER, DB.MEMBER_PASS, DB.MEMBER_ID);
	public static final String MEMBER_DELETE=String.format("DELETE FROM %s WHERE %s=?", DB.TABLE_MEMBER, DB.MEMBER_ID);
	
	public static final String BOARD_INSERT=String.format("INSERT INTO %s(%s,%s,%s,%s,%s,%s) VALUES (article_seq.nextval,?,?,?,0,SYSDATE)",DB.TABLE_BOARD,DB.BOARD_ARTICLE_SEQ,DB.MEMBER_ID, DB.BOARD_TITLE, DB.BOARD_CONTENT, DB.BOARD_HITCOUNT,DB.REGDATE);
	public static final String BOARD_COUNT=String.format("SELECT COUNT(*) AS %s FROM %s","count", DB.TABLE_BOARD);
	public static final String BOARD_LIST=String.format("SELECT * FROM %s",DB.TABLE_BOARD);
	public static final String BOARD_FINDBYID=String.format("SELECT * FROM %s WHERE %s=?", DB.TABLE_BOARD,DB.MEMBER_ID);
	public static final String BOARD_FINDBYSEQ=String.format("SELECT * FROM %s WHERE %s=?",DB.TABLE_BOARD, "article_seq");
	public static final String BOARD_UPDATE=String.format("UPDATE %s SET %s=?,%s=? WHERE %s=?", DB.TABLE_BOARD, DB.BOARD_TITLE, DB.BOARD_CONTENT, DB.BOARD_ARTICLE_SEQ);
	public static final String BOARD_DELETE=String.format("DELETE FROM %s WHERE %s=?", DB.TABLE_BOARD,DB.BOARD_ARTICLE_SEQ);
}
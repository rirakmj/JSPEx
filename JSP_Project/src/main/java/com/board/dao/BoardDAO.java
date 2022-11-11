package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.board.dto.BoardDTO;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	//��񿬰�
	private  Connection getConnection() throws Exception {
		Context  initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource  ds = (DataSource)envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
}

	// �߰�
		public void boardInsert(BoardDTO bi) {
			Connection con = null;
			PreparedStatement ps = null;
			
			try {
				con = getConnection();
				String sql = "insert into board(num,writer,subject,email,content,ip,passwd) "
						+ " values(board_seq.nextval,?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1,bi.getWriter());
				ps.setString(2,bi.getSubject());
				ps.setString(3,bi.getEmail());
				ps.setString(4,bi.getContent());
				ps.setString(5,bi.getIp());
				ps.setString(6,bi.getPasswd());
				ps.executeUpdate();  
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				closeConnection(con,ps,null,null);
			}
		}
	
	// ��ü����
	public ArrayList<BoardDTO> boardList() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<BoardDTO> arr = new ArrayList<BoardDTO>();
	
	try {
		con=getConnection();
		String sql = "select * from board order by num desc";
		st=con.createStatement();
		rs=st.executeQuery(sql);
		while(rs.next()) {
			BoardDTO board = new BoardDTO();
			board.setNum(rs.getInt("num"));
			board.setSubject(rs.getString("subject"));
			board.setWriter(rs.getString("writer"));
			board.setReg_date(rs.getString("Reg_date"));
			board.setReadcount(rs.getInt("readcount"));
			arr.add(board);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		closeConnection(con, null, st, rs);
	}
	return arr;
	}

	// �󼼺���
	public BoardDTO findByNum(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		BoardDTO board = null;
	
	try {
		con = getConnection();
	    String sql = "select * from board where num="+num;
	    st=con.createStatement();
		rs=st.executeQuery(sql);
	    if(rs.next()) {
	    	board = new BoardDTO();
	    	board.setContent(rs.getString("content"));
	    	board.setEmail(rs.getString("email"));
	    	board.setIp(rs.getString("num"));
	    	board.setPasswd(rs.getString("passwd"));
	    	board.setReadcount(rs.getInt("readcount"));
	    	board.setReg_date(rs.getString("reg_date"));
	    	board.setSubject(rs.getString("subject"));
	    	board.setWriter(rs.getString("writer"));
	     }	
	    } catch (Exception e) {
			e.printStackTrace();
	    }
	return board;
	}
	
	// �Խñ� ��
	public int getCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			con=getConnection();
		    String sql = "select count(*) from board";
		    st = con.createStatement();
		    rs = st.executeQuery(sql);
		    if(rs.next()) {
		    	count = rs.getInt(1);
		    }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return count;
	}
	
	private void closeConnection(Connection con, PreparedStatement ps, Statement st, ResultSet rs) {
		try {
			if(con !=null) 			con.close();
			if(ps !=null) 				ps.close();
			if(st !=null) 				st.close();
			if(rs !=null) 				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
package com.jqueryAddress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class JAddressDAOImpl  implements JAddressDAO{
	private static JAddressDAO instance = new JAddressDAOImpl();
	public static JAddressDAO getInstance() {
		return instance;
	}
	//��񿬰�
	private  Connection getConnection() throws Exception {
		Context  initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource  ds = (DataSource)envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}
	@Override
	public void insert(AddressVO avo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			// ȫ�浿   111 �λ� 010-1111-2222
			String sql = "insert into address(num,name, zipcode, addr, tel) "
					+ " values(address_seq.nextval,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, avo.getName());
			ps.setString(2,avo.getZipcode());
			ps.setString(3,  avo.getAddr());
			ps.setString(4, avo.getTel());
			ps.executeUpdate();  
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,ps, null, null);
		}
		
	}

	@Override
	public ArrayList<AddressVO> list() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<AddressVO> arr   = new ArrayList<AddressVO>();
	
		try {
			con = getConnection();
			
			String	sql = "select * from address order by num desc"; //�˻��ƴ�
			
			st = con.createStatement();
			rs= st.executeQuery(sql);
			while(rs.next()) {
				AddressVO ad = new AddressVO();
				ad.setAddr(rs.getString("addr"));
				ad.setName(rs.getString("name"));
				ad.setNum(rs.getInt("num"));
				ad.setTel(rs.getString("tel"));
				ad.setZipcode(rs.getString("zipcode"));
				arr.add(ad);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		return arr;
	}

	@Override
	public AddressVO findByNum(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		AddressVO avo = null;
		try {
			con = getConnection();
			String sql = "select * from address where num="+num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				 avo = new AddressVO();
				avo.setAddr(rs.getString("addr"));
				avo.setName(rs.getString("name"));
				avo.setNum(rs.getInt("num"));
				avo.setTel(rs.getString("tel"));
				avo.setZipcode(rs.getString("zipcode"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		return avo;
	}

	@Override
	public int getCount() {
         Connection con = null;
         Statement st = null;
         ResultSet rs = null;
         int count = 0;
         
         try {
			con =getConnection();
			String sql = "select count(*) from address";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				 count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		return count;
	}

	@Override
	public void update(AddressVO avo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String sql = "update  address "
					+ " set name=?, addr=?, tel=?, zipcode=? where num=?";
			System.out.println(sql);
			ps = con.prepareStatement(sql);
			ps.setString(1, avo.getName());
			ps.setString(2, avo.getAddr());
			ps.setString(3, avo.getTel());
			ps.setString(4, avo.getZipcode());
			ps.setInt(5, avo.getNum());
			ps.executeUpdate();
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			closeConnection(con, ps, null, null);
		}
		
	}

	@Override
	public void delete(int num) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = getConnection();
			String sql = "delete from address where num="+num;
			st = con.createStatement();
			st.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, null);
		}
		
		
	}
	
	@Override
	public ArrayList<ZipCodeVO> getZipcode(String dong) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<ZipCodeVO> zarr = new ArrayList<ZipCodeVO>();
		
		 try {
			con =getConnection();
			String sql = "select * from zipcode where dong like '%"+dong+"%'";
			System.out.println(sql);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ZipCodeVO z = new ZipCodeVO();
				z.setBunji(rs.getString("bunji"));
				z.setDong(rs.getString("dong"));
				z.setGugun(rs.getString("gugun"));
				z.setSeq(rs.getInt("seq"));
				z.setSido(rs.getString("sido"));
				z.setZipcode(rs.getString("zipcode"));
				zarr.add(z);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
			return zarr;
	}

	
	// �ݱ�
	private void closeConnection(Connection con, PreparedStatement ps,
			Statement st, ResultSet rs) {
			try {
				if(con !=null) 			con.close();
				if(ps !=null) 				ps.close();
				if(st !=null) 				st.close();
				if(rs !=null) 				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	//��ü����(�˻�)
	@Override
	public ArrayList<AddressVO> searchList(String field, String word) {
	    Connection con = null;
	    Statement st = null;
	    ResultSet rs = null;
	    ArrayList<AddressVO> arr = new ArrayList<AddressVO>();
	    
	    try {
			con =getConnection();
			String sql = "select * from address where "+field +" like '%"+word+"%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				AddressVO avo = new AddressVO();
				avo.setAddr(rs.getString("addr"));
				avo.setName(rs.getString("name"));
				avo.setNum(rs.getInt("num"));
				avo.setTel(rs.getString("tel"));
				avo.setZipcode(rs.getString("zipcode"));
				arr.add(avo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		return arr;
	}
	//����(�˻�)
	@Override
	public int getCount(String field, String word) {
		Connection con =null;
		Statement st = null;
		ResultSet rs = null;
		int count =0;
		
		try {
			con =getConnection();
			String sql="select count(*) from address where "+field +" like '%"+word+"%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
	
		return count;
	}

}

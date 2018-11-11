package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Items;
import util.ConnectionFactory;

// 商品业务逻辑
public class ItemsDao {
	/**
	 * 获取所有的商品信息
	 * @return
	 */
	public ArrayList<Items> getAllItems(){
		ArrayList<Items> list = new ArrayList<Items>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		conn = ConnectionFactory.getInstance().makeConnection();
		String sql = "select * from items";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Items item = new Items();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setNumber(rs.getInt("number"));
				item.setPrice(rs.getInt("price"));
				item.setPicture(rs.getString("picture"));
				
				list.add(item);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(ps != null) {
				try {
					ps.close();
					ps = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	/**
	 * 根据商品编号获取商品信息
	 * @param id
	 * @return
	 */
	public Items getItemsById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		conn = ConnectionFactory.getInstance().makeConnection();
		String sql = "select * from items where id=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				Items item = new Items();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setNumber(rs.getInt("number"));
				item.setPrice(rs.getInt("price"));
				item.setPicture(rs.getString("picture"));
				return item;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(ps != null) {
				try {
					ps.close();
					ps = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public ArrayList<Items> getViewList(String list){
		ArrayList<Items> itemList = new ArrayList<Items>();
		int iCount = 5;
		
		if(list!=null&&list.length()>0) {
			String[] arr = list.split("#");
			if(arr.length>=5) 			{
				for(int i=arr.length-1;i>=arr.length-iCount;i--) 
				{
					itemList.add(getItemsById(Integer.parseInt(arr[i])));
					
				}
			}else			{
				for(int i=arr.length-1; i>=0; i--) 				{
					itemList.add(getItemsById(Integer.parseInt(arr[i])));
				}
			}
			return itemList;
			
		}else {
			return null;
		}
	}
}

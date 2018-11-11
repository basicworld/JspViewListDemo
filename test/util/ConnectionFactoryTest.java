package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Items;

public class ConnectionFactoryTest {
	public static void main(String[] args) {
		Connection conn = ConnectionFactory.getInstance().makeConnection();
		String sql = "select * from items";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Items items = new Items();
				items.setId(rs.getInt("id"));
				items.setName(rs.getString("name"));
				items.setCity(rs.getString("city"));
				items.setPrice(rs.getInt("price"));
				items.setNumber(rs.getInt("number"));
				items.setPicture(rs.getString("picture"));
				System.out.println(items.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

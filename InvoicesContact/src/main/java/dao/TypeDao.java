package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modele.ConnectionBDD;
import modele.Type;

public class TypeDao implements Interface <Type> {
	
	@Override
	public boolean Create(Type object) {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		try {
			PreparedStatement sql = connect.prepareStatement("INSERT INTO type (type_mission) VALUES(?)");
			
			sql.setString(1, object.getType_mission());
			
			sql.executeUpdate();
			sql.close();
			connect.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return false;
	}

	@Override
	public ArrayList<Type> Read() {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		ArrayList<Type> typeTab = new ArrayList<Type>();
		try {

			PreparedStatement sql = connect.prepareStatement("SELECT * FROM type");
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				
				//creer un type
				Type newType=new Type();
				
				newType.setId_type(rs.getInt("id_type"));
				newType.setType_mission(rs.getString("type_mission"));
				
				

				typeTab.add(newType);
			}
			sql.close();
			rs.close();
			connect.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return typeTab;
	}

	@Override
	public boolean Update(Type object) {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		try {
			PreparedStatement sql = connect.prepareStatement("Update type SET type_mission=? WHERE id_type=?");
			
			sql.setString(1, object.getType_mission());
			sql.setInt(2, object.getId_type());
			
			sql.executeUpdate();
			sql.close();
			connect.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return false;
	}

	@Override
	public boolean Delete(Type object) {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		try {
			PreparedStatement sql = connect.prepareStatement("DELETE FROM type WHERE id_type=?");
			
			sql.setInt(1, object.getId_type());
			
			sql.executeUpdate();
			sql.close();
			connect.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return false;
	}

	@Override
	public ArrayList<Type> Findby(Type object) {
		// TODO Auto-generated method stub
		return null;
	}

}

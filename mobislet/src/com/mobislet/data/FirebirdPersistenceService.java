package com.mobislet.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mobislet.address.Address;
import com.mobislet.brand.Brand;
import com.mobislet.contact.Contact;
import com.mobislet.discovery.Discovery;
import com.mobislet.mall.Mall;
import com.mobislet.store.Store;

public class FirebirdPersistenceService extends PersistenceGateway{
	private static Connection connection;
	
	static {
        openConnection();
    }
	
	private static void openConnection(){
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            connection = DriverManager.getConnection("jdbc:firebirdsql://localhost:3050/C:/Users/kutay/Documents/mobisletDB.fdb","sysdba", "masterkey");
        } catch (Exception e) {
        	try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
	}
	
	private static Connection getConnection(){
		if (connection == null){
			openConnection();
		}
		
		return connection;
	}
	
	@Override
	public Brand getBrand(Long brandId) {
		Statement statement;
		ResultSet resultSet = null;
		Brand brand = null;
		try {
			statement = getConnection().createStatement();
			resultSet = statement.executeQuery("SELECT * FROM BRAND WHERE BRAND_ID = " + brandId);
			
			while (resultSet.next()) {
				brand = new Brand();
				brand.setName(resultSet.getString("NAME"));
				brand.setImage(resultSet.getString("IMAGE"));

	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return brand;
	}
	
	
	public Long addMall(Mall mall) {
		Long id = null;
		try {
			PreparedStatement pst = getConnection().prepareStatement("INSERT INTO MALL VALUES(?,?,?,?,?,?,?,?,?)");
			pst.setLong(1,0L);
			pst.setString(2,mall.getName());
			pst.setString(3,mall.getDscr());
			pst.setLong(4,mall.getAddress().getId());
			pst.setString(5,mall.getAddressDscr());
			pst.setString(6,mall.getImage());
			pst.setBigDecimal(7,mall.getLatitude());
			pst.setBigDecimal(8,mall.getLongitude());
			pst.setBigDecimal(9,mall.getAltitude());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public Long addAddress(Address address) {
		Long id = null;
		try {
			PreparedStatement pst = getConnection().prepareStatement("INSERT INTO ADDRESS VALUES(?,?,?,?,?,?,?,?) RETURNING ADDRESS_ID");
			pst.setLong(1,0L);
			pst.setString(2,address.getCity());
			pst.setString(3,address.getTown());
			pst.setString(4,address.getDistrict());
			pst.setString(5,address.getNeighborhood());
			pst.setString(6,address.getStreet());
			pst.setString(7,address.getAddresLine());
			pst.setInt(8,address.getPostcode());
			
			ResultSet rs = pst.executeQuery();
			
			if ( rs != null )
		    {
				rs.next ();
		        id = rs.getLong(1);
		        rs.close ();
		    }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
    
	public void deleteAddress(Long addressId) {
		
	}

	@Override
	public Long addContact(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMallContactRel(Long mallID, Long contactID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addStoreContactRel(Long storeID, Long contactID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Long> getAllMallIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mall getMall(Long mallId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Discovery getDiscovery(String mallIdStr, String storeIdStr,
			String campaignIdStr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long addBrand(Brand brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long addStore(Store store) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
}
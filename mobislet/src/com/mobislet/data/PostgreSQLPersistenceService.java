package com.mobislet.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mobislet.address.Address;
import com.mobislet.brand.Brand;
import com.mobislet.mall.Mall;

public class PostgreSQLPersistenceService extends PersistenceGateway {
private static Connection connection;
	
	static {
        try {
			openConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	private static void openConnection() throws Exception{
        try {
        	Class.forName("org.postgresql.Driver");
            //jdbc:postgresql://<host>:<port>/<dbname>  user=<username>&password=<password> &ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory
        	
        	Properties dbProps = new Properties();
        	dbProps.put("user", "xmdkaeaoeagkwi");
        	dbProps.put("password", "Er7AglOIMdPDbrzkIW3gF5-Cn-");
        	dbProps.put("ssl", "true");
        	dbProps.put("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        	dbProps.put("sslmode","require");
        	
            connection = DriverManager.getConnection("jdbc:postgresql://ec2-54-195-252-202.eu-west-1.compute.amazonaws.com:5432/d6sugsav98s83p", dbProps);
        } catch (Exception e) {
        	try {
        		if(connection != null)
        			connection.close();
        		
                throw e;
            } catch (Exception ex) {
                throw ex;
            }
        }
	}
	
	private static Connection getConnection(){
		try {
			if (connection == null || connection.isClosed()){
				openConnection();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	
	public void addMall(Mall mall) {
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
	}
	/*
	public Long addAddress(Address address) {
		Long id = null;
		try {
			PreparedStatement pst = getConnection().prepareStatement("INSERT INTO MOBISLET.ADDRESS VALUES(?,?,?,?,?,?,?,?) RETURNING ADDRESS_ID");
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
    */
	
	public Long addAddress(Address address) {
		Configuration config = new Configuration().configure();
//		config.setProperty("ssl", "true");
//		config.setProperty("javax.net.ssl.SSLSocketFactory", "org.postgresql.ssl.NonValidatingFactory");
//		config.setProperty("sslmode","require");
		
		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
 
		Address a = new Address();
		a.setAddresLine("KUTAY");
		a.setCity("KUTAY");
		a.setDistrict("KUTAY");
		a.setNeighborhood("KUTAY");
		a.setPostcode(123);
		a.setStreet("street");
		a.setTown("town");
		
		session.save(a);
 
		session.getTransaction().commit();
		session.close();
		
		return 1L;
	}
	
	public void deleteAddress(Long addressId) {
		
	}
	
	public ArrayList<Long> getAllMallIds() {
		Statement statement;
		ResultSet resultSet = null;
		ArrayList<Long> mallIdList = null;
		try {
			statement = getConnection().createStatement();
			resultSet = statement.executeQuery("SELECT MALL_ID FROM MOBISLET.MALL");
			
			mallIdList = new ArrayList<Long>();
			while (resultSet.next()) {
				mallIdList.add(resultSet.getLong("MALL_ID"));
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mallIdList;
	}
	
	public Mall getMall(Long mallId) {
		Statement statement;
		ResultSet resultSet = null;
		Mall mall = null;
		try {
			statement = getConnection().createStatement();
			resultSet = statement.executeQuery("SELECT * FROM MOBISLET.MALL WHERE MALL_ID = " + mallId);
			
			while (resultSet.next()) {
				mall = new Mall();
				mall.setAddressDscr(resultSet.getString("ADDRESS_DSCR"));
				mall.setAltitude(resultSet.getBigDecimal("ALTITUDE"));
				mall.setDscr(resultSet.getString("DSCR"));
				mall.setId(resultSet.getLong("MALL_ID"));
				mall.setImage(resultSet.getString("IMAGE"));
				mall.setLatitude(resultSet.getBigDecimal("LATITUDE"));
				mall.setLongitude(resultSet.getBigDecimal("LONGITUDE"));
				mall.setName(resultSet.getString("NAME"));
				
				Address address = new Address();
				address.setId(resultSet.getLong("ADDRESS_ID"));
				mall.setAddress(address);
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mall;
	}
}

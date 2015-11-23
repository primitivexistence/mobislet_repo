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
import com.mobislet.campaign.Campaign;
import com.mobislet.campaign.CampaignStatus;
import com.mobislet.contact.Contact;
import com.mobislet.discovery.Discovery;
import com.mobislet.mall.Mall;
import com.mobislet.store.Store;

public class MySQLPersistenceService extends PersistenceGateway{

	private static Connection connection;

	static {
		try {
			openConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static MySQLPersistenceService getPersistenceGateway() {
		return new MySQLPersistenceService();

	}

	private static void openConnection() throws Exception{
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Setup the connection with the DB

			final String DB_URL = "jdbc:mysql://93.89.225.243:3306/premobis_datmob";

			//  Database credentials
			final String USER = "premobis_webappu";
			final String PASS = "asdf1234";

			connection = DriverManager.getConnection(DB_URL,USER,PASS);

			//connection = DriverManager.getConnection("jdbc:mysql://93.89.225.243:3306/premobis_mob?" + "user=" + USER + "&password= " + PASS);

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

	public Long addAddress(Address address) {
		Long id = null;
		try {
			PreparedStatement pst = getConnection().prepareStatement("INSERT INTO address VALUES(?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			pst.setLong(1,0L);
			pst.setString(2,address.getCity());
			pst.setString(3,address.getTown());
			pst.setString(4,address.getDistrict());
			pst.setString(5,address.getNeighborhood());
			pst.setString(6,address.getStreet());
			pst.setString(7,address.getAddresLine());
			pst.setInt(8,address.getPostcode());


			int affectedRows = pst.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Insert failed, no rows affected.");
			}

			try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
				if (generatedKeys.next()) {

					id =  generatedKeys.getLong(1);
				}
				else {
					throw new SQLException("Insert failed, no rows affected.");
				}
			}




		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
	}

	public void deleteAddress(Long addressId) {

	}



	public Long addContact(Contact contact) {
		Long id = null;
		try {
			PreparedStatement pst = getConnection().prepareStatement("INSERT INTO contact VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
			pst.setLong(1,0L);
			pst.setString(2, contact.getName());
			pst.setInt(3, contact.getType());


			int affectedRows = pst.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Insert failed, no rows affected.");
			}

			try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
				if (generatedKeys.next()) {

					id =  generatedKeys.getLong(1);
				}
				else {
					throw new SQLException("Insert failed, no rows affected.");
				}
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
	}

	public void addMallContactRel(Long mallID, Long contactID) {
		try {
			PreparedStatement pst = getConnection().prepareStatement("INSERT INTO mall_contact_rel VALUES(?,?)");
			pst.setLong(1, mallID);
			pst.setLong(2, contactID);

			pst.executeUpdate();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addStoreContactRel(Long storeID, Long contactID) {

		try {
			PreparedStatement pst = getConnection().prepareStatement("INSERT INTO store_contact_rel VALUES(?,?)");
			pst.setLong(1, storeID);
			pst.setLong(2, contactID);

			pst.executeUpdate();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public Long addBrand(Brand brand) {
		Long id = null;
		try {
			PreparedStatement pst = getConnection().prepareStatement("INSERT INTO brand VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
			pst.setLong(1,0L);
			pst.setString(2,brand.name);
			pst.setString(3,brand.image);


			int affectedRows = pst.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Insert failed, no rows affected.");
			}

			try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
				if (generatedKeys.next()) {

					id =  generatedKeys.getLong(1);
				}
				else {
					throw new SQLException("Insert failed, no rows affected.");
				}
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
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


	public Mall getMall(Long mallId) {
		Statement statement;
		ResultSet resultSet = null;
		Mall mall = null;
		try {
			statement = getConnection().createStatement();
			resultSet = statement.executeQuery("SELECT * FROM mall WHERE MALL_ID = " + mallId);

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

	public ArrayList<Long> getAllMallIds() {

		Statement statement;
		ResultSet resultSet = null;
		ArrayList<Long> mallIdList = null;
		try {


			String query = "select mall_id from mall limit 5";

			// create the java statement
			Statement st = getConnection().prepareStatement(query);

			// execute the query, and get a java resultset
			resultSet = st.executeQuery(query);


			mallIdList = new ArrayList<Long>();
			while (resultSet.next()) {
				mallIdList.add(resultSet.getLong("mall_id"));
			}
			
			//System.out.println("Resulset:" + resultSet.toString()); 
			//System.out.println("Mall IDs:" + mallIdList.toString()); 
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mallIdList;
	}

	public Long addMall(Mall mall) {

		Long id = null;

		try {
			PreparedStatement pst = getConnection().prepareStatement("INSERT INTO mall VALUES(?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			pst.setLong(1,0L);
			pst.setString(2,mall.getName());
			pst.setString(3,mall.getDscr());
			pst.setLong(4,mall.getAddress().getId());
			pst.setString(5,mall.getAddressDscr());
			pst.setString(6,mall.getImage());
			pst.setBigDecimal(7,mall.getLatitude());
			pst.setBigDecimal(8,mall.getLongitude());
			pst.setBigDecimal(9,mall.getAltitude());
			pst.setString(10,mall.getCinema());
			pst.setString(11,mall.getCarParking());
			pst.setInt(12,mall.getMallType());

			int affectedRows = pst.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Insert failed, no rows affected.");
			}

			try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
				if (generatedKeys.next()) {

					id =  generatedKeys.getLong(1);
				}
				else {
					throw new SQLException("Insert failed, no rows affected.");
				}
			}




		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
	}



	public Long addStore(Store store) {

		Long id = null;

		try {
			PreparedStatement pst = getConnection().prepareStatement("INSERT INTO store VALUES(?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			pst.setLong(1,0L);
			pst.setString(2, store.getName());
			pst.setString(3, store.getDscr());
			pst.setLong(4, store.getAddress().getId());
			pst.setString(5, store.getAddressDscr());
			pst.setLong(6, store.getMall().getId());
			pst.setLong(7, store.getBrand().getId());
			pst.setString(8, store.getImage());
			pst.setBigDecimal(9, store.getLatitude());
			pst.setBigDecimal(10, store.getLongitude());
			pst.setBigDecimal(11, store.getAltitude());

			
			int affectedRows = pst.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Insert failed, no rows affected.");
			}

			try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
				if (generatedKeys.next()) {

					id =  generatedKeys.getLong(1);
				}
				else {
					throw new SQLException("Insert failed, no rows affected.");
				}
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;


	}

	public Discovery getDiscovery(String mallIdStr, String storeIdStr, String campaignIdStr) {
		
		Statement statement;
		ResultSet mallResultSet = null;
		ResultSet storeResultSet = null;
		ResultSet campaignResultSet = null;
		Discovery discovery = new Discovery();

		try {
			statement = getConnection().createStatement();

			if(mallIdStr != null){
				mallResultSet = statement.executeQuery("SELECT * FROM mall WHERE mall_id NOT IN (" + mallIdStr +") LIMIT 3");
			}else{
				mallResultSet = statement.executeQuery("SELECT * FROM mall LIMIT 3");
			}
			ArrayList<Mall> mallList = new ArrayList<Mall>();
			
			System.out.print("\nMall List:");

			while (mallResultSet.next()) {
				
				Mall mall = new Mall();
				
				mall.setAddressDscr(mallResultSet.getString("ADDRESS_DSCR"));
				mall.setAltitude(mallResultSet.getBigDecimal("ALTITUDE"));
				mall.setDscr(mallResultSet.getString("DSCR"));
				mall.setId(mallResultSet.getLong("mall_id"));
				mall.setImage(mallResultSet.getString("IMAGE"));
				mall.setLatitude(mallResultSet.getBigDecimal("LATITUDE"));
				mall.setLongitude(mallResultSet.getBigDecimal("LONGITUDE"));
				mall.setName(mallResultSet.getString("NAME"));

				Address address = new Address();
				address.setId(mallResultSet.getLong("ADDRESS_ID"));
				mall.setAddress(address);
				
				mallList.add(mall);
			
				System.out.print(mall.getId() + ",");
		
				}

			
			discovery.setMallList(mallList);

			if(storeIdStr != null){
				storeResultSet = statement.executeQuery("SELECT * FROM store WHERE STORE_ID NOT IN (" + storeIdStr +") LIMIT 3");
			}else{
				storeResultSet = statement.executeQuery("SELECT * FROM store LIMIT 3");
			}
			
			System.out.print("\nStore List:");

			
			ArrayList<Store> storeList = new ArrayList<Store>();
			while (storeResultSet.next()) {
				

				Store store = new Store();
				store.setAddressDscr(storeResultSet.getString("address_dscr"));
				store.setAltitude(storeResultSet.getBigDecimal("altitude"));
				store.setDscr(storeResultSet.getString("dscr"));
				store.setId(storeResultSet.getLong("store_id"));
				store.setImage(storeResultSet.getString("image"));
				store.setLatitude(storeResultSet.getBigDecimal("latitude"));
				store.setLongitude(storeResultSet.getBigDecimal("longitude"));
				store.setName(storeResultSet.getString("name"));

				Mall mall = new Mall();
				mall.setId(storeResultSet.getLong("mall_id"));
				store.setMall(mall);

				Brand brand = new Brand();
				brand.setId(storeResultSet.getLong("brand_id"));
				store.setBrand(brand);

				Address address = new Address();
				address.setId(storeResultSet.getLong("address_id"));
				mall.setAddress(address);

				storeList.add(store);
				
				System.out.print(store.getId() + ",");

			}

			discovery.setStoreList(storeList);

			if(campaignIdStr != null){
				campaignResultSet = statement.executeQuery("SELECT * FROM campaign WHERE CAMPAIGN_ID NOT IN (" + campaignIdStr +") LIMIT 3");
			}else{
				campaignResultSet = statement.executeQuery("SELECT * FROM campaign LIMIT 3");
			}
			
			System.out.print("\nCampaign List:");

			ArrayList<Campaign> campaignList = new ArrayList<Campaign>();
			while (campaignResultSet.next()) {
				Campaign campaign = new Campaign();
				campaign.setId(campaignResultSet.getLong("CAMPAIGN_ID"));
				campaign.setImage(campaignResultSet.getString("IMAGE"));
				campaign.setName(campaignResultSet.getString("NAME"));
				campaign.setStartDate(campaignResultSet.getDate("START_DATE"));
				campaign.setEndDate(campaignResultSet.getDate("START_DATE"));
				campaign.setImage(campaignResultSet.getString("IMAGE "));

				CampaignStatus cmpStatus = new CampaignStatus();
				cmpStatus.setCode(campaignResultSet.getInt("CMP_STATUS_CODE"));
				campaign.setCmpStatus(cmpStatus);

				campaignList.add(campaign);
				System.out.print(campaign.getId() + ",");

			}

			discovery.setCampaignList(campaignList);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return discovery;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Selamlar Dunya!";
	}


}

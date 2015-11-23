package test;

import java.math.BigDecimal;







import java.util.ArrayList;

import com.mobislet.address.Address;
import com.mobislet.address.AddressManager;
import com.mobislet.brand.Brand;
import com.mobislet.brand.BrandManager;
import com.mobislet.contact.Contact;
import com.mobislet.contact.ContactManager;
import com.mobislet.discovery.Discovery;
import com.mobislet.discovery.DiscoveryManager;
import com.mobislet.mall.Mall;
import com.mobislet.mall.MallManager;
import com.mobislet.request.GetDiscoveryRequest;
import com.mobislet.store.Store;
import com.mobislet.store.StoreManager;

public class Test {


	private static void insertBrandToMySQLDatabaseTest() {

		Brand tempBrand = new Brand();
		tempBrand.setName("Brand Name");
		tempBrand.setImage("brandimage.jpg");

		Long tempBrandID = BrandManager.addBrand(tempBrand);

		System.out.println("Added Brand id : " + tempBrandID);

	}

	private static void insertContactToMySQLDatabaseTest() {

		Contact tempContact = new Contact();
		tempContact.setType(3);
		tempContact.setName("0 123 456 78 90");

		Long tempContactID = ContactManager.addContact(tempContact);

		System.out.println("Added Contact id : " + tempContactID);

	}

	private static void insertAddressToMySQLDatabaseTest() {

		Address tempAddress = new Address();
		tempAddress.setAddresLine("Mall address");
		tempAddress.setCity("mall city");
		tempAddress.setDistrict("Discrict");
		tempAddress.setNeighborhood("neighborhood");
		tempAddress.setPostcode(10);
		tempAddress.setStreet("Street info");
		tempAddress.setTown("uptown");

		Long tempAddressID = AddressManager.addAddress(tempAddress);

		System.out.println("Added Address id : " + tempAddressID);
	}

	private static void insertMallToMySQLDatabaseTest() {

		Mall tempMall = new Mall();

		tempMall.setDscr("Avm description");
		tempMall.setAddressDscr("address desc s");
		tempMall.setLatitude(new BigDecimal("000.0000"));
		tempMall.setLongitude(new BigDecimal("100.0000"));
		tempMall.setAltitude(new BigDecimal("200.00000"));
		tempMall.setImage("avmimage.jpg");
		tempMall.setName("Avm Name 123");
		tempMall.setCinema("Sinema");
		tempMall.setCarParking("Car Parks");
		tempMall.setMallType(0);


		Address tempAddress = new Address();
		tempAddress.setAddresLine("Mall address");
		tempAddress.setCity("mall city");
		tempAddress.setDistrict("Discrict");
		tempAddress.setNeighborhood("neighborhood");
		tempAddress.setPostcode(10);
		tempAddress.setStreet("Street info");
		tempAddress.setTown("uptown");

		tempAddress.setId(new Long("230"));

		tempMall.setAddress(tempAddress);

		Long tempMallID = MallManager.addMall(tempMall);

		System.out.println("Added Mall id : " + tempMallID);


	}

	private static void insertContactRelsToMySQLDatabaseTest() {

		ContactManager.addMallContactRel(new Long("123"), new Long("456"));

		ContactManager.addStoreContactRel(new Long("789"), new Long("6543"));
	}

	private static void insertStoreToMySQLDatabaseTest() {


		Mall tempMall = new Mall();		
		tempMall.setDscr("Avm description");
		tempMall.setAddressDscr("address desc s");
		tempMall.setLatitude(new BigDecimal("000.0000"));
		tempMall.setLongitude(new BigDecimal("100.0000"));
		tempMall.setAltitude(new BigDecimal("200.00000"));
		tempMall.setImage("avmimage.jpg");
		tempMall.setName("Avm Name 123");
		tempMall.setCinema("Sinema");
		tempMall.setCarParking("Car Parks");
		tempMall.setMallType(0);

		tempMall.setId(new Long("223"));


		Address tempAddress = new Address();
		tempAddress.setAddresLine("Mall address");
		tempAddress.setCity("mall city");
		tempAddress.setDistrict("Discrict");
		tempAddress.setNeighborhood("neighborhood");
		tempAddress.setPostcode(10);
		tempAddress.setStreet("Street info");
		tempAddress.setTown("uptown");

		tempAddress.setId(new Long("230"));

		tempMall.setAddress(tempAddress);

		Brand tempBrand = new Brand();		
		tempBrand.setName("Brand Name");
		tempBrand.setImage("brandimage.jpg");

		tempBrand.setId(new Long("1"));

		Store tempStore = new Store();

		tempStore.setName("Store named");
		tempStore.setDscr("store description");
		tempStore.setAddressDscr("YKM nin yanı");
		tempStore.setAddress(tempAddress);
		tempStore.setMall(tempMall);
		tempStore.setBrand(tempBrand);
		tempStore.setImage("storeimage.jpg");

		tempStore.setLatitude(new BigDecimal("000.0000"));
		tempStore.setLongitude(new BigDecimal("100.0000"));
		tempStore.setAltitude(new BigDecimal("200.00000"));

		Long tempStoreID = StoreManager.addStore(tempStore);


		System.out.println("Added Store id : " + tempStoreID);

	}

	private static Discovery getDiscoverItems() {

		GetDiscoveryRequest request = new GetDiscoveryRequest();

		ArrayList<Integer> campaignIds = new ArrayList<Integer>();
		ArrayList<Integer> malIds = new ArrayList<Integer>();
		ArrayList<Integer> storeIds = new ArrayList<Integer>();
		
		request.setCampaignIdList(campaignIds);
		request.setMallIdList(malIds);
		request.setStoreIdList(storeIds);

		return DiscoveryManager.getDiscovery(request);

	}

	private static ArrayList<Long> getMallIds() {

		return MallManager.getAllMallIds();
	}
	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String[] args) {

		//insertAddressToMySQLDatabaseTest();

		//insertBrandToMySQLDatabaseTest();

		//insertContactRelsToMySQLDatabaseTest();

		//insertContactToMySQLDatabaseTest();

		//insertMallToMySQLDatabaseTest();

		//insertStoreToMySQLDatabaseTest();

		//getDiscoverItems();

		ArrayList<Long> mallIds = getMallIds();
		System.out.println("Mall Ids :" + mallIds);

		System.out.println("\nDonna!");
	}

}

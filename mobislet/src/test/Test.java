package test;

import java.math.BigDecimal;

import com.mobislet.address.Address;
import com.mobislet.address.AddressManager;
import com.mobislet.mall.Mall;
import com.mobislet.mall.MallManager;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Address a = new Address();
		a.setAddresLine("aglkjas;dfk");
		a.setCity("city");
		a.setDistrict("district");
		a.setNeighborhood("negihtabdf");
		a.setPostcode(123);
		a.setStreet("street");
		a.setTown("town");
		Long id = AddressManager.addAddress(a);
		
		Mall m = new Mall();
		m.setDscr("fuahosdflz");
		m.setAddressDscr("agj;asfgasfSADF");
		m.setAltitude(new BigDecimal("123.3123"));
		m.setLatitude(new BigDecimal("123.3123"));
		m.setLongitude(new BigDecimal("123.3123"));
		m.setImage("asdlhjaksd.hjs");
		m.setName("asdjalsd");
		m.setAddress(a);
		MallManager.addMall(m);
	}

}

package base.place.dao.hibernate;

import base.place.City;
import base.place.dao.CityDao;

public class CityDaoImplTest {

	private CityDao cityDao;

	public void testInsert() {
		City city = new City();
		city.setCode("11001");
		city.setName("±±¾©");
		city.setPhoneCode("010");
		city.setZipcode("1001");
		cityDao.insert(city);
	}
}

package base.place.dao.hibernate;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import base.place.City;
import base.place.Province;
import base.place.Region;
import base.place.dao.ProvinceDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/base/config/spring/applicationContext.xml" })
public class ProvinceDaoImplTest {

	@Autowired
	@Qualifier("base.provinceDao")
	private ProvinceDao provinceDao;

	@Test
	public void testInit() {
		Assert.assertNotNull("ProvinceDao is null.", provinceDao);
	}

	// @Test
	// public void testDelete() {
	// provinceDao.delete("11001");
	// }

	// @Test
	// public void testInsert() {
	// Province province = new Province();
	// province.setCode("11001");
	// province.setName("北京");
	// provinceDao.insert(province);
	// }
	//
	// @Test
	// public void testUpdate() {
	// Province province = new Province();
	// province.setCode("11001");
	// province.setName("北京市");
	// provinceDao.update(province);
	// }

	@Test
	public void testGet() {
		Province province = provinceDao.get("110000");
		Assert.assertNotNull("Not fund entity.", province);
		Assert.assertEquals("Province.name error.", "北京市", province.getName());
	}

	@Test
	public void testGetALL() {
		List<Province> lstProvince = provinceDao.get(0, -1);
		Assert.assertNotNull("Not fund entity.", lstProvince);
		Assert.assertTrue("List is empty.", lstProvince.size() > 0);
		for (Province province : lstProvince) {
			System.out.println(String.format("Code=[%s],Name=[%s],Citys=[%s]", province.getCode(), province.getName(),
					province.getCitys().size()));
			if (province.getCitys().isEmpty() == false) {
				for (City city : province.getCitys()) {
					System.out.println(String.format("\tCity:name=[%s],zipcode=[%s],phoneCode=[%s],region.size=[%s]",
							city.getName(), city.getZipcode(), city.getPhoneCode(), city.getRegions().size()));
					if (city.getRegions().isEmpty() == false) {
						for (Region region : city.getRegions()) {
							System.out.println(String.format("\t\tRegion:name=[%s],zipcode=[%s]", region.getName(),
									region.getZipcode()));

						}
					}
				}
			}
		}
	}
}

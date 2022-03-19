package auto_radnja.gume;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {

	private AutoGuma guma;

	@BeforeEach
	void setUp() throws Exception {
		guma = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		guma = null;
	}

//	@Test
//	void testAutoGuma() {
//		fail("Not yet implemented");
//	}

	@Test
	@DisplayName("testiranje parametrizovanog konstruktora")
	void testAutoGumaStringIntIntInt() {
		guma = new AutoGuma("Michelin A17-60", 17, 200, 60);

		assertEquals("Michelin A17-60", guma.getMarkaModel());
		assertEquals(17, guma.getPrecnik());
		assertEquals(200, guma.getSirina());
		assertEquals(60, guma.getVisina());
	}

	@Test
	void testSetMarkaModel() {
		guma.setMarkaModel("Michelin A17-60");
		assertEquals("Michelin A17-60", guma.getMarkaModel());
	}

	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class, () -> guma.setMarkaModel(null));
	}

	@Test
	void testSetMarkaModelPrazanString() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> guma.setMarkaModel(""));
	}

	@ParameterizedTest
	@CsvSource({ "13", "17", "22" })
	void testSetPrecnikDozvoljeno(int precnik) {
		guma.setPrecnik(precnik);
		assertEquals(precnik, guma.getPrecnik());
	}

	@Test
	void testSetPrecnikIznadOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> guma.setPrecnik(23));
	}

	@Test
	void testSetPrecnikIspodOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> guma.setPrecnik(12));
	}

	@ParameterizedTest
	@CsvSource({ "135", "200", "355" })
	void testSetSirinaDozvoljeno(int sirina) {
		guma.setSirina(sirina);
		assertEquals(sirina, guma.getSirina());
	}

	@Test
	void testSetSirinaIznadOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> guma.setSirina(134));
	}

	@Test
	void testSetSirinaIspodOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> guma.setSirina(356));
	}

	@ParameterizedTest
	@CsvSource({ "25", "60", "95" })
	void testSetVisinaDozvoljeno(int visina) {
		guma.setVisina(visina);
		assertEquals(visina, guma.getVisina());
	}

	@Test
	void testSetVisinaIznadOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> guma.setVisina(24));
	}

	@Test
	void testSetVisinaIspodOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> guma.setVisina(96));
	}

	@Test
	void testToString() {
		guma.setMarkaModel("Michelin A10");
		guma.setPrecnik(17);
		guma.setSirina(200);
		guma.setVisina(60);

		String s = guma.toString();
		assertTrue(s.contains(guma.getMarkaModel()));
		assertTrue(s.contains(String.valueOf(guma.getPrecnik())));
		assertTrue(s.contains(String.valueOf(guma.getSirina())));
		assertTrue(s.contains(String.valueOf(guma.getVisina())));
	}

	@ParameterizedTest
	@CsvSource({ "Michelin, 17, 200, 60, Michelin, 17, 200, 60, true",
			"Michelin, 17, 200, 60, Bridgestone, 17, 200, 60, false",
			"Michelin, 17, 200, 60, Michelin, 18, 200, 60, false",
			"Michelin, 17, 200, 60, Michelin, 17, 220, 60, false",
			"Michelin, 17, 200, 60, Michelin, 17, 200, 70, false",
			"Michelin, 17, 200, 60, Bridgestone, 18, 220, 70, false" })
	void testEqualsObject(String markaModel1, String precnik1, String sirina1, String visina1, String markaModel2,
			String precnik2, String sirina2, String visina2, boolean istaGuma) {
		guma.setMarkaModel(markaModel1);
		guma.setPrecnik(Integer.parseInt(precnik1));
		guma.setSirina(Integer.parseInt(sirina1));
		guma.setVisina(Integer.parseInt(visina1));

		AutoGuma guma2 = new AutoGuma();
		guma2.setMarkaModel(markaModel2);
		guma2.setPrecnik(Integer.parseInt(precnik2));
		guma2.setSirina(Integer.parseInt(sirina2));
		guma2.setVisina(Integer.parseInt(visina2));

		assertEquals(istaGuma, guma.equals(guma2));
	}

}

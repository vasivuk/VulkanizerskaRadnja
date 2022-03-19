package auto_radnja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {

	protected Radnja radnja;

	@Test
	void testDodajGumu() {
		AutoGuma guma = new AutoGuma();
		guma.setMarkaModel("Michelin A10");
		guma.setPrecnik(17);
		guma.setSirina(200);
		guma.setVisina(60);

		radnja.dodajGumu(guma);

		assertEquals(1, radnja.vratiSveGume().size());
		assertEquals(guma, radnja.vratiSveGume().get(0));
	}

	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class, () -> radnja.dodajGumu(null));
	}

	@Test
	void testDodajGumuVecPostoji() {
		AutoGuma guma = new AutoGuma();
		guma.setMarkaModel("Michelin A10");
		guma.setPrecnik(17);
		guma.setSirina(200);
		guma.setVisina(60);

		AutoGuma guma1 = new AutoGuma();
		guma1.setMarkaModel("Michelin A10");
		guma1.setPrecnik(17);
		guma1.setSirina(200);
		guma1.setVisina(60);

		radnja.dodajGumu(guma);

		assertThrows(java.lang.RuntimeException.class, () -> radnja.dodajGumu(guma1));

	}

	@Test
	void testPronadjiGumu() {
		AutoGuma guma = new AutoGuma();
		guma.setMarkaModel("Michelin A10");
		guma.setPrecnik(17);
		guma.setSirina(200);
		guma.setVisina(60);

		AutoGuma guma1 = new AutoGuma();
		guma1.setMarkaModel("Bridgestone B10");
		guma1.setPrecnik(17);
		guma1.setSirina(200);
		guma1.setVisina(60);

		radnja.dodajGumu(guma);
		radnja.dodajGumu(guma1);

		List<AutoGuma> rezultat = radnja.pronadjiGumu("Bridgestone B10");
		assertEquals(1, rezultat.size());
		assertEquals(guma1, rezultat.get(0));
	}

	@Test
	void testPronadjiGumuMarkaModelNull() {
		assertEquals(null, radnja.pronadjiGumu(null));
	}

	@Test
	void testPronadjiGumuNemaGume() {
		AutoGuma guma = new AutoGuma();
		guma.setMarkaModel("Michelin A10");
		guma.setPrecnik(17);
		guma.setSirina(200);
		guma.setVisina(60);

		AutoGuma guma1 = new AutoGuma();
		guma1.setMarkaModel("Bridgestone B10");
		guma1.setPrecnik(17);
		guma1.setSirina(200);
		guma1.setVisina(60);

		radnja.dodajGumu(guma);
		radnja.dodajGumu(guma1);

		List<AutoGuma> rezultat = radnja.pronadjiGumu("Guma1");

		assertEquals(0, rezultat.size());
	}

	@Test
	void testPronadjiGumuRazliciteDimenzijeIsteGume() {
		AutoGuma guma = new AutoGuma();
		guma.setMarkaModel("Michelin A10");
		guma.setPrecnik(17);
		guma.setSirina(200);
		guma.setVisina(60);

		AutoGuma guma1 = new AutoGuma();
		guma1.setMarkaModel("Michelin A10");
		guma1.setPrecnik(18);
		guma1.setSirina(210);
		guma1.setVisina(65);

		radnja.dodajGumu(guma);
		radnja.dodajGumu(guma1);

		List<AutoGuma> rezultat = radnja.pronadjiGumu("Michelin A10");

		assertEquals(2, rezultat.size());
	}

	@Test
	void testVratiSveGume() {
		AutoGuma guma = new AutoGuma();
		guma.setMarkaModel("Michelin A10");
		guma.setPrecnik(17);
		guma.setSirina(200);
		guma.setVisina(60);

		radnja.dodajGumu(guma);

		assertEquals(1, radnja.vratiSveGume().size());
		assertEquals(guma, radnja.vratiSveGume().get(0));
	}

}

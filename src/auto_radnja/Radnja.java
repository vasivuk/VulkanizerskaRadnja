package auto_radnja;

import java.util.List;

import auto_radnja.gume.AutoGuma;

/**
 * Predstavlja radnju sa gumama za auto.
 * 
 * Ima osnovne operacije dodavanja i pretrage.
 * 
 * @author Vale
 *
 */
public interface Radnja {
	/**
	 * Dodaje gumu u ponudu radnje.
	 * 
	 * Dodaj gumu u ponudu samo ako nije null i ako vec ne postoji u ponudi radnje.
	 * 
	 * @param a auto guma koja se dodaje u ponudu radnje
	 * 
	 * @throws java.lang.NullPointerException uneta guma je null
	 * @throws RuntimeException               uneta guma vec postoji u ponudi radnje
	 */
	void dodajGumu(AutoGuma a);

	/**
	 * Pronalazi gumu u ponudi na osnovu njene marke i modela.
	 * 
	 * U slucaju da je unet parametar pretrage null, samo ce vratiti praznu listu.
	 * 
	 * @param markaModel zadati marka i model po kojima se vrsi pretraga ponude.
	 * @return Lista koja sadrzi sve gume sa datom markom i modelom
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);

	/**
	 * Vraca sve gume koje se nalaze u ponudi radnje.
	 * 
	 * @return Lista sa svim gumama u radnji
	 */
	List<AutoGuma> vratiSveGume();
}

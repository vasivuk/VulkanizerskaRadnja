package auto_radnja.gume;

/**
 * Predstavlja automobilsku gumu sa svim svojim dimenzijama i modelom.
 * 
 * @author Vale
 *
 */

public class AutoGuma {
	/**
	 * Marka i model gume.
	 */
	private String markaModel = null;
	/**
	 * Prečnik gume izražen u centimetrima.
	 */
	private int precnik = -1;
	/**
	 * Širina gume izražena u milimetrima.
	 */
	private int sirina = -1;
	/**
	 * Visina gume izražena u centimetrima.
	 */
	private int visina = -1;

	public AutoGuma() {
	}

	/**
	 * Postavlja marku i model, prečnik, širinu i visinu gume na zadate vrednosti
	 * 
	 * @param markaModel nova marka i model
	 * @param precnik    novi prečnik
	 * @param sirina     nova širina
	 * @param visina     nova visina
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}

	/**
	 * Vraća marku i model gume.
	 * 
	 * @return marka i model kao String
	 */
	public String getMarkaModel() {
		return markaModel;
	}

	/**
	 * Postavlja novu vrednost za atribut markaModel.
	 * 
	 * @param markaModel nova marka i model gume
	 * @throws java.lang.NullPointerException     ako su uneti marka i model null
	 * @throws java.lang.IllegalArgumentException ako uneti marka i model sadrže
	 *                                            manje od 3 znaka
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new IllegalArgumentException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}

	/**
	 * Vraća prečnik gume.
	 * 
	 * @return prečnik gume u centimetrima
	 */
	public int getPrecnik() {
		return precnik;
	}

	/**
	 * Postavlja novu vrednost za atribut prečnik.
	 * 
	 * @param precnik novi prečnik gume
	 * @throws java.lang.IllegalArgumentException ako je prečnik manji od 13cm ili
	 *                                            veći od 22cm
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 || precnik > 22)
			throw new IllegalArgumentException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * Vraća širinu gume.
	 * 
	 * @return širina gume izrazena u milimetrima
	 */
	public int getSirina() {
		return sirina;
	}

	/**
	 * Postavlja novu vrednost za širinu gume
	 * 
	 * @param sirina nova širina gume
	 * @throws java.lang.IllegalArgumentException ako je širina manja od 135 ili
	 *                                            veća od 355
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 || sirina > 355)
			throw new IllegalArgumentException("Sirina van opsega");
		this.sirina = sirina;
	}

	/**
	 * Vraća visinu gume.
	 * 
	 * @return visina gume izražena u centimetrima
	 */
	public int getVisina() {
		return visina;
	}

	/**
	 * Postavlja novu vrednost za visinu gume.
	 * 
	 * @param visina nova visina gume
	 * @throws java.lang.IllegalArgumentException ako visina manja od 25cm ili veća
	 *                                            od 95cm
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new IllegalArgumentException("Visina van opsega");
		this.visina = visina;
	}

	/**
	 * Vraća sve podatke o gumi u jednom Stringu.
	 * 
	 * @return String sa svim podacima o gumi.
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}

	/**
	 * Poredi dve gume po marki, modelu i po dimenzijama
	 * 
	 * @return
	 *         <ul>
	 *         <li>true - ako su marka model i sve dimenzije iste kod obe gume</li>
	 *         <li>false - ako to nije slucaj</li>
	 *         </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}

}

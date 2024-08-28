package Eccezioni;

public class BotteVino {

	private final int capacita; // metto final perchè il volume della botte non puo aumentare o diminuire
	private int livello;

	public int getCapacita() {
		return capacita;
	}

	public int getLivello() {
		return livello;
	}

	public BotteVino(int capacita, int livello) throws QuantitaNegativaException, CapacitaSuperataException {
		if (capacita > 0 && livello >= 0) {
			if (livello <= capacita) {
				this.capacita = capacita;
				this.livello = livello;
			} else {
				throw new CapacitaSuperataException(
						"il livello inziale non può essere maggiore del volume della botte");
			}
		} else {
			throw new QuantitaNegativaException("capacità o livello sono negativi");
		}
	}

	// mi crea una botte vuoto dove dovrò inserire solo la capoacità ovvero il
	// volume{

	// mentre il livello sarà settato a 0
	public BotteVino(int capacita) throws QuantitaNegativaException {
		if (capacita > 0) {
			this.livello = 0;
			this.capacita = capacita;
		} else {
			throw new QuantitaNegativaException("Capacità della botte non può essere nulla o minore di zero");
		}
	}

	public void preleva(int quantita) throws PrelevaException {
		if (quantita >= 0) {
			if (quantita <= livello) {
				livello = livello - quantita;
			} else {
				throw new PrelevaException("quantità eccessiva, non puoi prelevare");
			}
		} else {
			throw new PrelevaException("quantità negativa");
		}
	}

	public void versa(int quantita) throws VersaException {
		if (quantita >= 0) {
			if (quantita < capacita - livello) {
				livello += quantita;
			} else {
				throw new VersaException("La quantità supera la capacità della botte, non puoi versare");
			}
		} else {
			throw new VersaException("La quantità che vuoi versare non può essere negativa");
		}
	}

	@Override
	public String toString() {
		return "BotteVino [capacita=" + capacita + ", livello=" + livello + "]";
	}

	// oppure potevamo utilizzare un approccio diverso cioè creare eccezione in base
	// ai problemi e non legati all'azione

	/*
	 * public void versa(int quantita) throws VersaException { if (quantita >= 0) {
	 * if (quantita < capacita - livello) { livello += quantita; } else { throw new
	 * QuantitaEccessivaException("non puoi versare "+quantita+" litri"); } } else {
	 * throw new QuantitaNegativaException(); } }
	 */

}

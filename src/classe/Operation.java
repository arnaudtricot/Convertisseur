package classe;

public class Operation {

	private double valeur1;
	private double valeur2;
	private lesActions action;
	
	public Operation(double valeur1, double valeur2, lesActions action) {
		super();
		this.valeur1 = valeur1;
		this.valeur2 = valeur2;
		this.action = action;
	}

	public double getValeur1() {
		return valeur1;
	}

	public void setValeur1(double valeur1) {
		this.valeur1 = valeur1;
	}

	public double getValeur2() {
		return valeur2;
	}

	public void setValeur2(double valeur2) {
		this.valeur2 = valeur2;
	}

	public lesActions getAction() {
		return action;
	}

	public void setAction(lesActions action) {
		this.action = action;
	}
}

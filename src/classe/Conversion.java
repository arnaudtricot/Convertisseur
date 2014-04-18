package classe;

import java.util.ArrayList;
import java.util.List;

public class Conversion {
	List<Operation>  lesOperations = new ArrayList<Operation>();
	Unite unite1;
	Unite unite2;
	double montant;
	
	public Conversion(List<Operation>  Operation, Unite u1, Unite u2, double mtt){  
		lesOperations = Operation;
		unite1= u1;
		unite2 = u2;
		montant= mtt; 
	}
	
	public List<Operation> getLesOperations() {
		return lesOperations;
	}

	public void setLesOperations(List<Operation> lesOperations) {
		this.lesOperations = lesOperations;
	}


	public Unite getunite1() {
		return unite1;
	}

	public void setunite1(Unite u1) {
		this.unite1 = u1;
	}
	
	public Unite getunite2() {
		return unite2;
	}

	public void setunite2(Unite u2) {
		this.unite2 = u2;
	}
	
	public double getMontant() {
		return montant;
	}

	public void setMontant(double mtt) {
		this.montant = mtt;
	}
}

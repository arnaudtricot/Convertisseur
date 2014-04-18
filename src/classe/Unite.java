package classe;

public class Unite {
	String nom;
	lesTypes type;
	
	public Unite(String nom, lesTypes type) {
		super();
		this.nom = nom;
		this.type = type;
	}

	public lesTypes getType() {
		return type;
	}

	public void setType(lesTypes type) {
		this.type = type;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/*public ArrayList<String> getType() {
		return type;
	}
	
	public void ensembleType(){
		type.add("Metre");
		type.add("Pouce");
		type.add("Annee");
		type.add("Mois");
		type.add("Jour");
		type.add("Heure");
		type.add("Minute");
		type.add("Seconde");
		type.add("Celsius");
		type.add("Fahrenheit");
		type.add("Kelvin");
		type.add("Gallon");
		type.add("Metre cube");
		type.add("Litre");
		type.add("Euro");
		type.add("Dollar");
		type.add("Livre Sterling");
		type.add("Gramme");
	}
	
	public void parcourtType(){
		for(int i = 0; i < type.size(); i++)
	    {
	      System.out.println("donnée à l'indice " + i + " = " + type.get(i));
	    }
	}*/
	
}

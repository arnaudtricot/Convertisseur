package gestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import classe.*;

public class Menu {
	static List<Conversion> lesConv = new ArrayList<Conversion>();
	static List<Unite> lesUnites = new ArrayList<Unite>();
	static Scanner saisie = new Scanner(System.in);
		
	public static void main(String[] args) {
		/* ---------------    JEUX DE DONNEES  ---------------------  */
		// DEVIS 
		Unite euro = new Unite("EURO", lesTypes.DEVISE);
		lesUnites.add(euro);
		Unite dollar = new Unite("DOLLAR", lesTypes.DEVISE);
		lesUnites.add(dollar);
		Operation eur_doll = new Operation (1,1.3827,lesActions.MULTIPLICATION);
		List<Operation> lesOperations = new ArrayList<Operation>();
		lesOperations.add(eur_doll);
		Conversion EUR_DOLL = new Conversion ( lesOperations , euro, dollar, 1);
		lesConv.add(EUR_DOLL);
		
		// TEMPERATURE
		Unite celsius = new Unite("CELSIUS", lesTypes.TEMPERATURE);
		lesUnites.add(celsius);
		Unite fahrenheit = new Unite("FAHRENHEIT", lesTypes.TEMPERATURE);
		lesUnites.add(fahrenheit);
		Operation cel_fahrMul = new Operation (1,9,lesActions.MULTIPLICATION);
		Operation cel_fahrDiv = new Operation (1,5,lesActions.DIVISION);
		Operation cel_fahrAdd = new Operation (1,32,lesActions.ADDITION);
		List<Operation>  lesOperationsTemp = new ArrayList<Operation>();
		lesOperationsTemp.add(cel_fahrMul);
		lesOperationsTemp.add(cel_fahrDiv);
		lesOperationsTemp.add(cel_fahrAdd);
		Conversion CEL_FAHR = new Conversion ( lesOperationsTemp , celsius, fahrenheit, 1);
		lesConv.add(CEL_FAHR);
		
		System.out.println("Bonjour ! Bienvenue dans le menu");
		System.out.println();
		leMenu();
	}
	
	public static void leMenu() {
		
		int choix = 0;
	
		System.out.println("********** MENU **********");
		System.out.println("- 1 - Ajouter une conversion");
		System.out.println("- 2 - Effectuer une conversion");
		System.out.println("- 3 - Quitter");

		while ((choix < 1) || (choix > 3)){
		System.out.println("Tapez votre choix :");
		choix = saisie.nextInt();
		}
		
		if (choix == 1){
			AjouterConversion();
		} else if (choix == 2)
			{
				EffectuerConversion();
			} else {
				saisie.close();
				System.exit(0);
			}

	}
	
public static void AjouterConversion(){
		
		
		int choix_type = 0;
		
		String Nom_u1;
		String Nom_u2;
		Unite u1 = null, u2 = null;
		Operation o = null;
		double valeur2 = 0;
		
		System.out.println("********** AJOUTER CONVERSION **********");
		System.out.println("De quel type d'unités s'agit-il ?");
		System.out.println("- 1 - Longueur");
		System.out.println("- 2 - Temporel");
		System.out.println("- 3 - Température");
		System.out.println("- 4 - Volume");
		System.out.println("- 5 - Devise");
		System.out.println("- 6 - Masse");
		System.out.println("- 7 - Retourner au menu");
		
		while ((choix_type < 1) || (choix_type > 7)){
			System.out.println("Tapez votre choix :");
			choix_type = saisie.nextInt();
		}
		
		System.out.println("Tapez le nom de la première unité :");
		Nom_u1 = saisie.next().toUpperCase();
		System.out.println("Tapez le nom de la seconde unité :");
		Nom_u2 = saisie.next().toUpperCase();
		
		boolean exist_u1=false;
		boolean exist_u2=false;
		List<Unite> listUnites =  new ArrayList<Unite>();
		lesTypes type = null;
		switch (choix_type){
		case 1:
			listUnites=parcourtUnite(lesTypes.LONGUEUR);
			type=lesTypes.LONGUEUR;
			break;
		case 2:
			listUnites=parcourtUnite(lesTypes.TEMPOREL);
			type=lesTypes.TEMPOREL;
			break;
		case 3:
			listUnites=parcourtUnite(lesTypes.TEMPERATURE);
			type=lesTypes.TEMPERATURE;
			break;
		case 4:
			listUnites=parcourtUnite(lesTypes.VOLUME);
			type=lesTypes.VOLUME;	
			break;
		case 5:
			listUnites=parcourtUnite(lesTypes.DEVISE);
			type=lesTypes.DEVISE;	
			break;
		case 6:
			listUnites=parcourtUnite(lesTypes.MASSE);
			type=lesTypes.MASSE;
			break;
		case 7:
			leMenu();
			break;
		default:
			System.out.println("Erreur");
			break;
		}
		
		for(int i = 0; i < listUnites.size(); i++)
	    {
			if(listUnites.get(i).getNom().equals(Nom_u1)){
				System.out.println("Cette unité existe déjà");
				u1=listUnites.get(i);
				exist_u1=true;
			}
			if(listUnites.get(i).getNom().equals(Nom_u2)){
				System.out.println("Cette unité existe déjà");
				u2=listUnites.get(i);
				exist_u2=true;
			}
	    }
		if (exist_u1==false){
			u1 = new Unite(Nom_u1, type);
			lesUnites.add(u1);
		}	
		if (exist_u2==false){
			u2 = new Unite(Nom_u2, type);
			lesUnites.add(u2);
		}
		
		boolean trouve = false;
		
		for (int i=0; i < lesConv.size(); i++){
			if (lesConv.get(i).getunite1() == u1 && lesConv.get(i).getunite2() == u2){
				trouve = true;
			}
		}
		if (trouve){
			System.out.println("La conversion \""+u1.getNom()+"\" vers \""+u2.getNom()+"\" existe déjà !");
			leMenu();
		}else{
			System.out.println("Cette conversion n'est pas renseigné dans l'application");
		}
		
		
		System.out.println();
		System.out.println("Combien d'opérations sont nécessaires à la conversion ?");
		System.out.println("A noter que les opérations s'enchaînent, il faut donc prioriser les opérations.");
		System.out.println("Exemple:l'opération que vous rentrez en premier sera effectuée avant les autres.");
		System.out.println("L'opération numéro 2 prendra donc le résultat de la première opération pour effectuer le calcul");
		System.out.println("et ainsi de suite pour les autres opérations");
		int nb_operat=saisie.nextInt();
		
		int cpt_operat=0;
		List<Operation>  lesOperationsTemp = new ArrayList<Operation>();
		while(cpt_operat<nb_operat){
			System.out.println("Quelle opération est effectuée ?");
			System.out.println("- 1 - Addition");
			System.out.println("- 2 - Soustraction");
			System.out.println("- 3 - Multiplication");
			System.out.println("- 4 - Division");
			System.out.println("- 5 - Retourner au menu");
			int choix_operat = 0;
			while ((choix_operat < 1) || (choix_operat > 5)){
				System.out.println("Tapez votre choix :");
				choix_operat = saisie.nextInt();
			}
			
			System.out.println("Entrez la valeur de l'opération :");
			System.out.println("ATTENTION, pour un nombre décimal, il faut mettre une virgule et non un point");
			valeur2 = saisie.nextDouble();
			
			switch (choix_operat){
			case 1:
				o = new Operation(1,valeur2,lesActions.ADDITION);
				break;
			case 2:
				o = new Operation(1,valeur2,lesActions.SOUSTRACTION);
				break;
			case 3:
				o = new Operation(1,valeur2,lesActions.MULTIPLICATION);
				break;
			case 4:
				o = new Operation(1,valeur2,lesActions.DIVISION);
				break;
			case 5:
				leMenu();
				break;
			default:
				System.out.println("Erreur");
				break;
			}
			if (o!=null){
				lesOperationsTemp.add(o);
			}
			cpt_operat++;
		}
		Conversion CONV = new Conversion ( lesOperationsTemp , u1, u2, 1);
		for (int i =0; i< lesOperationsTemp.size(); i++){
			System.out.println(lesOperationsTemp.get(i).getAction());
		}
		lesConv.add(CONV);
		leMenu();
	}
	
	public static List<Unite> parcourtUnite(lesTypes leType){
		int nb=0;
		List<Unite> lesUnitesTemp = new ArrayList<Unite>();
		for(int i = 0; i < lesUnites.size(); i++)
	    {
			if(lesUnites.get(i).getType() == leType){
				nb++;
				System.out.println("- " + nb + " - " + lesUnites.get(i).getNom());
				lesUnitesTemp.add(lesUnites.get(i));
			}
	    }
		return lesUnitesTemp;
	}
	
	public static double faireOperation(int nb){
		double monResult =0;
		for (int i = 0; i < lesConv.get(nb).getLesOperations().size(); ++i){
			if (i==0){
				lesConv.get(nb).getLesOperations().get(i).setValeur1(lesConv.get(nb).getMontant());
			}
			if (monResult != 0){
				lesConv.get(nb).getLesOperations().get(i).setValeur1(monResult);
			}
			if (lesConv.get(nb).getLesOperations().get(i).getAction() == lesActions.MULTIPLICATION){
				monResult = lesConv.get(nb).getLesOperations().get(i).getValeur1() * lesConv.get(nb).getLesOperations().get(i).getValeur2();
			}
			if (lesConv.get(nb).getLesOperations().get(i).getAction() == lesActions.DIVISION){
				monResult = lesConv.get(nb).getLesOperations().get(i).getValeur1() / lesConv.get(nb).getLesOperations().get(i).getValeur2();
			}
			if (lesConv.get(nb).getLesOperations().get(i).getAction() == lesActions.ADDITION){
				monResult = lesConv.get(nb).getLesOperations().get(i).getValeur1() + lesConv.get(nb).getLesOperations().get(i).getValeur2();
			}
			if (lesConv.get(nb).getLesOperations().get(i).getAction() == lesActions.SOUSTRACTION){
				monResult = lesConv.get(nb).getLesOperations().get(i).getValeur1() - lesConv.get(nb).getLesOperations().get(i).getValeur2();
			}
		}
		return monResult;
	}

	public static void EffectuerConversion(){
		
		int choix_convert = 0;
		
		System.out.println("************** EFFECTUER CONVERSION **************");
		System.out.println("Quelle type d'unités souhaitez-vous convertir ?");
		System.out.println("- 1 - Longueur");
		System.out.println("- 2 - Temporel");
		System.out.println("- 3 - Température");
		System.out.println("- 4 - Volume");
		System.out.println("- 5 - Devise");
		System.out.println("- 6 - Masse");
		System.out.println("- 7 - Retourner au menu");
		while ((choix_convert < 1) || (choix_convert > 7)){
			System.out.println("Tapez votre choix :");
			choix_convert = saisie.nextInt();
		}
		List<Unite> lesUnitesTemp = new ArrayList<Unite>();
		if (choix_convert == 1){
			lesUnitesTemp = parcourtUnite(lesTypes.LONGUEUR);
		}
		if (choix_convert == 2){
			lesUnitesTemp = parcourtUnite(lesTypes.TEMPOREL);
		}
		if (choix_convert == 3){
			lesUnitesTemp = parcourtUnite(lesTypes.TEMPERATURE);
		}
		if (choix_convert == 4){
			lesUnitesTemp = parcourtUnite(lesTypes.VOLUME);
		}
		if (choix_convert == 5){
			lesUnitesTemp = parcourtUnite(lesTypes.DEVISE);
		}
		if (choix_convert == 6){
			lesUnitesTemp = parcourtUnite(lesTypes.MASSE);
		}
		if (choix_convert == 7){
			leMenu();
		}
		if (lesUnitesTemp.size() == 0){
			System.out.println("Aucune unité trouvée correspondant au type "+lesTypes.LONGUEUR);
			leMenu();
		}else{
			Scanner saisieUnite =  new Scanner(System.in);
			int uniDep = 0;
			while ((uniDep < 1) || (uniDep > lesUnitesTemp.size())){
			System.out.println("Tapez votre unité de départ :");
			uniDep = saisieUnite.nextInt();
			}
			System.out.println("Votre unité de départ : "+lesUnitesTemp.get(uniDep-1).getNom());
			
			int uniFin = 0;
			while ((uniFin < 1) || (uniFin > lesUnitesTemp.size())){
			System.out.println("Tapez votre unité de fin :");
			uniFin = saisieUnite.nextInt();
			}
			
			System.out.println(lesUnitesTemp.get(uniDep-1).getNom()+" vers "+lesUnitesTemp.get(uniFin-1).getNom());
			boolean trouve = false;
			int nb = 0;
			for (int i=0; i < lesConv.size(); i++){
				if (lesConv.get(i).getunite1() == lesUnitesTemp.get(uniDep-1) && lesConv.get(i).getunite2() == lesUnitesTemp.get(uniFin-1)){
					trouve = true;
					nb = i;
				}
			}
			if (trouve){
				System.out.println("Tapez votre montant :");
				double montant = saisieUnite.nextDouble();
				lesConv.get(nb).setMontant(montant);
				
				System.out.println (montant+" "+lesConv.get(nb).getunite1().getNom()+" = "+faireOperation(nb)+" "+lesConv.get(nb).getunite2().getNom()); 
				saisieUnite.close();
			}else{
				System.out.println("Cette conversion n'est pas renseigné dans l'application");
				leMenu();
			}
		}
	}
}

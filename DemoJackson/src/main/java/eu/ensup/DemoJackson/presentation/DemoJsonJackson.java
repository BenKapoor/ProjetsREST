package eu.ensup.DemoJackson.presentation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import eu.ensup.DemoJackson.domaine.Employe;

public class DemoJsonJackson {

	public static void main(String[] args) throws IOException{

		ObjectMapper mapper =  new ObjectMapper();
		Employe employe1 = new Employe("BA", "Amadou");
		Employe employe2 = new Employe("BA", "Amadou");
		
		// Object vers fichier json
		File resultFile = new File("employe.json");
		mapper.writeValue(resultFile, employe1);
		
		// Récupération depuis le json
		Employe employ2 = mapper.readValue(resultFile, Employe.class);
		System.out.println(employ2);
		
		
		// Array objet vers json
		File resultFile2 = new File("employeArray.json");
		ArrayList<Employe> listEmploye = new ArrayList<Employe>();
		listEmploye.add(employe1);
		listEmploye.add(employe2);
		mapper.writeValue(resultFile2, listEmploye);
		
		//json recupération array
		ArrayList<Employe> recupList = mapper.readValue(resultFile2, ArrayList.class);
		System.out.println(recupList);
	}

}

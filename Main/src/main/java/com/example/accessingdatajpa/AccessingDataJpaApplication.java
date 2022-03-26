package com.example.accessingdatajpa;

import com.example.accessingdatajpa.entity.*;
import com.example.accessingdatajpa.repository.api.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;


@SpringBootApplication
public class AccessingDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}

}

@Component
@EnableJpaRepositories
class PseudoMain implements ApplicationRunner {

	@PersistenceContext
	private EntityManager em;


	final ClientRepository clientRepository;
	final VeloRepository veloRepository;
	final AbonneRepository abonneRepository;
	final BornetteRepository bornetteRepository;
	final LocationRepository locationRepository;
	final StationRepository stationRepository;

	Client currentClient = null;
	Station currentStation = null;
	final Scanner scanner = new Scanner(System.in);


	public PseudoMain(ClientRepository clientRepository, VeloRepository veloRepository, AbonneRepository abonneRepository, BornetteRepository bornetteRepository, LocationRepository locationRepository, StationRepository stationRepository) {
		this.clientRepository = clientRepository;
		this.veloRepository = veloRepository;
		this.abonneRepository = abonneRepository;
		this.bornetteRepository = bornetteRepository;
		this.locationRepository = locationRepository;
		this.stationRepository = stationRepository;
	}

	private void returnProcess() {
		System.out.println("Return Process");
	}

	private void locationProcess() {
		System.out.println("Vous etes deja abonne? (O/N)");
		String userInput = scanner.nextLine();  // Read user input
		switch(userInput.toLowerCase()){
			case "o":
				locationAbonne();
				break;
			case "n":
				locationNonAbonne();
				break;
			default:
				System.out.println("Entrez O si vous etes abonne et N - sinon.");
				locationProcess();
				break;
		}
	}

	private void locationAbonne() {
		System.out.print("Entrez votre code secret: ");
		String userInput = scanner.nextLine();  // Read user input
		while(userInput.length()!=4){
			System.out.print("Code incorrecte.");
			userInput = scanner.nextLine();  // Read user input
		}
		currentClient = clientRepository.findByCodeSecret(userInput);
		Abonne currentAbonne = abonneRepository.findByAbonneId(currentClient.getClientId());
		if(currentAbonne == null){
			System.out.print("Vous n'etes pas abonne. Voulez-vous vous abonne? (O/N)");
			userInput = scanner.nextLine();  // Read user input
			switch(userInput.toLowerCase()){
				case "o":
					creerAbonne();
					break;
				case "n":
					locationNonAbonne();
					break;
				default:
					System.out.println("Entrez O si vous etes abonne et N - sinon.");
					locationProcess();
					break;
			}
		}
	}

	private void creerAbonne() {
	}

	private void locationNonAbonne() {
		System.out.println("Input your bank card credentials (16 digits card number): ");
		Long clientCB = Long.parseLong(scanner.nextLine());
		String clientSecretCode = getAlphaNumericString();
		System.out.println("Your secret code is " + clientSecretCode + ". Remember it!");

		Client newClient = Client.builder()
				.numeroCarteBancaire(clientCB)
				.codeSecret(clientSecretCode)
				.build();

		clientRepository.save(newClient);


		List<Bornette> bornettesDispo = bornetteRepository.findByStationMereAndCurrentVelo_EtatV(currentStation, AllEnums.Etat.ETAT_OK);
		StringBuilder modeles = new StringBuilder();

		if(bornettesDispo.size()==0){
			System.out.println("Il n'y a pas de velo disponible sur cette station");
		}
		for(Bornette bornette: bornettesDispo){
			modeles.append("/").append(bornette.getCurrentVelo().getModeleDeVeloModeleName());
		}
		System.out.println("Quel modele de velo voulez vous imprunter: " + modeles);
		String modeleChoisi = scanner.nextLine();
		List<Velo> veloDisponibles = new ArrayList<>(Collections.emptyList());
		for (Bornette b : bornettesDispo) {
			veloDisponibles.add(b.getCurrentVelo());
		}
		Bornette bornettePourClient = bornetteRepository.findFirstByStationMereAndCurrentVelo_ModeleDeVelo_ModeleName(currentStation,modeleChoisi);
		System.out.println("Vous pouvez prendre le velo a la bornette" + bornettePourClient.getBornetteId());
		System.out.println("....Client recupere le velo....");
		bornettePourClient.setCurrentVelo(null);
		Location location = Location.builder()
				.startDate(LocalDateTime.now())
				.stationDepart(currentStation)
				.build();
		locationRepository.save(location);
		System.out.println("Location " + location +" vient d'etre cree.");
	}

	private static String getAlphaNumericString()
	{
		int n = 4;
		// length is bounded by 256 Character
		byte[] array = new byte[256];
		new Random().nextBytes(array);

		String randomString
				= new String(array, StandardCharsets.UTF_8);

		// Create a StringBuffer to store the result
		StringBuilder r = new StringBuilder();

		// Append first 20 alphanumeric characters
		// from the generated random String into the result
		for (int k = 0; k < randomString.length(); k++) {

			char ch = randomString.charAt(k);

			if (((ch >= 'a' && ch <= 'z')
					|| (ch >= 'A' && ch <= 'Z')
					|| (ch >= '0' && ch <= '9'))
					&& (n > 0)) {

				r.append(ch);
				n--;
			}
		}

		// return the resultant string
		return r.toString();
	}


	//Main Application
	@Override
	public void run(ApplicationArguments args){

		System.out.println("******* Welcome to Our Application *******");

		boolean end = false;
		while(!end){
			//Toutes les stations disponibles
			List<Station> stations = stationRepository.findAll();

			//Station aleatoire
			currentStation = stations.get(new Random().nextInt(stations.size()));

			System.out.println("1) Location.");
			System.out.println("2) Return a bicycle.");
			System.out.println("3) Quit.");
			System.out.print("-What would you like to do: ");

			String userInput = scanner.nextLine();  // Read user input
			switch (userInput){
				case "1":
					locationProcess();
					break;
				case "2":
					returnProcess();
					break;
				case "3":
					end = true;
					break;
				default:
					System.out.print("Tapez 1, 2 ou 3 s'il vou plait.");
					break;

			}
		}
	}
}

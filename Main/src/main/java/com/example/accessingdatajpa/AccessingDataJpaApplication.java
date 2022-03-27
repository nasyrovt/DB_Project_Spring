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
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;


@SpringBootApplication
public class AccessingDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}

}
//
//@Component
//@EnableJpaRepositories
//class PseudoMain implements ApplicationRunner {
//
//	@PersistenceContext
//	private EntityManager em;
//
//
//	final ClientRepository clientRepository;
//	final VeloRepository veloRepository;
//	final AbonneRepository abonneRepository;
//	final BornetteRepository bornetteRepository;
//	final LocationRepository locationRepository;
//	final StationRepository stationRepository;
//
//	List<Bornette> bornettesDispo = null;
//	Client currentClient = null;
//	Station currentStation = null;
//	final Scanner scanner = new Scanner(System.in);
//
//
//	public PseudoMain(ClientRepository clientRepository, VeloRepository veloRepository, AbonneRepository abonneRepository, BornetteRepository bornetteRepository, LocationRepository locationRepository, StationRepository stationRepository) {
//		this.clientRepository = clientRepository;
//		this.veloRepository = veloRepository;
//		this.abonneRepository = abonneRepository;
//		this.bornetteRepository = bornetteRepository;
//		this.locationRepository = locationRepository;
//		this.stationRepository = stationRepository;
//	}
//
//	private void returnProcess() {
//		List<Bornette> bornettesLibre = bornetteRepository.findByStationMereAndCurrentVelo(currentStation, null);
//		if(bornettesLibre.size()==0){
//			System.out.println("Malheureusement, il n'y a pas de bornette libre pour votre velo.");
//		}
//		else{
//			System.out.print("Entrez votre code secret: ");
//			String userInput = scanner.nextLine();  // Read user input
//			while(userInput.length()!=4){
//				System.out.print("Code incorrecte.");
//				userInput = scanner.nextLine();  // Read user input
//			}
//			currentClient = clientRepository.findByCodeSecret(userInput);
//			if(currentClient==null){
//				System.out.println("On n'a pas reussi de trouver le client avec ce code.");
//			}
//			else{
//				List<Location> locationsDeClient = locationRepository.findByClient_CodeSecret(userInput);
//				System.out.println("Quel location(id) voulez-vous terminer: \n" + locationsDeClient);
//				userInput = scanner.nextLine();
//				Location locationATerminer = locationRepository.getByLocationId(Long.parseLong(userInput));
//				locationATerminer.setEndDate(LocalDateTime.now());
//				locationATerminer.setStationArrivee(currentStation);
//				locationRepository.save(locationATerminer);
//				long minutes = ChronoUnit.MINUTES.between(locationATerminer.getStartDate(), locationATerminer.getEndDate());
//				float prix;
//				Abonne currentClientAbonne = abonneRepository.getByAbonneId(currentClient.getClientId());
//				if(currentClientAbonne!=null){
//					prix = 0.3f * locationATerminer.getVelo().getModeleDeVeloPrix()*Float.parseFloat(String.valueOf(minutes));
//					if(locationATerminer.getStationArrivee().getClassification()== AllEnums.Classification.vPlus
//							&&locationATerminer.getStationDepart().getClassification()== AllEnums.Classification.vMoins){
//						currentClientAbonne.setPrime(Float.parseFloat(String.valueOf(minutes)));
//					}
//					System.out.println("Vous avez gagne" + currentClientAbonne.getPrime() + "minutes.");
//				}
//				else {
//					prix = locationATerminer.getVelo().getModeleDeVeloPrix() * Float.parseFloat(String.valueOf(minutes));
//				}
//
//				System.out.println("Location est terminer. Vous serez facture de" + prix + " euros");
//			}
//		}
//	}
//
//	private void locationProcess() {
//		System.out.println("Vous etes deja abonne? (O/N)");
//		String userInput = scanner.nextLine();  // Read user input
//		switch(userInput.toLowerCase()){
//			case "o":
//				locationAbonne();
//				break;
//			case "n":
//				locationNonAbonne();
//				break;
//			default:
//				System.out.println("Entrez O si vous etes abonne et N - sinon.");
//				locationProcess();
//				break;
//		}
//	}
//
//	private void locationAbonne() {
//		System.out.print("Entrez votre code secret: ");
//		String userInput = scanner.nextLine();  // Read user input
//		while(userInput.length()!=4){
//			System.out.print("Code incorrecte.");
//			userInput = scanner.nextLine();  // Read user input
//		}
//		currentClient = clientRepository.findByCodeSecret(userInput);
//		if(currentClient==null){
//			System.out.println("On n'a pas reussi de trouver le client avec ce code. On va vous donner le nouveau.");
//			locationNonAbonne();
//			return;
//		}
//		Abonne currentAbonne = abonneRepository.findByAbonneId(currentClient.getClientId());
//		if(currentAbonne == null){
//			System.out.print("Vous n'etes pas abonne. Voulez-vous vous abonne? (O/N)");
//			userInput = scanner.nextLine();  // Read user input
//			switch(userInput.toLowerCase()){
//				case "o":
//					creerAbonne();
//					break;
//				case "n":
//					locationNonAbonne();
//					break;
//				default:
//					System.out.println("Entrez O si vous etes abonne et N - sinon.");
//					locationProcess();
//					break;
//			}
//		}
//		else{
//			locationClientOk();
//		}
//	}
//
//	private void creerAbonne() {
//		System.out.println("Entrez votre nom: ");
//		String nomAbonne = scanner.nextLine();
//		System.out.println("Entrez votre prenom: ");
//		String prenomAbonne = scanner.nextLine();
//		System.out.println("Entrez votre dateDeN:(separe par /) ");
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
//		String dateDeNAbonne = scanner.nextLine();
//		LocalDateTime dateTime = LocalDateTime.parse(dateDeNAbonne+" 00:00", formatter);
//		System.out.println("Entrez votre adresse: ");
//		String adresseAbonne = scanner.nextLine();
//		System.out.println("Entrez votre sex: (femme=1/homme=0) ");
//		String sexeAbonne = scanner.nextLine();
//
//		Abonne newAbonne = Abonne.builder()
//				.abonneId(currentClient.getClientId())
//				.adresse(adresseAbonne)
//				.dateDebutAbonne(LocalDateTime.now())
//				.dateFinAbonne(LocalDateTime.now().plusYears(1L))
//				.nom(nomAbonne)
//				.prenom(prenomAbonne)
//				.sexe(Integer.parseInt(sexeAbonne))
//				.dateDeN(dateTime)
//				.build();
//
//		abonneRepository.save(newAbonne);
//		locationClientOk();
//	}
//
//	private void locationNonAbonne() {
//		if(currentClient!=null){
//			locationClientOk();
//		}
//		else {
//			System.out.println("Input your bank card credentials (16 digits card number): ");
//			Long clientCB = Long.parseLong(scanner.nextLine());
//			String clientSecretCode = getAlphaNumericString();
//			System.out.println("Your secret code is " + clientSecretCode + ". Remember it!");
//
//			Client newClient = Client.builder()
//					.numeroCarteBancaire(clientCB)
//					.codeSecret(clientSecretCode)
//					.build();
//
//			clientRepository.save(newClient);
//			List<Client> clients = clientRepository.findAll();
//			currentClient = clients.get(clients.size() - 1);
//			System.out.println(currentClient.getClientId());
//
//			locationClientOk();
//		}
//	}
//
//	private void locationClientOk() {
//		StringBuilder modeles = new StringBuilder();
//
//		for(Bornette bornette: bornettesDispo){
//			modeles.append("/").append(bornette.getCurrentVelo().getModeleDeVeloModeleName());
//		}
//		System.out.println("Quel modele de velo voulez vous imprunter: " + modeles);
//		String modeleChoisi = scanner.nextLine();
//		List<Velo> veloDisponibles = new ArrayList<>(Collections.emptyList());
//		for (Bornette b : bornettesDispo) {
//			if(b.getCurrentVelo().getEtatV()== AllEnums.Etat.ETAT_OK)
//				veloDisponibles.add(b.getCurrentVelo());
//		}
//		Bornette bornettePourClient = bornetteRepository.findFirstByStationMereAndCurrentVelo_ModeleDeVelo_ModeleName(currentStation,modeleChoisi);
//		System.out.println("Vous pouvez prendre le velo a la bornette numero " + bornettePourClient.getBornetteId() + ".");
//		System.out.println("....Client recupere le velo....");
//
////		List<Location> locations = locationRepository.findAll();
////		System.out.println(locations);
//
//		Location location = Location.builder()
//				.locationId(200L)
//				.client(currentClient)
//				.velo(bornettePourClient.getCurrentVelo())
//				.startDate(LocalDateTime.now())
//				.stationDepart(currentStation)
//				.build();
//
//		locationRepository.save(location);
//		bornettePourClient.setCurrentVelo(null);
//		bornetteRepository.save(bornettePourClient);
//		System.out.println("Location " + location +" vient d'etre cree.");
//	}
//
//	private static String getAlphaNumericString()
//	{
//		int n = 4;
//		// length is bounded by 256 Character
//		byte[] array = new byte[256];
//		new Random().nextBytes(array);
//
//		String randomString
//				= new String(array, StandardCharsets.UTF_8);
//
//		// Create a StringBuffer to store the result
//		StringBuilder r = new StringBuilder();
//
//		// Append first 20 alphanumeric characters
//		// from the generated random String into the result
//		for (int k = 0; k < randomString.length(); k++) {
//
//			char ch = randomString.charAt(k);
//
//			if (((ch >= 'a' && ch <= 'z')
//					|| (ch >= 'A' && ch <= 'Z')
//					|| (ch >= '0' && ch <= '9'))
//					&& (n > 0)) {
//
//				r.append(ch);
//				n--;
//			}
//		}
//
//		// return the resultant string
//		return r.toString();
//	}
//
//
//	//Main Application
//	@Override
//	public void run(ApplicationArguments args){
//
//		System.out.println("******* Welcome to Our Application *******");
//
//		boolean end = false;
//		while(!end){
//
//			currentStation = stationRepository.getById(14L);
//			System.out.println("Bonjour, vous etes a la station numero " + currentStation.getStationId() +".");
//			bornettesDispo = bornetteRepository.findByStationMereAndCurrentVelo_EtatV(currentStation, AllEnums.Etat.ETAT_OK);
//			if(bornettesDispo.size()==0){
//				System.out.println("Malheureusement, il n'y a plus de velo disponible sur cette station.");
//				break;
//			}
//
//			System.out.println("1) Location.");
//			System.out.println("2) Return a bicycle.");
//			System.out.println("3) Quit.");
//			System.out.print("-What would you like to do: ");
//
//			String userInput = scanner.nextLine();  // Read user input
//			switch (userInput){
//				case "1":
//					locationProcess();
//					break;
//				case "2":
//					returnProcess();
//					break;
//				case "3":
//					end = true;
//					break;
//				default:
//					System.out.print("Tapez 1, 2 ou 3 s'il vou plait.");
//					break;
//
//			}
//		}
//	}
//}

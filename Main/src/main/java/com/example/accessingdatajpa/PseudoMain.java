package com.example.accessingdatajpa;


import com.example.accessingdatajpa.entity.*;
import com.example.accessingdatajpa.repository.api.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Component
@EnableJpaRepositories
class PseudoMain implements ApplicationRunner {

    //Repositories pour le CRUD
    final ClientRepository clientRepository;
    final VeloRepository veloRepository;
    final AbonneRepository abonneRepository;
    final BornetteRepository bornetteRepository;
    final LocationRepository locationRepository;
    final StationRepository stationRepository;

    List<Bornette> bornettesDispo = null;
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
        List<Bornette> bornettesLibre = bornetteRepository.findByStationMereAndCurrentVelo(currentStation, null);
        if(bornettesLibre.size()==0){
            System.out.println("Malheureusement, il n'y a pas de bornette libre pour votre velo.");
        }
        else{
            System.out.print("Entrez votre code secret: ");
            String userInput = scanner.nextLine();  // Read user input
            while(userInput.length()!=4){
                System.out.print("Code incorrecte.");
                userInput = scanner.nextLine();  // Read user input
            }
            currentClient = clientRepository.findByCodeSecret(userInput);
            if(currentClient==null){
                System.out.println("On n'a pas reussi de trouver le client avec ce code.");
            }
            else{
                List<Location> locationsDeClient = locationRepository.findAllByClientAndStationArriveeNull(currentClient);
                if(locationsDeClient.size()==0){
                    System.out.println("Vous n'avez pas de locations.");
                    return;
                }
                System.out.println("Quel location(id) voulez-vous terminer: \n" + locationsDeClient);
                userInput = scanner.nextLine();

                Location locationATerminer = locationRepository.getByLocationId(Long.parseLong(userInput));
                locationATerminer.setEndDate(LocalDateTime.now());
                locationATerminer.setStationArrivee(currentStation);
                locationRepository.save(locationATerminer);

                long minutes = ChronoUnit.MINUTES.between(locationATerminer.getStartDate(), locationATerminer.getEndDate());
                float prix;

                Bornette bornetteDisponible = bornetteRepository.findFirstByStationMereAndCurrentVelo(currentStation, null);
                bornetteDisponible.setCurrentVelo(locationATerminer.getVelo());
                bornetteRepository.save(bornetteDisponible);
                Abonne currentClientAbonne = abonneRepository.findByAbonneId(currentClient.getClientId());
                if(currentClientAbonne!=null){
                    prix = 0.7f * locationATerminer.getVelo().getModeleDeVeloPrix()*Float.parseFloat(String.valueOf(minutes));
                    if(locationATerminer.getStationArrivee().getClassification()== AllEnums.Classification.vPlus
                            &&locationATerminer.getStationDepart().getClassification()== AllEnums.Classification.vMoins){
                        currentClientAbonne.setPrime(currentClientAbonne.getPrime()+Float.parseFloat(String.valueOf(minutes)));
                    }
                    System.out.println("Vous avez gagne" + currentClientAbonne.getPrime() + "minutes.");
                    abonneRepository.save(currentClientAbonne);
                }
                else {
                    prix = locationATerminer.getVelo().getModeleDeVeloPrix() * Float.parseFloat(String.valueOf(minutes));
                }
                System.out.println("Location est terminer. Vous serez facture de " + prix + " euros");
            }
        }
    }

    private void locationProcess() {
        if(bornettesDispo.size()==0){
            System.out.println("Malheureusement, il n'y a plus de velo disponible sur cette station.");
            return;
        }
        System.out.println("Vous etes deja abonne? (O/N)");
        String userInput = scanner.nextLine();  // Read user input
        switch(userInput.toLowerCase()){
            case "o":
                locationAbonne();
                break;
            case "n":
                userInput = "";
                while(!userInput.equalsIgnoreCase("o") && !userInput.equalsIgnoreCase("n")){
                    System.out.println("Voulez-vous vous abonne? (O/N)");
                    userInput = scanner.nextLine();  // Read user input
                }
                if(Objects.equals(userInput.toLowerCase(), "o"))
                    creerAbonne();
                else
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
        if(currentClient==null){
            System.out.println("On n'a pas reussi de trouver le client avec ce code. On va vous donner le nouveau.");
            locationNonAbonne();
            return;
        }
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
        else{
            locationClientOk();
        }
    }

    private void creerAbonne() {
        System.out.println("Entrez votre nom: ");
        String nomAbonne = scanner.nextLine();
        System.out.println("Entrez votre prenom: ");
        String prenomAbonne = scanner.nextLine();
        System.out.println("Entrez votre dateDeN:(separe par /) ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dateDeNAbonne = scanner.nextLine();
        LocalDateTime dateTime = LocalDateTime.parse(dateDeNAbonne+" 00:00", formatter);
        System.out.println("Entrez votre adresse: ");
        String adresseAbonne = scanner.nextLine();
        System.out.println("Entrez votre sex: (femme=1/homme=0) ");
        String sexeAbonne = scanner.nextLine();
        if(currentClient==null)
            creationClient();
        Abonne newAbonne = Abonne.builder()
                .abonneId(currentClient.getClientId())
                .adresse(adresseAbonne)
                .dateDebutAbonne(LocalDateTime.now())
                .dateFinAbonne(LocalDateTime.now().plusYears(1L))
                .nom(nomAbonne)
                .prenom(prenomAbonne)
                .sexe(Integer.parseInt(sexeAbonne))
                .dateDeN(dateTime)
                .build();

        abonneRepository.save(newAbonne);
        locationClientOk();
    }

    private void locationNonAbonne() {
        if (currentClient == null) {
            creationClient();
        }
        locationClientOk();
    }

    private void creationClient() {
        System.out.println("Input your bank card credentials (16 digits card number): ");
        Long clientCB = Long.parseLong(scanner.nextLine());
        String clientSecretCode = getAlphaNumericString();
        System.out.println("Your secret code is " + clientSecretCode + ". Remember it!");

        Client newClient = Client.builder()
                .numeroCarteBancaire(clientCB)
                .codeSecret(clientSecretCode)
                .build();

        clientRepository.save(newClient);
        currentClient = newClient;
    }

    private void locationClientOk() {
        StringBuilder modeles = new StringBuilder();

        //Collection des modeles disponobles
        for(Bornette bornette: bornettesDispo){
            if(modeles.indexOf(bornette.getCurrentVelo().getModeleDeVeloModeleName())==-1)
                modeles.append("/").append(bornette.getCurrentVelo().getModeleDeVeloModeleName());
        }
        System.out.println("Quel modele de velo voulez vous imprunter: " + modeles);
        String modeleChoisi = scanner.nextLine();

        //Collection des velos disponibles
        List<Velo> veloDisponibles = new ArrayList<>(Collections.emptyList());
        for (Bornette b : bornettesDispo) {
            if(b.getCurrentVelo().getEtatV()== AllEnums.Etat.ETAT_OK)
                veloDisponibles.add(b.getCurrentVelo());
        }
        Bornette bornettePourClient = bornetteRepository.findFirstByStationMereAndCurrentVelo_ModeleDeVelo_ModeleName(currentStation,modeleChoisi);
        System.out.println("Vous pouvez prendre le velo a la bornette numero " + bornettePourClient.getBornetteId() + ".");
        System.out.println("....Client recupere le velo....");
        clientRepository.save(currentClient);

        //Creation de la nouvelle location
        long size = Long.parseLong(String.valueOf(locationRepository.findAll().size()));
        Location location = Location.builder()
                .locationId(size+1)
                .client(currentClient)
                .velo(bornettePourClient.getCurrentVelo())
                .startDate(LocalDateTime.now())
                .stationDepart(currentStation)
                .build();
        locationRepository.save(location);
        bornettePourClient.setCurrentVelo(null);
        bornetteRepository.save(bornettePourClient);
        System.out.println("Location " + location +" vient d'etre cree.");
    }

    private static String getAlphaNumericString()
    {
        //Longeur choisi
        int n = 4;
        // Longeur maximale est de 256
        byte[] array = new byte[256];
        new Random().nextBytes(array);

        String randomString = new String(array, StandardCharsets.UTF_8);

        // String-buffer pour contenir le resultat
        StringBuilder stringBufferResult = new StringBuilder();

        // Append les 20 premiers caracters alphanumeric
        // de random-String into the result
        for (int k = 0; k < randomString.length(); k++) {

            char charAt = randomString.charAt(k);

            if (((charAt >= 'a' && charAt <= 'z')
                    || (charAt >= 'A' && charAt <= 'Z')
                    || (charAt >= '0' && charAt <= '9'))
                    && (n > 0)) {

                stringBufferResult.append(charAt);
                n--;
            }
        }

        // return le resultat
        return stringBufferResult.toString();
    }


    //Main Application
    @Override
    public void run(ApplicationArguments args){

        System.out.println("******* Welcome to Our Application *******");

        currentStation = stationRepository.getById(1L);
        System.out.println("Bonjour, vous etes a la station numero " + currentStation.getStationId() +".");

        boolean end = false;
        while(!end){
            bornettesDispo = bornetteRepository.findByStationMereAndCurrentVelo_EtatV(currentStation, AllEnums.Etat.ETAT_OK);


            System.out.println("1) Location.");
            System.out.println("2) Retourner un velo.");
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

package com.example.accessingdatajpa;

import com.example.accessingdatajpa.entity.Client;
import com.example.accessingdatajpa.repository.RepositoryFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class PseudoMain {


    @PersistenceContext
    protected EntityManager em;

    RepositoryFactory repositories = new RepositoryFactory(em);

    Client currentClient = null;
    Scanner scanner;

    public PseudoMain() {
        this.scanner = new Scanner(System.in);
    }

    public void mainBoucle(){

        System.out.println("******* Welcome to Our Application *******");

        boolean end = false;
        while(!end){

            System.out.println("1) Location.");
            System.out.println("2) Return a bicycle.");
            if(currentClient!=null)
                System.out.println("3) Sign out.");
            else
                System.out.println("3) Sign in.");
            System.out.println("4) Log in.");
            System.out.println("5) Quit.");
            System.out.println("-What would you like to do: ");

            String userInput = scanner.nextLine();  // Read user input
            switch (userInput){
                case "1":
                    locationProcess();
                    break;
                case "2":
                    returnProcess();
                    break;
                case "3":
                    if(currentClient!=null)
                        signOutProcess();
                    else
                        signInProcess();
                    break;
                case "4":
                    logInProcess();
                    break;
                default:
                    end = true;
                    break;
            }
        }
    }

    private void signOutProcess() {
    }

    private void returnProcess() {
        System.out.println("Return Process");
    }

    private void locationProcess() {
        System.out.println("Location Process");
        if(currentClient==null)
            locationNonAbonne();
        else
            locationAbonne();
    }

    private static void locationAbonne() {
    }

    private void locationNonAbonne() {
        System.out.println("Input your bank card credentials (16 digits card number): ");
        int clientCB = Integer.parseInt(scanner.nextLine());
        String clientSecretCode = gerenateCode();
        System.out.println("Your secret code is " + clientSecretCode + ". Remember it!");
        Client newClient = Client.builder()
                .clientId(1L)
                .numeroCarteBancaire(clientCB)
                .codeSecret(clientSecretCode)
                .build();

        repositories.clientRepository.save(newClient);
        System.out.println(newClient);
    }

    private void logInProcess() {
        System.out.println("Log In Process");
    }

    private void signInProcess() {

        currentClient = Client.builder()
                .build();
        System.out.println("Sign In Process");
    }

    private static String gerenateCode(){
        byte[] array = new byte[4]; // length is bounded by 4
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }
}

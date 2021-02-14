package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.ClientRepository;
import com.example.demo.dao.CompteRepository;
import com.example.demo.dao.OperationRepository;
import com.example.demo.entities.Client;
import com.example.demo.entities.Compte;
import com.example.demo.entities.CompteCourant;
import com.example.demo.entities.CompteEpargne;
import com.example.demo.entities.Retrait;
import com.example.demo.entities.Versement;
import com.example.metier.IBanqueMetier;

@SpringBootApplication
public class VotreBanqueApplication implements CommandLineRunner{
    @Autowired
	private ClientRepository clientRep;
    @Autowired
	private CompteRepository compteRep;
    @Autowired
	private OperationRepository operationRep;
    @Autowired
    private IBanqueMetier banqueMetier;
	public static void main(String[] args) {
		SpringApplication.run(VotreBanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*	// TODO Auto-generated method stub
		Client c1 = clientRep.save(new Client("Najm","Najm@gmail.com"));
		Client c2 = clientRep.save(new Client("NajmDin","NajmDin@gmail.com"));
	Compte cp1 = compteRep.save(new CompteCourant("c1", new Date(), 9000, c1, 6000));
	Compte cp2 = compteRep.save(new CompteEpargne("c2", new Date(), 6000, c2, 5.5));
	operationRep.save(new Versement(new Date(),9000,cp1));
	operationRep.save(new Versement(new Date(),6000,cp1));
	operationRep.save(new Retrait(new Date(),9000,cp1));
	
	operationRep.save(new Versement(new Date(),2500,cp2));
	operationRep.save(new Versement(new Date(),6000,cp2));
	operationRep.save(new Retrait(new Date(),3000,cp2));
	banqueMetier.verser("c1", 5741);*/
	}

}

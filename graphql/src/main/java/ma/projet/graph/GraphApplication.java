package ma.projet.graph;

import ma.projet.graph.entities.Compte;
import ma.projet.graph.entities.Transaction;
import ma.projet.graph.entities.TypeCompte;
import ma.projet.graph.entities.TypeTransaction;
import ma.projet.graph.repositories.CompteRepository;
import ma.projet.graph.repositories.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class GraphApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository, TransactionRepository transactionRepository) {
		return args -> {
			// Initialisation des comptes
			Compte compte1 = compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE));
			Compte compte2 = compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.COURANT));
			Compte compte3 = compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE));

			// Initialisation des transactions pour chaque compte
			transactionRepository.save(new Transaction(null, 1000.0, new Date(), TypeTransaction.DEPOT, compte1));
			transactionRepository.save(new Transaction(null, 500.0, new Date(), TypeTransaction.DEPOT, compte1));

			transactionRepository.save(new Transaction(null, 2000.0, new Date(), TypeTransaction.DEPOT, compte2));
			transactionRepository.save(new Transaction(null, 800.0, new Date(), TypeTransaction.RETRAIT, compte2));

			transactionRepository.save(new Transaction(null, 3000.0, new Date(), TypeTransaction.RETRAIT, compte3));
			transactionRepository.save(new Transaction(null, 1500.0, new Date(), TypeTransaction.RETRAIT, compte3));
		};
	}
}

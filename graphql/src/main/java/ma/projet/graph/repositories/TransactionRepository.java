package ma.projet.graph.repositories;
import ma.projet.graph.entities.Compte;
import ma.projet.graph.entities.Transaction;
import ma.projet.graph.entities.TypeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Trouver toutes les transactions associées à un compte
    @Query("SELECT t FROM Transaction t WHERE t.compte = :compte")
    List<Transaction> findByCompte(Compte compte);

    // Compter le nombre total de transactions
    @Query("SELECT COUNT(t) FROM Transaction t")
    long count();

    // Calculer la somme des transactions d'un type spécifique
    @Query("SELECT SUM(t.montant) FROM Transaction t WHERE t.type = :type")
    double sumByType(TypeTransaction type);
}
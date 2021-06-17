package tutorapp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tutorapp.api.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

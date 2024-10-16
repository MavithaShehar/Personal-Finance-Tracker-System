package lk.my_finance.my_finance.repo;

import lk.my_finance.my_finance.entity.Category;
import lk.my_finance.my_finance.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByUserId(int userId);
}

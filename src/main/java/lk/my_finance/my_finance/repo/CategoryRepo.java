package lk.my_finance.my_finance.repo;

import lk.my_finance.my_finance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<User, Integer> {
}

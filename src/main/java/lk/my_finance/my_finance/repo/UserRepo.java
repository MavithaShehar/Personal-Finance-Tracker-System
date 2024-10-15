package lk.my_finance.my_finance.repo;

import lk.my_finance.my_finance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM user WHERE id = ?1", nativeQuery = true)
    User getUserById(int userId);
}


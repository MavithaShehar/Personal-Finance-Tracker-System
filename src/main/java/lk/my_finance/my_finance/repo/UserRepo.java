package lk.my_finance.my_finance.repo;

import lk.my_finance.my_finance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM user WHERE email = ?1", nativeQuery = true)
    Optional<User> findByEmail(String email);

    @Query(value = "SELECT * FROM user WHERE id = ?1", nativeQuery = true)
    User getUserById(int userId);
}


package in.careerit.main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.careerit.main.entities.Users;



public interface UserRepository extends JpaRepository<Users, Long> {
	Optional<Users> findByEmail(String email);

}

package org.dnyanyog.repository;

import java.util.Optional;

import org.dnyanyog.entity.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepo extends JpaRepository<Authentication, Long>{
	
	Optional<Authentication> findByUserNameAndPassword(String userName, String password);
	
}

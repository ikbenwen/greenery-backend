package nl.wendymichels.springboot.greenery.repository;

import nl.wendymichels.springboot.greenery.domain.ERole;
import nl.wendymichels.springboot.greenery.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}

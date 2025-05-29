package in.careerit.main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.careerit.main.entities.UrlMapping;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long>{
	
	Optional<UrlMapping>findByShortCode(String shortUrl);

}

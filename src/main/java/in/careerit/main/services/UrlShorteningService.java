package in.careerit.main.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.careerit.main.UrlShorteningApplication;
import in.careerit.main.entities.UrlMapping;
import in.careerit.main.repositories.UrlMappingRepository;
import in.careerit.main.urlgenerator.UrlGenerator;

@Service
public class UrlShorteningService {

    private final UrlShorteningApplication urlShorteningApplication;
	
	@Autowired
	private UrlMappingRepository repository;

    UrlShorteningService(UrlShorteningApplication urlShorteningApplication) {
        this.urlShorteningApplication = urlShorteningApplication;
    }
	
	public String ShorternUrl(String originalUrl) {
		String shortCode=UrlGenerator.generateShortCode();
		UrlMapping mapping=new UrlMapping();
		mapping.setOriginalUrl(originalUrl);
		mapping.setShortCode(shortCode);
		repository.save(mapping);
		
		return shortCode;
		
	}
	
	
	public Optional<String> getOriginalUrl(String shortcode){
		return repository.findByShortCode(shortcode).map(UrlMapping::getOriginalUrl);
	}

}

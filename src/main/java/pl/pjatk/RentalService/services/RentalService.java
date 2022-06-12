package pl.pjatk.RentalService.services;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.RentalService.domain.Movie;

@Service
public class RentalService {

    private static final String RESOURCE_URL = "http://localhost:8080/db_movies";
    private final RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public ResponseEntity<Movie> getMovie(Integer id){
        return restTemplate.getForEntity(RESOURCE_URL + "/movies/" + id,Movie.class);
    }
    public ResponseEntity<Movie> returnMovie(Integer id){
        return restTemplate.exchange(RESOURCE_URL + "/makeAvailable/"+ id,HttpMethod.PUT,null,Movie.class);
    }
    public ResponseEntity<Movie> rentMovie(Integer id){
        return restTemplate.exchange(RESOURCE_URL + "/makeNotAvailable/" + id, HttpMethod.PUT,null,Movie.class);
    }
}

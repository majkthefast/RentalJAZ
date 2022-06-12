package pl.pjatk.RentalService.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.RentalService.domain.Movie;
import pl.pjatk.RentalService.services.RentalService;

@RestController
@RequestMapping("/rent")
public class RentalRestController {

    private final RentalService rentalService;

    public RentalRestController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/getexample/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Integer id) {
        return rentalService.getMovie(id);
    }
    @PutMapping("/returnmovie/{id}")
    public ResponseEntity<Movie> returnMovie(@PathVariable Integer id){
        return rentalService.returnMovie(id);
    }
    @PutMapping("/rentmovie/{id}")
    public ResponseEntity<Movie> rentMovie(@PathVariable Integer id){
        return rentalService.rentMovie(id);
    }

}

package pl.pjatk.RentalService.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.RentalService.domain.Movie;
import pl.pjatk.RentalService.services.RentalService;

@RestController
@RequestMapping("/rent")
@Api("/api/tasks")
public class RentalRestController {

    private final RentalService rentalService;

    public RentalRestController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Movie[].class),
            @ApiResponse(code = 400, message = "Bad request", response = Movie.class)
    })
    @ApiOperation(value = "Get example movie by id", notes = "info about movie by id")
    @GetMapping("/getexample/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Integer id) {
        return rentalService.getMovie(id);
    }
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Movie[].class),
            @ApiResponse(code = 400, message = "Bad request", response = Movie.class)
    })
    @ApiOperation(value = "Return movie by id", notes = "return movie and change availbility")
    @PutMapping("/returnmovie/{id}")
    public ResponseEntity<Movie> returnMovie(@PathVariable Integer id){
        return rentalService.returnMovie(id);
    }
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Movie[].class),
            @ApiResponse(code = 400, message = "Bad request", response = Movie.class)
    })
    @ApiOperation(value = "Rent movie by id", notes = "rent movie and change availbility")
    @PutMapping("/rentmovie/{id}")
    public ResponseEntity<Movie> rentMovie(@PathVariable Integer id){
        return rentalService.rentMovie(id);
    }

}

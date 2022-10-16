package pl.jdbcqueryexample.jdbcquery.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistBasicDTO;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistCreateDTO;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistUpdateDTO;
import pl.jdbcqueryexample.jdbcquery.exception.ValidationObjectException;
import pl.jdbcqueryexample.jdbcquery.service.artist.IArtistService;
import pl.jdbcqueryexample.jdbcquery.validator.ArtistValidator;

import java.util.Set;

@AllArgsConstructor
@RequestMapping("/artist")
@Controller
public class ArtistController {

    private final IArtistService artistService;
    private final ArtistValidator validator;

    @GetMapping("/{id}")
    public ResponseEntity <ArtistBasicDTO> getById(@PathVariable Long id) {
        return new ResponseEntity <>(artistService.getBasicArtistDTOById(id) , HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity <Set <ArtistBasicDTO>> getById() {
        return new ResponseEntity <>(artistService.getAllBasicArtistDTO() , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity <ArtistBasicDTO> create(@RequestBody ArtistCreateDTO dto , Errors errors) {
        validator.validateCreate(dto , errors);
        if ( errors.hasErrors() ) {
            throw new ValidationObjectException(errors);
        }

        return new ResponseEntity <>(artistService.create(dto) , HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity <ArtistBasicDTO> update(@PathVariable Long id , @RequestBody ArtistUpdateDTO dto , Errors errors) {
        validator.validateUpdate(id , errors);
        if ( errors.hasErrors() ) {
            throw new ValidationObjectException(errors);
        }

        return new ResponseEntity <>(artistService.update(dto , id) , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        artistService.deleteById(id);
        return new ResponseEntity <>(HttpStatus.OK);
    }

}

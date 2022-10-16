package pl.jdbcqueryexample.jdbcquery.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistBasicDTO;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistCreateDTO;
import pl.jdbcqueryexample.jdbcquery.exception.ValidationObjectException;
import pl.jdbcqueryexample.jdbcquery.service.artist.IArtistService;
import pl.jdbcqueryexample.jdbcquery.validator.ArtistValidator;

@AllArgsConstructor
@RequestMapping("/artist")
@Controller
public class ArtistController {

    private final IArtistService artistService;
    private final ArtistValidator validator;

    @PostMapping
    public ResponseEntity <ArtistBasicDTO> create(@RequestBody ArtistCreateDTO dto , Errors errors) {
        validator.validateCreate(dto , errors);
        if ( errors.hasErrors() ) {
            throw new ValidationObjectException(errors);
        }
        return new ResponseEntity <>(artistService.create(dto) , HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity <ArtistBasicDTO> update(@PathVariable Long id , @RequestBody ArtistCreateDTO dto , Errors errors) {
        validator.validateCreate(dto , errors);
        if ( errors.hasErrors() ) {
            throw new ValidationObjectException(errors);
        }
        return new ResponseEntity <>(artistService.create(dto) , HttpStatus.CREATED);
    }

}

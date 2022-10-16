package pl.jdbcqueryexample.jdbcquery.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.jdbcqueryexample.jdbcquery.dto.SongCreateDTO;
import pl.jdbcqueryexample.jdbcquery.dto.SongDTO;
import pl.jdbcqueryexample.jdbcquery.exception.ValidationObjectException;
import pl.jdbcqueryexample.jdbcquery.service.song.ISongService;
import pl.jdbcqueryexample.jdbcquery.validator.SongValidator;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/song")
@Controller
public class SongController {

    private final ISongService songService;

    private final SongValidator validator;

    @GetMapping("/{id}")
    public ResponseEntity <SongDTO> getById(@PathVariable Long id) {
        return new ResponseEntity <>(songService.getSongDTOById(id) , HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity <List <SongDTO>> getById() {
        return new ResponseEntity <>(songService.getAllSongDTO() , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity <SongDTO> create(@RequestBody SongCreateDTO dto , Errors errors) {
        validator.validateCreate(dto , errors);
        if ( errors.hasErrors() ) {
            throw new ValidationObjectException(errors);
        }

        return new ResponseEntity <>(songService.create(dto) , HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <?> delete(@PathVariable Long id) {
        songService.deleteById(id);
        return new ResponseEntity <>(HttpStatus.OK);
    }

}

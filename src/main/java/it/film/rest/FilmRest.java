package it.film.rest;

import java.util.List;

import javax.persistence.Query;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.film.dao.FilmDao;
import it.film.dao.FilmDaoImp;
import it.film.entity.Film;

@RestController
@RequestMapping("/film")
@Api(value="FilmRest", tags="Gestione film")
public class FilmRest {
	
	// http://localhost:8080/progettosettimana10-0.0.1-SNAPSHOT/swagger-ui.html <--- Link di accesso a Swagger

	FilmDao fd = new FilmDaoImp();
	@PostMapping
	@ApiOperation(value="Inserimento film", notes="Permette di inserire un film nel database")
	public ResponseEntity<String> aggiungiFilm(@RequestBody Film f) {
		try {	fd.aggiungiFilm(f);
		return new ResponseEntity<String>("Film salvato con successo!", HttpStatus.OK);
		} 

		catch (Exception e) {		
			return new ResponseEntity<String>("Film non salvato!", HttpStatus.BAD_REQUEST);

		} 

	}
	
	
	@PutMapping("/{id}")
	@ApiOperation(value="aggiornamento film", notes="Permette di aggiornare un film nel database")
	public ResponseEntity<String> aggiornaFilm(@RequestBody Film f, @PathVariable int id) {
		f.setId(id);
		try { fd.aggiornaFilm(f);
		return new ResponseEntity<String>("Film aggiornato correttamente!", HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Film non aggiornato", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}") //Per convenzione nelle Delete si mette sempre la PK(id)
	@ApiOperation(value="Cancellazione film", notes="Permette di cancellare un film dal database")
	public ResponseEntity<String> cancellaFilm(@PathVariable int id) {
		try { fd.cancellaFilm(id);
			return new ResponseEntity<String>("Film eliminato correttamente!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Film non eliminato", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping
	@ApiOperation(value="Lista film", notes="Permette di visualizzare la lista dei film")
	public ResponseEntity<List<Film>> trovaTutti() {
		try { 
			return new ResponseEntity<List<Film>>(fd.trovaTutti(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Film>>((List<Film>)null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{regista}")
	@ApiOperation(value="Ricerca per regista", notes="Ricerca i film per regista")
	public ResponseEntity<List<Film>> trovaByRegista(@PathVariable String regista) {
		try {
			return new ResponseEntity<List<Film>>(fd.trovaByRegista(regista), HttpStatus.OK);
					
			
		} catch (Exception e) {
			return new ResponseEntity<List<Film>>((List<Film>)null, HttpStatus.BAD_REQUEST);
		}
	}







}

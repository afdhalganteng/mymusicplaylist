package com.myspotify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myspotify.model.Album;
import com.myspotify.services.AlbumService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/album")
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;
	
	
	@PostMapping
	public ResponseEntity<?> addAAlbum(@RequestBody Album album){
		try {
			albumService.add(album);
			return new ResponseEntity<>("Add Album Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PutMapping
	public ResponseEntity<?> edit(@RequestBody Album album){
		try {
			albumService.edit(album);
			return new ResponseEntity<>("Update Album Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id){
		try {
			albumService.delete(id);
			return new ResponseEntity<>("Delete Album Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		try {
			return new ResponseEntity<>(albumService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable String id){
		try {
			return new ResponseEntity<>(albumService.getAlbumbyId(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET,params = {"album"},path = "search")
	public ResponseEntity<?> getByAlbumName(String album){
		try {
			return new ResponseEntity<>(albumService.getAlbumByName(album), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET,params = {"artist"},path = "search")
	public ResponseEntity<?> getByAlbumbyArtistName(String artist){
		try {
			return new ResponseEntity<>(albumService.getAlbumByArtistName(artist), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	

}

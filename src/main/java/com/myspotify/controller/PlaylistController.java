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
import org.springframework.web.bind.annotation.RestController;

import com.myspotify.model.Playlist;
import com.myspotify.services.PlaylistService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/playlist")
public class PlaylistController {
	
	@Autowired
	private PlaylistService playlistService;
	
	@PostMapping
	public ResponseEntity<?> addPlayList(@RequestBody Playlist playlist){
		try {
			playlistService.add(playlist);;
			return new ResponseEntity<>("Add Playlist Succes Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updatePlaylist(@RequestBody Playlist playlist){
		try {
			playlistService.edit(playlist);
			return new ResponseEntity<>("Update Playlist Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> getAllPlayList(){
		try {
			return new ResponseEntity<>(playlistService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAllPlayListbyId(@PathVariable("id") String id){
		try {
			return new ResponseEntity<>(playlistService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id){
		try {
			playlistService.delete(id);
			return new ResponseEntity<>("Delete Playlist Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	

}

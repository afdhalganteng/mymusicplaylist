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

import com.myspotify.model.DetailPlaylist;
import com.myspotify.services.DetailPlayListService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/detail-playlist")
public class DetailPlaylistController {
	
	@Autowired
	private DetailPlayListService dtlService;
	
	
	@PostMapping
	public ResponseEntity<?> addLagutoPlayList(@RequestBody DetailPlaylist dtl){
		try {
			dtlService.add(dtl);
			return new ResponseEntity<>("Add Song To Playlist Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> editLagutoPlayList(@RequestBody DetailPlaylist dtl){
		try {
			dtlService.edit(dtl);
			return new ResponseEntity<>("Update Song To Playlist Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPlaylistbyId(@PathVariable("id") String id){
		try {
			return new ResponseEntity<>(dtlService.getPlaylistDetail(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteSongFromPlaylist(@PathVariable("id") String id){
		try {
			dtlService.delete(id);
			return new ResponseEntity<>("Delete Song From Playlist Succes", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}

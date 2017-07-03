package com.hristov.album.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hristov.album.services.contracts.IAlbumService;

@RestController
@RequestMapping("/api")
public class AlbumController {
	
	private IAlbumService albumService;
	
	@Autowired
	public AlbumController(IAlbumService albumService){
		this.albumService = albumService;
	}
	
	@RequestMapping(value = "/albums", produces = "application/json")
	public String allAlbums(){
		String[] albums = this.albumService.albums();

		Gson gson = new Gson();
		
		return gson.toJson(albums);
	}
}

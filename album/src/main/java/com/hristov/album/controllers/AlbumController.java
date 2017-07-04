package com.hristov.album.controllers;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hristov.album.models.Album;
import com.hristov.album.services.contracts.IAlbumService;
import com.hristov.album.viewmodels.AddPictureViewModel;
import com.hristov.album.viewmodels.CreateAlbumViewModel;

@RestController
@RequestMapping("/api")
public class AlbumController {

	private IAlbumService albumService;

	@Autowired
	public AlbumController(IAlbumService albumService) {
		this.albumService = albumService;
	}

	@RequestMapping(value = "/albums", method = RequestMethod.GET, produces = "application/json")
	public String allAlbums() {
		List<Album> albums = this.albumService.albums();

		Gson gson = new Gson();

		return gson.toJson(albums);
	}

	@RequestMapping(value = "/albums/create", method = RequestMethod.POST, consumes = { "application/json" })
	public String createAlbum(@RequestBody CreateAlbumViewModel albumViewModel) {
		System.out.println(albumViewModel.getName());

		this.albumService.create(albumViewModel.getName());

		return albumViewModel.getName();
	}

	@RequestMapping(value = "/albums/addpicture", method = RequestMethod.POST, consumes = { "application/json" })
	public String addPicture(@RequestBody AddPictureViewModel model) throws UnsupportedEncodingException {
		
		// TODO: Parse properly to byte array
		Album album = this.albumService.addPictureToAlbum(model.getAlbumId(), model.getImage(), model.getPictureName(),
				model.getPictureLocation());

		Gson gson = new Gson();

		return gson.toJson(album);
	}
}

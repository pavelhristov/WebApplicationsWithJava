package com.hristov.album.services;

import org.springframework.stereotype.Service;

import com.hristov.album.services.contracts.IAlbumService;

@Service
public class AlbumService implements IAlbumService {
	public String[] albums(){
		String[] array = new String[]{
		"pesho",
		"gosho",
		"ivan",
		"trendafil"};
		
		return array;
	}
}

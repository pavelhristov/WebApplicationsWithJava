package com.hristov.album.services.contracts;

import java.util.List;

import com.hristov.album.models.Album;

public interface IAlbumService {
	
	List<Album> albums();
	
	Album getById(int id);
	
	Album create(String name) ;
	
	Album addPictureToAlbum(int albumId, byte[] image, String pictureName, String pictureLocation);
	
	Album deletePictureFromAlbum(int albumId, int pictureId);
}
package com.hristov.album.services.contracts;

import java.util.List;

import com.hristov.album.models.Album;
import com.hristov.album.models.Picture;

public interface IAlbumService {
	
	List<Album> albums();
	
	Album getById(int id);
	
	List<Picture> getPictureInAlbum(int id);
	
	Picture getPictureById(int id);
	
	Album create(String name) ;
	
	Album addPictureToAlbum(int albumId, String image, String pictureName, String pictureLocation);
	
	Album deletePictureFromAlbum(int albumId, int pictureId);
}
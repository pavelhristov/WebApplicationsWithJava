package com.hristov.album.viewmodels;

public class AddPictureViewModel {
	private int albumId;
	private String pictureName;
	private String pictureLocation;
	private String image;

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getPictureLocation() {
		return pictureLocation;
	}

	public void setPictureLocation(String pictureLocation) {
		this.pictureLocation = pictureLocation;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}

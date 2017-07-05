package com.hristov.album.services;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.hristov.album.db.HibernateUtils;
import com.hristov.album.models.Album;
import com.hristov.album.models.Picture;
import com.hristov.album.services.contracts.IAlbumService;

@Service
public class AlbumService implements IAlbumService {
	public List<Album> albums() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		return session.createCriteria(Album.class).list();
	}

	public Album getById(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Album album = session.get(Album.class, id);

		return album;
	}
	
	public Picture getPictureById(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Picture pic = session.get(Picture.class, id);

		return pic;
	}
	
	public List<Picture> getPictureInAlbum(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Picture.class).add(
                Restrictions.eq("albumId", id));

		return criteria.list();
	}

	public Album create(String name) {
		Session session = HibernateUtils.getSessionFactory().openSession();

		Transaction transaction = session.getTransaction();
		transaction.begin();

		Album album = new Album();
		album.setName(name);
		album.setLastModified(new Date());

		session.save(album);
		transaction.commit();

		session.close();
		return album;
	}

	public Album addPictureToAlbum(int albumId, String image, String pictureName, String pictureLocation) {
		Session session = HibernateUtils.getSessionFactory().openSession();

		Transaction transaction = session.getTransaction();
		transaction.begin();

		Date now = new Date();
		Album album = session.get(Album.class, albumId);
		Picture picture = new Picture();
		picture.setDate(now);
		picture.setLocation(pictureLocation);
		picture.setName(pictureName);
		picture.setImage(image);

		album.setLastModified(now);
		//album.getPictures().add(picture);
		picture.setAlbumId(album.getId());

		session.save(picture);
		session.save(album);
		transaction.commit();

		session.close();
		return album;
	}

	public Album deletePictureFromAlbum(int albumId, int pictureId) {
		Session session = HibernateUtils.getSessionFactory().openSession();

		Transaction transaction = session.getTransaction();
		transaction.begin();

		Date now = new Date();
		Album album = session.get(Album.class, albumId);
		Picture pic = session.get(Picture.class, pictureId);

		album.setLastModified(now);
		//album.getPictures().remove(pic);

		session.delete(pic);
		session.save(album);
		transaction.commit();

		session.close();
		return album;
	}
}

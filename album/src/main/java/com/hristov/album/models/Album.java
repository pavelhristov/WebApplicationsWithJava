package com.hristov.album.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "albums")
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	@Column(name = "Name")
	private String name;


	@Temporal(TemporalType.DATE)
	@Column(name = "LastModified", unique = true, nullable = false, length = 10)
	private Date lastModified;

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "albums")
//	private Set<Picture> pictures = new HashSet<Picture>(0);
//
//	public Set<Picture> getPictures() {
//		return pictures;
//	}
//
//	public void setPictures(Set<Picture> pictures) {
//		this.pictures = pictures;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
}

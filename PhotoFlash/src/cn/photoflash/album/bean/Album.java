package cn.photoflash.album.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.photoflash.photo.bean.Photo;

public class Album {
	private int aid;
	private String albumname;
	private String a_description;
	private String type;
	private int number;
	private String coverpath;
	private Date time;
	private int power;
	private int uid;
	private List<Photo> photoList = new ArrayList<Photo>();

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAlbumname() {
		return albumname;
	}

	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}

	public String getA_description() {
		return a_description;
	}

	public void setA_description(String a_description) {
		this.a_description = a_description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCoverpath() {
		return coverpath;
	}

	public void setCoverpath(String coverpath) {
		this.coverpath = coverpath;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public List<Photo> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<Photo> photoList) {
		this.photoList = photoList;
	}

	@Override
	public String toString() {
		return "Album [aid=" + aid + ", albumname=" + albumname + ", a_description=" + a_description + ", type=" + type
				+ ", number=" + number + ", coverpath=" + coverpath + ", time=" + time + ", power=" + power + ", uid="
				+ uid + "]";
	}

}

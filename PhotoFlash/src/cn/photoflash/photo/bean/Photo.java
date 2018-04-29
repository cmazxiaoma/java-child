package cn.photoflash.photo.bean;

import java.util.Date;

public class Photo {

	private int pid;
	private String photoname;
	private String filepath;
	private String p_description;
	private boolean isdel;
	private int uid;
	private int aid;
	private Date uptime;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPhotoname() {
		return photoname;
	}

	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getP_description() {
		return p_description;
	}

	public void setP_description(String p_description) {
		this.p_description = p_description;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public boolean isIsdel() {
		return isdel;
	}

	public void setIsdel(boolean isdel) {
		this.isdel = isdel;
	}

	public Date getUptime() {
		return uptime;
	}

	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}

	@Override
	public String toString() {
		return "Photo [pid=" + pid + ", photoname=" + photoname + ", filepath=" + filepath + ", p_description="
				+ p_description + ", isdel=" + isdel + ", uid=" + uid + ", aid=" + aid + "]";
	}

}

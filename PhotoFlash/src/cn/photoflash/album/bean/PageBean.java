package cn.photoflash.album.bean;

import java.util.List;

public class PageBean {
	private int curpage; // 当前页面
	@SuppressWarnings("unused")
	private int totalpage; // 总页数
	private int totalrows; // 总行数 从数据库中获取
	private int pagesize; // 页面显示的条目
	private List<Album> albumList;

	public int getCurpage() {
		return curpage;
	}

	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}

	// 判断条数是否被整除 然后 只有get方法 没有set方法 因为总页数是求出来的
	public int getTotalpage() {
		int pc = totalrows / pagesize;
		return totalrows % pagesize == 0 ? pc : pc + 1;
	}

	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public List<Album> getAlbumList() {
		return albumList;
	}

	public void setAlbumList(List<Album> albumList) {
		this.albumList = albumList;
	}

}

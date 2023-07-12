package bitedu.bipa.boardList.vo;

import java.sql.Date;

public class BoardVO {
	private int no;
	private String title;
	private String writer;
	private String contents;
	private Date cdt; //积己老
	private Date mdt; //荐沥老
	private int flag;
	
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", contents=" + contents + ", cdt="
				+ cdt + ", mdt=" + mdt + ", flag=" + flag + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getCdt() {
		return cdt;
	}
	public void setCdt(Date cdt) {
		this.cdt = cdt;
	}
	public Date getMdt() {
		return mdt;
	}
	public void setMdt(Date mdt) {
		this.mdt = mdt;
	}
	public int isFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}

}

package bitedu.bipa.boardList.vo;

public class CommentsVo {
	public int no;
	public int boardNo;
	public String contents;
	public String writter;
	public String cdt;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWritter() {
		return writter;
	}
	public void setWritter(String writter) {
		this.writter = writter;
	}
	public String getCdt() {
		return cdt;
	}
	public void setCdt(String cdt) {
		this.cdt = cdt;
	}
	@Override
	public String toString() {
		return "CommentsVo [no=" + no + ", boardNo=" + boardNo + ", contents=" + contents + ", writter=" + writter
				+ ", cdt=" + cdt + "]";
	}
	
	

}

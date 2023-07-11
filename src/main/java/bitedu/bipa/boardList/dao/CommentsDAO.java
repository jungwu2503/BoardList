package bitedu.bipa.boardList.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import bitedu.bipa.boardList.utils.ConnectionManager;
import bitedu.bipa.boardList.vo.CommentsVo;


@Repository
public class CommentsDAO {

private ConnectionManager manager;
	
	public CommentsDAO() {
		manager = ConnectionManager.getInstance();
	}
	
	//댓글 조회
	public ArrayList<CommentsVo> findByBoard(int boardNo){
		ArrayList<CommentsVo> list = new ArrayList<CommentsVo>();
		
		StringBuilder sb = new StringBuilder("select * from comments where board_no = ? ");
		String sql = sb.toString();
		
		Connection con = manager.getConnection();
		PreparedStatement pstmt;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CommentsVo cmt = new CommentsVo();
				cmt.setNo(rs.getInt(1));
				cmt.setBoardNo(rs.getInt(2));
				cmt.setContents(rs.getString(3));
				cmt.setWritter(rs.getString(4));
				cmt.setCdt(rs.getString(5));
				list.add(cmt);
			}
			manager.closeConnection(rs, pstmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
}

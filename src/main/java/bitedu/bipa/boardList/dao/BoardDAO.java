package bitedu.bipa.boardList.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bitedu.bipa.boardList.utils.ConnectionManager;
import bitedu.bipa.boardList.vo.BoardVO;

@Repository("BoardDAO")
public class BoardDAO {
	
	@Autowired
	private DataSource dataSource;
//	private ConnectionManager manager;
//	public BoardDAO() {
//		manager = ConnectionManager.getInstance();
//	}
//	
	//search board list all
	public ArrayList<BoardVO> searchAll(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select * from board where flag = 1";
		Connection con = null;
		PreparedStatement pstmt = null;		
		try {
			con = dataSource.getConnection();
//			con = manager.getConnection();
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setNo(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContents(rs.getString(4));
				board.setCdt(rs.getDate(5));
				board.setMdt(rs.getDate(6));
				board.setFlag(rs.getInt(7));
				list.add(board);
			}
//			manager.closeConnection(rs, pstmt, con);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return list;
	}
	
	// delete to list(change flag 1 -> 0)
	public boolean delete(int parseInt) {
		boolean flag = false;
		String sql = "update board set flag = 0 where no = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
//			con = manager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, parseInt);
			int affectedCount = pstmt.executeUpdate();
			if(affectedCount > 0) {
				flag = true;
			}
			con.close();
//			manager.closeConnection(null, pstmt, con);
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}
	
	public BoardVO select(int parseInt) {
		BoardVO board = null;
		String sql = "select contents from board where no = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, parseInt);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board = new BoardVO();
				board.setContents(rs.getString(1));
			}
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return board;
	}
	
	public boolean update(BoardVO board) {
		boolean flag = false;
		String sql = "update boardlist set contents=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getContents());
			int affectedCount = pstmt.executeUpdate();
			if(affectedCount>0) {
				flag = true;
			}
			con.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

}

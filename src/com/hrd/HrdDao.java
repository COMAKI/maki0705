package com.hrd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.Hrd;

public class HrdDao<K,V> extends Dao<K, V> {

	@Override
	public void insert(Connection con, K obj) throws Exception {
		PreparedStatement pstmt = null;
		Hrd hrd = (Hrd)obj;
		try {
			pstmt = 
			con.prepareStatement(Sql.insertHrd);
			pstmt.setString(1, hrd.getTitle());
			pstmt.setString(2, hrd.getTitleIcon());
			pstmt.setString(3, hrd.getImgGubun());
			pstmt.setString(4, hrd.getSubTitle());
			pstmt.setString(5, hrd.getAddress());
			pstmt.setString(6, hrd.getTelNo());
			pstmt.setString(7, hrd.getContents());
			pstmt.setString(8, hrd.getSuperViser());
			pstmt.setString(9, hrd.getTrainTarget());
			pstmt.setString(10, hrd.getYardMan());
			pstmt.setString(11, hrd.getRealMan());
			pstmt.setString(12, hrd.getCourseMan());
			pstmt.setString(13, hrd.getRegCourseMan());
			pstmt.setString(14, hrd.getTraEndDate());
			pstmt.setString(15, hrd.getTraStartDate());
			pstmt.setString(16, hrd.getGrade());
			pstmt.setString(17, hrd.getNcsCd());
			pstmt.setString(18, hrd.getInstCd());
			pstmt.setString(19, hrd.getTrprId());
			pstmt.setString(20, hrd.getTrprDegr());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
		}
	}

	@Override
	public void delete(Connection con, V id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Connection con, K obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings({ "unchecked", "null" })
	@Override
	public K select(Connection con, V id) throws Exception {
		Hrd hrd = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = 
			con.prepareStatement(Sql.selectHrd);
			pstmt.setString(1, hrd.getTrprId());
			pstmt.setString(2, hrd.getTrprDegr());
			rset = pstmt.executeQuery();
			rset.next();
			String title        = rset.getString("TITLE");
			String titleIcon    = rset.getString("TITLE_ICON");
			String imgGubun     = rset.getString("IMG_GUBUN");
			String subTitle     = rset.getString("SUB_TITLE"); 
			String address      = rset.getString("ADDRESS");	
			String telNo        = rset.getString("TEL_NO");	
			String contents     = rset.getString("CONTENTS");
			String superViser   = rset.getString("SUPER_VISER");
			String trainTarget  = rset.getString("TRAIN_TARGET");
			String yardMan      = rset.getString("YARD_MAN");
			String realMan      = rset.getString("REAL_MAN");
			String courseMan    = rset.getString("COURSE_MAN");
			String regCourseMan = rset.getString("REG_COURSE_MAN");
			String traEndDate   = rset.getString("TRA_END_DATE");	
			String traStartDate = rset.getString("TRA_START_DATE");
			String grade        = rset.getString("GRADE");	
			String ncsCd        = rset.getString("NCS_CD");	
			String instCd       = rset.getString("INST_CD");	
			String trprId       = rset.getString("TRPR_ID");	
			String trprDegr     = rset.getString("TRPR_DEGR");
	
			hrd = new Hrd(
					title, titleIcon, imgGubun, subTitle, address,
					telNo, contents, superViser, trainTarget, yardMan,
					realMan, courseMan, regCourseMan, traEndDate, traStartDate,
					grade, ncsCd, instCd, trprId, trprDegr);
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
			close(rset);
		}					
		return (K)hrd;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<K> select(Connection con) throws Exception {
		ArrayList<Hrd> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = 
			con.prepareStatement(Sql.selectallHrd);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Hrd hrd = null;
				String title        = rset.getString("TITLE");
				String titleIcon    = rset.getString("TITLE_ICON");
				String imgGubun     = rset.getString("IMG_GUBUN");
				String subTitle     = rset.getString("SUB_TITLE"); 
				String address      = rset.getString("ADDRESS");	
				String telNo        = rset.getString("TEL_NO");	
				String contents     = rset.getString("CONTENTS");
				String superViser   = rset.getString("SUPER_VISER");
				String trainTarget  = rset.getString("TRAIN_TARGET");
				String yardMan      = rset.getString("YARD_MAN");
				String realMan      = rset.getString("REAL_MAN");
				String courseMan    = rset.getString("COURSE_MAN");
				String regCourseMan = rset.getString("REG_COURSE_MAN");
				String traEndDate   = rset.getString("TRA_END_DATE");	
				String traStartDate = rset.getString("TRA_START_DATE");
				String grade        = rset.getString("GRADE");	
				String ncsCd        = rset.getString("NCS_CD");	
				String instCd       = rset.getString("INST_CD");	
				String trprId       = rset.getString("TRPR_ID");	
				String trprDegr     = rset.getString("TRPR_DEGR");
				hrd = new Hrd(
						title, titleIcon, imgGubun, subTitle, address,
						telNo, contents, superViser, trainTarget, yardMan,
						realMan, courseMan, regCourseMan, traEndDate, traStartDate,
						grade, ncsCd, instCd, trprId, trprDegr);
				list.add(hrd);
			}
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
			close(rset);
		}					
		return (ArrayList<K>)list;
	}

}

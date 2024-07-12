package com.win.app.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.win.app.util.Pager;

@Repository
public class NoticeDAO {
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.win.app.notice.NoticeDAO.";

	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);
	}

	public List<NoticeDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}

	public int add(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", noticeDTO);
	}

	public NoticeDTO detail(int boardNum) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", boardNum);
	}

	public int update(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", noticeDTO);
	}

	public int delete(int boardNum) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", boardNum);
	}
}

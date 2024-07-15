package com.win.app.boards.qnas;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.win.app.boards.BoardDAO;
import com.win.app.util.Pager;

@Repository
public class QnaDAO implements BoardDAO<QnaDTO> {
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.win.app.boards.qnas.QnaDAO.";

	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);
	}

	@Override
	public List<QnaDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}

	@Override
	public int add(QnaDTO qnaDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", qnaDTO);
	}

	@Override
	public QnaDTO detail(int boardNum) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", boardNum);
	}

	@Override
	public int update(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", qnaDTO);
	}

	@Override
	public int delete(int boardNum) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", boardNum);
	}

	@Override
	public int incrementHit(int boardNum) throws Exception {
		return sqlSession.update(NAMESPACE + "incrementHit", boardNum);
	}
}

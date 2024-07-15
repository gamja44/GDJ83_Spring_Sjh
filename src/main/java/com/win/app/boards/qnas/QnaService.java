package com.win.app.boards.qnas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.win.app.util.Pager;

@Service
public class QnaService {
	@Autowired
	private QnaDAO qnaDAO;

	public List<QnaDTO> getList(Pager pager) throws Exception {
		if (pager.getPage() == null || pager.getPage() < 1) {
			pager.setPage(1L);
		}

		if (pager.getSearch() == null) {
			pager.setSearch("");
		}

		pager.makeRow();
		long totalCount = qnaDAO.getTotalCount(pager);
		pager.makeNum(totalCount);

		return qnaDAO.getList(pager);
	}

	public int add(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.add(qnaDTO);
	}

	public QnaDTO detail(int boardNum) throws Exception {
		return qnaDAO.detail(boardNum);
	}

	public int update(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.update(qnaDTO);
	}

	public int delete(int boardNum) throws Exception {
		return qnaDAO.delete(boardNum);
	}

	public int incrementHit(int boardNum) throws Exception {
		return qnaDAO.incrementHit(boardNum);
	}
}

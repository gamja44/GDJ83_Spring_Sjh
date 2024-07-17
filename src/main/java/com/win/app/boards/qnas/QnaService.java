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

	public int reply(QnaDTO qnaDTO) throws Exception {
		// 필요한 필드 체크
		if (qnaDTO == null || qnaDTO.getBoardNum() == null) {
			throw new NullPointerException("QnaDTO or BoardNum is null");
		}

		// 부모 글 정보 가져오기
		QnaDTO parentDTO = qnaDAO.detail(qnaDTO.getBoardNum());
		if (parentDTO == null) {
			throw new NullPointerException("Parent QnaDTO is null");
		}

		// 답글 처리 로직
		qnaDTO.setRef(parentDTO.getRef());
		qnaDTO.setStep(parentDTO.getStep() + 1);
		qnaDTO.setDepth(parentDTO.getDepth() + 1);

		qnaDAO.updateStep(qnaDTO);
		int result = qnaDAO.reply(qnaDTO);

		return result;
	}
}
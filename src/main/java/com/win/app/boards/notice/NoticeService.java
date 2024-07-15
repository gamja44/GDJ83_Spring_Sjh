package com.win.app.boards.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.win.app.boards.BoardService;
import com.win.app.util.Pager;

@Service
public class NoticeService implements BoardService<NoticeDTO> {
	@Autowired
	private NoticeDAO noticeDAO;

	@Override
	public List<NoticeDTO> getList(Pager pager) throws Exception {
		if (pager.getPage() == null || pager.getPage() < 1) {
			pager.setPage(1L);
		}

		if (pager.getSearch() == null) {
			pager.setSearch("");
		}

		pager.makeRow();
		long totalCount = noticeDAO.getTotalCount(pager);
		pager.makeNum(totalCount);

		return noticeDAO.getList(pager);
	}

	@Override
	public int add(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.add(noticeDTO);
	}

	@Override
	public NoticeDTO detail(int boardNum) throws Exception {
		return noticeDAO.detail(boardNum);
	}

	@Override
	public int update(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.update(noticeDTO);
	}

	@Override
	public int delete(int boardNum) throws Exception {
		return noticeDAO.delete(boardNum);
	}

	@Override
	public int incrementHit(int boardNum) throws Exception {
		return noticeDAO.incrementHit(boardNum);
	}
}

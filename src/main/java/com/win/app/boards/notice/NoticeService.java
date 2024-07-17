package com.win.app.boards.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.win.app.util.Pager;

@Service
public class NoticeService {
	@Autowired
	private NoticeDAO noticeDAO;

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

	public int add(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.add(noticeDTO);
	}

	public NoticeDTO detail(int boardNum) throws Exception {
		return noticeDAO.detail(boardNum);
	}

	public int update(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.update(noticeDTO);
	}

	public int delete(int boardNum) throws Exception {
		return noticeDAO.delete(boardNum);
	}

	public int incrementHit(int boardNum) throws Exception {
		return noticeDAO.incrementHit(boardNum);
	}
}

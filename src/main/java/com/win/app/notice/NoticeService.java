package com.win.app.notice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.win.app.util.Pager;

@Service
public class NoticeService {
	@Autowired
	private NoticeDAO noticeDAO;

	public Map<String, Object> getList(Long page, String kind, String search) throws Exception {
		if (page == null) {
			page = 1L;
		}

		if (page < 1) {
			page = 1L;
		}

		if (search == null) {
			search = "";
		}

		long perPage = 10L;
		long startRow = (page - 1) * perPage + 1;
		long lastRow = page * perPage;

		Pager pager = new Pager();
		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);
		pager.setKind(kind);
		pager.setSearch(search);

		long totalCount = noticeDAO.getTotalCount(pager);
		long totalPage = totalCount / perPage;

		if (totalCount % perPage != 0) {
			totalPage++;
		}

		long perBlock = 5L;
		long totalBlock = totalPage / perBlock;

		if (totalPage % perBlock != 0) {
			totalBlock++;
		}

		long curBlock = page / perBlock;

		if (page % perBlock != 0) {
			curBlock++;
		}

		long startNum = (curBlock - 1) * perBlock + 1;
		long lastNum = curBlock * perBlock;

		boolean pre = curBlock != 1;
		boolean next = curBlock != totalBlock;

		if (curBlock == totalBlock) {
			lastNum = totalPage;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", noticeDAO.getList(pager));
		map.put("totalPage", totalPage);
		map.put("startNum", startNum);
		map.put("lastNum", lastNum);
		map.put("pre", pre);
		map.put("next", next);
		map.put("kind", kind);
		map.put("search", search);

		return map;
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

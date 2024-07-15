package com.win.app.boards;

import java.util.List;

import com.win.app.util.Pager;

public interface BoardService<T extends BoardDTO> {
	List<T> getList(Pager pager) throws Exception;

	int add(T boardDTO) throws Exception;

	T detail(int boardNum) throws Exception;

	int update(T boardDTO) throws Exception;

	int delete(int boardNum) throws Exception;

	int incrementHit(int boardNum) throws Exception;
}

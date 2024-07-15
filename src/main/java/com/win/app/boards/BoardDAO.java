package com.win.app.boards;

import java.util.List;

import com.win.app.util.Pager;

public interface BoardDAO<T> {
	Long getTotalCount(Pager pager) throws Exception;

	List<T> getList(Pager pager) throws Exception;

	int add(T dto) throws Exception;

	T detail(int boardNum) throws Exception;

	int update(T dto) throws Exception;

	int delete(int boardNum) throws Exception;

	int incrementHit(int boardNum) throws Exception;
}

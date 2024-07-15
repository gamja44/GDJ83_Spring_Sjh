package com.win.app.boards.qnas;

import com.win.app.boards.BoardDTO;

public class QnaDTO extends BoardDTO {
	private Integer ref;
	private Integer step;
	private Integer depth;

	// Getters and Setters for Qna-specific fields
	public Integer getRef() {
		return ref;
	}

	public void setRef(Integer ref) {
		this.ref = ref;
	}

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public Integer getDepth() {
		return depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}
}

package org.springframework.social.instagram.api;

import java.io.Serializable;
import java.util.List;

public class CommentsInfo implements Serializable {

	private int total;
	private List<Comment> list;

	public CommentsInfo() {

	}

	public CommentsInfo(final int total, final List<Comment> list) {
		this.total = total;
		this.list = list;
	}

	public int getTotal() {
		return total;
	}

	public List<Comment> getList() {
		return list;
	}

	public void setTotal(final int total) {
		this.total = total;
	}

	public void setList(final List<Comment> list) {
		this.list = list;
	}
}

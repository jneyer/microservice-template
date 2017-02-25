package com.example.util;

import java.io.Serializable;
import java.util.Optional;

/**
 * CollectionRequest collect information for pagination.
 * 
 */
public class CollectionRequest implements Serializable {

	private static final long serialVersionUID = 8617500946622238588L;

	private Integer page = 0;
	private Integer limit = 50;

	public CollectionRequest() {
		super();
	}

	public CollectionRequest(Integer page, Integer limit) {
		super();
		this.setPage(Optional.ofNullable(page).orElse(this.page));
		this.setLimit(Optional.ofNullable(limit).orElse(this.limit));
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "CollectionRequest [page=" + this.getPage() + ", limit=" + this.getLimit() + "]";
	}

}

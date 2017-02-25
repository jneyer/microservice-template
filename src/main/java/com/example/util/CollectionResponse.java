package com.example.util;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.data.domain.Page;

/**
 * CollectionResponse provides the additional page information for a collection
 * response type.
 * 
 * @author jneyer
 */
public class CollectionResponse<T> implements Serializable {

	private static final long serialVersionUID = -5755505138495583964L;

	private Collection<T> content;
	private Integer page;
	private Integer size;
	private Integer pages;
	private Long totalElements;
	private Boolean last;

	public CollectionResponse(Page<T> page) {
		super();
		this.content = page.getContent();
		this.page = page.getNumber();
		this.pages = page.getTotalPages();
		this.last = page.isLast();
		this.size = page.getSize();
		this.totalElements = page.getTotalElements();
	}

	public CollectionResponse(Collection<T> collection) {
		super();
		this.content = collection;
		this.page = 0;
		this.pages = 1;
		this.last = true;
		this.size = (collection != null ? collection.size() : 0);
		this.totalElements = this.size.longValue();
	}

	public Collection<T> getContent() {
		return content;
	}

	public Integer getPage() {
		return page;
	}

	public Integer getSize() {
		return size;
	}

	public Integer getPages() {
		return pages;
	}

	public Boolean getLast() {
		return last;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	@Override
	public String toString() {
		return "CollectionResponse [content=" + this.getContent() + ", page=" + this.getPage() + ", size="
				+ this.getSize() + ", pages=" + this.getPages() + ", totalElements=" + this.getTotalElements()
				+ ", last=" + this.getLast() + "]";
	}

}

package com.source.open.payload;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PagePayload<T> {

	private List<T> content;
	private int pageNumber;
	private int pageSize;
	private long totalElements;
	private int totalPages;
	private boolean lastPage;

	public static <T> PagePayload<T> of(List<T> content, int pageNumber, int pageSize, long totalElements,
			int totalPages, boolean lastPage) {
		PagePayload<T> data = new PagePayload<>();
		data.content = content;
		data.pageNumber = pageNumber;
		data.pageSize = pageSize;
		data.totalElements = totalElements;
		data.totalPages = totalPages;
		data.lastPage = lastPage;
		return data;
	}

	public static <T> PagePayload<T> of(Page<T> page) {

		PagePayload<T> data = new PagePayload<>();

		data.setContent(page.getContent());
		data.setPageNumber(page.getNumber());
		data.setPageSize(page.getSize());
		data.setTotalElements(page.getTotalElements());
		data.setTotalPages(page.getTotalPages());
		data.setLastPage(page.isLast());

		return data;
	}

}

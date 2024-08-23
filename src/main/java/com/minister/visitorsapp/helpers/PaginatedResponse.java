package com.minister.visitorsapp.helpers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PaginatedResponse<T> {
	
	    private List<T> content;
	    private int currentPage;
	    private int totalPages;
	    private long totalItems;

	    public PaginatedResponse(Page<T> page) {
	        this.content = page.getContent();
	        this.currentPage = page.getNumber();
	        this.totalPages = page.getTotalPages();
	        this.totalItems = page.getTotalElements();
	    }

		public List<T> getContent() {
			return content;
		}

		public void setContent(List<T> content) {
			this.content = content;
		}

		public int getCurrentPage() {
			return currentPage;
		}

		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}

		public int getTotalPages() {
			return totalPages;
		}

		public void setTotalPages(int totalPages) {
			this.totalPages = totalPages;
		}

		public long getTotalItems() {
			return totalItems;
		}

		public void setTotalItems(long totalItems) {
			this.totalItems = totalItems;
		}

		@Override
		public String toString() {
			return "PaginatedRespone [content=" + content + ", currentPage=" + currentPage + ", totalPages="
					+ totalPages + ", totalItems=" + totalItems + "]";
		}

		public PaginatedResponse() {
			super();
			// TODO Auto-generated constructor stub
		}

		public PaginatedResponse(List<T> content, int currentPage, int totalPages, long totalItems) {
			super();
			this.content = content;
			this.currentPage = currentPage;
			this.totalPages = totalPages;
			this.totalItems = totalItems;
		}

	    
	}



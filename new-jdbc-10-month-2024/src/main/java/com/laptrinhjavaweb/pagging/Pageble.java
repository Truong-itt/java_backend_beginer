package com.laptrinhjavaweb.pagging;

import com.laptrinhjavaweb.sort.Sorter;

public interface Pageble {
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
	
}

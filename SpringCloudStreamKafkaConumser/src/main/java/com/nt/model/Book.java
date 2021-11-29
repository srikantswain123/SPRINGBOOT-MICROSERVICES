package com.nt.model;

public class Book {
	
	private int bookid;
	private String bookname;
	
	
	public Book(int bookid, String bookname) {
		this.bookid = bookid;
		this.bookname = bookname;
	}


	public Book() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookname=" + bookname + "]";
	}
	
	
	
	
	
	
	
	

}

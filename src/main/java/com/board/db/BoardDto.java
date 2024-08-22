package com.board.db;

public class BoardDto {
	private int num = 0;
	private String writer = "";
	private String title = "";
	private String content = "";
	private String regtime = "";
	private int hits = 0;
	private int usernum = 0;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getUsernum() {
		return usernum;
	}

	public void setUsernum(int usernum) {
		this.usernum = usernum;
	}

	@Override
	public String toString() {
		return "BoardDto [num=" + num + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", regtime=" + regtime + ", hits=" + hits + ", usernum=" + usernum + "]";
	}

}
package com.mindtree.BookApplication.dto;

public class WriterDto {

	private int writerId;
	private String writerName;

	public WriterDto() {
		super();
	}

	public WriterDto(int writerId, String writerName) {
		super();
		this.writerId = writerId;
		this.writerName = writerName;
	}

	public int getWriterId() {
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

}

package com.getir.readingisgood.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database_seq")
public class DatabaseSequencer {

	@Id
	private String id;
	private long seq;
	
	public DatabaseSequencer(String id, long seq) {
		this.id = id;
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
}

package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "Filestatus")
public class Filestatus {

	private long id;
	private String batchID;
	private String fileName;
	private String status;
	
	public Filestatus() {
		
	}
	
	public Filestatus(String batchID, String fileName, String status) {
		this.batchID = batchID;
		this.fileName = fileName;
		this.status = status;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "batch_ID", nullable = false)
	public String getbatchID() {
		return batchID;
	}
	public void setbatchID(String batchID) {
		this.batchID = batchID;
	}
	
	@Column(name = "file_Name", nullable = false)
	public String getfileName() {
		return fileName;
	}
	public void setfileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Column(name = "status", nullable = false)
	public String getstatus() {
		return status;
	}
	public void setstatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", batchID=" + batchID + ", fileName=" + fileName + ", status=" + status
				+ "]";
	}
	
}

package com.csrn.demo.modal;

import java.sql.Blob;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "file_upload")
public class FileUpload {

	@Column(name = "file_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fileId;
	@Column(name = "file_name")
	private String fileName;
	@Column(name = "file_data")
	@Lob
	private byte[] fileData;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

}

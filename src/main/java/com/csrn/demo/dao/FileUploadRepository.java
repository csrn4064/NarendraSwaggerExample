package com.csrn.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csrn.demo.modal.FileUpload;

public interface FileUploadRepository extends JpaRepository<FileUpload, Integer>{

}

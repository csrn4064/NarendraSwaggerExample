package com.csrn.demo.controller;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Spring;
import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.csrn.demo.dao.FileUploadRepository;
import com.csrn.demo.modal.FileUpload;

@RestController
public class FileUploadController {

	@Autowired
	FileUploadRepository fileUploadRepository;

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Transactional
	public ResponseEntity<Object> fileUpload(@RequestParam("file") MultipartFile file) throws IOException {

		FileUpload fileUpload = new FileUpload();
		fileUpload.setFileName(file.getOriginalFilename());
		fileUpload.setFileData(file.getBytes());

		/*
		 * File convertFile = new
		 * File("C:\\Users\\AG43232\\Downloads\\fileUpload\\"+file.getOriginalFilename()
		 * ); convertFile.createNewFile(); FileOutputStream fout = new
		 * FileOutputStream(convertFile); System.out.println(file.getBytes());
		 * 
		 * fout.write(file.getBytes()); fout.close();
		 */

		fileUploadRepository.save(fileUpload);

		return new ResponseEntity<Object>("file uploded successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/random")
	public Map<String, Object> RandomAlphaNumericGenerator() {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("aphanumeric", RandomStringUtils.randomAlphanumeric(5));
		map.put("alphabetic", RandomStringUtils.randomAlphabetic(5));
		map.put("numeric", RandomStringUtils.randomNumeric(5));
		map.put("print", RandomStringUtils.randomPrint(5));
		return map;

	}
	
	@RequestMapping(value = "/check")
	public List<String> checking(@RequestBody Map<String, String> map) {
		
		List<String> list=new ArrayList<String>();
		String groupNumber=map.get("GroupNumber");
		String caseNumber=map.get("CaseNumber");
		String regex = "[a-zA-Z]";
		String alpregex = "[a-zA-Z0-9]+" ;
		String newRegex="(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+";
		System.out.println(groupNumber);
		System.out.println(caseNumber);
		
		if(groupNumber.matches(alpregex)) {
			list.add( "alpregexproper groupNumber");
		}else {
			list.add( "alpregexInproper groupNumber");
			
		}
		if(caseNumber.matches(newRegex)) {
			list.add( "proper case number");
		}else {
			list.add( "in proper case number");
			
		}
		return list;
	}

}

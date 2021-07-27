package com.csrn.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.csrn.demo.dao.UserRepository;
import com.csrn.demo.modal.User;

@RestController
public class ExcelReader {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "/excelupload", method = RequestMethod.POST)
	@Transactional
	public ResponseEntity<Object> fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		
		
		
		//File files=new File("C:\\heapdump\\readerexcel.xlsx");
		
		//FileInputStream fileInputStream=new FileInputStream(files);
		
		 //XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream); 
		XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
		 XSSFSheet sheet=workbook.getSheetAt(0);
		 
		 Row row;
		 for(int i=1; i<=sheet.getLastRowNum();i++) {
			 User user=new User();
			 row=sheet.getRow(i);
			 
			 System.out.println(row.getCell(0).toString());
			 System.out.println(row.getCell(1).toString());
			 System.out.println(row.getCell(2).toString());
			 System.out.println(row.getCell(3).toString());
			 System.out.println(row.getCell(4).toString());
			 System.out.println(row.getCell(5).toString());
			
			 user.setUserName(row.getCell(0).toString());
			user.setFirstName(row.getCell(1).toString());
            user.setMiddleName(row.getCell(2).toString());
            user.setLastName(row.getCell(3).toString());
             
			 Long mobileNo=(long) Double.parseDouble(row.getCell(4).toString());
             int noOfdays=(int) Double.parseDouble(row.getCell(5).toString());
			 
			user.setMobileNo(mobileNo);
			user.setNoOfDays(noOfdays);
			 
			 userRepository.save(user);
			 System.out.println( userRepository.save(user));
			 
		 }
		 
		return new ResponseEntity<Object>("excel uploded successfully", HttpStatus.OK);
	}

}

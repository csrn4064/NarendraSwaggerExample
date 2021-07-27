package com.csrn.demo.controller;

import java.io.IOException;

import org.apache.commons.lang.StringEscapeUtils;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Encoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShedulerPractice {

@RequestMapping("/encode")
public String getEncode() {

		String paramString = "yuhuhjnnmnmn&*&*&*&^%^%$@$@klklklk";

		Encoder encoder = ESAPI.encoder();

		String escapedHTML = StringEscapeUtils.escapeHtml(paramString);
		System.out.println(escapedHTML);

		return encoder.canonicalize(paramString);

	}

}

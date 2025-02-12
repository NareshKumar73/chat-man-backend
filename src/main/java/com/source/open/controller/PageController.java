package com.source.open.controller;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PageController {

//	@formatter:off
	@GetMapping(value = { 
		    "/{path:[^\\.]*}", 
		    "/{path:^(?!api\\/).*}", 
		    "/{path:^(?!webjars\\/).+}", 
		    "/{path:^(?!swagger\\/).+}" 
		})
//	@formatter:on
	public void serveReactApp(HttpServletRequest req, HttpServletResponse res, @PathVariable String path)
			throws IOException {
//		log.debug("Client at {} requested: {}", req.getRemoteHost(), path);
		var indexHtml = new ClassPathResource("static/index.html");
		res.setContentType(MediaType.TEXT_HTML_VALUE);
		StreamUtils.copy(indexHtml.getInputStream(), res.getOutputStream());
	}
}

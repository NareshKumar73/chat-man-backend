package com.source.open.controller;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class PageController {

//	@GetMapping({ "/", "/{path:[^\\.]*}" })
//	public void serveReactApp(HttpServletResponse response) throws IOException {
//		var indexHtml = new ClassPathResource("static/index.html");
//		response.setContentType(MediaType.TEXT_HTML_VALUE);
//		StreamUtils.copy(indexHtml.getInputStream(), response.getOutputStream());
//	}

	@GetMapping(value = { "/{path:[^\\.]*}", "/{path:^(?!api\\/v1).*}" })
	public void serveReactApp(HttpServletResponse response) throws IOException {
		var indexHtml = new ClassPathResource("static/index.html");
		response.setContentType(MediaType.TEXT_HTML_VALUE);
		StreamUtils.copy(indexHtml.getInputStream(), response.getOutputStream());
	}
}

package com.example.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.local.CustomizeMessageResource;
import com.example.local.G11nUploadResult;

@Controller
@RequestMapping(path="/local")
public class LocalTestController {
@GetMapping(path="/success")
public @ResponseBody String ok() throws IOException {
    CustomizeMessageResource customizeMessageResource = new CustomizeMessageResource();

	return customizeMessageResource.getMessage("local.message.success", "zh_CN");
}
}

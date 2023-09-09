package com.fxtrading.FX.Trading.com.entity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@RequestMapping("name")
	String getName() {
		return "Finzly";
	}
}

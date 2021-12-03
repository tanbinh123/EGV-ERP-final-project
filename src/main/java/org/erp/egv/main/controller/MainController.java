package org.erp.egv.main.controller;

import java.util.List;

import org.erp.egv.main.model.dto.ScheduleDTO;
import org.erp.egv.main.model.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	private MainService mainService;
	
	@Autowired
	public MainController(MainService mainService) {
		this.mainService = mainService;
	}
	
	@GetMapping(value = {"/", "/main"})
	public String main() {
		return "main/main";
	}
	
	@PostMapping(value="/")
	public String redirectMain() {
		return "redirect:/";
	}
	
	@GetMapping(value = "/schedule/scheduleList", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<ScheduleDTO> selectScheduleList() {
		System.out.println(mainService.selectScheduleList());
		return mainService.selectScheduleList();
	}
}

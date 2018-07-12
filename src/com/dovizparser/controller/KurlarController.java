package com.dovizparser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dovizparser.entity.Kurlar;
import com.dovizparser.service.KurlarService;

@Controller
@RequestMapping("/kurlar")
public class KurlarController {

	@Autowired
	private KurlarService kurlarService;
	
	@RequestMapping("/list")
	public String ListKurlar(Model theModel){
		
		List<Kurlar> theKurlar = kurlarService.getKurlar();
		
		theModel.addAttribute("kurlar",theKurlar);
		
		return "list-kurlar";
		
	}
	
	public String saveStudent(Kurlar theKurlar) {
		
		kurlarService.saveKurlar(theKurlar);
		
		return "redirect:/student/list";
	}
	
	
}

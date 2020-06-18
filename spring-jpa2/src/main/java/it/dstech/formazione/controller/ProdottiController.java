package it.dstech.formazione.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.dstech.formazione.model.Prodotti;
import it.dstech.formazione.service.ProdottiService;

@Controller
public class ProdottiController {

	@Autowired
	private ProdottiService pservice;
	
	@RequestMapping("/")
	public ModelAndView home() {
		List<Prodotti> listap = pservice.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listap", listap);
		return mav;
	}
	
	@RequestMapping("/new")
	public String newProdottiForm(Map<String, Object> model) {
		Prodotti p = new Prodotti();
		model.put("prodotti", p);
		return "new_prodotti";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProdotti(@ModelAttribute("prodotti") Prodotti prodotti) {
		pservice.save(prodotti);
		return "redirect:/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editProdottiForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_prodotti");
		Prodotti p = pservice.get(id);
		mav.addObject("prodotti", p);
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteProdottiForm(@RequestParam long id) {
		pservice.delete(id);
		return "redirect:/";		
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Prodotti> result = pservice.search(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		
		return mav;		
	}	
}

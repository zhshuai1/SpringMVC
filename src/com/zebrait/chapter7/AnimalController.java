package com.zebrait.chapter7;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value="/zoo/z")
public class AnimalController {

	Map<String,Animal> zoo=new HashMap<String,Animal>();
	public AnimalController() {
		// TODO Auto-generated constructor stub
		super();
		zoo.put("dog", new Animal("dog",2,3,4));
		zoo.put("cat", new Animal("cat", 5, 5, 6));
	}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String showAnimals(Model model){
		model.addAttribute("content", "main");
		model.addAttribute("animals", zoo.values());
		return "zoo";
	}
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	public String showAnimal(@PathVariable String name,Model model){
		model.addAttribute("content", "show");
		model.addAttribute("animal",zoo.get(name));
		return "zoo";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String createAnimal(@ModelAttribute Animal animal,Model model){
		zoo.put(animal.getName(), animal);
		return "redirect:/zoo/z/"+animal.getName();		
	}
	@RequestMapping(value="/",method=RequestMethod.GET,params="new")
	public String newAnimal(Model model){
		model.addAttribute("content", "new");
		model.addAttribute(new Animal());
		return "zoo";
	}
	@RequestMapping(value="/{name}",method=RequestMethod.PUT)
	public String editAnimal(@PathVariable String name,Model model){
		model.addAttribute("content", "edit");
		model.addAttribute("animal",zoo.get(name));
		return "zoo";
	}
	@RequestMapping(value="/{name}",method=RequestMethod.DELETE)
	public String deleteAnimal(@PathVariable String name,Model model){
		zoo.remove(name);
		return "redirect:/zoo/z/";
	}
	
	//下面是Restful的controller
	
	@RequestMapping(value="/y/{name}",method=RequestMethod.GET,
			headers={"Accept=application/json"},produces="application/json")
	public @ResponseBody String getAnimal(@PathVariable String name){	
		zoo.put(name+zoo.size(), new Animal(name+zoo.size(),3,4,5));
		Animal animal=zoo.get(name);
		String result=null;
		ObjectMapper mapper=new ObjectMapper();
		try {
			result=mapper.writeValueAsString(animal);
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return result;
	}
	
}

package com.zebrait.chapter7;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RestMain {
	public static void main(String []args){
		RestTemplate restTemplate=new RestTemplate();
		//List<HttpMessageConverter<?>> messageConverters=restTemplate.getMessageConverters();
		//messageConverters.add(new MappingJackson2HttpMessageConverter());		
		//restTemplate.setMessageConverters(messageConverters);
		for(Object converter: restTemplate.getMessageConverters())
			System.out.println(converter.getClass());
		
		MultiValueMap<String, String> headers=new LinkedMultiValueMap<>();
		headers.add("Accept", "application/json,text/plain,text/html");
		HttpEntity<Object> httpEntity=new HttpEntity<>(headers);
		ResponseEntity<Animal> entity=restTemplate.exchange("http://localhost:8080/SpringMVC/zoo/z/y/{name}", HttpMethod.GET, httpEntity, Animal.class, "dog");
		System.out.println("body: "+entity.getBody().getName());
		Animal animal=restTemplate.getForObject("http://localhost:8080/SpringMVC/zoo/z/y/{name}", 
				Animal.class,"dog");
		System.out.println(animal.getName());		
	}
}

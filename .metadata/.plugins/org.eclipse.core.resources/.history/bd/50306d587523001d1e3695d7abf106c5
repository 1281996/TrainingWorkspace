package com.cog;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cog.entity.User;

public class RestClient {
	private static String url = "http://localhost:7777/user";

	public static void main(String[] args) {

		get();
		post();

	}

	private static void get() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> res = restTemplate.getForEntity(url, String.class);
		System.out.println(res.getStatusCodeValue() + "-" + res.getBody());

	}
	private static void post() {
		RestTemplate restTemplate=new RestTemplate();
		User user=new User();
		user.setAge(21);
		user.setName("Akhila");
		Object obj=restTemplate.postForObject(url, user, Integer.class, new HashMap<>());
		System.out.println(obj);
	}
	
}

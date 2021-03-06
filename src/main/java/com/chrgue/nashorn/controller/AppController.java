package com.chrgue.nashorn.controller;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.chrgue.nashorn.model.Post;
import com.chrgue.nashorn.repository.PostRepository;

@Controller
public class AppController {

	@Autowired
	private PostRepository repository;

	@GetMapping("/")
	public String home(Model model) {
		Stream<Post> posts = repository.findAll();

		model.addAttribute("title", "React example");
		model.addAttribute("posts", posts.collect(Collectors.toList()));
		return "index";
	}
}

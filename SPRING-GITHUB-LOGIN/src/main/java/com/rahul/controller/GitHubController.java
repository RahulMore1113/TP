package com.rahul.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/security")
public class GitHubController {

	@GetMapping("/user")
	public Mono<String> user(@AuthenticationPrincipal Mono<OAuth2User> principal) {

		return principal.map(val -> val.getAttribute("login"));

	}

}

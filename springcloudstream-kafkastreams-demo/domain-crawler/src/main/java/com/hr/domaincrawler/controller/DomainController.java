package com.hr.domaincrawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hr.domaincrawler.service.DomainCrawlerService;

@RestController
@RequestMapping("/domain")
public class DomainController {

	@Autowired
	private DomainCrawlerService service;
	
	@GetMapping("/lookup")
	public String lookup(@RequestParam("name") final String domainName)
	{
		service.crawl(domainName);
		return "The Crawler has fetched the data for the given domain name";
	}
	
}

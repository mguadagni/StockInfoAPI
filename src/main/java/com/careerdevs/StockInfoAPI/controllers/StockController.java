package com.careerdevs.StockInfoAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/stockinfo")
public class StockController {

    @Autowired
    private Environment env;

//    https://www.alphavantage.co/query?function=OVERVIEW&symbol=IBM&apikey=

    private String alphaVantageEndpoint = "https://www.alphavantage.co/query?function=OVERVIEW&symbol=";

    @GetMapping("/{id}")
    public Object ibmHandler(RestTemplate restTemplate, @PathVariable("id") String userId) {
        String apiKey = env.getProperty("API_KEY");
        String stockUrl = alphaVantageEndpoint + userId + "&apikey=" + apiKey;
        return restTemplate.getForObject(stockUrl, Object.class);
    }
}

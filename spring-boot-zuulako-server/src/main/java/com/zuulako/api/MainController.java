package com.zuulako.api;

import com.zuulako.web.ZuulakoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ZuulakoController
@ResponseBody
@RequestMapping("/api/applications")
public class MainController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(method = RequestMethod.GET)
    public List<String> applications() {
        List<String> services = discoveryClient.getServices();


        return services;
    }
}

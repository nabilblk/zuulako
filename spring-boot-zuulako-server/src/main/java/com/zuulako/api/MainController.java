package com.zuulako.api;

import com.zuulako.web.ZuulakoController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@ZuulakoController
@ResponseBody
@RequestMapping("/api/applications")
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    public List<String> applications() {
        List<String> fake = new ArrayList<>();

        fake.add("Elem 1");
        fake.add("Elem 2");
        fake.add("Elem 3");
        fake.add("Elem 4");

        return fake;
    }
}

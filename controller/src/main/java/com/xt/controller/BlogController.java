package com.xt.controller;

import com.xt.pojo.Blog;
import com.xt.service.IBlogService;
import com.xt.utils.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


//跨域请求
@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogservice;

    @RequestMapping(value = "/find",method = RequestMethod.GET)
    @ResponseBody
    public JsonObject getBlogs() {
        JsonObject json = new JsonObject<>();
        List<Blog> blog =blogservice.getBlog();
        json.setResult(blog);
        return json;
    }

}


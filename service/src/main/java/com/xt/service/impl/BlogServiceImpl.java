package com.xt.service.impl;

import com.xt.dao.BlogMapper;
import com.xt.pojo.Blog;
import com.xt.redis.JedisClient;
import com.xt.service.IBlogService;
import com.xt.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private BlogMapper mapper;
    @Autowired
    private JedisClient jedis;

    @SuppressWarnings("unchecked")
    public List<Blog> getBlog() {

        List<Blog> blogs;

        try {
            // 先判断缓存冲是否存在我们需要的结果
            String empsStr = jedis.get("blog");
            // 没有则在数据库查询之后放入
            if (empsStr != null) {
                // 将json字符串转换为Java对象
                blogs = StringUtils.jsonToJava(empsStr, Blog.class);

                return blogs;// 查询到则返回
            }
            // 如果有则直接从缓存中取出来
        } catch (Exception e) {
            e.printStackTrace();
        }

        blogs = mapper.selAll();

        try {
            // 放入到缓存
            jedis.set("blog", StringUtils.javaToJson(blogs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 需要拿到参数去拼接SQL语句
        return blogs;
    }

//    public void delEmp(Integer empNo) {
//
//        //删除缓存
//        jedis.del("EmployeeServiceImpl_listEmps");
//        mapper.delEmp(empNo);
//
//    }


}


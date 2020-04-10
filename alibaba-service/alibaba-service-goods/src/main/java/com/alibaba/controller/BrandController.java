package com.alibaba.controller;

import com.alibaba.goods.pojo.Brand;
import com.alibaba.service.impl.BrandServiceImpl;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
/**
 * 跨域，域名 协议 端口不同 存在跨域问题
 * 如何解决？
 *  DAo 使用通用的mapper
 * */
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandServiceImpl brandServiceImpl;

    /**
     * 查询所有的品牌
     * */
    @GetMapping
    public Result<List<Brand>> findAll(){

        List<Brand> brand= brandServiceImpl.findAll();
        return new Result<List<Brand>>(true, StatusCode.OK,"查询品牌数据成功",brand);
    }
    /**
     * 分页条件查询
     * */

    @PostMapping(value = "/searchpage/{page}/{size}")
    public Result<PageInfo<Brand>> serachList(@RequestBody Brand brand,
                                              @PathVariable(value = "page") Integer page,
                                              @PathVariable(value = "size") Integer size){
        PageInfo<Brand> brandPageInfo = brandServiceImpl.searchpage(brand,page,size);
        return new Result<PageInfo<Brand>>(true,StatusCode.OK,"成功",brandPageInfo);
    }
    /**
     * 多条件查询
     * */
    @PostMapping(value = "/findList")
    public Result<List<Brand>> findList(@RequestBody Brand brand){
        return new Result<>(true,StatusCode.OK,"查询成功",brandServiceImpl.findList(brand));
    }
}

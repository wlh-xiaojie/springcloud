package com.alibaba.service;

import com.alibaba.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface BrandService {
    /**
     * 查询所有品牌
     * */
    List<Brand> findAll();

    /**
     * 分页条件查询
     * @param brand 实体
     * @param page 当前页
     * @param size 条数
     * @return PageInfo<Brand>
     * */
    PageInfo<Brand>  searchpage(Brand brand,Integer page,Integer size);

    /**
     * 多条件搜索
     * */
    List<Brand> findList(Brand brand);
}

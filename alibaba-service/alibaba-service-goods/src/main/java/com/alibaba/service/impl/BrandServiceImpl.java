package com.alibaba.service.impl;

import com.alibaba.dao.BrandMapper;
import com.alibaba.goods.pojo.Brand;
import com.alibaba.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import tk.mybatis.mapper.entity.Example;
import javax.annotation.Resource;
import java.util.List;

public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;
    /**
     * 查询所有的品牌
     *
     * */
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }
    /**
     * 分页条件查询商品
     * @param brand
     * @param page
     * @param size
     * */
    @Override
    public PageInfo<Brand> searchpage(Brand brand, Integer page, Integer size) {
        //分页
        PageHelper.startPage(page,size);
        // 自定义条件
        Example example = createExample(brand);
        // 查询数据
        List<Brand> brands = brandMapper.selectByExample(example);
        return new PageInfo<Brand>(brands);
    }
    /**
     * 多条件查询
     * */
    @Override
    public List<Brand> findList(Brand brand) {
//        Example example = new Example(Brand.class);
//        Example.Criteria criteria = example.createCriteria();
//        if (brand != null){
//            if(!StringUtils.isEmpty(brand.getName())){
//                criteria.andLike("name","%"+brand.getName()+"%");
//            }
//            if (!StringUtils.isEmpty(brand.getLetter())){
//                criteria.andEqualTo("letter",brand.getLetter());
//            }
//        }

        return brandMapper.selectByExample(createExample(brand));
    }

    public Example createExample(Brand brand){
        // 自定义条件搜索
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (brand != null){
            if(!StringUtils.isEmpty(brand.getName())){
                criteria.andLike("name","%"+brand.getName()+"%");
            }
            if (!StringUtils.isEmpty(brand.getLetter())){
                criteria.andEqualTo("letter",brand.getLetter());
            }
        }
        return example;
    }

}

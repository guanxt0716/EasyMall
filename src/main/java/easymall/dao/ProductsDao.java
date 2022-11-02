package easymall.dao;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import easymall.po.Products;

@Repository
@Mapper
public interface ProductsDao {
	//查找商品类别
	public List<String> allcategorys();
	//查找商品
	public List<Products> prodlist(Map<String, Object> map);
	//查找商品详情
	public Products prodInfo(String pid);
	//根据分类查找商品
	public List<Products> proclass(String category);
	public Object findByImgurl(String imgurl);
	public void save(Products products);
	public void delprod(String id);
}

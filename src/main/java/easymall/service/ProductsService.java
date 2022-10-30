package easymall.service;

import java.util.List;
import java.util.Map;

import easymall.po.Products;

public interface ProductsService {
	//查找商品类别
	public List<String> allcategorys();
	//查找商品
	public List<Products> prodkist(Map<String, Object> map);
	
	//查找商品详情
	public Products prodInfo(String pid);
	public List<Products> proclass(String proclass);
}

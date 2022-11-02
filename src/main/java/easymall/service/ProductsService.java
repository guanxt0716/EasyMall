package easymall.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import easymall.po.Products;
import easymall.pojo.MyProducts;

public interface ProductsService {
	//查找商品类别
	public List<String> allcategorys();
	//查找商品
	public List<Products> prodkist(Map<String, Object> map);
	
	//查找商品详情
	public Products prodInfo(String pid);
	public List<Products> proclass(String proclass);
	public String save(MyProducts myProducts, HttpServletRequest request);
	public void delprod(String id);
}

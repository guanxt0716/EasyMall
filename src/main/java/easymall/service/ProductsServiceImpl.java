package easymall.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import easymall.dao.ProductsDao;
import easymall.po.Products;
@Service("productsService")
public class ProductsServiceImpl implements ProductsService {
	@Autowired
	private ProductsDao productsDao;
	@Override
	public List<String> allcategorys() {
		// TODO Auto-generated method stub
		List<String> categorys = productsDao.allcategorys();
		return categorys;
	}

	@Override
	public List<Products> prodkist(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<Products> products = productsDao.prodlist(map);
		return products;
	}

	@Override
	public Products prodInfo(String pid) {
		// TODO Auto-generated method stub
		return productsDao.prodInfo(pid);
	}

	@Override
	public List<Products> proclass(String proclass) {
		// TODO Auto-generated method stub
		return productsDao.proclass(proclass);
	}
}

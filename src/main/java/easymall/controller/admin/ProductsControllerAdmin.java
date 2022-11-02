package easymall.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.stat.TableStat.Mode;

import easymall.po.Products;
import easymall.pojo.MyProducts;
import easymall.service.ProductsService;

@Controller
@RequestMapping("/admin")
public class ProductsControllerAdmin {
	@Autowired
	private ProductsService productsService;
	@RequestMapping("/prodlist")
	public String prodlist(Model model){
		double _minprice = 0;
		double _maxprice = Double.MAX_VALUE;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "");
		map.put("category", "");
		map.put("minPrice", _minprice);
		map.put("maxPrice", _maxprice);
		List<Products> products = productsService.prodkist(map);
		System.out.println(products.size());
		model.addAttribute("products", products);
		return "/admin/prod_list";
	}
	@RequestMapping("/addprod")
	public String addprod(Model model){
		List<String> categories = productsService.allcategorys();
		model.addAttribute("categories", categories);
		model.addAttribute("myproducts", new MyProducts());
		return "/admin/add_prod";
	}
	@RequestMapping("/save")
	public String save(@Valid @ModelAttribute MyProducts myProducts, 
			HttpServletRequest request,Model model) throws Exception{
		String msg = productsService.save(myProducts,request);
		model.addAttribute("msg", msg);
		return "redirect:/admin/addprod";
	}
	@RequestMapping("/delprod")
	public String delprod(String id){
		productsService.delprod(id);
		return "redirect:/admin/prodlist";
	}
}

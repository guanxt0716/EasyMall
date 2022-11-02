package easymall.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import easymall.dao.ProductsDao;
import easymall.po.Products;
import easymall.pojo.MyProducts;
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

	@Override
	public String save(MyProducts myProducts, HttpServletRequest request) {
		// 1.判断后缀是否合法
				// 获取图名称，后缀名称
				String originName = myProducts.getImgurl().getOriginalFilename();
					
				// 截取后缀substring split (".png" ".jgp")
				String extName = originName.substring(originName.lastIndexOf("."));

				if (!(extName.equalsIgnoreCase(".jpg") || extName.equalsIgnoreCase(".png")
								|| extName.equalsIgnoreCase(".gif"))) {// 图片后缀不合法
					return "图片后缀不合法!";
				}
				// 判断木马(java的类判断是否是图片属性，也可以引入第三方jar包判断)
				try {
					BufferedImage bufImage = ImageIO.read(myProducts.getImgurl().getInputStream());
					bufImage.getHeight();
					bufImage.getWidth();
				} catch (Exception e) {
					return "该文件不是图片！";
				}
				// 2.创建upload开始的一个路径
				// 生成多级路径
				String dir = "";
				// /a/2/e/a/2/3/j/p
				for (int i = 0; i < 8; i++) {
					dir += "/" + Integer.toHexString(new Random().nextInt(16));
				}
				
				String realpath = request.getServletContext().getRealPath("/WEB-INF");
				realpath += "/upload";
				// D:\java\Workspace\.metadata\.plugins\org.eclipse.wst.server.core
				// \tmp0\wtpwebapps\EasyMall18\WEB-INF/upload/2/6/2/7/2/d/2/1		
				System.out.println(realpath + dir+"************");
				// 拼接图片存入数据库的路径
				System.out.println(dir+"-------");	
				String imgurl = "/upload" + dir + "/" + originName;	
				System.out.println(imgurl);
				if (productsDao.findByImgurl(imgurl) != null) {
					String fname = imgurl.substring(0,imgurl.lastIndexOf("."));
					imgurl=fname+System.currentTimeMillis()+extName;
				}
				
				File file = new File(realpath + dir, originName);
				if (!file.exists()) {
					file.mkdirs();
				}
				// 上传文件
				try {
					myProducts.getImgurl().transferTo(file);
				} catch (Exception ex) {
					ex.printStackTrace();
				}

				String id = UUID.randomUUID().toString();
				Products products = new Products();
				products.setId(id);
				products.setName(myProducts.getName());
				products.setCategory(myProducts.getCategory());
				products.setPrice(myProducts.getPrice());
				products.setPnum(myProducts.getPnum());
				products.setImgurl(imgurl);
				products.setDescription(myProducts.getDescription());
				productsDao.save(products);	
				return "商品添加成功";

	}

	@Override
	public void delprod(String id) {
		// TODO Auto-generated method stub
		productsDao.delprod(id);
	}
}

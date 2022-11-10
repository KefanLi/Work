package com.shop.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.springframework.stereotype.Controller;

import com.shop.entity.News;
import com.shop.entity.Notice;
import com.shop.entity.PageBean;
import com.shop.entity.Product;
import com.shop.entity.ProductBigType;
import com.shop.entity.Tag;
import com.shop.service.NewsService;
import com.shop.service.NoticeService;
import com.shop.service.ProductBigTypeService;
import com.shop.service.ProductService;
import com.shop.service.TagService;
import com.shop.util.ResponseUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 系统Action类
 * @author Administrator
 *
 */
@Controller
public class SysAction extends ActionSupport implements ApplicationAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> application;
	
	@Resource
	private ProductBigTypeService productBigTypeService;
	
	@Resource
	private TagService tagService;
	
	@Resource
	private NoticeService noticeService;
	
	@Resource
	private NewsService newsService;
	
	@Resource
	private ProductService productService;

	@Override
	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub
		this.application=application;
	}
	
	/**
	 * 刷新系统
	 * @return
	 * @throws Exception
	 */
	public String refreshSystem()throws Exception{
		List<ProductBigType> bigTypeList=productBigTypeService.findAllBigTypeList();
		application.put("bigTypeList", bigTypeList);
		
		List<Tag> tagList=tagService.findTagList(null,null);
		application.put("tagList", tagList);
		
		List<Notice> noticeList=noticeService.findNoticeList(null, new PageBean(1,7));
		application.put("noticeList", noticeList);
		
		List<News> newsList=newsService.findNewsList(null, new PageBean(1,7));
		application.put("newsList", newsList);
		
		Product s_product=new Product();
		s_product.setSpecialPrice(1);
		List<Product> specialPriceProductList=productService.findProductList(s_product, new PageBean(1,8));
		application.put("specialPriceProductList", specialPriceProductList);
		
		s_product=new Product();
		s_product.setHot(1);
		List<Product> hotProductList=productService.findProductList(s_product, new PageBean(1,6));
		application.put("hotProductList", hotProductList);
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(ServletActionContext.getResponse(), result);
		return null;
	}

}

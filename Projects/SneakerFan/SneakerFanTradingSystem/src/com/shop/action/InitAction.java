package com.shop.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

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

/**
 * ��ҳ��ʼ��Action��
 * @author Administrator
 *
 */
@Component
public class InitAction implements ServletContextListener,ApplicationContextAware{

	private static ApplicationContext applicationContext;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		// TODO Auto-generated method stub
		ServletContext application=servletContextEvent.getServletContext();
		ProductBigTypeService productBigTypeService=(ProductBigTypeService)applicationContext.getBean("productBigTypeService");
		List<ProductBigType> bigTypeList=productBigTypeService.findAllBigTypeList();
		application.setAttribute("bigTypeList", bigTypeList);
		
		TagService tagService=(TagService)applicationContext.getBean("tagService");
		List<Tag> tagList=tagService.findTagList(null,null);
		application.setAttribute("tagList", tagList);
		
		NoticeService noticeService=(NoticeService)applicationContext.getBean("noticeService");
		List<Notice> noticeList=noticeService.findNoticeList(null, new PageBean(1,7));
		application.setAttribute("noticeList", noticeList);
		
		NewsService newsService=(NewsService)applicationContext.getBean("newsService");
		List<News> newsList=newsService.findNewsList(null, new PageBean(1,7));
		application.setAttribute("newsList", newsList);
		
		ProductService productService=(ProductService)applicationContext.getBean("productService");
		Product s_product=new Product();
		s_product.setSpecialPrice(1);
		List<Product> specialPriceProductList=productService.findProductList(s_product, new PageBean(1,8));
		application.setAttribute("specialPriceProductList", specialPriceProductList);
		
		s_product=new Product();
		s_product.setHot(1);
		List<Product> hotProductList=productService.findProductList(s_product, new PageBean(1,6));
		application.setAttribute("hotProductList", hotProductList);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext=applicationContext;
	}

}

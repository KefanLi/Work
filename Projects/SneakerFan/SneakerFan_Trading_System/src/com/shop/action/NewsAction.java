package com.shop.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.shop.entity.News;
import com.shop.entity.News;
import com.shop.entity.PageBean;
import com.shop.service.NewsService;
import com.shop.util.NavUtil;
import com.shop.util.ResponseUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 新闻Action类
 * @author Administrator
 *
 */
@Controller
public class NewsAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private NewsService newsService;
	
	private News news;
	private int newsId;
	private String mainPage;
	private String navCode;
	
	private String page;
	private String rows;
	private News s_news;
	private String ids;
	
	
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public News getS_news() {
		return s_news;
	}
	public void setS_news(News s_news) {
		this.s_news = s_news;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getMainPage() {
		return mainPage;
	}
	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}
	public String getNavCode() {
		return navCode;
	}
	public void setNavCode(String navCode) {
		this.navCode = navCode;
	}
	
	/**
	 * 显示新闻详情
	 * @return
	 * @throws Exception
	 */
	public String showNews()throws Exception{
		news=newsService.getNewsById(newsId);
		mainPage="news/newsDetails.jsp";
		navCode=NavUtil.genNavCode("新闻信息");
		return SUCCESS;
	}
	
	/**
	 * 分页查询新闻信息
	 * @return
	 * @throws Exception
	 */
	public String list()throws Exception{
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		List<News> newsList=newsService.findNewsList(s_news, pageBean);
		long total=newsService.getNewsCount(s_news);
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray rows=JSONArray.fromObject(newsList, jsonConfig);
		JSONObject result=new JSONObject();
		result.put("rows", rows);
		result.put("total", total);
		ResponseUtil.write(ServletActionContext.getResponse(), result);
		return null;
	}
	
	/**
	 * 后台-保存新闻信息
	 * @return
	 * @throws Exception
	 */
	public String save()throws Exception{
		if(news.getId()==0){
			news.setCreateTime(new Date());
		}
		newsService.saveNews(news);
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(ServletActionContext.getResponse(), result);
		return null;
	}
	
	/**
	 * 删除新闻
	 * @return
	 * @throws Exception
	 */
	public String delete()throws Exception{
		JSONObject result=new JSONObject();
		String []idsStr=ids.split(",");
		for(int i=0;i<idsStr.length;i++){
			News news=newsService.getNewsById(Integer.parseInt(idsStr[i]));
			newsService.delete(news);
		}
		result.put("success", true);
		ResponseUtil.write(ServletActionContext.getResponse(), result);
		return null;
	}

}

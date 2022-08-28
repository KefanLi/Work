package com.shop.service;

import java.util.List;

import com.shop.entity.Notice;
import com.shop.entity.PageBean;

/**
 * 公告Service类
 * @author Administrator
 *
 */
public interface NoticeService {

	/**
	 * 查找公告集合
	 * @return
	 */
	public List<Notice> findNoticeList(Notice s_notice,PageBean pageBean);
	
	/**
	 * 查询公告数量
	 * @param s_notice
	 * @return
	 */
	public Notice getNoticeById(int noticeId);
	
	/**
	 * 通过公告id获取公告
	 * @param noticeId
	 * @return
	 */
	public Long getNoticeCount(Notice s_notice);
	
	/**
	 * 保存公告
	 * @param notice
	 */
	public void saveNotice(Notice notice);
	
	/**
	 * 删除公告
	 * @param notice
	 */
	public void delete(Notice notice);
}

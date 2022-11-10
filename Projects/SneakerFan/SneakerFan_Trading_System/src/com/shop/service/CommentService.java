package com.shop.service;

import java.util.List;

import com.shop.entity.Comment;
import com.shop.entity.PageBean;

/**
 * 留言Service接口
 * @author Administrator
 *
 */
public interface CommentService {

	/**
	 * 查找留言集合
	 * @param pageBean
	 * @return
	 */
	public List<Comment> findCommentList(Comment s_Comment,PageBean pageBean);
	
	/**
	 * 获取留言总记录数
	 * @param s_Comment
	 * @return
	 */
	public Long getCommentCount(Comment s_Comment);
	
	/**
	 * 保存留言
	 * @param comment
	 */
	public void saveComment(Comment comment);
	
	/**
	 * 通过留言id获取留言
	 * @param commentId
	 * @return
	 */
	public Comment getCommentById(int commentId);
	
	/**
	 * 删除留言
	 * @param comment
	 */
	public void delete(Comment comment);
}

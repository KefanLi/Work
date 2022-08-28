package com.shop.service;

import java.util.List;

import com.shop.entity.Comment;
import com.shop.entity.PageBean;

/**
 * ����Service�ӿ�
 * @author Administrator
 *
 */
public interface CommentService {

	/**
	 * �������Լ���
	 * @param pageBean
	 * @return
	 */
	public List<Comment> findCommentList(Comment s_Comment,PageBean pageBean);
	
	/**
	 * ��ȡ�����ܼ�¼��
	 * @param s_Comment
	 * @return
	 */
	public Long getCommentCount(Comment s_Comment);
	
	/**
	 * ��������
	 * @param comment
	 */
	public void saveComment(Comment comment);
	
	/**
	 * ͨ������id��ȡ����
	 * @param commentId
	 * @return
	 */
	public Comment getCommentById(int commentId);
	
	/**
	 * ɾ������
	 * @param comment
	 */
	public void delete(Comment comment);
}
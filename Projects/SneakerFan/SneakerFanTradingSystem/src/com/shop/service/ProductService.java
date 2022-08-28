package com.shop.service;

import java.util.List;

import com.shop.entity.PageBean;
import com.shop.entity.Product;

/**
 * ��ƷService��
 * @author Administrator
 *
 */
public interface ProductService {

	/**
	 * ������Ʒ����
	 * @return
	 */
	public List<Product> findProductList(Product s_product,PageBean pageBean);
	
	/**
	 * ��ȡ��Ʒ�ļ�¼��
	 * @param s_product
	 * @return
	 */
	public Long getProductCount(Product s_product);
	
	/**
	 * ͨ����Ʒid��ȡ��Ʒ
	 * @param productId
	 * @return
	 */
	public Product getProductById(int productId);
	
	/**
	 * ������Ʒ
	 * @param product
	 */
	public void saveProduct(Product product);
	
	/**
	 * ɾ����Ʒ
	 * @param product
	 */
	public void deleteProduct(Product product);
	
	/**
	 * ������ƷΪ����
	 * @param productId
	 */
	public void setProductWithHot(int productId);
	
	/**
	 * ������ƷΪ�ؼ�
	 * @param productId
	 */
	public void setProductWithSpecialPrice(int productId);
	
	/**
	 * �Ƿ����ָ����ƷС�����Ʒ
	 * @param smallTypeId
	 * @return
	 */
	public boolean existProductWithSmallTypeId(int smallTypeId);
	
}
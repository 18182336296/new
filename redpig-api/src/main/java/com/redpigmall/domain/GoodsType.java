package com.redpigmall.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.redpigmall.api.constant.Globals;
import com.redpigmall.api.domain.IdEntity;
/**
 * 
 * <p>
 * Title: GoodsType.java
 * </p>
 * 
 * <p>
 * Description:商品类型管理控制类，用来描述商品类型信息
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2014
 * </p>
 * 
 * <p>
 * Company: www.redpigmall.net
 * </p>
 * 
 * @author redpig
 * 
 * @date 2014-4-25
 * 
 * 
 * @version redpigmall_b2b2c v8.0 2016版
 */
@SuppressWarnings("serial")
@Table(name = Globals.DEFAULT_TABLE_SUFFIX + "goodstype")
public class GoodsType extends IdEntity {
	private String name;// 类型名称
	private int sequence;// 排序
	@ManyToMany
	@JoinTable(name = Globals.DEFAULT_TABLE_SUFFIX + "goodstype_brand", joinColumns = @JoinColumn(name = "type_id"), inverseJoinColumns = @JoinColumn(name = "brand_id"))
	private List<GoodsBrand> gbs = new ArrayList<GoodsBrand>();//品牌
	@OneToMany(mappedBy = "goodsType", cascade = CascadeType.REMOVE)
	@OrderBy(value = "sequence asc")
	private List<GoodsTypeProperty> properties = new ArrayList<GoodsTypeProperty>();//商品类型属性

	@OneToMany(mappedBy = "goodsType")
	private List<GoodsClass> gcs = new ArrayList<GoodsClass>();//商品分类

	public GoodsType() {
	}

	public GoodsType(Long id, Date addTime) {
		super(id, addTime);
	}

	public List<GoodsClass> getGcs() {
		return this.gcs;
	}

	public void setGcs(List<GoodsClass> gcs) {
		this.gcs = gcs;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSequence() {
		return this.sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public List<GoodsBrand> getGbs() {
		return this.gbs;
	}

	public void setGbs(List<GoodsBrand> gbs) {
		this.gbs = gbs;
	}

	public List<GoodsTypeProperty> getProperties() {
		return this.properties;
	}

	public void setProperties(List<GoodsTypeProperty> properties) {
		this.properties = properties;
	}
}
package com.redpigmall.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.redpigmall.api.constant.Globals;
import com.redpigmall.api.domain.IdEntity;

/**
 * 
 * <p>
 * Title: GroupInfo.java
 * </p>
 * 
 * <p>
 * Description: 生活类商品团购消费码类，如：电影票消费码
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: www.redpigmall.net
 * </p>
 * 
 * @author redpig
 * 
 * @date 2014-5-8
 * 
 * @version redpigmall_b2b2c v8.0 2016版
 */
@SuppressWarnings("serial")
@Table(name = Globals.DEFAULT_TABLE_SUFFIX + "groupinfo")
public class GroupInfo extends IdEntity {
	private String group_sn;// 团购编号
	private Long user_id;// 团购拥有的用户id
	private String user_name;// 用户名
	@ManyToOne(fetch = FetchType.LAZY)
	private GroupLifeGoods lifeGoods;// 对应的生活类团购商品
	@Column(columnDefinition = "int default 0")
	private int status;// 团购信息状态，默认为0，,使用后为1,-1为过期,3申请退款、5退款中、7退款完成
	@ManyToOne
	private Payment payment;// 支付方式
	private Long order_id;// 对应的订单id
	private Date refund_Time;// 买家退款截止日期
	private Date refund_complete_Time;// 退款时间
	@Column(columnDefinition = "LongText")
	private String refund_reasion;// 退款说明

	public GroupInfo() {
	}

	public GroupInfo(Long id, Date addTime) {
		super(id, addTime);
	}

	public Date getRefund_complete_Time() {
		return this.refund_complete_Time;
	}

	public void setRefund_complete_Time(Date refund_complete_Time) {
		this.refund_complete_Time = refund_complete_Time;
	}

	public String getRefund_reasion() {
		return this.refund_reasion;
	}

	public void setRefund_reasion(String refund_reasion) {
		this.refund_reasion = refund_reasion;
	}

	public Date getRefund_Time() {
		return this.refund_Time;
	}

	public void setRefund_Time(Date refund_Time) {
		this.refund_Time = refund_Time;
	}

	public Long getOrder_id() {
		return this.order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public String getGroup_sn() {
		return this.group_sn;
	}

	public void setGroup_sn(String group_sn) {
		this.group_sn = group_sn;
	}

	public Long getUser_id() {
		return this.user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return this.user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public GroupLifeGoods getLifeGoods() {
		return this.lifeGoods;
	}

	public void setLifeGoods(GroupLifeGoods lifeGoods) {
		this.lifeGoods = lifeGoods;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}

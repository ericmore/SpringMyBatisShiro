package com.lance.shiro.entity;

import java.util.Date;

/**
 * 交易记录
 * @author root
 * 交易过程中需要不断更新相关内容，采用sys.businessLog方式记录
 * tradeLog:缴纳定金记录，签订合同记录，房屋交付记录
 */
public class TradeEntity{

	
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public UserAgent getAgent() {
		return agent;
	}

	public void setAgent(UserAgent agent) {
		this.agent = agent;
	}

	public UserCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(UserCustomer customer) {
		this.customer = customer;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public Double getPreMoney() {
		return preMoney;
	}

	public void setPreMoney(Double preMoney) {
		this.preMoney = preMoney;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Date getPreDate() {
		return preDate;
	}

	public void setPreDate(Date preDate) {
		this.preDate = preDate;
	}

	public Integer getPreStatus() {
		return preStatus;
	}

	public void setPreStatus(Integer preStatus) {
		this.preStatus = preStatus;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private Property property;
	
	private UserAgent agent;
	
	private UserCustomer customer;
	
	private Date tradeDate;
	
	private Double preMoney;
	
	private Double money;
	
	private Date preDate;
	
	private Integer preStatus;
	
	private Date finishDate;//完成日期
}

package com.lance.shiro.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import java.sql.Date;
@Table(name = "i_property")
public class IProperty {


    @Column(name = "id",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private int id;
    @Column(name = "address",type = MySqlTypeConstant.VARCHAR,length = 200)
    private String address;
    @Column(name = "agentId",type = MySqlTypeConstant.INT,length = 11)
    private int agentId;
    private IUser agent;

    @Column(name = "propertyListId",type = MySqlTypeConstant.INT,length = 11)
    private int propertyListId;
    private IPropertyList propertyList;
    @Column(name = "lot",type = MySqlTypeConstant.VARCHAR,length = 200)
    private String lot;
    @Column(name = "buildingOverview",type = MySqlTypeConstant.TEXT)
    private String buildingOverview;
    @Column(name = "features",type = MySqlTypeConstant.TEXT)
    private String features;
    @Column(name = "purchasePrice",type = MySqlTypeConstant.DOUBLE,length = 10,decimalLength = 2)
    private double purchasePrice;
    @Column(name = "sellingPrice",type = MySqlTypeConstant.DOUBLE,length = 10,decimalLength = 2)
    private double sellingPrice;
    @Column(name = "weeklyRent",type = MySqlTypeConstant.DOUBLE,length = 10,decimalLength = 2)
    private double weeklyRent;
    @Column(name = "managedDoma",type = MySqlTypeConstant.VARCHAR,length = 1)
    private String managedDoma;
    @Column(name = "lotTypeId",type = MySqlTypeConstant.INT,length = 11)
    private int lotTypeId;
    private ILotType lotType;
    @Column(name = "type",type = MySqlTypeConstant.VARCHAR,length = 20)
    private String type;
    @Column(name = "textContractOfSale",type = MySqlTypeConstant.TEXT)
    private String textContractOfSale;
    @Column(name = "textDepositForm",type = MySqlTypeConstant.TEXT)
    private String textDepositForm;
    @Column(name = "textSolicitor",type = MySqlTypeConstant.TEXT)
    private String textSolicitor;
    @Column(name = "textBillsCharges",type = MySqlTypeConstant.TEXT)
    private String textBillsCharges;
    @Column(name = "textManagementAgreement",type = MySqlTypeConstant.TEXT)
    private String textManagementAgreement;
    @Column(name = "textOthers",type = MySqlTypeConstant.TEXT)
    private String textOthers;
    @Column(name = "purchaseDate",type = MySqlTypeConstant.DATETIME,length = 80)
    private Date purchaseDate;
    @Column(name = "commenceDate",type = MySqlTypeConstant.DATETIME,length = 80)
    private Date commenceDate;
    @Column(name = "commission_rent",type = MySqlTypeConstant.DOUBLE,length = 10,decimalLength = 2)
    private double commission_rent;
    @Column(name = "commission_sale",type = MySqlTypeConstant.DOUBLE,length = 10,decimalLength = 2)
    private double commission_sale;
    @Column(name = "term_of_lease",type = MySqlTypeConstant.DOUBLE,length = 10,decimalLength = 2)
    private double term_of_lease;
    @Column(name = "ownerId",type = MySqlTypeConstant.INT,length = 11)
    private int ownerId;
    private IUser owner;
    @Column(name = "status",type = MySqlTypeConstant.VARCHAR,length = 20,defaultValue = "active")
    private String status;
    @Column(name = "createTime",type = MySqlTypeConstant.DATETIME,length = 80)
    private Date createTime;
    @Column(name = "updateTime",type = MySqlTypeConstant.DATETIME,length = 80)
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public int getPropertyListId() {
        return propertyListId;
    }

    public void setPropertyListId(int propertyListId) {
        this.propertyListId = propertyListId;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getBuildingOverview() {
        return buildingOverview;
    }

    public void setBuildingOverview(String buildingOverview) {
        this.buildingOverview = buildingOverview;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getWeeklyRent() {
        return weeklyRent;
    }

    public void setWeeklyRent(double weeklyRent) {
        this.weeklyRent = weeklyRent;
    }

    public String getManagedDoma() {
        return managedDoma;
    }

    public void setManagedDoma(String managedDoma) {
        this.managedDoma = managedDoma;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTextContractOfSale() {
        return textContractOfSale;
    }

    public void setTextContractOfSale(String textContractOfSale) {
        this.textContractOfSale = textContractOfSale;
    }

    public String getTextDepositForm() {
        return textDepositForm;
    }

    public void setTextDepositForm(String textDepositForm) {
        this.textDepositForm = textDepositForm;
    }

    public String getTextSolicitor() {
        return textSolicitor;
    }

    public void setTextSolicitor(String textSolicitor) {
        this.textSolicitor = textSolicitor;
    }

    public String getTextBillsCharges() {
        return textBillsCharges;
    }

    public void setTextBillsCharges(String textBillsCharges) {
        this.textBillsCharges = textBillsCharges;
    }

    public String getTextManagementAgreement() {
        return textManagementAgreement;
    }

    public void setTextManagementAgreement(String textManagementAgreement) {
        this.textManagementAgreement = textManagementAgreement;
    }

    public String getTextOthers() {
        return textOthers;
    }

    public void setTextOthers(String textOthers) {
        this.textOthers = textOthers;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getCommenceDate() {
        return commenceDate;
    }

    public void setCommenceDate(Date commenceDate) {
        this.commenceDate = commenceDate;
    }

    public double getCommission_rent() {
        return commission_rent;
    }

    public void setCommission_rent(double commission_rent) {
        this.commission_rent = commission_rent;
    }

    public double getCommission_sale() {
        return commission_sale;
    }

    public void setCommission_sale(double commission_sale) {
        this.commission_sale = commission_sale;
    }

    public double getTerm_of_lease() {
        return term_of_lease;
    }

    public void setTerm_of_lease(double term_of_lease) {
        this.term_of_lease = term_of_lease;
    }

    public int getLotTypeId() {
        return lotTypeId;
    }

    public void setLotTypeId(int lotTypeId) {
        this.lotTypeId = lotTypeId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public IUser getAgent() {
        return agent;
    }

    public void setAgent(IUser agent) {
        this.agent = agent;
    }

    public IPropertyList getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(IPropertyList propertyList) {
        this.propertyList = propertyList;
    }

    public ILotType getLotType() {
        return lotType;
    }

    public void setLotType(ILotType lotType) {
        this.lotType = lotType;
    }

    public IUser getOwner() {
        return owner;
    }

    public void setOwner(IUser owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}

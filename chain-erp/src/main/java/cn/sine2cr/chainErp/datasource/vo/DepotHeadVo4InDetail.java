package cn.sine2cr.chainErp.datasource.vo;


import java.math.BigDecimal;
import java.util.Date;

public class DepotHeadVo4InDetail {

    private String Number;

    private String barCode;

    private String MName;

    private String Model;

    private String standard;

    private BigDecimal UnitPrice;

    private String mUnit;

    private String newRemark;

    private BigDecimal OperNumber;

    private BigDecimal AllPrice;

    private BigDecimal taxRate;

    private BigDecimal taxMoney;

    private BigDecimal taxLastMoney;

    private String SName;

    private String DName;

    private String OperTime;

    private String NewType;

    private Long tenantId;

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getMName() {
        return MName;
    }

    public void setMName(String MName) {
        this.MName = MName;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public BigDecimal getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        UnitPrice = unitPrice;
    }

    public String getmUnit() {
        return mUnit;
    }

    public void setmUnit(String mUnit) {
        this.mUnit = mUnit;
    }

    public String getNewRemark() {
        return newRemark;
    }

    public void setNewRemark(String newRemark) {
        this.newRemark = newRemark;
    }

    public BigDecimal getOperNumber() {
        return OperNumber;
    }

    public void setOperNumber(BigDecimal operNumber) {
        OperNumber = operNumber;
    }

    public BigDecimal getAllPrice() {
        return AllPrice;
    }

    public void setAllPrice(BigDecimal allPrice) {
        AllPrice = allPrice;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxMoney() {
        return taxMoney;
    }

    public void setTaxMoney(BigDecimal taxMoney) {
        this.taxMoney = taxMoney;
    }

    public BigDecimal getTaxLastMoney() {
        return taxLastMoney;
    }

    public void setTaxLastMoney(BigDecimal taxLastMoney) {
        this.taxLastMoney = taxLastMoney;
    }

    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }

    public String getDName() {
        return DName;
    }

    public void setDName(String DName) {
        this.DName = DName;
    }

    public String getOperTime() {
        return OperTime;
    }

    public void setOperTime(String operTime) {
        OperTime = operTime;
    }

    public String getNewType() {
        return NewType;
    }

    public void setNewType(String newType) {
        NewType = newType;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }
}

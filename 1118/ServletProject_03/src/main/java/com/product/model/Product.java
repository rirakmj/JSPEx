package com.product.model;

public class Product {
	private long productId;  //��ǰ���̵� 
	private String pname;  //��ǰ��
	private Integer unitPrice; //��ǰ����
	private String description; //��ǰ ����
	private String manufacturer; //������
	private String category ; //�з�
	private long unitsInStock; //��� ��
	private String condition; //�Ż�ǰ, �߰�ǰ, ���ǰ
	private String filename;
	
	//getter, setter
	public long getProductId() {
		return productId ;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getPname() {
		return pname == null ? "" : pname.trim();
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getUnitPrice() {
		return unitPrice ;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDescription() {
		return description == null ? "" : description.trim();
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManufacturer() {
		return manufacturer == null ? "" : manufacturer.trim();
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getCategory() {
		return category == null ? "" : category.trim();
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getUnitsInStock() {
		return unitsInStock ;
	}
	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public String getCondition() {
		return condition == null ? "" : condition.trim();
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getFilename() {
		return filename == null ? "" : filename.trim();
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	

	
}






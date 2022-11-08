package com.jqueryAddress;

import java.util.ArrayList;

public interface JAddressDAO {

	public void insert(AddressVO avo);     //�߰�

	public ArrayList<AddressVO> list();  	//��ü����

	public AddressVO findByNum(int num); 	//�󼼺���
	
	public int getCount();  //����

	public void update(AddressVO avo); 	//����
	
	public void delete(int num);//����
	
}

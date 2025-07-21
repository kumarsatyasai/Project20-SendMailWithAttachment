package com.nt.service;

public interface IPurchaseOrderMgmtService {

	public String purchase(String []items, Double prices[], String emails[])throws Exception;
}

package com.tms.DAO;

import java.util.List;

import com.tms.EXCEPTION.AdministratorException;
import com.tms.EXCEPTION.BidderException;
import com.tms.EXCEPTION.TendorException;
import com.tms.EXCEPTION.VendorException;
import com.tms.MODEL.Bidder;
import com.tms.MODEL.Tender;
import com.tms.MODEL.Vendor;

public interface AdministratorDao {
	/*1. Login with his account.*/
	public boolean adminLoginWithAccount(String adminUserName, String adminPassword) throws AdministratorException;

	
	/*2. Register new Vendor. (assign a new username and password to him)*/
	public String registerNewVendorDetails(Vendor vendor) throws VendorException;

	
	/*3. View all the vendors.*/
	public List<Vendor> ViewAllVendorsDetails() throws VendorException;

	
	/*4. Create new tenders.*/
	public String CreateNewTenders(Tender tender) throws TendorException;

	
	/*5. View All the Tenders.*/
	public List<Tender> ViewAllTenderDetails() throws TendorException;

	
	/**/
//	public List<Bidder> getAllBids() throws BidderException;

	
	/*6. View All the Bids of a tender.*/
	public List<Bidder> ViewAllBidsOfTender(int tdrId) throws BidderException;

	
	/*7. Assign tender to a vendor.*/
	public String assignTendorToVendor(int tdrId, int vdrId, int bidId)
			throws TendorException, VendorException, BidderException;

}

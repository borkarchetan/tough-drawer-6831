package com.tms.DAO;

import java.util.List;

import com.tms.EXCEPTION.BidderException;
import com.tms.EXCEPTION.TendorException;
import com.tms.EXCEPTION.VendorException;
import com.tms.MODEL.Bidder;
import com.tms.MODEL.Tender;
import com.tms.MODEL.Vendor;

public interface VendorDao {

	/*1. Login with his account (username and password given by admin)*/
	public Vendor loginVendorWithAccount(String userName, String password) throws VendorException;

	
	/*1. View all the current Tenders.*/
	public List<Tender> getAllCurrentTendersList() throws TendorException;

	
	
	/*2. Place a Bid against a Tender.*/
	public String bidAgainstTender(int tdrId, int vdrId, int bidAmount, String bidDeadLine)
			throws BidderException, TendorException;

	
	/*3. View status of a Bid(Whether Selected or Not)*/
	public String ViewStatusOfBid(int bidId) throws BidderException;

	
	/*4. View his own Bid History.*/
	public List<Bidder> viewVendorBidHistory(int vdrId) throws BidderException;

}

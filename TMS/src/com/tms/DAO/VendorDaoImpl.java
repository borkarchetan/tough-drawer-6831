package com.tms.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tms.EXCEPTION.BidderException;
import com.tms.EXCEPTION.TendorException;
import com.tms.EXCEPTION.VendorException;
import com.tms.MODEL.Bidder;
import com.tms.MODEL.Tender;
import com.tms.MODEL.Vendor;
import com.tms.UTIL.DBUtil;

public class VendorDaoImpl implements VendorDao {

	@Override
	public Vendor loginVendorWithAccount(String userName, String password) throws VendorException {

		Vendor v = null;

		try (Connection con = DBUtil.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from vendor where vdrName = ? AND vdrPassword = ?");
			ps.setString(1, userName);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				v = new Vendor(rs.getInt("vdrId"), rs.getString("vdrPassword"), rs.getString("vdrName"),
						rs.getString("vdrMobile"), rs.getString("vdrEmail"), rs.getString("vdrCompany"),
						rs.getString("vdrAddress"));
			} else {
				throw new VendorException("Wrong Username or Password...");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return v;
	}

	@Override
	public List<Tender> getAllCurrentTendersList() throws TendorException {
		List<Tender> currentTender = new ArrayList<>();

		try (Connection con = DBUtil.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from tender where status = 'No_Tender'");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				currentTender.add(new Tender(rs.getInt("tdrId"), rs.getString("tdrName"),
						rs.getString("tdrType"), rs.getInt("tdrAmount"), rs.getString("tdrAddress"),
						rs.getString("tdrDeadline")));
			}

			if (currentTender.size() == 0) {
				throw new TendorException("Tendor not found....");
			}

		} catch (SQLException e) {
			e.getMessage();
		}

		return currentTender;
	}

	@Override
	public String bidAgainstTender(int tdrId, int vdrId, int bidAmount, String bidDeadLine)
			throws BidderException, TendorException {
		String str = "Something went wrong....";
		int price;
		try (Connection con = DBUtil.provideConnection()) {

			List<Bidder> bidders = new ArrayList<>();

			PreparedStatement ps = con.prepareStatement(
					"select b.tdrId, b.vdrId, b.bidAmount, b.status, b.bidDeadLine from bidder b inner join tender t ON b.tdrId = t.tdrId where t.tdrId = ?");
			ps.setInt(1, tdrId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				bidders.add(new Bidder(rs.getInt("vdrId"), rs.getInt("tdrId"), rs.getInt("bidAmount"),
						rs.getString("bidDeadLine"), rs.getString("status")));
			}

			boolean flag = true;
			for (Bidder b : bidders) {
				if (b.getVdrId() == vdrId) {
					flag = false;
				}
			}

			PreparedStatement ps2 = con.prepareStatement("select tdrAmount from tender where tdrId = ?");
			ps2.setInt(1, tdrId);

			ResultSet rs2 = ps2.executeQuery();

			if (rs2.next()) {
				price = rs2.getInt("tdrAmount");

			} else
				throw new TendorException("Tendor not found for price....");

			if (price <= bidAmount) {

				if (bidders.size() == 0 || flag) {

					PreparedStatement ps1 = con.prepareStatement(
							"insert into bidder(vdrId, tdrId, bidAmount, bidDeadLine) values(?, ?, ?, ?)");
					ps1.setInt(1, vdrId);
					ps1.setInt(2, tdrId);
					ps1.setInt(3, bidAmount);
					ps1.setString(4, bidDeadLine);

					int x = ps1.executeUpdate();
					if (x > 0) {

						PreparedStatement ps3 = con
								.prepareStatement("select * from bidder where vdrId=? AND tdrId=?");
						ps3.setInt(1, vdrId);
						ps3.setInt(2, tdrId);

						ResultSet rs3 = ps3.executeQuery();

						if (rs3.next()) {

							Bidder b = new Bidder(rs3.getInt("bidId"), rs3.getInt("vdrId"),
									rs3.getInt("tdrId"), rs3.getInt("bidAmount"), rs3.getString("bidDeadLine"),
									rs3.getString("status"));
							str = "Successfully bid for " + b.toString();
						} else {
							throw new BidderException("Bid not placed successfully...");
						}

					} else {
						throw new BidderException("Tendor not found");
					}

				} else {
					throw new BidderException(
							"You have already bidded for tender id : " + tdrId + " With respect to " + vdrId);
				}
			} else {
				throw new BidderException(
						"Bidding Price is too low for bidding it must be greater than price -- " + price);
			}

		} catch (SQLException e) {
			e.getMessage();
		}

		return str;
	}

	@Override
	public String ViewStatusOfBid(int bid) throws BidderException {
		String str = "No bids present";

		try (Connection con = DBUtil.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select status from bidder where bidId=?");

			ps.setInt(1, bid);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				str = rs.getString("status");
			} else {
				throw new BidderException("Tendor not found");
			}

		} catch (SQLException e) {
			e.getMessage();
		}

		return str;
	}

	@Override
	public List<Bidder> viewVendorBidHistory(int vid) throws BidderException {
		List<Bidder> bids = new ArrayList<>();

		try (Connection con = DBUtil.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from bidder where vdrId=?");
			ps.setInt(1, vid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				bids.add(new Bidder(rs.getInt("bidId"), rs.getInt("vdrId"), rs.getInt("tdrId"),
						rs.getInt("bidAmount"), rs.getString("status"), rs.getString("bidDeadLine")));

			}

			if (bids.size() == 0) {
				throw new BidderException("No Tender for Bidding");
			}
		} catch (SQLException e) {
			e.getMessage();
		}

		return bids;
	}

}

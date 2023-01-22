package com.tms.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tms.EXCEPTION.AdministratorException;
import com.tms.EXCEPTION.BidderException;
import com.tms.EXCEPTION.TendorException;
import com.tms.EXCEPTION.VendorException;
import com.tms.MODEL.Bidder;
import com.tms.MODEL.Tender;
import com.tms.MODEL.Vendor;
import com.tms.UTIL.DBUtil;

public class AdministratorDaoImpl implements AdministratorDao {

	@Override
	public boolean adminLoginWithAccount(String adminUserName, String adminPassword) throws AdministratorException {
		boolean b = false;

		try (Connection con = DBUtil.provideConnection()) {

			PreparedStatement ps = con
					.prepareStatement("select * from Administrator where adminUserName = ? AND adminPassword = ?");
			ps.setString(1, adminUserName);
			ps.setString(2, adminPassword);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				b = true;
			} else {
				throw new AdministratorException("Sorry...! Wrong Username OR Password...");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}

	@Override
	public String registerNewVendorDetails(Vendor vendor) throws VendorException {
		String str = "Not inserted";

		try (Connection con = DBUtil.provideConnection()) {

			PreparedStatement ps = con.prepareStatement(
					"insert into vendor(vdrPassword, vdrName, vdrMobile, vdrEmail, vdrCompany, vdrAddress) values(?, ?, ?, ?, ?, ?)");

			ps.setString(1, vendor.getVdrPassword());
			ps.setString(2, vendor.getVdrName());
			ps.setString(3, vendor.getVdrMobile());
			ps.setString(4, vendor.getVdrEmail());
			ps.setString(5, vendor.getVdrCompany());
			ps.setString(6, vendor.getVdrAddress());

			int result = ps.executeUpdate();

			if (result > 0) {
				str = "Vendor Details Added Sucessfully...";
			} else {
				throw new VendorException("Vendor Registration Fail...!");
			}

		} catch (SQLException e) {
			e.getMessage();
		}

		return str;
	}

	@Override
	public List<Vendor> ViewAllVendorsDetails() throws VendorException {
		List<Vendor> vendors = new ArrayList<>();

		try (Connection con = DBUtil.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from vendor");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				vendors.add(new Vendor(rs.getInt("vdrId"), rs.getString("vdrPassword"), rs.getString("vdrName"),
						rs.getString("vdrMobile"), rs.getString("vdrEmail"), rs.getString("vdrCompany"),
						rs.getString("vdrAddress")));
			}

			if (vendors.size() == 0) {
				throw new VendorException("Vendor List is Empty!....");
			}

		} catch (SQLException e) {
			e.getMessage();
		}

		return vendors;
	}

	@Override
	public String CreateNewTenders(Tender tender) throws TendorException {

		String str = "Tender Details is Not Added";

		try (Connection con = DBUtil.provideConnection()) {

			PreparedStatement ps = con.prepareStatement(
					"insert into tender(tdrName, tdrType, tdrAmount,  tdrDeadline, tdrAddress) values( ?, ?, ?, ?, ?)");

			ps.setString(1, tender.getTdrName());
			ps.setString(2, tender.getTdrType());
			ps.setInt(3, tender.getTdrAmount());
			ps.setString(4, tender.getTdrAddress());
			ps.setString(5, tender.getTdrDeadline());
			int result = ps.executeUpdate();

			if (result > 0) {
				str = "Tender Details is Added Successfully...";
			} else {
				throw new TendorException("Tendor not found");
			}

		} catch (SQLException e) {
			e.getMessage();
		}

		return str;
	}

	@Override
	public List<Tender> ViewAllTenderDetails() throws TendorException {
		List<Tender> tendors = new ArrayList<>();

		try (Connection con = DBUtil.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from tender");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				tendors.add(new Tender(rs.getInt("tdrId"), rs.getString("tdrName"), rs.getString("tdrType"),
						rs.getInt("tdrAmount"), rs.getString("tdrAddress"), rs.getString("tdrDeadline")));
			}

			if (tendors.size() == 0) {
				throw new TendorException("Tendor List is Empty!....");
			}

		} catch (SQLException e) {
			e.getMessage();
		}

		return tendors;
	}

	@Override
	public List<Bidder> ViewAllBidsOfTender(int tenderId) throws BidderException {
		List<Bidder> bidders = new ArrayList<>();

		try (Connection con = DBUtil.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from bidder where tdrId=?");
			ps.setInt(1, tenderId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				bidders.add(new Bidder(rs.getInt("vdrId"), rs.getInt("tdrId"), rs.getInt("bidAmount"),
						rs.getString("status"), rs.getString("bidDeadLine")));
			}

			if (bidders.size() == 0) {
				throw new BidderException("Tendor id with bidId is mismatched...");
			}

		} catch (SQLException e) {
			e.getMessage();
		}

		return bidders;
	}

	@Override
	public String assignTendorToVendor(int tdrId, int vdrId, int bidId)
			throws TendorException, VendorException, BidderException {

		String str = "";
		try (Connection con = DBUtil.provideConnection()) {

			PreparedStatement ps = con
					.prepareStatement("select * from tenderstatus where tsTdrId=? AND tsVdrId =?");
			ps.setInt(1, tdrId);
			ps.setInt(2, vdrId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				str = "Assigned already...";
			} else {
				PreparedStatement psOne = con.prepareStatement(
						"insert into tenderstatus(status, tsTdrId, tsBidId, tsVdrId) values('Selected', ?, ?, ?)");
				psOne.setInt(1, tdrId);
				psOne.setInt(2, bidId);
				psOne.setInt(2, vdrId);

				int result = ps.executeUpdate();

				if (result > 0) {

					PreparedStatement psTwo = con
							.prepareStatement("update tender set status = 'Assigned' where tendorId=?");
					psTwo.setInt(1, tdrId);
					int resTwo = ps.executeUpdate();

					if (resTwo > 0) {
						str = "Assigned tendor " + tdrId + " to a vendor " + vdrId + "...";
						PreparedStatement psThree = con.prepareStatement(
								"update bidder set status = 'Selected' where tdrId = ? And bidId = ? AND vdrId = ?");
						psThree.setInt(1, tdrId);
						psThree.setInt(2, bidId);
						psThree.setInt(3, vdrId);

						int resThree = ps.executeUpdate();

					}

				} else {
					throw new TendorException("Tendor is not available");

				}

			}

		} catch (SQLException e) {
			e.getMessage();
			throw new VendorException("Vendor is not available");
		}

		return str;
	}

}

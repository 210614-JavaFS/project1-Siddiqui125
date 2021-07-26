package com.siddiqui.repos;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siddiqui.model.ReimbursementPlan;
import com.siddiqui.utils.ConnectionUtils;

public class ReimbursementDAOImp implements RemibDAO {
	public boolean addRequest(ReimbursementPlan plan) {
		try {
			Connection connection = ConnectionUtils.getConnection();
			String sql = "INSERT INTO ers_reimbursement(remin_amount,remib_submitted,remib_resolved,reimb_description,remib_author,remib_resolver)"
					+ "VALUES (?,?,?,?,?,?)";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<ReimbursementPlan> viewAllTickets() {
		try {
			Connection conn = ConnectionUtils.getConnection();
			String sql = "SELECT * FROM ers_users";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<ReimbursementPlan> list = new ArrayList<>();

			while (result.next()) {
				ReimbursementPlan plan = new ReimbursementPlan();
				plan.setRemib_amount(result.getInt("reimb_amount"));
				plan.setRemib_submitted(result.getString("remib_submitted"));
				plan.setRemib_resolved(result.getString("remib_resolved"));
				plan.setRemib_despcription(result.getString("reimb_description"));
				plan.setReimb_author(result.getString("remib_author"));
				plan.setRemib_resolver(result.getString("reimb_resolver"));

				list.add(plan);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}

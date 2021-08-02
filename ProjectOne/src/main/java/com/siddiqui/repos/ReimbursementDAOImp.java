package com.siddiqui.repos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.siddiqui.model.Employee;
import com.siddiqui.model.ReimbursementPlan;
import com.siddiqui.model.Status;
import com.siddiqui.model.Type;
import com.siddiqui.services.EmployeeServices;
import com.siddiqui.services.ReimbursementService;
import com.siddiqui.utils.ConnectionUtils;
import com.siddiqui.utils.Utils;

public class ReimbursementDAOImp implements RemibDAO {
	public boolean addRequest(ReimbursementPlan plan) {
		try {
			Connection connection = ConnectionUtils.getConnection();
			String sql = "INSERT INTO ers_reimbursement(reimb_amount,reimb_submitted,reimb_resolved,reimb_description,reimb_author,reimb_resolver)"
					+ "VALUES (?,?,?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sql);
			int index = 0;
			statement.setInt(++index, plan.getRemib_amount());
			statement.setString(++index, plan.getRemib_submitted());
			statement.setString(++index, plan.getRemib_resolved());
			statement.setString(++index, plan.getRemib_despcription());
			statement.setInt(++index, plan.getReimb_author());
			statement.setInt(++index, plan.getRemib_resolver());

			statement.execute();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<ReimbursementPlan> viewAllTickets() {
		try {
			Connection conn = ConnectionUtils.getConnection();
			String sql = "SELECT * FROM ers_reimbursement";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<ReimbursementPlan> list = new ArrayList<>();

			while (result.next()) {
				ReimbursementPlan plan = new ReimbursementPlan();
				plan.setRemib_id(result.getInt("reimb_id"));
				plan.setRemib_amount(result.getInt("reimb_amount"));
				plan.setRemib_submitted(result.getString("reimb_submitted"));
				plan.setRemib_resolved(result.getString("reimb_resolved"));
				plan.setRemib_despcription(result.getString("reimb_description"));
				plan.setReimb_author(result.getInt("reimb_author"));
				plan.setRemib_resolver(result.getInt("reimb_resolver"));
				plan.setRemib_statusId(result.getInt("reimb_status_id"));
				plan.setRemib_typeId(result.getInt("reimb_type_id"));

				list.add(plan);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean addStatus(Status status) {
		try {
			Connection connection = ConnectionUtils.getConnection();
			String sql = "INSERT INTO ERS_REIMBURSEMENT_STATUS(reimb_status_id, REIMB_STATUS) VALUES (?, ?) ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			int index = 0;
			preparedStatement.setInt(++index, status.getStatus_id());
			preparedStatement.setString(++index, status.getStatus());

			preparedStatement.execute();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean addType(Type type) {
		try {
			Connection connection = ConnectionUtils.getConnection();
			String sql = "INSERT INTO ERS_REIMBURSEMENT_TYPE(remib_type_id, remib_TYPE) VALUES (?, ?) ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			int index = 0;
			preparedStatement.setInt(++index, type.getType_id());
			preparedStatement.setString(++index, type.getType());

			preparedStatement.execute();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Status findStatusbyID(int status_id) {
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "SELECT * FROM ers_reimbursement_status WHERE reimb_status_id = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, status_id);
			ResultSet result = statement.executeQuery();

			Status status = new Status();
			while (result.next()) {
				status.setStatus(result.getString("reimb_status"));
				status.setStatus_id(result.getInt("reimb_status_id"));
			}
			return status;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Type findTypebyID(int type_id) {
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "SELECT * FROM ers_reimbursement_type WHERE remib_type_id = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, type_id);
			ResultSet result = statement.executeQuery();

			Type type = new Type();
			while (result.next()) {
				type.setType(result.getString("remib_type"));
				type.setType_id(result.getInt("remib_type_id"));
			}
			return type;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ReimbursementPlan> getAllTicketByUserId(int userId) {
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, userId);
			ResultSet result = statement.executeQuery();

			List<ReimbursementPlan> list = new ArrayList<>();

			while (result.next()) {
				ReimbursementPlan plan = new ReimbursementPlan();
				plan.setRemib_id(result.getInt("reimb_id"));
				plan.setRemib_amount(result.getInt("reimb_amount"));
				plan.setRemib_submitted(result.getString("reimb_submitted"));
				plan.setRemib_resolved(result.getString("reimb_resolved"));
				plan.setRemib_despcription(result.getString("reimb_description"));
				plan.setReimb_author(result.getInt("reimb_author"));
				plan.setRemib_resolver(result.getInt("reimb_resolver"));
				plan.setRemib_statusId(result.getInt("reimb_status_id"));
				plan.setRemib_typeId(result.getInt("reimb_type_id"));

				list.add(plan);

			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ReimbursementPlan> getAllbyReimbID(String reimb_id) {
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_id = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, reimb_id);
			ResultSet result = statement.executeQuery();

			List<ReimbursementPlan> list = new ArrayList<>();

			while (result.next()) {
				ReimbursementPlan plan = new ReimbursementPlan();
				plan.setRemib_id(result.getInt("reimb_id"));
				plan.setRemib_amount(result.getInt("reimb_amount"));
				plan.setRemib_submitted(result.getString("reimb_submitted"));
				plan.setRemib_resolved(result.getString("reimb_resolved"));
				plan.setRemib_despcription(result.getString("reimb_description"));
				plan.setReimb_author(result.getInt("reimb_author"));
				plan.setRemib_resolver(result.getInt("reimb_resolver"));
				plan.setRemib_statusId(result.getInt("reimb_status_id"));
				plan.setRemib_typeId(result.getInt("reimb_type_id"));

				list.add(plan);

			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public boolean updateStatusByReimbid(int reimb_id, String action) {
//		if (action.equals("approve")) {
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "UPDATE ers_reimbursement set reimb_resolver = ?, reimb_resolved=? where reimb_id=?;";

			PreparedStatement statement = conn.prepareStatement(sql);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();

			String dataResolved = dtf.format(now);
			int userID = Utils.currentEmployee.getUserId();
			int index = 0;
			statement.setInt(++index, userID);
			statement.setString(++index, dataResolved);
			statement.setInt(++index, reimb_id);
			int result = statement.executeUpdate();
			updateStatusByStatusId(Utils.currentPlan.getRemib_statusId(), action);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateStatusByStatusId(int status_id, String status) {

		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "UPDATE ers_reimbursement_status set reimb_status = ? where reimb_status_id=?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, status);
			statement.setInt(2, status_id);
			int result = statement.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return false;
	}

}
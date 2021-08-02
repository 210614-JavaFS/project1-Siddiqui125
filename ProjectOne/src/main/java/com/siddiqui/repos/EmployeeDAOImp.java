package com.siddiqui.repos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siddiqui.model.Employee;
import com.siddiqui.model.ReimbursementPlan;
import com.siddiqui.utils.ConnectionUtils;
import com.siddiqui.utils.Utils;

public class EmployeeDAOImp implements EmployeeDAO {

//	@Override
//	public List<Employee> allEmployee() {
//		try {
//			Connection conn = ConnectionUtils.getConnection();
//			Utils.log.debug("Umer");
//			String sql = "SELECT * FROM ers_users";
//
//			Statement statement = conn.createStatement();
//
//			ResultSet result = statement.executeQuery(sql);
//
//			List<Employee> list = new ArrayList<>();
//
//			while (result.next()) {
//				Employee employee = new Employee();
//				employee.setUserId(result.getInt("ers_user_id"));
//				employee.setUsername(result.getString("ers_username"));
//				employee.setPassword(result.getString("ers_password"));
//				employee.setFirstname(result.getString("ers_first_name"));
//				employee.setLastname(result.getString("ers_last_name"));
//				employee.setEmail(result.getString("user_email"));
//				employee.setUser_role_id(result.getInt("user_role_id"));
//
//				list.add(employee);
//			}
//
//			return list;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return null;
//	}

//	@Override
//	public boolean addRequest(ReimbursementPlan plan) {
//
//		try (Connection conn = ConnectionUtils.getConnection()) {
//
//			String sql = "INSERT INTO ers_reimbursement (reimb_amount,reimb_submitted,reimb_resolved,reimb_description,reimb_author,reimb_resovler,reimb_status_id,reimb_type_id)"
//					+ " VALUES (?,?,?,?,?,?,?,?,?);";
//
//			PreparedStatement statement = conn.prepareStatement(sql);
//
//			int index = 0;
//			statement.setInt(++index, plan.getRemib_id());
//			statement.setInt(++index, plan.getRemib_amount());
//			statement.setString(++index, plan.getRemib_submitted());
//			statement.setString(++index, plan.getRemib_resolved());
//			statement.setString(++index, plan.getRemib_despcription());
//			statement.setString(++index, plan.getReimb_author());
//			statement.setString(++index, plan.getRemib_resolver());
//			statement.setInt(++index, plan.getRemib_statusId());
//			statement.setInt(++index, plan.getRemib_typeId());
//
//			statement.execute();
//			Utils.log.debug("Employee Added");
//			return true;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return false;
//	}

	@Override
	public Employee findbyUsername(String username) {

		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "SELECT * FROM ers_users WHERE ers_username = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			// This is where SQL injection is checked for.
			statement.setString(1, username);

			ResultSet result = statement.executeQuery();

			Employee employee = new Employee();
			while (result.next()) {
				employee.setUserId(result.getInt("ers_user_id"));
				employee.setUsername(result.getString("ers_username"));
				employee.setPassword(result.getString("ers_password"));
				employee.setFirstname(result.getString("ers_first_name"));
				employee.setLastname(result.getString("ers_last_name"));
				employee.setEmail(result.getString("user_email"));
				employee.setUser_role_id(result.getInt("user_role_id"));
			}

			return employee;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String findByRoleId(int roleId) {
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "SELECT * FROM ers_users_roles WHERE ers_user_role = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			// This is where SQL injection is checked for.
			statement.setInt(1, roleId);

			ResultSet result = statement.executeQuery();

			String role = "";
			while (result.next()) {
				role = result.getString("ers_roles");
			}

			return role;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee getUserNameByUserID(int userID) {
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "SELECT * FROM ers_users WHERE ers_user_id = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			// This is where SQL injection is checked for.
			statement.setInt(1, userID);

			ResultSet result = statement.executeQuery();

			Employee employee = new Employee();
			while (result.next()) {
				employee.setUserId(result.getInt("ers_user_id"));
				employee.setUsername(result.getString("ers_username"));
				employee.setPassword(result.getString("ers_password"));
				employee.setFirstname(result.getString("ers_first_name"));
				employee.setLastname(result.getString("ers_last_name"));
				employee.setEmail(result.getString("user_email"));
				employee.setUser_role_id(result.getInt("user_role_id"));
			}

			return employee;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

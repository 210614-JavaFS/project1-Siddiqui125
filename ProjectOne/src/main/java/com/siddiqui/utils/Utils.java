package com.siddiqui.utils;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.siddiqui.model.Employee;
import com.siddiqui.services.EmployeeServices;
import com.siddiqui.services.ReimbursementService;

public class Utils {

	public static Employee currentEmployee;
	public static EmployeeServices employeeServices = new EmployeeServices();
	public static ReimbursementService reimbursementService = new ReimbursementService();

	public static boolean isAdmin = false;
	public static boolean isEmployee = false;

	public static Logger log = LoggerFactory.getLogger(Utils.class);
	public static Scanner scan = new Scanner(System.in);

	public static void print(String s) {
		System.out.println(s);
	}

	public static void logDebug(String s) {
		log.debug(s);
	}

	public static void logError(String s) {
		log.error(s);
	}

}

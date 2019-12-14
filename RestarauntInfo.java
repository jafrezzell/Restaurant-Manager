package Classes;

import java.util.ArrayList;

public class RestarauntInfo {

	private static Chef chef1 =new Chef("Erik V. Mathews III", "001255", 10.25);
	private static Chef chef2 =new Chef("Thomas Kambell", "014245",13.75);
	private static Chef chef3 =new Chef("Aimee Lee", "201922",11.00);

	private static Server server1= new Server("Ashley Brown", "903751", 3.26);
	private static Server server2= new Server("John Alimoe", "001836", 2.57);
	private static Server server3= new Server("Jenny Yap", "234567", 4.55);
	
	private static ArrayList<Chef> chefs = new ArrayList<Chef>();
	private static ArrayList<Server> servers = new ArrayList<Server>();
	private static ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public static void populate() {
		chefs.add(chef1);
		chefs.add(chef2);
		chefs.add(chef3);
		
		servers.add(server1);
		servers.add(server2);
		servers.add(server3);
		
		employees.addAll(chefs);
		employees.addAll(servers);
		
	}

	
	
	
	public static boolean isEmployeeID(String ID) {
		for(Employee emp: employees) {
			if (emp.getEmployeeId().equals(ID))
				return true;
		}
		return false;
	}
	
	public static Employee getEmployee(String ID) {
		for(Employee emp: employees) {
			if(emp.getEmployeeId().equals(ID))
				return emp;
		}
		return null;
	}
	/*
	public static double calcAllWages() {
		double total = 0;
		for(Employee emp: employees) {
			
		}
	}
	
	*/
}

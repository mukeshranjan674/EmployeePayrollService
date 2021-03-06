package fileio.employee.payrollservice;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fileio.employee.payrollservice.EmployeePayrollService.IOService;

public class EmployeePayrollServiceTest {

	/**
	 * UC1
	 */
	@Test
	public void whenEmployeeAddedShouldReadAndWriteOnConsole() {
		List<EmployeePayrollData> employeeList = new ArrayList<>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeeList);
		employeePayrollService.readEmployeePayrollData();
		employeePayrollService.writeEmployeePayrollData(IOService.CONSOLE_IO);
	}

	/**
	 * UC4
	 */
	@Test
	public void whenThreeEmployeeAddedShouldWriteToAFile() {
		EmployeePayrollData[] employeeList = { new EmployeePayrollData(1, "Rama", 50000),
				new EmployeePayrollData(2, "Shyama", 50000), new EmployeePayrollData(3, "Krishna", 50000) };
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(employeeList));
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
	}

	/**
	 * UC5
	 */
	@Test
	public void whenThreeEmployeeAddedShouldReturnCountOfEmployeesAndPrintData() {
		EmployeePayrollData[] employeeList = { new EmployeePayrollData(1, "Rama", 50000),
				new EmployeePayrollData(2, "Shyama", 50000), new EmployeePayrollData(3, "Krishna", 50000) };
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(employeeList));
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
		employeePayrollService.printData(IOService.FILE_IO);
		long entries = employeePayrollService.countEntries();
		assertEquals(3, entries);
	}

	/**
	 * UC6
	 */
	@Test
	public void whenReadFromFileShouldReturnListOfEmployees() {
		EmployeePayrollData[] employeeList = { new EmployeePayrollData(1, "Rama", 50000),
				new EmployeePayrollData(2, "Shyama", 50000), new EmployeePayrollData(3, "Krishna", 50000) };
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(employeeList));
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
		List<EmployeePayrollData> list = employeePayrollService.readData(IOService.FILE_IO);
		list.forEach(System.out::println);
		assertEquals(3, list.size());
	}
}

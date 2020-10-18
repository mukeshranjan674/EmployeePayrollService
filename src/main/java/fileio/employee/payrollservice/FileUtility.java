package fileio.employee.payrollservice;

import java.io.File;

/**
 * UC3
 * 
 * @author LENOVO
 *
 */
public class FileUtility {
	public static boolean deleteFiles(File contentsToDelete) {
		File[] allContents = contentsToDelete.listFiles();
		if (allContents != null) {
			for (File file : allContents) {
				deleteFiles(file);
			}
		}
		return contentsToDelete.delete();
	}
}

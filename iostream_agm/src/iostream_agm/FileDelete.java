/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iostream_agm;

/**
 *
 * @author Nguyen Quynh
 */
public class FileDelete {
	public static void DeleteFile(File file) {
		if (file.isFile()) {
			System.out.println("Removed: " + file.getAbsolutePath());
			// xoa neu la tap tin
			file.delete();
		} else if (file.isDirectory()) {
			// lay cac file con
			File [] mangCon = file.listFiles();
			for (File file2 : mangCon) {
				DeleteFile(file2);
			}
			System.out.println("Removed: " + file.getAbsolutePath());
			file.delete();
		}
	}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter foder: ");
	String file = sc.nextLine();
	File f = new File(file);
	FileDelete.DeleteFile(f);
}

    private static class File {

        public File() {
        }

        private File(String file) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private boolean isFile() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String getAbsolutePath() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void delete() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private boolean isDirectory() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private File[] listFiles() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
package org.onkar.DesignPattern.CompositePatternSolution;

public class FileSystemAppI {

	public static void main(String[] args) {
		FileSystemComponent file1 = new File("file1.txt");
		FileSystemComponent file2 = new File("file2.txt");

		Folder folder = new Folder("Documents");
		folder.addComponents(file1);
		folder.addComponents(file2);

		// subfolder
		Folder subfolder = new Folder("subfolder");
		FileSystemComponent file3 = new File("file3.txt");
		subfolder.addComponents(file3);
		folder.addComponents(subfolder);
		folder.showDetails();
	}
}

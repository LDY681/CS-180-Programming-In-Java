import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

public class RecursionTest {

	@Test(timeout = 100)
	public void testFilecountRootDirIsFile() throws Exception {
		File root = new File("root_dir1");
		root.createNewFile();
		
		int actual = Recursion.filecount(root);
		int expected = 1;

		String message = "filecount(): check when root is a file";

		root.delete();
		
		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void testFilecountRootDirOneFile() throws Exception {
		File root = new File("root_dir2");
		root.mkdir();
		File f1 = new File(root, "file");
		f1.createNewFile();
		
		int actual = Recursion.filecount(root);
		int expected = 1;

		String message = "filecount(): check when root contains just one file";
		
		f1.delete();
		root.delete();

		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void testFilecountEmptyRoot() throws Exception {
		File root = new File("root_dir3");
		root.mkdir();
		
		int actual = Recursion.filecount(root);
		int expected = 0;

		String message = "filecount(): check when root is an empty directory";

		root.delete();
		
		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void testFilecountNestedDir() throws Exception {
		File root = new File("root_dir4");
		root.mkdir();
		
		File f1 = new File(root, "file1");
		f1.createNewFile();
		File d1 = new File(root, "dir1");
		d1.mkdir();
		File f2 = new File(d1, "file2");
		f2.createNewFile();
		File f3 = new File(d1, "file3");
		f3.createNewFile();
		File f4 = new File(d1, "file4");
		f4.createNewFile();
		
		int actual = Recursion.filecount(root);
		int expected = 4;

		String message = "filecount(): check when root directory has files and nested directory with files";
		
		f2.delete();
		f3.delete();
		f4.delete();
		d1.delete();
		f1.delete();
		root.delete();

		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void testFilecountMultiLevel() throws Exception {
		File parentDir = new File("root_dir5");
		parentDir.mkdir();
		
		File parentDirFile1 = new File(parentDir, "parentDirFile1");
		parentDirFile1.createNewFile();
		File subDir1Level1 = new File(parentDir, "subDir1Level1");
		subDir1Level1.mkdir();
		File subDir1Level2File1 = new File(subDir1Level1, "subDir1Level2File1");
		subDir1Level2File1.createNewFile();
		File subDir1Level2File2 = new File(subDir1Level1, "subDir1Level2File2");
		subDir1Level2File2.createNewFile();
		File subDir1Level2File3 = new File(subDir1Level1, "subDir1Level2File3");
		subDir1Level2File3.createNewFile();
		File subDir1Level2 = new File(subDir1Level1, "subDir1Level2");
		subDir1Level2.mkdir();
		File subDir1Level3File1 = new File(subDir1Level2, "subDir1Level3File1");
		subDir1Level3File1.createNewFile();
		File subDir2Level1 = new File(parentDir, "subDir2Level1");
		subDir2Level1.mkdir();
		File subDir2Level1File1 = new File(subDir2Level1, "subDir2Level1File1");
		subDir2Level1File1.createNewFile();
		
		int actual = Recursion.filecount(parentDir);
		int expected = 6;
		
		String message = "filecount(): check when there are multiple levels of subdirectories with files";
		
		
		subDir1Level3File1.delete();
		subDir1Level2.delete();
		subDir1Level2File1.delete();
		subDir1Level2File2.delete();
		subDir1Level2File3.delete();
		subDir1Level2.delete();
		subDir2Level1File1.delete();
		subDir2Level1.delete();
		parentDirFile1.delete();
		subDir1Level1.delete();
		parentDir.delete();
		
		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void testFilecountRandomFiles() throws Exception {
		Random r = new Random();
		int numFiles1 = r.nextInt(20) + 1;
		
		File root = new File("root_dir1");
		root.mkdir();
		
		ArrayList<File> files = new ArrayList<File>();
		
		for (int i = 1; i <= numFiles1; i++) {
			File f = new File(root, "file" + i);
			f.createNewFile();
			files.add(f);
		}
		
		File subDir = new File(root, "sub_dir");
		subDir.mkdir();
		
		int numFiles2 = r.nextInt(20) + 1;
		
		for (int i = 1; i <= numFiles2; i++) {
			File f = new File(subDir, "file" + i);
			f.createNewFile();
			files.add(f);
		}
		
		int actual = Recursion.filecount(root);
		int expected = numFiles1 + numFiles2;
		
		String message = "filecount(): check when root directory has files and subdirectory with files";

		for (File f : files) {
			f.delete();
		}
		
		subDir.delete();
		root.delete();
		
		assertEquals(message, expected, actual);
	}
}

import java.io.File;

public class Recursion {

    public static int filecount(File f) {
        int count = 0;
        if (f.isFile()) {
            count++;
        }
        File[] files = f.listFiles();
        if (files != null)
            //System.out.println("files,legnth = " + files.length);
            for (int i = 0; i < files.length; i++) {

                if (files[i].isFile()) {
                    count++;
                }


                if (files[i].isDirectory()) {
                    count = count + filecount(files[i]);
                }
            }


        return count;
    }
}

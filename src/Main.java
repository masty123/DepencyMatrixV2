import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
//        String path = "/Users/theeruthborisuth/Documents/WSP/aries/blueprint/blueprint-api/src/main/java/";
//        String outerPackage = "org/osgi/service/blueprint/";
//        File jcdFile = new File(path+outerPackage);
//        //Get list of files and store in our array
//        String[] jcdFiles = jcdFile.list();
//
//        for (String myFile : jcdFiles) {
//            if (!myFile.contains(".")) Utils.calculate(path + "/", myFile, outerPackage);
//        }
    	
    	String path = "D:/workspace/JavaSpace_oxygen/apache-log4j-2.11.1-src/log4j-core/src/main/java/";
    	String outerPackage = "org/apache/logging/log4j/core/";
    	
    	String csvFile = "software_instability.csv";
    	CSVUtils writer = null;
        try {
			writer = new CSVUtils(csvFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			writer.writeLineInstant(Arrays.asList("package_name", "instability", "abstactness", "distance_from_main_sequence"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	File file = new File(path+outerPackage);
    	String[] directories = file.list(new FilenameFilter() {
    	  @Override
    	  public boolean accept(File current, String name) {
    	    return new File(current, name).isDirectory();
    	  }
    	});
    	
    	for (String subPackage : directories) {
    		PackageInfo info = Utils.calculate(subPackage,path,outerPackage);
    		String in = String.valueOf(info.getInstability());
    		String abs = String.valueOf(info.getAbstactness());
    		String dis = String.valueOf(info.getDistanceFromMainSequence());
    		
    		try {
    			writer.writeLineInstant( Arrays.asList(info.packageName, in, abs, dis));
				System.out.println(Arrays.asList(info.packageName, in, abs, dis));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

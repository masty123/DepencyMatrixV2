import java.io.File;
/**
 * @author Theeruth Borisuth
 * @author Nitith Chayakul
 */
public class Utils {



	public static PackageInfo calculate(String packageName, String path, String outerPackage){
		File jcdFile = new File(path+outerPackage+packageName);

		String[] jcdFiles = jcdFile.list();
		ReadFile read = new ReadFile();

		System.out.println("Files Found: " + jcdFiles.length);

		for (String myFile : jcdFiles) {
			if (myFile.contains(".java"))
				read.readInFile(jcdFile.toString(), myFile);
		}

		PackageInfo info = new PackageInfo(packageName, read.getNa(), read.getNc(), read.getCa(), read.getCe());

		return info;

		//            System.out.println("=======");
		//            System.out.println("Ca = "+info.ca);
		//            System.out.println("Ce = "+info.ce);
		//            System.out.println("Na = "+info.na);
		//            System.out.println("Nc = "+info.nc);
		//            System.out.println("Abstractness: "+info.getAbstactness());
		//            System.out.println("Insability: "+info.getInstability());
	}
}


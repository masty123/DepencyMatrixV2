import java.io.File;
public class Main {
    public static void main(String[] args) {
        String path = "/Users/theeruthborisuth/Documents/WSP/aries/blueprint/blueprint-api/src/main/java/";
        String outerPackage = "org/osgi/service/blueprint/";
        File jcdFile = new File(path+outerPackage);
        //Get list of files and store in our array
        String[] jcdFiles = jcdFile.list();

        for (String myFile : jcdFiles) {
            if (!myFile.contains(".")) Utils.calculate(path + "/", myFile, outerPackage);
        }
    }
}

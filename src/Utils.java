import java.io.File;
/**
 * @author Theeruth Borisuth
 * @author Nitith Chayakul
 */
public class Utils {

    public static void recur(String path, String folder, PackageInfo info){
        String newPath = path+"/"+folder;
        File jcdFile = new File(newPath);
        String[] jcdFiles = jcdFile.list();
        readFile read = new readFile();
        for(String myFile : jcdFiles) {
            if (myFile.endsWith(".java")) {
                //System.out.println(myFile.toString()+":");
                read.readFile(jcdFile.getPath() + "/" + myFile, info);
                //System.out.println(myFile);
            } else if (!myFile.contains(".") && !myFile.equals("packageinfo")) {
                recur(jcdFile.getPath(), myFile, info);
            }
        }
    }

    public static void recurCa(String path, String folder,PackageInfo info, String outerPackage){
        String newPath = path+"/"+folder;
        File jcdFile = new File(newPath);
        String[] jcdFiles = jcdFile.list();
        readFile read = new readFile();
        for(String myFile : jcdFiles)
        {
            if(myFile.endsWith(".java")){
                read.readFileCa(jcdFile.getPath()+"/"+myFile, info, outerPackage);
            }
            else if(!myFile.contains(".") && !myFile.equals("packageinfo")){
                recurCa(jcdFile.getPath(), myFile, info, outerPackage);
            }
        }
    }


    public static void calculate(String path, String packageName, String outerPackage){
            PackageInfo info =new PackageInfo();
            info.packageName = packageName;
            File jcdFile = new File(path+outerPackage+info.packageName);
            //Get list of files and store in our array
            String[] jcdFiles = jcdFile.list();
            readFile read = new readFile();



            //Print out number of files
            System.out.println("Files Found: "+jcdFiles.length);
            System.out.print("Package Name: "+info.packageName);

            //Add blank line
            System.out.println("");

            //Enhance loop through all files in the directory or folder
            for(String myFile : jcdFiles)
            {
                if(myFile.endsWith(".java")){
                    read.readFile(jcdFile.getPath()+"/"+myFile, info);
                }
                else if(!myFile.contains(".") && !myFile.equals("packageinfo")){
                    Utils.recur(jcdFile.getPath(), myFile, info);
                }
            }


            File jcdFileCa = new File(path);
            //Get list of files and store in our array
            String[] jcdFilesCa = jcdFileCa.list();
            for(String myFile : jcdFilesCa){
                if(myFile.endsWith(".java")){
                    read.readFileCa(jcdFileCa.getPath()+"/"+myFile, info, outerPackage);
                }
                else if(myFile.equals(info.packageName)){

                }
                else if(!myFile.contains(".") && !myFile.equals("packageinfo")){
                    recurCa(jcdFileCa.getPath(), myFile, info, outerPackage);
                }
            }

            System.out.println("=======");
            System.out.println("Ca = "+info.ca);
            System.out.println("Ce = "+info.ce);
            System.out.println("Na = "+info.na);
            System.out.println("Nc = "+info.nc);
            System.out.println("Abstractness: "+info.getAbstactness());
        System.out.println("Insability: "+info.getInstability());
        }
    }



//    public static void main(String[] args) {
//
//        PackageInfo info = new PackageInfo();
//        info.packageName = "reflect";
//        String path = "/Users/theeruthborisuth/Documents/WSP/aries/blueprint/blueprint-api/src/main/java/";
//        String outerPackage = "org/osgi/service/blueprint/";
//        File jcdFile = new File(path+outerPackage+info.packageName);
//        //Get list of files and store in our array
//        String[] jcdFiles = jcdFile.list();
//        readFile read = new readFile();
//
//
//
//        //Print out number of files
//        System.out.println("Files Found: "+jcdFiles.length);
//
//        //Add blank line
//        System.out.println("");
//
//        //Enhance loop through all files in the directory or folder
//        for(String myFile : jcdFiles)
//        {
//            if(myFile.endsWith(".java")){
//                read.readFile(jcdFile.getPath()+"/"+myFile, info);
//            }
//            else if(!myFile.contains(".") && !myFile.equals("packageinfo")){
//                Utils.recur(jcdFile.getPath(), myFile, info);
//            }
//        }
//
//
//        File jcdFileCa = new File(path);
//        //Get list of files and store in our array
//        String[] jcdFilesCa = jcdFileCa.list();
//        for(String myFile : jcdFilesCa){
//            if(myFile.endsWith(".java")){
//                read.readFileCa(jcdFileCa.getPath()+"/"+myFile, info, outerPackage);
//            }
//            else if(myFile.equals(info.packageName)){
//
//            }
//            else if(!myFile.contains(".") && !myFile.equals("packageinfo")){
//                recurCa(jcdFileCa.getPath(), myFile, info, outerPackage);
//            }
//        }
//
//        System.out.println("=======");
//        System.out.println("Ca = "+info.ca);
//        System.out.println("Ce = "+info.ce);
//        System.out.println("Na = "+info.na);
//        System.out.println("Nc = "+info.nc);
//        System.out.println("Abstractness: "+info.getAbstactness());
//        System.out.println("Insability: "+info.getInstability());
//    }

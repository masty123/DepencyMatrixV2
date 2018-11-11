import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;
/**
 * @author Theeruth Borisuth
 * @author Nitith Chayakul
 */
public class ReadFile {

	private double ca;
	private double ce;
	private double nc;
	private double na;

	public ReadFile() {
		this.ca = 0;
		this.ce = 0;
		this.nc = 0;
		this.na = 0;
	}

	public void readInFile(String direc, String name) {
		String jdkReleaseFile = direc + "/" + name;
		System.out.println("rif: " + jdkReleaseFile);
		readTextFile(jdkReleaseFile);
	}

	public void readTextFile(String fileToRead) {
		String eachLine = "";
		try {
			BufferedReader buffReader = new BufferedReader(new FileReader(fileToRead));
			while ((eachLine = buffReader.readLine()) != null) {
				if (eachLine.contains(" extends ") || eachLine.contains(" implements "))
					ca++;
				if (eachLine.contains("import "))
					ce++;
				if (eachLine.contains(" class "))
					nc++;
				if (eachLine.contains(" abstract "))
					na++;
			}
			buffReader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public double getCa() {
		return ca;
	}

	public double getCe() {
		return ce;
	}

	public double getNc() {
		return nc;
	}

	public double getNa() {
		return na;
	}

}
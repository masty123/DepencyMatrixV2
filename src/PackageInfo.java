/**
 * @author Theeruth Borisuth
 * @author Nitith Chayakul
 */
public class PackageInfo {

	String packageName;

	//The number of classes outside this package.
	private double ca;
	//The number of classes inside this package.
	private double ce;
	//numbers of abstract class in package.
	private double na;
	//numbers of class in package.
	private double nc;

	public PackageInfo(String name, double na, double nc, double ca, double ce) {
		packageName = name;
		this.ce = ce;
		this.ca = ca;
		this.na = na;
		this.nc = nc;
	}

	public double getInstability(){
		return ce/(ca+ce);
	}



	public double getAbstactness(){
		return na/nc;
	}

	public double getDistanceFromMainSequence() {
		return getInstability() + getAbstactness() - 1.0;
	}

}

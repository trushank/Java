
/**
 * OsName.java
 * Display the operating system name
 * 
 * @author    tgd2900
 *
 *Version:  $Id: OsName.java,v 1.0 2012/09/06 13:15:46 tgd Exp tgd $ 
 * 
 * Revisions: 
 *     
 */
public class OsName 
{
	/**
	 * Prints Operating System name
	 * @param args Command line input (Not used)
	 */
		public static void main(String args[])
		{
			System.out.println("OS: " + System.getProperty("os.name"));
		}
}

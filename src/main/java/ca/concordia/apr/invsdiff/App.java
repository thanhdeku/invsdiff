package ca.concordia.apr.invsdiff;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;

import ca.concordia.apr.invsdiff.comparasion.Comparator;

/**
 * Compare similar invariants file generated by daikon, i.e. invariants of slightly different versions
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, IOException, NoSuchAlgorithmException
    {
    	if (args.length < 2) {
    		System.out.println("Usage: \nca.concordia.apr.invsdiff.App invsfile0 invsfile1 invsfile2 ...");
    		System.exit(1);
    	}
    	List<InvsFile> invsFiles = new LinkedList<InvsFile>();
        for (int j = 0; j < args.length; j++) {
        	if (args[j].startsWith("-")) {
        	} else {
        		invsFiles.add(new InvsFile(args[j]));
        	}
        }
        Comparator.compareInvsFile(invsFiles.toArray(new InvsFile[invsFiles.size()]));
    }
}

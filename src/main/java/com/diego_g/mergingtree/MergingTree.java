package main.java.com.diego_g.mergingtree;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 
 * @author Diego Garcia
 */
class MergingTree {
	
    private static Tree myTree;
    private static final String[] pathFiles = {"./files/File1.txt", "./files/File2.txt"};
    private static final String resultFile = "./files/Result.txt";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		myTree = new Tree();
      
        for (String path : pathFiles) {
            try{
            	File f = new File(path);
            	if (f.exists() && f.isFile()) {
	            	myTree.fileMerger(f);
	                System.out.println(f + " successuflly processes");
            	}
            }catch (Exception e){
            	System.err.println(e.getMessage());
            }
        }
        try {
        	myTree.getTreeLayout(resultFile);
            System.out.println("The resultant tree (" +myTree.toString()+ ") has been printed in "+ resultFile);
        } catch (FileNotFoundException ex) {
            throw new Error("Error writing into file: " + ex.getMessage());
        }		
	}

}

package main.java.com.diego_g.mergingtree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Pattern;

/**
 * 
 * @author Diego Garcia
 */
public class Tree {

	public final Pattern pathLimiter = Pattern.compile("\\/|\\.");
	public final Pattern weightLimiter = Pattern.compile(" : ");

	SortedMap<String, Integer> tree;

	/**
	 * Constructor
	 *
	 */
	public Tree() {
		SortedMap<String, Integer> map = new TreeMap<>();
		this.tree = (SortedMap<String, Integer>) Collections
				.synchronizedSortedMap(map);
	}

	/**
	 * It adds a file data into a tree
	 *
	 * @param file
	 * @throws java.lang.Exception
	 */
	public void fileMerger(File f) throws Exception {
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {

			String line;
			int line_number = 1;

			while ((line = br.readLine()) != null) {

				final String[] path_weight = weightLimiter.split(line);

				if (path_weight.length != 2) {
					throw new Exception("Line " + line_number
							+ ": unproperly formatted.");
				}

				try {
					Integer.parseInt(path_weight[1]);
				} catch (NumberFormatException e) {
					throw new Exception("Line " + line_number
							+ ": incorrect weight.");
				}

				if (isEmpty(path_weight[0])) {
					throw new Exception("Line " + line_number
							+ ": NO path found.");
				}

				int weight = Integer.parseInt(path_weight[1]);

				final String[] nodes = pathLimiter.split(path_weight[0]);

				for (int i = 0; i < nodes.length; i++) {
					if (isEmpty(nodes[i])) {
						System.out.println("Line " + line_number
								+ " has an empty node: skipped!");
						continue;
					}
					if (i != 0) {
						nodes[i] = nodes[i - 1] + '/' + nodes[i];
					}
					if (tree.containsKey(nodes[i])) {
						tree.put(nodes[i], tree.get(nodes[i]) + weight);
					} else {
						tree.put(nodes[i], weight);
					}
				}
				line_number++;
			}
		} catch (IOException e) {
			throw new Exception("File problems!");
		}
	}

	public static boolean isEmpty(String str) {
		return (str == null || str.trim().isEmpty());
	}

	/**
	 * It prints the tree in a file
	 *
	 * @param path
	 * @throws java.io.FileNotFoundException
	 */
	public void getTreeLayout(String p) throws FileNotFoundException {

		File f = new File(p);

		try (PrintWriter writer = new PrintWriter(f)) {

			for (SortedMap.Entry<String, Integer> entry : tree.entrySet()) {
				writer.println(entry.getKey() + " : " + entry.getValue());
			}
		}
	}
}

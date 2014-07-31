package com.sixdimensions.wcm.randomrow;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class RandomRowFetcher {

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException,
			IOException {

		System.out.println("Getting random line from file: " + args[0]);

		InputStream is = null;
		BufferedReader reader = null;
		try {
			is = new FileInputStream(args[0]);

			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(args[0])));

			System.out.println("Reading file...");
			List<String> list = new ArrayList<String>();
			String line = reader.readLine();
			while (line != null) {
				list.add(line);
				line = reader.readLine();
			}

			System.out.println("Generating random...");
			SecureRandom random = new SecureRandom();
			int row = random.nextInt(list.size());

			System.out.println("Random selection is:\n");
			System.out.println(list.get(row));

		} finally {
			if (is != null) {
				is.close();
			}
			if (reader != null) {
				reader.close();
			}
		}
	}

}

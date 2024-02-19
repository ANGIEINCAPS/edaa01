package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		long t0 = System.nanoTime();

		ArrayList<TextProcessor> array = new ArrayList<>();
		Set<String> stopwords = new HashSet<>();

		Scanner scanStop = new Scanner(new File("lab2-3\\undantagsord.txt"));
		scanStop.findWithinHorizon("\uFEFF", 1);
		scanStop.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");

		while (scanStop.hasNext()) {
			stopwords.add(scanStop.next().toLowerCase());
		}

		TextProcessor g = new GeneralWordCounter(stopwords);
		array.add(g);

		TextProcessor p = new SingleWordCounter("nils");
		array.add(p);
		TextProcessor q = new SingleWordCounter("norge");
		array.add(q);
		TextProcessor r = new MultiWordCounter(REGIONS);
		array.add(r);

		Scanner scanNils = new Scanner(new File("lab2-3\\nilsholg.txt"));
		scanNils.findWithinHorizon("\uFEFF", 1);
		scanNils.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (scanNils.hasNext()) {
			String word = scanNils.next().toLowerCase();

			p.process(word);
			q.process(word);
			r.process(word);
			g.process(word);
		}

		scanNils.close();
		scanStop.close();

		p.report();
		q.report();
		r.report();
		g.report();

		long t1 = System.nanoTime();
		System.out.println("tid: " + (t1 - t0) / 1000000.0 + " ms");
		//382  359  395  [ms]  HashMap
		//354  418  413  [ms] TreeMap

	}



}
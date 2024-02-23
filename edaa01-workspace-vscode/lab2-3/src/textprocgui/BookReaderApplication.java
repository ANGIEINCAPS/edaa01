package textprocgui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import textproc.GeneralWordCounter;
import textproc.TextProcessor;

public class BookReaderApplication {

	public static void main(String[] args) throws FileNotFoundException {
		Set<String> stopwords = new HashSet<>();

		Scanner scanStop = new Scanner(new File("lab2-3\\undantagsord.txt"));
		scanStop.findWithinHorizon("\uFEFF", 1);
		scanStop.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");

		while (scanStop.hasNext()) {
			stopwords.add(scanStop.next().toLowerCase());
		}

		Scanner scanNils = new Scanner(new File("lab2-3\\nilsholg.txt"));
		scanNils.findWithinHorizon("\uFEFF", 1);
		scanNils.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		TextProcessor counter = new GeneralWordCounter(stopwords);

		while (scanNils.hasNext()) {
			String word = scanNils.next().toLowerCase();
			counter.process(word);
		}

		counter.report();

		scanNils.close();
		scanStop.close();

		BookReaderController controller = new BookReaderController((GeneralWordCounter) counter);

	}

}

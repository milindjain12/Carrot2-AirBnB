package com.ureka.milind.main;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.carrot2.clustering.lingo.LingoClusteringAlgorithm;
import org.carrot2.core.Cluster;
import org.carrot2.core.Controller;
import org.carrot2.core.ControllerFactory;
import org.carrot2.core.Document;
import org.carrot2.core.ProcessingResult;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.ureka.milind.domain.AirBnbReview;
import com.ureka.milind.util.ConsoleFormatter;

public class Main {

	private static List<AirBnbReview> reviews = new ArrayList<>();
	private static List<Document> documents = new ArrayList<>();

	public static void readDataLineByLine(String file) {

		try {
			FileReader filereader = new FileReader(file);
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
			String[] attributes;

			while ((attributes = csvReader.readNext()) != null) {
				Long listingId = Long.parseLong(attributes[0]);
				Long id = Long.parseLong(attributes[1]);
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(attributes[2]);
				Long reviewerId = Long.parseLong(attributes[3]);
				String reviewerName = attributes[4];
				String review = attributes[5];
				reviews.add(new AirBnbReview(listingId, id, date, reviewerId, reviewerName, review));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String csvFile = "resources/reviews.csv";
		readDataLineByLine(csvFile);
		for (AirBnbReview ar : reviews) {
			documents.add(new Document(ar.getReview()));
		}

		final Controller controller = ControllerFactory.createPooling();
		final ProcessingResult byTopicClusters = controller.process(documents, "host", LingoClusteringAlgorithm.class);
		final List<Cluster> clustersByTopic = byTopicClusters.getClusters();

		ConsoleFormatter.displayClusters(clustersByTopic);
	}

}

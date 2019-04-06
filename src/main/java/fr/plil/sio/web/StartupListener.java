package fr.plil.sio.web;

import com.opencsv.CSVReader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <b>Warning:</b> it is not intelligent to use the same pattern in your code,
 * as listener is started in another thread and first page could be requested
 * before listener has finished
 *
 * @author Julien Iguchi-Cartigny
 */
@WebListener
public class StartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        VideoGamesRepository videoGamesRepository = new VideoGamesRepository();

        List<List<String>> records = readCsv();

        int id = 1;
        for (List<String> r : records) {
            VideoGame videoGame = new VideoGame(id, r);
            videoGamesRepository.add(videoGame);
            id += 1;
        }
        event.getServletContext().setAttribute("videoGamesRepository", videoGamesRepository);
    }

    private List<List<String>> readCsv() {
        List<List<String>> records = new ArrayList<>();
        try {
            CSVReader csvReader = new CSVReader(new FileReader("video-games.csv"));
            String[] values;
            csvReader.readNext(); // skip header
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        } catch (Exception e) {
            System.out.println("Not able to read the CSV");
        }
        return records;
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        event.getServletContext().removeAttribute("videoGamesRepository");
    }
}

package fr.plil.sio.web;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

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
        int i = 1;
        for(List<String> r : records){
            VideoGame videoGame = new VideoGame(i, r);
            videoGamesRepository.add(videoGame);
            i+=1;
        }
        event.getServletContext().setAttribute("videoGamesRepository", videoGamesRepository);
    }
    
    public List<List<String>> readCsv(){
        List<List<String>> records = new ArrayList<List<String>>();
        try{
            CSVReader csvReader = new CSVReader(new FileReader("video-games.csv"));
            String[] values = null;
            String[] header = csvReader.readNext();
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        } catch(Exception e) {

        }
        return records;
    }
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        event.getServletContext().removeAttribute("videoGamesRepository");
    }
}

package chrlryo.uspolling.data;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by charlesherriau on 17/11/2016.
 */
public class CreateFile {

    private static final String FILE_NAME = "/tmp/data/";

    public static void main(String[] args) throws IOException {


        final LocalDate localDate = LocalDate.of(2016, 11, 8);

        for(States state : States.values()) {
            LocalTime localTime = LocalTime.of((int) (Math.random()) + 20, (int) (Math.random() * 60));
            LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
            String timestamp = localDateTime.toString();

            FileWriter fileWriter = new FileWriter(FILE_NAME + localDateTime.format(DateTimeFormatter.ofPattern("YYYY-MM-dd-HH-mm")) + "_" + state +".txt");

            for(int i = 0; i < state.getClinton(); i++) {
                fileWriter.append(timestamp + ";" + state.name() + ";Clinton\n");
            }
            for(int i = 0; i < state.getTrump(); i++) {
                fileWriter.append(timestamp + ";" + state.name() + ";Trump\n");
            }
            for(int i = 0; i < state.getCastle(); i++) {
                fileWriter.append(timestamp + ";" + state.name() + ";Castle\n");
            }
            for(int i = 0; i < state.getJohnson(); i++) {
                fileWriter.append(timestamp + ";" + state.name() + ";Johnson\n");
            }
            for(int i = 0; i < state.getMcMullin(); i++) {
                fileWriter.append(timestamp + ";" + state.name() + ";McMullin\n");
            }
            for(int i = 0; i < state.getStein(); i++) {
                fileWriter.append(timestamp + ";" + state.name() + ";Stein\n");
            }
            for(int i = 0; i < state.getAutres(); i++) {
                fileWriter.append(timestamp + ";" + state.name() + ";Autre\n");
            }
            if(state.getVotants() != States.getNoVotants()) {
                for (int i = 0; i < state.getVotants() - state.getTotal(); i++) {
                    fileWriter.append(timestamp + ";" + state.name() + ";Blanc\n");
                }
            }

            fileWriter.flush();
            fileWriter.close();
        }
    }
}

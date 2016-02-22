package it.reexon.utility.ping;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import it.reexon.utility.ping.enums.SystemEnum;


/**
 * Hello world!
 *
 */
public class App
{

    public static void main(String[] args)
    {

        final int SECONDS_ONE_DAY = 86400;
        final Boolean realtimePrint = true;

        PingArguments pingArguments = new PingArguments.Builder(SystemEnum.WINDOWS).build();
        pingArguments.setCount(SECONDS_ONE_DAY);
        pingArguments.setUrl("www.google.it");

        BufferedReader reader = null;
        BufferedWriter writer = null;
        try
        {
            File file = new File("C:\\TEMP\\ping2.txt");
            writer = new BufferedWriter(new FileWriter(file, true));

            Runtime r = Runtime.getRuntime();
            Process p = r.exec(pingArguments.getCommand());
            reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String inputLine;
            int c = 0;
            while ((inputLine = reader.readLine()) != null && c < pingArguments.getCount())
            {
                c++;
                Date date = new Date();

                String message = "";
                message = createMessage(pingArguments.getCommand(), date);
                writer.newLine();
                message = createMessage(inputLine, date);

                System.out.println(message);
                if (realtimePrint)
                    writer.flush();

                writer.write(message);
            }
            writer.newLine();
            writer.write(createMessage("END", new Date()));
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
        finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {}
            }
            if (writer != null)
            {
                try
                {
                    writer.flush();
                    writer.close();
                }
                catch (IOException e)
                {}
            }
        }
    }

    private static String createMessage(String inputLine, Date date)
    {
        StringBuilder message = new StringBuilder();
        message.append(date + " ");
        message.append(inputLine);

        return message.toString();
    }

}

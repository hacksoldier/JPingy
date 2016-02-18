package it.reexon.utility.ping;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


class PingTest
{
    @SuppressWarnings("unused")
    public static void main(String[] args)
    {
        String ip = "127.0.0.1";
        String pingResult = "";

        String pingCmd = "ping " + ip;
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try
        {
            File file = new File("C:\\TEMP\\ping2.txt");
            writer = new BufferedWriter(new FileWriter(file, true));

            Runtime r = Runtime.getRuntime();
            Process p = r.exec(pingCmd);

            reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String inputLine;
            while ((inputLine = reader.readLine()) != null)
            {
                System.out.println(inputLine);
                writer.newLine();
                writer.write(inputLine);
                pingResult += inputLine;
            }
            writer.flush();
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
                    writer.close();
                }
                catch (IOException e)
                {}
            }
        }
    }
}
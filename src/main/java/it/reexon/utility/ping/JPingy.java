/**
 * 
 */
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
 * @author marco.velluto
 *
 */
public class JPingy
{

    public static final int SECOND_ONE_DAY = 86400;

    private Boolean realtimeWrite = true;
    private String fileName;
    private String location = "C:\\TEMP\\";
    private Integer count;

    public JPingy(String fileName)
    {
        super();
        this.fileName = fileName;
    }

    /**
     * 
     * @return
     */
    public Boolean run()
    {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try
        {
            File file = new File(this.location + this.fileName);
            writer = new BufferedWriter(new FileWriter(file, true));

            writer.write(createMessage("BEGIN PROCESS", new Date()));
            writer.newLine();

            PingArguments pingArguments = new PingArguments.Builder(SystemEnum.WINDOWS).build();
            pingArguments.setCount(this.count);

            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(pingArguments.getCommand());
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            write(writer, createMessage(pingArguments.getCommand(), new Date()));

            String inputLine;
            while ((inputLine = reader.readLine()) != null)
            {
                Date date = new Date();
                String message = "";
                writer.newLine();
                message = createMessage(inputLine, date);

                System.out.println(message);

                write(writer, message);
            }
            writer.newLine();
            writer.write(createMessage("END PROCESS", new Date()));
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
        finally
        {
            closeReader(reader);
            closeWriter(writer);
        }
        return null;
    }

    /**
     * 
     * @param writer
     */
    private void closeWriter(BufferedWriter writer)
    {
        if (writer != null)
        {
            try
            {
                writer.flush();
            }
            catch (IOException e)
            {}
            finally
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

    /**
     * 
     * @param reader
     */
    private void closeReader(BufferedReader reader)
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
    }

    /**
    * 
    * @param writer
    * @param message
    * @throws IOException
    */
    private void write(BufferedWriter writer, String message) throws IOException
    {
        writer.write(message);
        if (realtimeWrite)
            writer.flush();
    }

    /**
     * 
     * @param inputLine
     * @param date
     * @return
     */
    private static String createMessage(String inputLine, Date date)
    {
        StringBuilder message = new StringBuilder();
        message.append(date + " ");
        message.append(inputLine);

        return message.toString();
    }

    public Boolean getRealtimeWrite()
    {
        return realtimeWrite;
    }

    public void setRealtimeWrite(Boolean realtimeWrite)
    {
        this.realtimeWrite = realtimeWrite;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public Integer getCount()
    {
        return count;
    }

    public void setCount(Integer count)
    {
        this.count = count;
    }
}

package it.reexon.utility.ping;

public class App
{
    public static void main(String[] args)
    {
        JPingy jpPingy = new JPingy("ping.txt", "www.google.it", JPingy.SECOND_ONE_DAY);
        jpPingy.run();
    }
}

/**


final int SECONDS_ONE_DAY = 86400;
final Boolean realtimePrint = true;

PingArguments pingArguments = new PingArguments.Builder(SystemEnum.WINDOWS).build();
pingArguments.setCount(SECONDS_ONE_DAY);
pingArguments.setUrl("www.google.it");

BufferedReader reader = null;
File file = new File("C:\\TEMP\\ping2.txt");

try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)); )
{
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
}
*/
import java.io.*;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileCommanderCLI {
    private FileCommander fileCommander;
    private BufferedReader reader;
    private BufferedReader writer
    public FileCommanderCLI(InputStream in, PrintStream out)
    {

        fileCommander = new FileCommander();
        reader = new BufferedReader(new InputStreamReader(in));
        writer = new BufferedReader(new OutputStreamWriter(out));





    }
    public void eventLoop()
    {
        while (true) {
            try {
                String line = reader.readLine();
                runCommand(line);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
    private void runCommand(String line)
    {
       String[] params =  line.split(" ");
       if(params.length == 0)
       {
           return;

       }
       switch (params[0])
       {
           case "ls" -> System.out.println(fileCommander.ls());
           case "pwd" -> System.out.println(fileCommander.pwd());
           case "cd" -> fileCommander.cd(Path.of(params[1]));


       }


    }


}

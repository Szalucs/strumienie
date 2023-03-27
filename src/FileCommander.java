import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileCommander {
    private Path path;

    public FileCommander() {
        this.path = Path.of(System.getProperty("user.home"));
    }
    public String pwd()
    {
        return path.toString();


    }
    public void cd(Path path)
    {
        this.path = this.path.resolve(path).normalize();



    }
    public List<String> ls()
    {

        try{
           Files.list(path)
                   .map(Path::toString)
                   .collect(Collectors.toList());

        }
        catch(IOException e){
            throw new RuntimeException(e);



        }

    }
}

import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    public static String readFileToString(String fileName)throws Exception
    {
        String data;
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static JSONObject readFileToJSON(String fileName)throws Exception
    {
        JSONObject data;
        data = new JSONObject(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }
}

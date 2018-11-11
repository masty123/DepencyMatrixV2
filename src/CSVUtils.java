import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class CSVUtils {

    private static final char DEFAULT_SEPARATOR = ',';
    private FileWriter writer;

    public CSVUtils(String filepath) throws IOException {
    	writer = new FileWriter(filepath);
    }
    
    public void writeLineInstant(List<String> values) throws IOException {
    	CSVUtils.writeLine(writer, values);
    }
    
    public void close() throws IOException {
    	writer.flush();
		writer.close();
    }
    
    //https://tools.ietf.org/html/rfc4180
    private static String followCVSformat(String value) {

        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;

    }

    public static void writeLine(Writer w, List<String> values) throws IOException {

        boolean first = true;

        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(DEFAULT_SEPARATOR);
            }
            sb.append(followCVSformat(value));

            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());
    }

}
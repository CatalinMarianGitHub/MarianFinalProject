import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private String apiUrl;
    private String loginPassword;
    private String applicationURL;
    private String browser;

    public Configuration () throws IOException {
        Properties prop = new Properties();

        try {
            InputStream fis = new FileInputStream("D:/qa automation/Final Project/framework catalin, first version/Curs11/src/test/resources/app.properties");
            prop.load(fis);
            apiUrl = prop.getProperty("apiUrl");
            loginPassword = prop.getProperty("loginPassword");
            applicationURL = prop.getProperty("applicationURL");
            browser = prop.getProperty("browser");
        } catch(FileNotFoundException e) {
            System.out.println("Fisierul nu exista");
            throw new FileNotFoundException();
        }
    }

    public String getApiUrl () {
        return apiUrl;
    }
    public String getLoginPassword() {
        return loginPassword;
    }
    public String getApplicationURL() {
        return applicationURL;
    }
    public String getBrowser() {
        return browser;
    }

}

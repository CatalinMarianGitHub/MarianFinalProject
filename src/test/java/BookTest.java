import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;

public class BookTest {
    final static Logger log = Logger.getLogger(String.valueOf(LogExample.class));
    SeleniumHelper seleniumHelper;


    @Test
    public void _1_verifyBookCanBeLendedd() throws IOException, InterruptedException {
        Configuration config = new Configuration();
        ApiCalls api = new ApiCalls();
        seleniumHelper = new SeleniumHelper(config.getBrowser());
        Methods methods = new Methods(config.getBrowser());

        api.createNewUser(config.getApiUrl(), config.getLoginPassword());
        log.info("user created");
        seleniumHelper.navigateToURL(config.getApplicationURL());
        seleniumHelper.loginInApplication(api.getEmailCreated(),
                config.getLoginPassword());
        log.info("login OK");
        seleniumHelper.verifyUserHasLoggedIn();
        log.info("login asserted");
        api.createAuthor(config.getLoginPassword());
        log.info("author created");
        api.createBook(config.getLoginPassword());
        log.info("Book created");
        seleniumHelper.getElement("books").click();
        Thread.sleep(2000);
        seleniumHelper.lendBook_SHelper();
    }

    @Test
    public void _2_createEmptyBook() throws IOException, InterruptedException {
        Configuration config = new Configuration();
        ApiCalls api = new ApiCalls();
        seleniumHelper = new SeleniumHelper(config.getBrowser());
        Methods methods = new Methods(config.getBrowser());

        api.createNewUser(config.getApiUrl(), config.getLoginPassword());
        log.info("user created");
        seleniumHelper.navigateToURL(config.getApplicationURL());
        seleniumHelper.loginInApplication(api.getEmailCreated(),
                config.getLoginPassword());
        log.info("login OK");
        seleniumHelper.verifyUserHasLoggedIn();
        log.info("login asserted");
        api.createAuthor(config.getLoginPassword());
        log.info("author created");
        Thread.sleep(1000);
        seleniumHelper.getElement("books").click();
        Thread.sleep(1000);
        seleniumHelper.create_EMPTYBook_Method_SEHelper();
    }

    @Test
    public void _3_verifyTheBookCanBeDeleted() throws IOException, InterruptedException {
        Configuration config = new Configuration();
        ApiCalls api = new ApiCalls();
        seleniumHelper = new SeleniumHelper(config.getBrowser());
        Methods methods = new Methods(config.getBrowser());

        api.createNewUser(config.getApiUrl(), config.getLoginPassword());
        log.info("user created");
        seleniumHelper.navigateToURL(config.getApplicationURL());
        seleniumHelper.loginInApplication(api.getEmailCreated(),
                config.getLoginPassword());
        log.info("login OK");
        seleniumHelper.verifyUserHasLoggedIn();
        log.info("login asserted");
        api.createAuthor(config.getLoginPassword());
        log.info("author created");
        api.createBook(config.getLoginPassword());
        log.info("Book created");
        seleniumHelper.getElement("books").click();
        Thread.sleep(2000);
        seleniumHelper.deletedBook_SeleniumHelper();
    }

    @Test
    public void _4_verifyTheBookCanBeEdited() throws IOException, InterruptedException {
        Configuration config = new Configuration();
        ApiCalls api = new ApiCalls();
        seleniumHelper = new SeleniumHelper(config.getBrowser());
        Methods methods = new Methods(config.getBrowser());

        api.createNewUser(config.getApiUrl(), config.getLoginPassword());
        log.info("user created");
        seleniumHelper.navigateToURL(config.getApplicationURL());
        seleniumHelper.loginInApplication(api.getEmailCreated(),
                config.getLoginPassword());
        log.info("login OK");
        seleniumHelper.verifyUserHasLoggedIn();
        log.info("login asserted");
        api.createAuthor(config.getLoginPassword());
        log.info("author created");
        api.createBook(config.getLoginPassword());
        log.info("Book created");
        seleniumHelper.getElement("books").click();
        Thread.sleep(2000);
        seleniumHelper.editBook_SHelper();
    }


    private static class LogExample {
    }
}

package Builder;
import BuilderInterfaces.IBuilder;
import org.openqa.selenium.chrome.ChromeOptions;



public class profileBuilder implements IBuilder<ChromeOptions> {
    private final String profileDir;
    private final String profilePath;
    public ChromeOptions options = new ChromeOptions();
    public profileBuilder(){


        this.profileDir =  "";
        this.profilePath =   "";

    }

    public profileBuilder create() {return  new profileBuilder();}

    public ChromeOptions build(){



        options.addArguments(profileDir,profilePath);

        return options;
    }


}

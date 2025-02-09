package keys;

import io.github.cdimascio.dotenv.Dotenv;

public class Keys {

    // Create a .env in the project root with these keys and your values for them
    private static final String OPEN_AI_API_KEY = "OPEN_AI_API_KEY";

    public static final String openAiAPI;

    static {
        Dotenv dotenv = Dotenv.configure().load();

        openAiAPI = dotenv.get(OPEN_AI_API_KEY);
        System.out.println(OPEN_AI_API_KEY);
    }

}

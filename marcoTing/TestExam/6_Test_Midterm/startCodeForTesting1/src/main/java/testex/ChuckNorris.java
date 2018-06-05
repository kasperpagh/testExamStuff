package testex;


import testex.IjokeFetcher;
import testex.Joke;

import static com.jayway.restassured.RestAssured.given;

public class ChuckNorris implements IjokeFetcher {
    @Override
    public Joke getJoke() {
        try{
            String joke = given().get("http://api.icndb.com/jokes/random").path("value.joke");
            return new Joke(joke,"http://api.icndb.com/");
        } catch(Exception e){
            return null;
        }
    }
}

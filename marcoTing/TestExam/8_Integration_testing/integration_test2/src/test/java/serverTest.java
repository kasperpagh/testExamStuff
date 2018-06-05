
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import org.junit.*;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
public class serverTest {
    @BeforeClass
    public static void beforeAll(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3333;
    }

    @Test
    public void UserAmount(){
        get("/users").then()
                .contentType(JSON)
                .assertThat()
                .body("count",equalTo(659774));
    }

    @Test
    public void links(){
        get("/linkers/10").then()
                .contentType(JSON)
                .assertThat()
                .body("[0]._id",equalTo("lost_dog"),"[0].total",equalTo(549))
                .body("[1]._id",equalTo("dogzero"),"[1].total",equalTo(334))
                .body("[2]._id",equalTo("tweetpet"),"[2].total",equalTo(310))
                .body("[3]._id",equalTo("VioletsCRUK"),"[3].total",equalTo(296))
                .body("[4]._id",equalTo("tsarnick"),"[4].total",equalTo(258))
                .body("[5]._id",equalTo("SongoftheOss"),"[5].total",equalTo(257))
                .body("[6]._id",equalTo("what_bugs_u"),"[6].total",equalTo(246))
                .body("[7]._id",equalTo("Karen230683"),"[7].total",equalTo(244))
                .body("[8]._id",equalTo("keza34"),"[8].total",equalTo(239))
                .body("[9]._id",equalTo("SallytheShizzle"),"[9].total",equalTo(234));
    }
    @Test
    public void activeUsers(){
        get("/active/10").then()
                .contentType(JSON)
                .assertThat()
                .body("[0]._id",equalTo("lost_dog"),"[0].total",equalTo(549))
                .body("[1]._id",equalTo("webwoke"),"[1].total",equalTo(345))
                .body("[2]._id",equalTo("tweetpet"),"[2].total",equalTo(310))
                .body("[3]._id",equalTo("SallytheShizzle"),"[3].total",equalTo(281))
                .body("[4]._id",equalTo("VioletsCRUK"),"[4].total",equalTo(279))
                .body("[5]._id",equalTo("mcraddictal"),"[5].total",equalTo(276))
                .body("[6]._id",equalTo("tsarnick"),"[6].total",equalTo(248))
                .body("[7]._id",equalTo("what_bugs_u"),"[7].total",equalTo(246))
                .body("[8]._id",equalTo("Karen230683"),"[8].total",equalTo(238))
                .body("[9]._id",equalTo("DarkPiano"),"[9].total",equalTo(236));
    }
    @Test
    public void mentionedUsers(){
        get("/mentioned/10").then()
                .contentType(JSON)
                .assertThat()
                .body("[0]._id",equalTo("@mileycyrus"),"[0].total",equalTo(4310))
                .body("[1]._id",equalTo("@tommcfly"),"[1].total",equalTo(3837))
                .body("[2]._id",equalTo("@ddlovato"),"[2].total",equalTo(3349))
                .body("[3]._id",equalTo("@Jonasbrothers"),"[3].total",equalTo(1263))
                .body("[4]._id",equalTo("@DavidArchie"),"[4].total",equalTo(1222))
                .body("[5]._id",equalTo("@jordanknight"),"[5].total",equalTo(1105))
                .body("[6]._id",equalTo("@DonnieWahlberg"),"[6].total",equalTo(1085))
                .body("[7]._id",equalTo("@JonathanRKnight"),"[7].total",equalTo(1053))
                .body("[8]._id",equalTo("@mitchelmusso"),"[8].total",equalTo(1038))
                .body("[9]._id",equalTo("@taylorswift13"),"[9].total",equalTo(973));
    }
    @Test
    public void badWords(){
        get("/words/10/bad/shit,fuck,kill,bieber").then()
                .contentType(JSON)
                .assertThat()
                .body("[0]._id",equalTo("mcraddictal"),"[0].total",equalTo(24))
                .body("[1]._id",equalTo("MCRmuffin"),"[1].total",equalTo(21))
                .body("[2]._id",equalTo("x33ieroNINJA"),"[2].total",equalTo(17))
                .body("[3]._id",equalTo("She_shines92"),"[3].total",equalTo(16))
                .body("[4]._id",equalTo("CC_Cassin"),"[4].total",equalTo(15))
                .body("[5]._id",equalTo("tsarnick"),"[5].total",equalTo(15))
                .body("[6]._id",equalTo("risha_"),"[6].total",equalTo(14))
                .body("[7]._id",equalTo("misskatiemarie"),"[7].total",equalTo(12))
                .body("[8]._id",equalTo("Spidersamm"),"[8].total",equalTo(12))
                .body("[9]._id",equalTo("SallytheShizzle"),"[9].total",equalTo(11));
    }
    @Test
    public void goodWords(){
        get("/words/10/good/love,sweet,flower,tits").then()
                .contentType(JSON)
                .assertThat()
                .body("[0]._id",equalTo("thalovebug"),"[0].total",equalTo(48))
                .body("[1]._id",equalTo("StDAY"),"[1].total",equalTo(46))
                .body("[2]._id",equalTo("TaqiyyaLuvLa"),"[2].total",equalTo(24))
                .body("[3]._id",equalTo("_shannon1234"),"[3].total",equalTo(22))
                .body("[4]._id",equalTo("ShesElectric_"),"[4].total",equalTo(22))
                .body("[5]._id",equalTo("JasmineBarton"),"[5].total",equalTo(20))
                .body("[6]._id",equalTo("stuckinlalaland"),"[6].total",equalTo(20))
                .body("[7]._id",equalTo("VioletsCRUK"),"[7].total",equalTo(19))
                .body("[8]._id",equalTo("jonas_twilight3"),"[8].total",equalTo(19))
                .body("[9]._id",equalTo("GodFirst08"),"[9].total",equalTo(17));
    }
    @Test
    public void goodPolarity(){
        // polarity/list length/good(-1) or bad (1)/minimum posts posted
        get("/polarity/10/-1/150").then()
                .contentType(JSON)
                .assertThat()
                .body("[0]._id",equalTo("KevinEdwardsJr"),"[0].total",equalTo(171))
                .body("[1]._id",equalTo("what_bugs_u"),"[1].total",equalTo(246))
                .body("[2]._id",equalTo("DarkPiano"),"[2].total",equalTo(236))
                .body("[3]._id",equalTo("Scyranth"),"[3].total",equalTo(166))
                .body("[4]._id",equalTo("keza34"),"[4].total",equalTo(219))
                .body("[5]._id",equalTo("shanajaca"),"[5].total",equalTo(213))
                .body("[6]._id",equalTo("cookiemonster82"),"[6].total",equalTo(160))
                .body("[7]._id",equalTo("shellrawlins"),"[7].total",equalTo(159))
                .body("[8]._id",equalTo("maynaseric"),"[8].total",equalTo(159))
                .body("[9]._id",equalTo("TraceyHewins"),"[9].total",equalTo(211));
    }
    @Test
    public void badPolarity(){
        // polarity/list length/good(-1) or bad (1)/minimum posts posted
        get("/polarity/10/1/150").then()
                .contentType(JSON)
                .assertThat()
                .body("[0]._id",equalTo("tweetpet"),"[0].total",equalTo(310))
                .body("[1]._id",equalTo("lost_dog"),"[1].total",equalTo(549))
                .body("[2]._id",equalTo("wowlew"),"[2].total",equalTo(212))
                .body("[3]._id",equalTo("mrs_mcsupergirl"),"[3].total",equalTo(158))
                .body("[4]._id",equalTo("webwoke"),"[4].total",equalTo(345))
                .body("[5]._id",equalTo("mcraddictal"),"[5].total",equalTo(276))
                .body("[6]._id",equalTo("_magic8ball"),"[6].total",equalTo(189))
                .body("[7]._id",equalTo("Dogbook"),"[7].total",equalTo(192))
                .body("[8]._id",equalTo("JBnVFCLover786"),"[8].total",equalTo(163))
                .body("[9]._id",equalTo("MiDesfileNegro"),"[9].total",equalTo(177));
    }
}

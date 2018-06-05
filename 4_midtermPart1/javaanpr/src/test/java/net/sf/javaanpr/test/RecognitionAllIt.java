package net.sf.javaanpr.test;

import net.sf.javaanpr.imageanalysis.CarSnapshot;
import net.sf.javaanpr.intelligence.Intelligence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import org.hamcrest.CoreMatchers.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

@RunWith(Parameterized.class)
public class RecognitionAllIt
{
    private static final Logger logger = LoggerFactory.getLogger(RecognitionIT.class);

    private String inputFile;
    private String expectedPlate;

    @Parameterized.Parameters
    public static Collection prepareParameters() throws IOException
    {
        String resultsPath = "src/test/resources/results.properties";
        InputStream resultsStream = new FileInputStream(new File(resultsPath));

        Properties properties = new Properties();
        properties.load(resultsStream);
        resultsStream.close();
        assertThat(properties.size() > 0, is(equalTo(true)));
        Collection propList = new ArrayList();
        properties.forEach((key, value) ->
        {
            propList.add(new Object[]{key, value});

        });

        return propList;
    }

    public RecognitionAllIt(String inputFile, String expectedPlate)
    {
        this.inputFile = inputFile;
        this.expectedPlate = expectedPlate;
    }

    @Test
    public void intelligenceParameterized() throws IOException, ParserConfigurationException, SAXException
    {
        logger.info("####### Running: " + inputFile + " ######");
        final String image = "snapshots/" + inputFile;
        CarSnapshot carSnap = new CarSnapshot(image);
        assertThat(carSnap, is(notNullValue()));
        assertThat(carSnap.getImage(), is(notNullValue()));
        Intelligence intel = new Intelligence();
        assertThat(intel, is(notNullValue()));
        String spz = intel.recognize(carSnap);
        assertThat(spz, is(notNullValue()));
        assertThat(expectedPlate, is(equalTo(spz)));
        carSnap.close();
    }

}

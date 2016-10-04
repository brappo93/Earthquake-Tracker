package berkeleycs160prog02.edu.yourfault;

import java.net.URLEncoder;

/**
 * Created by brettrapponotti on 10/8/15.
 */
public class EarthquakeMobileService extends Service {

    //This service continuously sends GET requests to the USGS API to find recent earthquakes
    //Make a service (done) and query the USGS API at regular intervals

    public void getEarthquakeData() {
        String url = "http://earthquake.usgs.gov/fdsnws/event/1/query";
        String charset = "UTF-8";
        String param1 = "format=geojson&method=query";
        String param2 = "starttime=2015-10-06&endtime=2015-10-16&minmagnitude=4";

        String query = String.format("param1=%s&param2=%s",
                URLEncoder.encode(param1, charset),
                URLEncoder.encode(param2, charset));

        URLConnection connection = new URL(url + "?" + query).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
        InputStream response = connection.getInputStream();

    }
}

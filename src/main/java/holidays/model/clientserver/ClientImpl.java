package holidays.model.clientserver;

import java.io.IOException;

import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.impl.classic.*;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.client5.http.ClientProtocolException;

import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.entity.mime.StringBody;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.auth.*;
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;
import com.google.gson.*;
import org.apache.hc.core5.net.URIAuthority;
import org.apache.hc.core5.util.Timeout;

import java.net.URI;
import java.util.concurrent.*;
import java.net.http.*;

//API KEY = ee1737a9956d439aac718d1828e57570
// uri = https://holidays.abstractapi.com/v1/?api_key=ee1737a9956d439aac718d1828e57570&country=US&year=2020&month=12&day=25
// uri = https://ipgeolocation.abstractapi.com/v1/?api_key=ee1737a9956d439aac718d1828e57570&ip_address=166.171.248.255


public class ClientImpl implements Client {

    /**
     * get data from the online input API
     * @param country the search term, it should be countryID
     * @param year the search term, it should be int
     * @param month the search term, it should be int
     * @param day the search term, it should be int
     * @return the data get from input
     */
    @Override
    public String getHolidaysSingleDay(String country, int year, int month, int day) {
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet("https://holidays.abstractapi.com/v1/?api_key=ee1737a9956d439aac718d1828e57570&country="+country+"&year="+year+"&month="+month+"&day="+day);
            CloseableHttpResponse response = null;
            response = httpClient.execute(httpGet);
            HttpEntity responseEntity = response.getEntity();
            String result = EntityUtils.toString(responseEntity);
            return result;
        } catch (Exception e) {
            return null;
        }

    }

}

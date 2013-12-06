package de.srvn.client.webservice;

import de.srvn.client.config.ApplicationConfig;
import de.srvn.client.exception.SrvnException;
import de.srvn.client.security.SecurityContext;
import org.apache.commons.compress.utils.Charsets;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @author Markus Moormann
 * @version 18.11.13 - 19:51
 */
@Component
public class WebserviceClient {

    private static final Logger logger = LoggerFactory.getLogger(WebserviceClient.class);

    @Autowired
    private SecurityContext securityContext;

    @Autowired
    private ApplicationConfig applicationConfig;

    private CloseableHttpClient httpClient;

    @PostConstruct
    public void init() {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(
                new AuthScope("", 80),
                new UsernamePasswordCredentials(securityContext.getUsername(), securityContext.getPassword()));

        httpClient = HttpClientBuilder
                .create()
                .setDefaultCredentialsProvider(credentialsProvider)
                .build();
    }

    public String postResource(String resource, String content) throws SrvnException {
        try {
            String url = applicationConfig.getRestUrl() + resource;
            logger.debug("trying to post to url '{}' with content '{}'", url, content);
            HttpPost post = new HttpPost(url);
            post.setHeader(new BasicHeader("Content-Type", "application/json"));
            post.setEntity(new StringEntity(content, Charsets.UTF_8));
            CloseableHttpResponse response = httpClient.execute(post);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(response.getEntity());
                logger.debug("result content: {}", result);
                return result;
            } else {
                switch (response.getStatusLine().getStatusCode()) {
                    case HttpStatus.SC_FORBIDDEN:
                }
            }
        } catch (Exception e) {
            throw new SrvnException(e);
        }
        return "";
    }

    public String getResource(String resource, NameValuePair... valuePairs) throws SrvnException {
        try {
            String url = applicationConfig.getRestUrl() + resource;
            if (valuePairs.length > 0) {
                url += "?";
            }
            for (NameValuePair nameValuePair : valuePairs) {
                url += nameValuePair.getName() + "=" + nameValuePair.getValue();
            }
            logger.debug("trying to obtain url: '{}'", url);
            HttpGet get = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(get);
            logger.debug("result status code: {}", response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String content = EntityUtils.toString(response.getEntity());
                logger.debug("result content: {}", content);
                return content;
            } else {
                switch (response.getStatusLine().getStatusCode()) {
                    case HttpStatus.SC_FORBIDDEN:
                }
            }
        } catch (IOException e) {
            throw new SrvnException(e);
        }
        return "";
    }


}

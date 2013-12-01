package de.srvn.client.webservice;

import de.srvn.client.security.SecurityContext;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.util.concurrent.Callable;

/**
 * @author Markus Moormann
 * @version 18.11.13 - 20:29
 */
public abstract class WebResourceCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(
                new AuthScope("", 80),
                new UsernamePasswordCredentials(getSecurityContext().getUsername(), getSecurityContext().getPassword()));

        CloseableHttpClient httpClient = HttpClientBuilder
                .create()
                .setDefaultCredentialsProvider(credentialsProvider)
                .build();

        return executeRequest(httpClient);
    }

    public abstract SecurityContext getSecurityContext();

    protected abstract String executeRequest(CloseableHttpClient httpClient) throws Exception;


}

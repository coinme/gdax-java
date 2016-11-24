package com.coinbase.exchange.api;

import com.coinbase.exchange.api.entity.*;
import com.coinbase.exchange.api.entity.gson.MoneyTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.joda.money.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author msmyers
 * @author  irufus
 * @since 2/25/15
 */
public class CoinbaseExchangeImpl implements CoinbaseExchange {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoinbaseExchangeImpl.class);

    protected static Mac SHARED_MAC;

    private Gson gson = new GsonBuilder()
            .registerTypeHierarchyAdapter(Money.class, MoneyTypeAdapter.getInstance())
            .create();

    private Authentication auth;
    private String cbURL;

    public CoinbaseExchangeImpl(CoinbaseExchangeBuilder builder) throws NoSuchAlgorithmException {
        auth = new Authentication(builder.public_key, builder.secret_key, builder.passphrase);
        this.cbURL = builder.url;
        SHARED_MAC = Mac.getInstance("HmacSHA256");
    }

    @Override
    public Account[] getAccounts() throws IOException, InvalidKeyException, NoSuchAlgorithmException, CloneNotSupportedException {
        return executeGet("/accounts", Account[].class);
    }

    @Override
    public Account getAccount(String accountId) {
        return null;
    }

    @Override
    public AccountHistory[] getAccountHistory(String accountId) throws CloneNotSupportedException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        return executeGet("/accounts/" + accountId + "/ledger", AccountHistory[].class);
    }

    @Override
    public Hold[] getHolds(String accountId) throws CloneNotSupportedException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        return executeGet("/accounts/" + accountId + "/holds", Hold[].class);
    }

    @Override
    public Order createOrder(NewOrderSingle order) throws CloneNotSupportedException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        String body = gson.toJson(order);
        String json = generatePostRequestJSON("/orders", body);
        System.out.println(json);
        return gson.fromJson(json, Order.class);
    }

    @Override
    public String cancelOrder(String orderId) throws CloneNotSupportedException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        return executeDeleteRequest("/orders", orderId);
    }

    @Override
    public Order[] getOpenOrders() throws NoSuchAlgorithmException, InvalidKeyException, CloneNotSupportedException, IOException {
        return executeGet("/orders", Order[].class);
    }

    @Override
    public PaymentMethod[] getPaymentMethods() throws NoSuchAlgorithmException, InvalidKeyException, CloneNotSupportedException, IOException {
        return executeGet("/payment-methods", PaymentMethod[].class);
    }

    @Override
    public Order getOrder(String order_id) throws CloneNotSupportedException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        return executeGet("/orders/" + order_id, Order.class);
    }

    @Override
    public Product[] getProducts() throws IOException, CloneNotSupportedException, NoSuchAlgorithmException, InvalidKeyException {
        return executeGet("/products", Product[].class);
    }

    @Override
    public Fill[] getFills() {
        return new Fill[0];
    }

    @Override
    public String getMarketDataOrderBook(String product, String level) throws IOException {
        String endpoint = "/products/" + product + "/book";
        if (level != null)
            endpoint += "?level=" + level;
        HttpGet getRequest = new HttpGet(cbURL + endpoint);
        Authentication.setNonAuthenticationHeaders(getRequest);
        CloseableHttpResponse response = HttpClients.createDefault().execute(getRequest);
        BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String json = processStream(br);
        return json;
    }

    /**
     * @param product
     * @param level
     * @return ProductOrderBook
     * @throws IOException
     */
    @Override
    public ProductOrderBook getMarketDataProductOrderBook(String product, String level) throws IOException {
        String json = getMarketDataOrderBook(product, level);
        System.out.println(json);

        ProductOrderBook pob = gson.fromJson(json, ProductOrderBook.class);
        return pob;
    }

    private String executeDeleteRequest(String endpoint, String parameter) throws NoSuchAlgorithmException, InvalidKeyException, CloneNotSupportedException, IOException {
        HttpDelete deleteRequest = new HttpDelete(cbURL + endpoint + "/" + parameter);
        auth.setAuthenticationHeaders(deleteRequest, "DELETE", endpoint + "/" + parameter);
        CloseableHttpResponse response = HttpClients.createDefault().execute(deleteRequest);
        BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        return processStream(br);
    }

    private String generatePostRequestJSON(String endpoint, String body) throws NoSuchAlgorithmException, InvalidKeyException, CloneNotSupportedException, IOException {
        HttpPost postRequest = new HttpPost(cbURL + endpoint);
        auth.setAuthenticationHeaders(postRequest, "POST", endpoint, body);
        postRequest.addHeader("content-type", "application/json");
        postRequest.setEntity(new StringEntity(body));
        CloseableHttpResponse response = HttpClients.createDefault().execute(postRequest);
        BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        return processStream(br);
    }

    private String generateGetRequestJSON(String endpoint) throws NoSuchAlgorithmException, InvalidKeyException, CloneNotSupportedException, IOException {
        HttpGet getRequest = new HttpGet(cbURL + endpoint);
        auth.setAuthenticationHeaders(getRequest, "GET", endpoint);
        CloseableHttpResponse response = HttpClients.createDefault().execute(getRequest);
        BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        return processStream(br);
    }

    private String processStream(BufferedReader br) throws IOException {
        String json = "";
        String output = null;
        while ((output = br.readLine()) != null)
            json += output;
        return json;
    }

    @Nullable
    protected <T> T executeGet(@Nonnull final String uri, @Nonnull final Class<T> clazz) throws CloneNotSupportedException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("Executing [{}] to GET [{}]", uri, clazz);
        }

        long startTime = System.currentTimeMillis();

        @Nullable
        String json = generateGetRequestJSON(uri);

        long durationMillis = System.currentTimeMillis() - startTime;

        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("GET [{}] ({} ms) {}", uri, durationMillis, json);
        }

        @Nullable
        T result = gson.fromJson(json, clazz);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("GET [{}] ({} ms) {}", uri, durationMillis, result);
        }

        return result;
    }

}

package com.prueba.springboot;


import java.net.URI;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.prueba.springboot2.entity.Client;

public class RestClientUtil {
    public void getClientById() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/client/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Client> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Client.class, 1);
        Client client = responseEntity.getBody();
        System.out.println("Id:"+client.getClientId()+", LastName:"+client.getClientLastName()
                +", Name:"+client.getClientName());
    }
    public void getAllClientsDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/clients";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Client[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Client[].class);
        Client[] clients = responseEntity.getBody();
        for(Client client : clients) {
            System.out.println("Id:"+client.getClientId()+", LastName:"+client.getClientLastName()
                    +", Name:"+client.getClientName());
        }
    }
    public void addClientDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/client";
        Client objClient = new Client();
        objClient.setClientName("Spring REST Security using Hibernate");
        objClient.setClientLastName("Spring");
        HttpEntity<Client> requestEntity = new HttpEntity<Client>(objClient, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());
    }
    public void updateClientDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/article";
        Client objClient = new Client();
        objClient.setClientId(1);
        objClient.setClientName("Update:Java Concurrency");
        objClient.setClientLastName("Java");
        HttpEntity<Client> requestEntity = new HttpEntity<Client>(objClient, headers);
        restTemplate.put(url, requestEntity);
    }
    public void deleteArticleDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/client/{id}";
        HttpEntity<Client> requestEntity = new HttpEntity<Client>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);
    }
    public static void main(String args[]) {
        RestClientUtil util = new RestClientUtil();
        //util.getArticleByIdDemo();
        util.getAllClientsDemo();
        //util.addArticleDemo();
        //util.updateArticleDemo();
        //util.deleteArticleDemo();
    }
}
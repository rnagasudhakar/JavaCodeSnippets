package org.example.designPatterns.Builder;

public class Url {

    public static  void  main(String[] args) {

    UrlBuilder.Builder builder = new UrlBuilder.Builder();
    builder.setHostName("flipkart.com").setPathName("/abc").setQueryParams("?price>100").setProtocol("https");
    UrlBuilder urlBuilder = builder.build();

    System.out.println(urlBuilder.hostName);
    System.out.println(urlBuilder.queryParams);

    }
}

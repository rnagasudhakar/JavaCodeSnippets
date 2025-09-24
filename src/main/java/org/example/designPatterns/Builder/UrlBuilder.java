package org.example.designPatterns.Builder;

public class UrlBuilder {


    public static class Builder {

        private String hostName;
        private int portNumber;
        private String protocol;
        private String pathName;
        private String queryParams;

        public UrlBuilder build() {
            return new UrlBuilder(this);
        }

        public Builder setHostName(String hostName) {
            this.hostName = hostName;
            return this;
        }

        public Builder setPortNumber(int portNumber) {
            this.portNumber = portNumber;
            return this;
        }

        public Builder setProtocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder setPathName(String pathName) {
            this.pathName = pathName;
            return this;
        }

        public Builder setQueryParams(String queryParams) {
            this.queryParams = queryParams;
            return this;
        }

    }

    public String hostName;
    public int portNumber;
    public String protocol;
    public String pathName;
    public String queryParams;


    public UrlBuilder(Builder builder) {
        this.hostName = builder.hostName;
        this.portNumber = builder.portNumber;
        this.protocol = builder.protocol;
        this.pathName = builder.pathName;
        this.queryParams = builder.queryParams;
    }

}

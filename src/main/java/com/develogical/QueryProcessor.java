package com.develogical;

public class QueryProcessor {

    public String process(String query) {

        //output the request so that we can see it easily in the log
        System.out.println("QUERY:" + query);

        if (query.contains("hi")) {
            return "hello";
            //62694b40:%20what%20is%20your%20name
        }  else  if (query.contains("what is your name")) {
            return "joe";
        }
        return "";
    }

}

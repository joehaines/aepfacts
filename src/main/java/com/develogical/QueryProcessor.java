package com.develogical;

public class QueryProcessor {

    public String process(String query) {

        //output the request so that we can see it easily in the log
        System.out.println(query);



        if (query.contains("hi")) {
            return "hello";
            //62694b40:%20what%20is%20your%20name
        }  else  if (query.contains("which of the following numbers is the largest")) {

            String numbers_result[] = query.split(":");
            System.out.println("Numbers:" + numbers_result[2]);

            String numbers[] = numbers_result[2].split(",");

            int currentHighest = 0;

            for (int c = 0;numbers.length == c;c++) {

                //total += Integer.parseInt(numbers[c]);
                if (currentHighest < Integer.parseInt(numbers[c])) {

                    currentHighest = Integer.parseInt(numbers[c]);

                }


            }

            return String.valueOf(currentHighest);

        }  else  if (query.contains("what is")) {




        }  else  if (query.contains("")) {
            return "";
        }  else  if (query.contains("")) {
            return "";
        }  else  if (query.contains("")) {
            return "";
        }

        //default response
        return "I DON'T KNOW";
    }

}

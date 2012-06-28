package com.develogical;

public class QueryProcessor {

    public String process(String query) {

        //output the request so that we can see it easily in the log
        System.out.println(query);



        if (query.contains("which of the following numbers is the largest")) {

            //1383b7a0: which of the following numbers is the largest: 417, 24, 54, 196

            String numbers_result[] = query.split(":");
            System.out.println("Numbers:" + numbers_result[2]);

            String numbers[] = numbers_result[2].split(",");

            int currentHighest = findHighestNumber(numbers);

            return String.valueOf(currentHighest);

        }  else  if (query.contains("what is")) {

            System.out.println("WHAT IS STARTING");

            //332153a0: what is 10 multiplied by 13

            //get out the two numbers and the operator
            String numbers = query.substring(18, query.length());

            //10 multiplied by 13

            String tokens[] = numbers.split(" ");

            //first number tokens[0]
            //second number tokens[3]
            //operand tokens[1]

            int result = 0;
            int first = Integer.parseInt(tokens[0]);
            int second = Integer.parseInt(tokens[3]);

            if (tokens[1].equals("multiplied")) {

                result = (first*second);

            } else if (tokens[1].equals("plus")) {

                result = (first+second);

            } else if (tokens[1].equals("minus")) {

                result = (first-second);

            } else if (tokens[1].equals("divided")) {

                result = (first/second);

            }

            return String.valueOf(result);

        }  else  if (query.contains("")) {

            //which of the following numbers is both a square and a cube: 64, 953

            return "";
        }  else  if (query.contains("")) {
            return "";
        }  else  if (query.contains("")) {
            return "";
        }

        //default response
        return "I DON'T KNOW";
    }

    public int findHighestNumber(String[] numbers) {
        int currentHighest = 0;

        for (int c = 0;c < numbers.length;c++) {

            String num = numbers[c].trim();

            if (currentHighest < Integer.parseInt(num)) {

                currentHighest = Integer.parseInt(num);

            }


        }
        return currentHighest;
    }

}

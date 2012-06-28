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

        }  else  if (query.contains("which of the following numbers is both a square and a cube")) {

            //d1a87b20: which of the following numbers is both a square and a cube: 64, 953

            //70 chars in
            String input = query.substring(70, query.length());
            String numbers[] = input.split(", ");

            int first = Integer.parseInt(numbers[0]);
            int second = Integer.parseInt(numbers[1]);

            //if square root of number is int (whole) its a square
            //if ^3 is whole number




            return String.valueOf(first);


        }  else  if (query.contains("who is the Prime Minister of Great Britain")) {
            return "David Cameron";



            //50183b40: which of the following numbers are primes: 199, 915, 127, 356
        }  else  if (query.contains("which of the following numbers are primes")) {

            String input = query.substring(42, query.length());
            String numbers[] = input.split(", ");

            String result = "";

            for (int c = 0;c < numbers.length;c++) {

                if(isPrime(Integer.parseInt(numbers[c])) ) {

                    result = result+ numbers[c] + ", ";

                }

            }

            String final_result = result.substring(2, result.length());

            return final_result;
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

    boolean isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }

}

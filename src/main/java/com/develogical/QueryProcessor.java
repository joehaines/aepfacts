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

        }     else  if (query.contains("to the power of")) {

        String results[] = query.split(" ");

        int first = Integer.parseInt(results[3]);
        int second = Integer.parseInt(results[8]);

        int result = (first^second);

        return String.valueOf(result);

    } else  if (query.contains("what is")) {



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
            int second = Integer.parseInt(tokens[2]);

            if (tokens[1].equals("multiplied")) {

                result = (first*second);

            } else if (tokens[1].equals("plus")) {

                result = (first+second);

            } else if (tokens[1].equals("minus")) {

                result = (first-second);

            } else if (tokens[1].equals("divided")) {

                result = (first/second);

            }

            System.out.println("WHAT IS STARTING:" + result);

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

            int first_sq = (first*first);
            int first_cube = (first*first*first);

            String results = "";

            //check first is square
            if ( (first_sq)-Math.floor(first_sq) == 0 ) {

                if ( (first_cube)-Math.floor(first_cube) != 0 ) {

                    results = results+ String.valueOf(second)+", ";

                }

                //this number is square
                results = results+ String.valueOf(first)+", ";

            } else {

                results = results+ String.valueOf(second)+", ";

            }

            String final_result = results.substring(0, results.length()-2);

            return final_result;


        }  else  if (query.contains("who is the Prime Minister of Great Britain")) {
            return "David Cameron";



            //50183b40: which of the following numbers are primes: 199, 915, 127, 356
        }  else  if (query.contains("which of the following numbers are primes")) {

            String input = query.substring(53, query.length());
            String numbers[] = input.split(", ");

            String result = "";

            for (int c = 0;c < numbers.length;c++) {

                if(isPrime(Integer.parseInt(numbers[c])) ) {

                    result = result+ numbers[c] + ", ";

                }

            }

            String final_result = result.substring(0, result.length()-2);

            return final_result;


        }  else  if (query.contains("who played James Bond in the film Dr No")) {
            return "Sean Connery";

        }   else  if (query.contains("what colour is a banana")) {
            return "yellow";

        }    else  if (query.contains("what currency did Spain use before the Euro")) {
            return "peseta";

        }     else  if (query.contains("which city is the Eiffel tower in")) {
            return "paris";

        }     else  if (query.contains("number in the Fibonacci sequence")) {

            String first[] = query.split(":");
            String second[] = first[1].split(" what is the ");
            String third[] = second[1].split(" ");

            int number = Integer.parseInt(third[0]);

            return String.valueOf(fib(number));




    }


        //e7042800: what is 10 to the power of 15



        //42161d10: what is the 19th number in the Fibonacci sequence

        //default response
        return "I DON'T KNOW";
    }


    public static int fib(int n)
    {
        if (n <= 2)
            return 1;
        else
            return fib(n - 1) + fib(n - 2);
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

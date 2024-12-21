package working;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Function to check if a number is prime
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Function to check if a number is truncatable from both left and right
    public static boolean isTruncatablePrime(int n) {
        if (n < 10) return false; // Single-digit primes are not truncatable

        // Check truncation from left to right
        String numStr = String.valueOf(n);
        for (int i = 0; i < numStr.length(); i++) {
            if (!isPrime(Integer.parseInt(numStr.substring(i)))) {
                return false;
            }
        }

        // Check truncation from right to left
        for (int i = 1; i <= numStr.length(); i++) {
            if (!isPrime(Integer.parseInt(numStr.substring(0, i)))) {
                return false;
            }
        }

        return true;
    }

    // Function to find the first `limit` truncatable primes
    public static List<Integer> findTruncatablePrimes(int limit) {
        List<Integer> truncatablePrimes = new ArrayList<>();
        int num = 11; // Start checking from 11 since single-digit primes are not truncatable

        while (truncatablePrimes.size() < limit) {
            if (isTruncatablePrime(num)) {
                truncatablePrimes.add(num);
            }
            num += 2; // Only odd numbers need to be checked
        }

        return truncatablePrimes;
    }

    public static void main(String[] args) {
        int limit = 11; // Find the first 11 truncatable primes
        List<Integer> truncatablePrimes = findTruncatablePrimes(limit);
        int sum = 0;
        for (int i = 0; i < truncatablePrimes.size(); i++) {
        	sum = sum + truncatablePrimes.get(i);
        }
        System.out.println("Sum: " + sum);
    }
}

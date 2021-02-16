package com.portfolio.demoofme.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestController
public class MathController {

    //http://localhost:8080/math/max?aKey=3&bKey=4&cKey=10
    @GetMapping("math/max")
    public String maxValueReq(
            @RequestParam("aKey") int a,
            @RequestParam("bKey") int b) {
        return "Max value is " + max(a, b);
    }

    public static int max(int a, int b) {
        if (a >= b)
            return a;
        else
            return b;
    }

    //http://localhost:8080/math/Fibonacci?n=7
    @GetMapping("math/Fibonacci")
    public String fibonacciNrReq(
            @RequestParam("n") int n) {
        return "Fibonacci " + n + "th number is " + fibonacci(n);
    }

    public static long fibonacci(int nr) {
        long[] fib = new long[nr + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[nr - 1];
    }

    //http://localhost:8080/math/isEven?number=4
    @GetMapping("math/isEven")
    public String isNumberEvenReq(
            @RequestParam("number") int a) {
        return isNumberEven(a);
    }

    public static String isNumberEven(int a) {
        if (a % 2 == 0)
            return "Your number is even";
        else
            return "Your number is not even";
    }

}

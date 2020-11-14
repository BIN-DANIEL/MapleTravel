package com.maple.spring;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ApplicationTests.class);
        System.out.println("Unit test completed, Total tests run: " + result.getRunCount()
                + " Succeeded: " + (result.getRunCount() - result.getFailureCount()) + " Failed: " + result.getFailureCount());
        System.out.println("Test Report:");
        for (Failure failure : result.getFailures()) {
            System.out.println("---------------------");
            System.out.println(failure.toString());
            System.out.println("---------------------");
        }

        System.out.println(result.wasSuccessful() ? "All Tests Passed.^◡^." : "Some Tests Failed¯\\_(ツ)_/¯");
    }
}

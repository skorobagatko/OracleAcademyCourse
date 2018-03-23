package com.skorobahatko.lectures.lecture2;

import com.skorobahatko.lectures.lecture2.junit.CalculatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { App1Test.class, CalculatorTest.class} )
public class AllTests {
}

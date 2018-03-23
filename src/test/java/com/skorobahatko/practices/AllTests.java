package com.skorobahatko.practices;

import com.skorobahatko.practices.practice1.ArrayProdTest;
import com.skorobahatko.practices.practice1.ArraySumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( {ArrayProdTest.class, ArraySumTest.class} )
public class AllTests {
}

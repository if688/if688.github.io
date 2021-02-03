package br.ufpe.cin.if688.jflex;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TesteBubbleSort.class, TesteQuicksort.class,
	TesteBinarySearch.class, TesteBinaryTree.class, TesteLinearSearch.class, TesteLinkedList.class
	})
public class AllTests {

}

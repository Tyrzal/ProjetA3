package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import modele.Category;
import modele.IteratorQuestion;
import modele.Question;

public class IteratorQuestionTest {
	
	int index;
	Question q1, q2, q3;
	List<Question> questions;
	IteratorQuestion iterator;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		q1 = new Question("aaa","bbb","ccc", Category.cybersecurity);
		q2 = new Question("ddd","eee","fff", Category.operatingSystems);
		q3 = new Question("ggg","hhh","iii", Category.programmingLanguages);
		questions = new ArrayList<>();
		questions.add(q1);
		questions.add(q2);
		questions.add(q3);
		iterator = new IteratorQuestion(questions);
	}

	@After
	public void tearDown() throws Exception {
		questions = null;
		iterator = null;
		q1 = null;
		q2 = null;
		q3 = null;
	}

	@Test
	public void testIteratorQuestion() {
		IteratorQuestion test = new IteratorQuestion(questions);
		int index = (int) Explorateur.getField(test, "index");
		List<Question> list = (List<Question>) Explorateur.getField(test, "questions");
		assertEquals(true, list.equals(questions));
		assertEquals(true, index==0);
	}

	@Test
	public void testNext() {
		assertNotNull("test questions not null", questions);
		iterator.next();
		index = (int) Explorateur.getField(iterator, "index");
		assertTrue("index = 1", index==1);
	}

	@Test
	public void testHasNext() {
		assertNotNull("test questions not null", questions);
		assertEquals(true, iterator.hasNext());
		List<Question> test = new ArrayList<>();
		IteratorQuestion noNext = new IteratorQuestion(test);
		assertEquals(false, noNext.hasNext());
	}

	@Test
	public void testCheckAnswer() {
		assertNotNull("test questions not null", questions);
		assertEquals(true, iterator.checkAnswer("ccc"));
		assertEquals(false, iterator.checkAnswer("ddd"));
	}

	@Test
	public void testValue() {
		assertNotNull("test questions not null", questions);
		assertTrue(iterator.value().equals(q1));
		assertTrue(!iterator.value().equals(q3));
	}

}

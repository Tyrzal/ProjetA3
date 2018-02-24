package test;

import static org.junit.Assert.*;

import java.text.DateFormat.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exception.AlreadyInTheListException;
import modele.Category;
import modele.Deck;
import modele.Question;

public class DeckTest {
	
	Question q1, q2, q3;
	List<Question> list;
	Deck deck, test;
	java.lang.reflect.Field instance;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception,  SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {

		q1 = new Question("aaa","bbb","ccc", Category.cybersecurity);
		q2 = new Question("ddd","eee","fff", Category.operatingSystems);
		q3 = new Question("ggg","hhh","iii", Category.programmingLanguages);
		list = new ArrayList<>();
		/*list.add(q1);
		list.add(q2);
		list.add(q3);*/
		instance = Deck.class.getDeclaredField("instance");
		instance.setAccessible(true);
		test = test.getInstance();
		list = (List<Question>) Explorateur.getField(test, "questions"); 
		
	
	}

	@After
	public void tearDown() throws Exception { 
		list = null;
		q1 = null;
		q2 = null;
		q3 = null;
		deck = null;
		instance.set(null, null);
	}

	@Test
	public void testGetInstance() {
		assertNull("deck null", deck);
		deck = Deck.getInstance();
		assertNotNull("test singleton", deck);
	}

	@Test
	public void testGetQuestions() {
		assertNotNull("test list not null", list);
		List<Question> liste;
		list.add(q1);
		list.add(q2); 
		liste = test.getQuestions();

		assertEquals(true, list.equals(liste));
		list.add(q3);

		assertEquals(false, list.equals(liste)); 
		
	}

	@Test(expected = AlreadyInTheListException.class)
	public void testAddQuestion(){
		deck = Deck.getInstance();
		assertNotNull("test list not null", list);
		
		try {
			deck.addQuestion(q1);
		} catch (AlreadyInTheListException e) {
		}
		try {
			deck.addQuestion(q1);
		} catch (AlreadyInTheListException e) {

		}
	}

	@Test
	public void testRemoveQuestion() {
		assertNotNull("test list not null", list);
		list.add(q1);
		list.add(q2);
		list.add(q3);
		assertEquals(true, test.removeQuestion(q2));
		assertEquals(true, test.removeQuestion(q1));
		assertEquals(false, test.removeQuestion(q2));		
	}

	@Test
	public void testToString() {
		assertNotNull("test list not null", list);
		list.add(q1);
		list.add(q2);
		list.add(q3);
		
		String result = "Question list :\nAuthor : aaa\nCategory : cybersecurity\nbbb ==== ccc\n\n"
				+ "Author : ddd\nCategory : operating systems\neee ==== fff\n\n"
				+ "Author : ggg\nCategory : programming languages\nhhh ==== iii\n\n";
		
;
		assertEquals(true, test.toString().equals(result));
		
	
		

	}

}

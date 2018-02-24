package test;

import static org.junit.Assert.*;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import modele.Category;
import modele.Question;

public class QuestionTest {
	
	String author, statement, answer;
	Category category;
	Question question;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		question = new Question("Alexandre", "De quelle couleur est le bleu ?", "bleu", Category.networks);
		author = (String) Explorateur.getField(question, "author");
		statement = (String) Explorateur.getField(question, "statmeent");
		answer = (String) Explorateur.getField(question, "answer");
		category = (Category) Explorateur.getField(question, "category");
		
	}

	@After
	public void tearDown() throws Exception {
		author = null;
		statement = null;
		answer = null;
		category = null;
		question = null;
	}

	@Test
	public void testQuestion() {
		Question constructor = new Question("aaa", "bbb", "ccc", Category.internet);
		author = (String) Explorateur.getField(constructor, "author");
		statement = (String) Explorateur.getField(constructor, "statement");
		answer = (String) Explorateur.getField(constructor, "answer");
		category = (Category) Explorateur.getField(constructor, "category");
		assertTrue("Test constructeur", author.equals("aaa") && statement.equals("bbb") && answer.equals("ccc") && category.equals(Category.internet));
	} 

	@Test
	public void testGetAuthor() {
		assertNotNull("Test question not null", question);  
		assertTrue("Test get", question.getAuthor().equals("Alexandre"));		
	}
	
	@Test
	public void testGetCategory() {
		assertNotNull("Test question not null", question); 
		assertTrue("Test get", question.getCategory().equals(Category.networks));		
	}
	
	@Test
	public void testGetStatement() {
		assertNotNull("Test question not null", question); 
		assertTrue("Test get", question.getStatement().equals("De quelle couleur est le bleu ?"));	
	}

	@Test
	public void testGetAnswer() {
		assertNotNull("Test question not null", question);
		assertTrue("Test get", question.getAnswer().equals("bleu"));
	}
	
	@Test
	public void testEquals() { 
		boolean test;
		assertNotNull("Test question not null", question); 
		Object obj = new Object();
		test = question.equals(obj); 
		assertEquals(false, test);
		Question notEquals = new Question("aaa","bbb","ccc", Category.internet);
		test = question.equals(notEquals);
		assertEquals(false, test);
		Question equals = new Question("Alexandre", "De quelle couleur est le bleu ?", "bleu", Category.networks);
		test = question.equals(equals);
		assertEquals(true, test);
	}
	
	@Test
	public void testClone() {
		assertNotNull("Test question not null", question); 
		Question clone = question.clone();
		assertTrue("Test clone", clone.equals(question));
	}
	
	

}

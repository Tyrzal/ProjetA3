
public class Main {

	public static void main(String[] args) {
		
		public static void main(String[] args){
			Question q1 = new Question("Borgniet", "De quelle couleur est le bleu?", "bleu",Category.DEUX);
			Question q2 = new Question("Perazzo", "De quelle couleur est le orange?", "orange",Category.UNE);
			Question q3 = new Question("Rocroix", "De quelle couleur est le noir?", "noir",Category.TROIS);
			Question q4 = new Question("Perazzo", "De quelle couleur est le vert?", "vert",Category.UNE);
			Question q5 = new Question("Rocroix", "De quelle couleur est le rouge?", "rouge",Category.DEUX);
		
			Deck deck = Deck.getInstance();
			
			try {
				
				deck.addQuestion(q1);deck.addQuestion(q1);
				
			} catch (AlreadyInTheListException e) {
				
				e.printStackTrace();
			}	
			
			try {
				
				deck.addQuestion(q2);deck.addQuestion(q3);
				deck.addQuestion(q4);deck.addQuestion(q5);
				
			} catch (AlreadyInTheListException e) {
				e.printStackTrace();
			}	
			
			IteratorQuestion it = new IteratorQuestion(deck.getQuestions());
			
			Scanner scan = new Scanner(System.in);
			
			while(it.hasNext())
			{
				System.out.println((it.value().getQuestion()));
				
			
				
				if(it.checkAnswer(scan.nextLine()))
				{
					System.out.println("Good answer!");
				}
				else
				{
					System.out.println("Wrong answer!");
				}
				it.next();
			}
			System.out.println("Finish");
		
		}//main
		
		
		
	}

}

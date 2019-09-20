import java.util.Scanner;

public class Survey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		
		String[] topics = {"Space Exploration   ", "Deep Sea Exploration", "Ending Poverty      ", "Global Warming      ", "Save All Puppies    "};
		int [][] responses = new int[5][10];
		String type = "new user";
		int [] sum = new int[5];
		int [] numUsers = new int[5];
		int max = sum[0];
		int min = sum [0];
		
		System.out.println("Hello, thank you for taking our survey!");
				
		while (type.compareTo("quit") != 0) {
			System.out.println("\nPlease enter one of the following options:");
			System.out.println("\tTo complete the survey, enter \"new user\"");
			System.out.println("\tTo see the results, enter \"results\"");
			System.out.println("\tTo quit, enter \"quit\"");
			type = scnr.nextLine();
			
			switch (type) {
				case "new user":
					System.out.println("Please rank each topic on a scale of 1-10.");
					
					for (int i=0; i<5; i++) {
						System.out.println(topics[i]);
						int rank = scnr.nextInt();
						responses[i][rank-1] = responses[i][rank-1] + 1;
						
						numUsers[i] += 1;
					}	
					break;
					
				case "results":
					System.out.println("Currently the reults for our survey are:");
					System.out.println("                     1 2 3 4 5 6 7 8 9 10 Average");
					
					for (int i=0; i<5; i++) {                //counts up the sum for each vote
						for (int j=0; j<10; j++) {
							sum[i] += ((j+1)*responses[i][j]);
						}
					}
					for (int i=0; i<5; i++) {				//prints number of votes 
						System.out.print(topics[i]);
						for (int j=0; j<10; j++) {
							System.out.print(" " + responses[i][j]);
						}
					System.out.printf("   %.2f", (double)(1.0*sum[i]/numUsers[i])); 	//prints average per topic
					System.out.println("");	
					}		
					break;
					
				case "quit":
					//won't run this case due to switch statement
					break;	
			} //end switch
			
		}//end while
		System.out.println("\nThank you for participating!"); 
	}
}
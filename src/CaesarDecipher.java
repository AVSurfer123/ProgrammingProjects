import java.io.*;
import java.util.*;

public class CaesarDecipher {

	public CaesarDecipher() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the encrypted message:");
		char[] input = in.nextLine().toCharArray(), check= new char[input.length];
		boolean found = false;
		int shift = 0;
		while(!found && shift<94){
			for(int i=0;i<input.length;i++){
				if(input[i]!=32){
					int val = ((int)input[i] -33 - shift)%94;
					check[i] = (char) (val>=0 ? val+33: val+94+33);
				}
				else{
					check[i] = (char) 32;
				}
			}
			String word = String.valueOf(check).toLowerCase().split("\\s")[0];
			try{
				BufferedReader reader = new BufferedReader(new FileReader(new File("C:/Users/Ashwin/Documents/Homework/AP Comp Sci/OperationJuliusCaesar/words2.txt")));
				String english = reader.readLine();
				while(english!=null && !english.equals(word)){
					english = reader.readLine();
				}
				if(english != null){
					found = true;
				}
			}
			catch(Exception e){
				e.printStackTrace();	
			}
			finally{
				if(found){
					System.out.println("The decrypted message is: " + String.valueOf(check));
					System.out.println("If the message looks incorrect, enter 0 to continue decrypting. If you would like to decrypt another message, enter 1. Enter anything to finish decrypting.");
					String repeat = in.nextLine();
					if(repeat.equals("0")){
						found = false;
						shift++;
					}
					else if(repeat.equals("1")){
						main(null);
					}
					else{
						System.out.println("Decryption is complete.");
						break;
					}
				}
				else{
					shift++;
				}
			}
			
		}
		if(!found){
			System.out.println("You entered a non English phrase or an improper encryption. Try again.");
			main(null);
		}
		
	}

}

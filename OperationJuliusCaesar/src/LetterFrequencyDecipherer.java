import java.util.ArrayList;
import java.util.Scanner;

public class LetterFrequencyDecipherer {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the message to be decrypted:");
		char[] input = in.nextLine().toCharArray(), output = new char[input.length];
		int[] symbols= new int[94], common = {101, 116, 97, 111, 105, 110, 115, 104, 114, 100, 108};
		int most = 0, start=0, stop = 6;
		boolean done = false;
		for(int i=0;i<input.length;i++){
			if((int) input[i] != 32){
				symbols[(int)input[i] - 33]++;
			}
		}
		for(int i =0;i<symbols.length;i++){
			if(symbols[i]>symbols[most]){
				most = i;
			}
		}
		while(!done){
			for(int i = start; i<stop; i++){
				int shift = common[i] - most - 33;
				for(int j = 0; j<input.length; j++){
					if((int) input[j] != 32){
						int val = ((int) input[j] - 33 + shift)%94;
						output[j] =  (char) ((val>0) ? val+33: val+94+33); 
					}
				}
				System.out.println("Common letter: " + (char)common[i] + "\t Attempted shift: " + shift + "\t Message: " + String.valueOf(output));
			}
			System.out.println("If you would like to continue decrypting this message, enter 0. If you would like to decrypt a different message, enter 1. Enter anything to finish.");
			String repeat = in.nextLine();
			if(repeat.equals("0")){
				start = 6;
				stop+=5;
			}
			else if(repeat.equals("1")){
				done = true;
				main(null);
			}
			else{
				done = true;
				System.out.println("Decryption is complete.");
			}
		}
	}
}

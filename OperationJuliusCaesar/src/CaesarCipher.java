import java.util.*;

public class CaesarCipher
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your message to be encrypted:");
        char[] input = in.nextLine().toCharArray();
        System.out.println("Enter the shift number:");
        int shift = Integer.parseInt(in.nextLine());
        for(int i=0; i<input.length; i++){
            if(input[i]!=32){
            	int val = ((int) input[i] - 33 +shift%94)%94; 
                input[i] = (char) (val>=0? val+33: val+94+33);	
            }
        }
        System.out.println("The encrypted message is: "+ String.valueOf(input));
        System.out.println("Do you want to encrypt another message? (Enter yes to continue)");
        if(in.nextLine().toLowerCase().equals("yes")){
            main(null);
        }
        else{
        	System.out.println("Encryption is complete.");
        }
    }	
}





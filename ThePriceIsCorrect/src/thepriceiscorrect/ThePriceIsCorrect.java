package thepriceiscorrect;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author bytz
 */
public class ThePriceIsCorrect {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException  {
		Scanner scanner=new Scanner(new File("price.in"));
		FileWriter fileWriter=new FileWriter("the_price_is_correct.out");
		int T=scanner.nextInt();
		for(int t=1;t<=T;t++){
			int N=scanner.nextInt();
			int P=scanner.nextInt();
			int[] B=new int[N];
			for(int i=0;i<N;i++){
				B[i]=scanner.nextInt();
			}
			long count=0;
			for(int i=0;i<N;i++){
				int s=0;
				for(int j=i;j<N;j++){
					s+=B[j];
					if(s<=P){
						count++;
					}
					else break;
				}
			}
			fileWriter.write("Case #"+t+": "+count);fileWriter.write(System.lineSeparator());
		}
		fileWriter.close();
		scanner.close();
	}

}

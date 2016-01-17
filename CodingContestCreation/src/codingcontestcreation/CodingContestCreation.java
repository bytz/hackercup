package codingcontestcreation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author bytz
 */
public class CodingContestCreation {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner scanner=new Scanner(new File("coding_contest_creation.txt"));
		FileWriter fileWriter=new FileWriter("coding_contest_creation.out");
		int T=scanner.nextInt();
		for(int t=1;t<=T;t++){
			int N=scanner.nextInt();
			int[] D=new int[N];
			for(int i=0;i<N;i++)
				D[i]=scanner.nextInt();
			int extra=0;
			int problems=0;
			for(int i=0;i<N;i++){
				if(problems==0||D[i]>D[i-1]){
					problems++;
					if(problems>1&&D[i]-D[i-1]>10){
						int separator=(D[i]-D[i-1])/10+((D[i]-D[i-1])%10>0?1:0)-1;
						if(problems+separator>4){
							separator=4-problems+1;
							problems=1;
						}
						else problems+=separator;
						extra+=separator;
					}
				}
				else if(problems<4){
					extra+=4-problems;
					problems=1;
				}
				if(problems==4)
					problems=0;
			}
			if(problems>0&&problems<4){
				extra+=4-problems;
			}
			fileWriter.write("Case #"+t+": "+extra);fileWriter.write(System.lineSeparator());
		}
		fileWriter.close();
		scanner.close();
	}

}

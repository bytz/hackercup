package boomerangconstellations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author bytz
 */
public class BoomerangConstellations {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner scanner=new Scanner(new File("boomerang_constellations.txt"));
		FileWriter fileWriter=new FileWriter("boomerang_constellations.out");
		int T=scanner.nextInt();
		for(int t=1;t<=T;t++){
			int N=scanner.nextInt();
			int[][] pos=new int[N][2];
			for(int i=0;i<N;i++){
				pos[i][0]=scanner.nextInt();
				pos[i][1]=scanner.nextInt();
			}
			int[][] dist=new int[N][N];
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(i<j)
						dist[i][j]=(int)Math.pow(Math.abs(pos[i][0]-pos[j][0]),2)+(int)Math.pow(Math.abs(pos[i][1]-pos[j][1]),2);
					else
						dist[i][j]=dist[j][i];
				}
			}
			int count=0;
			for(int i=0;i<N;i++){
				for(int j=i+1;j<N;j++){
					for(int k=i+1;k<N;k++){
						if(dist[i][j]==dist[j][k]){
							count++;
						}
					}
					for(int k=j+1;k<N;k++){
						if(dist[j][i]==dist[i][k]){
							count++;
						}
					}
				}
			}
			fileWriter.write("Case #"+t+": "+count);fileWriter.write(System.lineSeparator());
		}
		fileWriter.close();
		scanner.close();
	}

}

import java.util.Scanner;
public class pattern{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter value of n: ");
		int n = input.nextInt();

		int size = 2*n-1;
		int[][] matrix = new int[size][size];

		for(int i=0; i<n; i++){
			for(int j=i; j<size-i; j++){
				
				matrix[i][j] = n-i;
				matrix[j][i] = n-i;
				matrix[size-1-i][j] = n-i;
				matrix[j][size-1-i] = n-i;
			}
		}
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
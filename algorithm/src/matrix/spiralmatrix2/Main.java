package matrix.spiralmatrix2;

import java.lang.*;
import java.util.*;

//˳�����룬�������

public class Main{
	
	public static void main(String[] args){
		Scanner cin=new Scanner(System.in);
		int N=cin.nextInt();
		int[][] arr=new int[N][N];
		int num=1;
		for(int i=0;i<N;i++){
		  for(int j=0;j<N;j++){
			arr[i][j]=num;
			num++;
		  }
		}
		int row=N;
		int col=N;
		int start=0;

		StringBuilder sb=new StringBuilder();
		while(2*start<row&&2*start<col){
			addArr(arr,row,col,start,sb);
			start++;
		}

		System.out.println(sb.toString().trim());
	}

	public static void addArr(int[][] arr,int row,int col,int start,StringBuilder sb){
		int endX=col-1-start;
		int endY=row-1-start;
		//������
		for(int i=start;i<=endX;i++){
			sb.append(arr[start][i]+" ");
		}
		//���ϵ���
		if(start<endY){
			for(int i=start+1;i<=endY;i++){
				sb.append(arr[i][endX]+" ");
			}
		}
		//���ҵ���
		if(start<endX&&start<endY){
			for(int i=endX-1;i>=start;i--){
				sb.append(arr[endY][i]+" ");
			}
		}
		//���µ���
		if(start<endX&&start<endY-1){
			for(int i=endY-1;i>=start+1;i--){
				sb.append(arr[i][start]+" ");
			}
		}
	}
}
package test;
import java.util.ArrayList;
class Multiple{
	Multiple(){}
	public int[] add1(int[] expx,int[] expy,int[] coefx,int[] coefy) {
		int i=0;
		int j=0;
		ArrayList<Integer> list = new ArrayList<>();
		while(i<expx.length && j<expy.length) {
			if(expx[i]==expy[j]) {
				list.add(coefx[i++]+coefy[j++]);
			}else if(expx[i]>expy[j]) {
				list.add(coefx[i++]);
			}else if(expx[i]<expy[j]) {
				list.add(coefy[j++]);
			}		
		}
			for( ; i<expx.length;i++) {
				list.add(coefx[i]);
			}
			for( ; j<expy.length;j++) {
				list.add(coefy[j]);
			}		
			int result[] = new int[list.size()];
			for(int k=0;k<list.size();k++) {
					result[k] = list.get(k);
			}
			return result;	
	}
	public int[] add2(int[] expx,int[] expy){
		int i=0;
		int j=0;
		ArrayList<Integer> list = new ArrayList<>();
		while(i<expx.length && j<expy.length) {
			if(expx[i]==expy[j]) {
				list.add(expx[i++]);
						j++;
			}else if(expx[i]>expy[j]) {
				list.add(expx[i++]);
			}else if(expx[i]<expy[j]) {
				list.add(expy[j++]);
			}		
		}
			for( ; i<expx.length;i++) {
				list.add(expx[i]);
			}
			for( ; j<expy.length;j++) {
				list.add(expy[j]);
			}
		int result[] = new int[list.size()];
		for(int k=0;k<list.size();k++) {
				result[k] = list.get(k);
		}
		return result;	
	}
}
public class Coef {
	public static void main(String[] args) {
		int[] coefx = {1,1};
		int[] coefy = {5,-10,5,-10};
		int[] expx = {1,0};
		int[] expy = {3,2,1,0};
		int[][] exp = new int[expx.length][expy.length];
		int[][] coef = new int[coefx.length][coefy.length];
		for(int j=0;j<coefy.length;j++) {
			for(int i=0;i<coefx.length;i++) {
				coef[i][j]=coefx[i]*coefy[j];
			}
		}
		for(int j=0;j<expy.length;j++) {
			for(int i=0;i<expx.length;i++) {
				exp[i][j]=expx[i]+expy[j];
			}
		}
		Multiple aa= new Multiple();
		int a1[]=aa.add1(exp[0], exp[1], coef[0], coef[1]);
		for(int semi : a1) {
			System.out.print(semi+" ");
		}
		System.out.println();
		int[] a2=aa.add2(exp[0], exp[1]);
		for(int semi : a2) {
			System.out.print(semi+" ");
		}
		System.out.println();
	}
}
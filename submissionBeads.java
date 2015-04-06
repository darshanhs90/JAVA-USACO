/*
ID: hsdars1
LANG: JAVA
PROG: beads
TASK: beads*/


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class beads {
	public static void main(String[] args) throws IOException {
		//BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader bufferedReader=new BufferedReader(new FileReader("beads.in"));
		String num=bufferedReader.readLine();
		int n=Integer.parseInt(num);
		String beadsString=	bufferedReader.readLine();
		//System.out.println(beadsString.length());
		int count=0;
		stringCheck(bufferedReader, n, beadsString, count);

		StringBuilder builder=new StringBuilder();
		for(int i=beadsString.length()-1;i>=0;i--)
		{
			builder.append(beadsString.charAt(i));
		}
		String reverseBeadsString=	builder.toString();
		int fwdCount[]=new int[beadsString.length()];
		int bwdCount[]=new int[beadsString.length()];
		for(int i=0;i<beadsString.length();i++){
			char fStart=beadsString.charAt(i);
			int j=i;
			int counter=0;
			counter = forwardCount(beadsString, fStart, j, counter);
			fwdCount[i]=counter;
			j=i;
			if(i==0){
				fStart=reverseBeadsString.charAt(i);
				j=i;
			}
			else{
				fStart=reverseBeadsString.charAt(reverseBeadsString.length()-i);
				j=reverseBeadsString.length()-i;
			}
			counter=0;
			counter = backwardCount(reverseBeadsString, fStart, j, counter);
			bwdCount[i]=counter;
		}
		int temp[]=new int[beadsString.length()];
		for (int i = 0; i < fwdCount.length; i++) {
			temp[i]=fwdCount[i]+bwdCount[i];
		}

		int max=0;
		for (int i = 0; i < temp.length; i++) {
			if(temp[i]>max){
				max=temp[i];
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		out.println(max);
		out.close();
		System.exit(0);


	}

	private static int backwardCount(String reverseBeadsString, char fStart,
			int j, int counter) {
		while(reverseBeadsString.charAt(j)==fStart ||reverseBeadsString.charAt(j)=='w'){
			counter++;
			//System.out.println("before :"+j);
			if((j+1)>reverseBeadsString.length()-1)
			{
				j=0;

			}
			else{
				j++;
			}

			//System.out.println("after :"+j);
			if(fStart=='w'){
				fStart=reverseBeadsString.charAt(j);
			}
		}
		return counter;
	}

	private static int forwardCount(String beadsString, char fStart, int j,
			int counter) {
		while(beadsString.charAt(j)==fStart ||beadsString.charAt(j)=='w'){
			counter++;
			if((j+1)>beadsString.length()-1)
			{
				j=0;

			}
			else{
				j++;
			}
			if(fStart=='w'){
				fStart=beadsString.charAt(j);
			}
		}
		return counter;
	}

	private static void stringCheck(BufferedReader bufferedReader, int n,
			String beadsString, int count) throws IOException {
		for(int i=0;i<beadsString.length();i++){
			if(beadsString.charAt(i)=='r'||beadsString.charAt(i)=='b'||beadsString.charAt(i)=='w'){
				count++;
			}	
		}
		boolean a=true;
		while(a==true){
			if(beadsString.length()>n||count!=n){
				count=0;
				System.out.println("Re-enter String");
				beadsString=	bufferedReader.readLine();
				for(int i=0;i<beadsString.length();i++){
					if(beadsString.charAt(i)=='r'||beadsString.charAt(i)=='b'||beadsString.charAt(i)=='w'){
						count++;
					}	
				}
			}//wwwbbrwrbrbrrbrbrwrwwrbwrwrrb
			else{
				a=false;
			}
		}
	}
}
/*
ID: hsdars1
LANG: JAVA
PROG: gift1
TASK: gift1
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class gift1 {
	public static void main(String[] args) throws IOException {
		//Line 1
		//System.out.println("Enter the number of people in the group");
		BufferedReader bufferedReader=new BufferedReader(new FileReader("gift1.in"));
		int numOfPersons=Integer.parseInt(bufferedReader.readLine());
		int finalCredit[]=new int[numOfPersons];
		int initialCredit[]=new int[numOfPersons];
		
		//Line 2
		//System.out.println("Enter the names of the people in the group");
		String names[]=new String[numOfPersons];
		for (int i = 0; i < numOfPersons; i++) {
			names[i]=bufferedReader.readLine();
		}
		for (int i = 0; i < numOfPersons; i++) {

			//System.out.println("enter the name of the person");
			String name=bufferedReader.readLine();
			int countNum=0;
			for(int j=0;j<names.length;j++){
				if(name.contentEquals(names[j])){
					countNum=j;
				}
			}
			//System.out.println("enter the amount to be divided to gifts");
			String spaceTemp=bufferedReader.readLine();
			int spaceIndex=spaceTemp.indexOf(' ');
			int amount=Integer.parseInt(spaceTemp.substring(0,spaceIndex));	
			initialCredit[countNum]=amount;
			//System.out.println("enter the number of people to be gifted");
			int numberOfPeople=Integer.parseInt(spaceTemp.substring(spaceIndex+1));
			int creditToBeAdded=0;
			if(numberOfPeople!=0){
				if(amount%numberOfPeople==0){
					creditToBeAdded=amount/numberOfPeople;
				}
				else{
					creditToBeAdded=(int)amount/numberOfPeople;
					finalCredit[countNum]+=amount-(((int)amount/numberOfPeople)*numberOfPeople);
				}
			}
			while(numberOfPeople!=0)
			{
				//System.out.println("enter the names of people who should be gifted");
				String peopleName=bufferedReader.readLine();
				//map the names and add credits
				for(int j1=0;j1<names.length;j1++){
					if(peopleName.contentEquals(names[j1])){
						finalCredit[j1]+=creditToBeAdded;
					}
				}
				numberOfPeople--;
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		for (int h = 0; h < finalCredit.length; h++) {
			out.println(names[h]+" "+(-initialCredit[h]+finalCredit[h]));
		}
		out.close();
		
		/*for (int h = 0; h < finalCredit.length; h++) {
			System.out.println(initialCredit[h]);
		}*/
		System.exit(0);
	}
}


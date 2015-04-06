/*
ID: hsdars1
LANG: JAVA
PROG: friday
TASK: friday*/


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Calendar;

class friday {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader=new BufferedReader(new FileReader("friday.in"));
		String years=bufferedReader.readLine();
		int N=Integer.parseInt(years);
		int startYear=1900;
		int endYear=startYear+N;
		int numOfDays[]=new int[N];
		int j=0,sum=0;
		for(int i=startYear;i<endYear;i++){
			if(i%100==0){
				if(i%400==0){
					numOfDays[j]=366;
				}
				else
					numOfDays[j]=365;
			}
			else if(i%4==0){
				numOfDays[j]=366;
			}else{
				numOfDays[j]=365;	
			}
			sum+=numOfDays[j];
			j++;
		}
		StringBuilder monday=new StringBuilder();
		StringBuilder tuesday=new StringBuilder();
		StringBuilder wednesday=new StringBuilder();
		StringBuilder thursday=new StringBuilder();
		StringBuilder friday=new StringBuilder();
		StringBuilder saturday=new StringBuilder();
		StringBuilder sunday=new StringBuilder();
		String startDay="Monday";
		boolean b=false;
		int febCount=0;
		System.out.println(j);
		for(j=0;j<numOfDays.length;j++){
			if(numOfDays[j]==365)
			{	b=false;
			febCount=28;
			}
			else{b=true;
			febCount=29;
			}

			//Jan count
			startDay = janCount(monday, tuesday, wednesday, thursday, friday,saturday, sunday, startDay,31);
			//feb count
			startDay = janCount(monday, tuesday, wednesday, thursday, friday, saturday, sunday, startDay, febCount);	
			
			//march count
			startDay = janCount(monday, tuesday, wednesday, thursday, friday,saturday, sunday, startDay,31);
			
			//april30
			startDay = janCount(monday, tuesday, wednesday, thursday, friday,saturday, sunday, startDay,30);
			
			//may31
			startDay = janCount(monday, tuesday, wednesday, thursday, friday,saturday, sunday, startDay,31);
			
			//june30
			startDay = janCount(monday, tuesday, wednesday, thursday, friday,saturday, sunday, startDay,30);
			
			//july31
			startDay = janCount(monday, tuesday, wednesday, thursday, friday,saturday, sunday, startDay,31);
			
			//august31
			startDay = janCount(monday, tuesday, wednesday, thursday, friday,saturday, sunday, startDay,31);
			
			//september30
			startDay = janCount(monday, tuesday, wednesday, thursday, friday,saturday, sunday, startDay,30);
			
			//oct31
			startDay = janCount(monday, tuesday, wednesday, thursday, friday,saturday, sunday, startDay,31);
			
			//nov30
			startDay = janCount(monday, tuesday, wednesday, thursday, friday,saturday, sunday, startDay,30);
			
			//dec31
			startDay = janCount(monday, tuesday, wednesday, thursday, friday,saturday, sunday, startDay,31);
			
		}
		int fromIndex=0,moCount=0,tuCount=0,weCount=0,thCount=0,frCount=0,saCount=0,suCount=0;
		int lastIndex=monday.lastIndexOf(",13");
		while(fromIndex!=-2){
			fromIndex=monday.indexOf(",13", fromIndex);
			if(fromIndex!=-1)
				moCount++;
			if(fromIndex==lastIndex)
			{
				fromIndex=-2;
				break;
			}
			fromIndex++;

		}
		fromIndex=0;
		lastIndex=tuesday.lastIndexOf(",13");
		while(fromIndex!=-2){
			fromIndex=tuesday.indexOf(",13", fromIndex);

			if(fromIndex!=-1)
				tuCount++;
			if(fromIndex==lastIndex)
			{
				fromIndex=-2;
				break;
			}
			fromIndex++;

		}
		fromIndex=0;
		lastIndex=wednesday.lastIndexOf(",13");
		while(fromIndex!=-2){
			fromIndex=wednesday.indexOf(",13", fromIndex);

			if(fromIndex!=-1)
				weCount++;
			if(fromIndex==lastIndex)
			{
				fromIndex=-2;
				break;
			}
			fromIndex++;

		}
		fromIndex=0;
		lastIndex=thursday.lastIndexOf(",13");
		while(fromIndex!=-2){
			fromIndex=thursday.indexOf(",13", fromIndex);

			if(fromIndex!=-1)
				thCount++;
			if(fromIndex==lastIndex)
			{
				fromIndex=-2;
				break;
			}
			fromIndex++;

		}
		fromIndex=0;
		lastIndex=friday.lastIndexOf(",13");
		while(fromIndex!=-2){
			fromIndex=friday.indexOf(",13", fromIndex);

			if(fromIndex!=-1)
				frCount++;
			if(fromIndex==lastIndex)
			{
				fromIndex=-2;
				break;
			}
			fromIndex++;

		}
		fromIndex=0;
		lastIndex=saturday.lastIndexOf(",13");
		while(fromIndex!=-2){
			fromIndex=saturday.indexOf(",13", fromIndex);

			if(fromIndex!=-1)
				saCount++;
			if(fromIndex==lastIndex)
			{
				fromIndex=-2;
				break;
			}
			fromIndex++;

		}
		fromIndex=0;
		lastIndex=sunday.lastIndexOf(",13");
		while(fromIndex!=-2){
			fromIndex=sunday.indexOf(",13", fromIndex);

			if(fromIndex!=-1)
				suCount++;
			if(fromIndex==lastIndex)
			{
				fromIndex=-2;
				break;
			}
			fromIndex++;

		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		out.println(saCount+" "+suCount+" "+moCount+" "+tuCount+" "+weCount+" "+thCount+" "+frCount);
		out.close();
		System.exit(0);
	}

	private static String dayBuilder(StringBuilder monday,
			StringBuilder tuesday, StringBuilder wednesday,
			StringBuilder thursday, StringBuilder friday,
			StringBuilder saturday, StringBuilder sunday, String startDay, int i) {
		if(startDay.contentEquals("Monday"))
		{
			monday.append(i+",");
			startDay="Tuesday";
		}else if(startDay.contentEquals("Tuesday"))
		{
			tuesday.append(i+",");
			startDay="Wednesday";
		}else if(startDay.contentEquals("Wednesday"))
		{
			wednesday.append(i+",");	
			startDay="Thursday";
		}else if(startDay.contentEquals("Thursday"))
		{
			thursday.append(i+",");
			startDay="Friday";
		}else if(startDay.contentEquals("Friday"))
		{
			friday.append(i+",");
			startDay="Saturday";
		}else if(startDay.contentEquals("Saturday"))
		{
			saturday.append(i+",");
			startDay="Sunday";
		}else if(startDay.contentEquals("Sunday"))
		{
			sunday.append(i+",");
			startDay="Monday";
		}
		return startDay;
	}

	private static String janCount(StringBuilder monday, StringBuilder tuesday,
			StringBuilder wednesday, StringBuilder thursday,
			StringBuilder friday, StringBuilder saturday, StringBuilder sunday,
			String startDay,int monthCount) {
		for(int i=1;i<=monthCount;i++){
			startDay = dayBuilder(monday, tuesday, wednesday, thursday, friday,
					saturday, sunday, startDay, i);				
		}
		return startDay;
	}
}
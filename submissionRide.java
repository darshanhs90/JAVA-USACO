/*
ID: hsdars1
LANG: JAVA
PROG: ride
TASK: ride
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class ride{
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader=new BufferedReader(new FileReader("ride.in"));
		String comet=bufferedReader.readLine();
		String group=bufferedReader.readLine();
		bufferedReader.close();
		int cometProduct=1;
		int groupProduct=1;
		for (int i = 0; i < comet.length(); i++) {
			if((int)comet.toUpperCase().charAt(i)<64){
				cometProduct*=comet.charAt(i);
			}
			else
				cometProduct*=((int)comet.toUpperCase().charAt(i)-64);
		}
		for (int i = 0; i < group.length(); i++) {
			if((int)group.toUpperCase().charAt(i)<64){
				groupProduct*=group.charAt(i);
			}
			else
				groupProduct*=((int)group.toUpperCase().charAt(i)-64);
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		if(cometProduct%47==groupProduct%47)
		{
			out.println("GO");
			out.close();
		}
		else{
			out.println("STAY");
			out.close();
		}

		System.exit(0);
	}
}

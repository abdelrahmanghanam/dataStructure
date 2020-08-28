import java.util.*;
import java.io.*;

public class Driver {

static FrequencyHashTable eapHashTable = new FrequencyHashTable(),
mwsHashTable = new FrequencyHashTable(),
hplHashTable = new FrequencyHashTable();
static int correctCounter = 0;
static String actualAuthor = "";
static PrintWriter pw = null;

public static void main(String [] args) {
	
	try {
	    pw = new PrintWriter(new File("NewData.csv"));
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}

trainScan();
testScan();
pw.flush();
pw.close();
//System.out.println("Number of correct guess: " + correctCounter + "/19580");
//double x= (double)correctCounter/19580 *100;
//System.out.println("accuracy: "+x+ " %" ); for accuracy
}

public static void trainScan() {
//setup scanners
try {
File trainFile = new File("train.csv");
FileReader fr=new FileReader(trainFile);   //reads the file  
BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
String line;  
while((line=br.readLine())!=null)  
{  
    
System.out.println(line);
Record r = new Record(line,true);
if (r.getAuthor().equals("EAP")) {
//it's written by EAP, increment each word
for (String word : r.getText().split(" ")) {
eapHashTable.increment(word);
}
}
if (r.getAuthor().equals("MWS")) {
//it's written by EAP, increment each word
for (String word : r.getText().split(" ")) {
mwsHashTable.increment(word);
}
}
if (r.getAuthor().equals("HPL")) {
//it's written by EAP, increment each word
for (String word : r.getText().split(" ")) {
hplHashTable.increment(word);
}
}
}
} catch (IOException e) { System.out.println("Can't load file"); }
}

public static void testScan() {
try {
File testFile = new File("test.csv");
FileReader fr=new FileReader(testFile);   //reads the file  
BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
String line;  

while((line=br.readLine())!=null) {  
double eapFreq = 1.0, mwsFreq = 1.0, hplFreq = 1.0;
String checkLine = line;
Record lines = new Record(checkLine,false);

for(String word : lines.getText().split(" ")) {
eapFreq = eapFreq * eapHashTable.get(word);
mwsFreq = mwsFreq * mwsHashTable.get(word);
hplFreq = hplFreq * hplHashTable.get(word);
}

if(eapFreq > mwsFreq && eapFreq > hplFreq) { actualAuthor = "EAP"; }
if(mwsFreq > eapFreq && mwsFreq > hplFreq) { actualAuthor = "MWS"; }
if(hplFreq > eapFreq && hplFreq > mwsFreq) { actualAuthor = "HPL"; }
if (!lines.getId().equals("id")) { // to avoid first line
System.out.println("ID: "+lines.getId()+" Author: " + actualAuthor);
StringBuilder builder = new StringBuilder();
builder.append("\""+lines.getId()+"\""+",");
builder.append("\""+actualAuthor+"\"");
builder.append('\n');
pw.write(builder.toString());
}



//if (actualAuthor.equals(lines.getAuthor())) { correctCounter++; } this was for checking the accuracy if found
}
} catch (IOException e) { System.out.println("Can't load file"); }
}
}


import java.util.Scanner;
import java.lang.StringBuilder;
public class Record {

private String mText;
private String mAuthor;
private String mId;
boolean x;

public Record (String rawCSVLine,boolean check) {
String split[] = rawCSVLine.split("\",\"");
String id = split[0].replaceAll("\"","");
String text = split[1].replaceAll("\"","");
String author;
if(check) {
author = split[2].replaceAll("\"","");
}else {
author = null;
}


mId = id;

StringBuilder sb = new StringBuilder();
  
Scanner wordScan = new Scanner(split[1]);
while(wordScan.hasNext()) {

String word = wordScan.next();
word = word.replaceAll("[^a-zA-Z0-9]","") ;
word = word.toLowerCase();
sb.append(word + " ");
}

mText = sb.toString();
mAuthor = author;

/*System.out.println("AUTHOR: " + mAuthor);
System.out.println("TEXT: " + mText);
System.out.println("ID: " + mId);*/

}

public String getId() { return mId;}
public String getText() { return mText;}
public String getAuthor() { return mAuthor;}


public String toString() {
return mId + "\n" + mText + "\n" + mAuthor;
}
}
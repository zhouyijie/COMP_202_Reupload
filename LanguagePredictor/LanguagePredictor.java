import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class LanguagePredictor{
  /**
   * read from two files that created before
   */
  public static void main(String[] args) {
    HashMap<String,Integer> learn_eng = readVocabulary("eng_vocab.txt");
    HashMap<String,Integer> learn_fre = readVocabulary("fre_vocab.txt");
    classifyDocuments(learn_eng, learn_fre ,"docs/test/",20);
    
  }
  /**
   * counter for wordCount
   * 
   */
  
  public static HashMap<String,Integer> readVocabulary(String fileName) {
    HashMap<String,Integer> wordCount = new HashMap<String,Integer>();
    
    try{
      FileReader fr = new FileReader(fileName);
      BufferedReader br = new BufferedReader(fr);
      String input = br.readLine(); 
      
      while(input!=null){
        if(input == null){
          break;}
        String[] seperate = input.split(" ");
        Integer temp = Integer.parseInt(seperate[1]);
        wordCount.put(seperate[0],temp);
        input=br.readLine();
      }
    }
    catch(FileNotFoundException e){
      System.out.println("the file exceeded our limits");
    }
    catch(IOException e){
      System.out.println("There was a problem reading from the files");
    }
    return wordCount;
  }
  /**
   * 
   */
  
  public static void classifyDocuments(HashMap<String,Integer> engVocab, HashMap<String,Integer> freVocab, 
                                       String directory, int nFiles) {
    
    for(int i =1;i<=nFiles;i++){
      int num_of_eng = 0;
    int num_of_fre = 0;
      String docid = directory + "" + i + ".txt";
      try{
      FileReader fr = new FileReader(docid);
      BufferedReader br = new BufferedReader(fr);
      String input = br.readLine(); 
      
      while(input!=null){
        if(input == null){
          break;}
        String[] seperate = input.split(" ");
        for(int j = 0; j<seperate.length;j++){
          if(engVocab.get(seperate[j]) != null){
            num_of_eng ++;}
          if(freVocab.get(seperate[j]) != null){
            num_of_fre ++;}
        }
        input=br.readLine();
      }
    }
    catch(FileNotFoundException e){
      System.out.println("the file exceeded our limits");
    }
    catch(IOException e){
      System.out.println("There was a problem reading from the files");
    }
    
    String decision = "";
    if(num_of_eng > num_of_fre){
      decision += "English";}
    if(num_of_eng <= num_of_fre){
      decision += "French";}
    System.out.println(docid + "  English: " + num_of_eng + "  French: " + num_of_fre + "  Decision: " + decision);
  }
  }
}
  
  /*****************************************************************************
    docs/test/1.txt  English: 29  French: 11  Decision: English 
docs/test/2.txt  English: 78  French: 33  Decision: English 
docs/test/3.txt  English: 148  French: 67  Decision: English 
docs/test/4.txt  English: 370  French: 140  Decision: English 
docs/test/5.txt  English: 91  French: 43  Decision: English 
docs/test/6.txt  English: 206  French: 88  Decision: English 
docs/test/7.txt  English: 60  French: 30  Decision: English 
docs/test/8.txt  English: 204  French: 94  Decision: English 
docs/test/9.txt  English: 74  French: 39  Decision: English 
docs/test/10.txt  English: 570  French: 272  Decision: English 
docs/test/11.txt  English: 66  French: 422  Decision: French 
docs/test/12.txt  English: 21  French: 164  Decision: French 
docs/test/13.txt  English: 23  French: 65  Decision: French 
docs/test/14.txt  English: 46  French: 256  Decision: French 
docs/test/15.txt  English: 38  French: 157  Decision: French 
docs/test/16.txt  English: 20  French: 131  Decision: French 
docs/test/17.txt  English: 41  French: 247  Decision: French 
docs/test/18.txt  English: 86  French: 456  Decision: French 
docs/test/19.txt  English: 21  French: 170  Decision: French 
docs/test/20.txt  English: 44  French: 222  Decision: French 

so it works apparently.

    *****************************************************************************/
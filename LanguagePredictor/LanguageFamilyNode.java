import java.util.ArrayList;

public class LanguageFamilyNode{
 // two private
 private String name;
 private ArrayList<LanguageFamilyNode> children;
 // Methods
 public LanguageFamilyNode(String language){
  name = language;
  children = new ArrayList<LanguageFamilyNode>();
 }
 public String getName(){
  return this.name;
 }
 public ArrayList<LanguageFamilyNode> getChildren(){
  return this.children;
 }
 public void addChild(LanguageFamilyNode child){
  this.children.add(child);
 }

 public void printAllDescendants(){
  System.out.println(this.getName());
  //check their child 
  int indexNum = 0;
  String prefix = "";
  while(indexNum < this.getChildren().size())
  {
   this.getChildren().get(indexNum).printAllDescendants(prefix + "  ");
   indexNum++;
  }

 }
 public void printAllDescendants(String prefix){
  System.out.println(prefix + this.getName());
  //check
  int i = 0;
  while(i < this.getChildren().size())
  {
   this.getChildren().get(i).printAllDescendants(prefix + "  ");
   i++;
  }
 }

 public static void main(String args[])
 {
  // set up the tree
  LanguageFamilyNode altaic = new LanguageFamilyNode("altaic Languages");
  LanguageFamilyNode a = new LanguageFamilyNode("Western altaic");
  LanguageFamilyNode ab1 = new LanguageFamilyNode("Mongolian");
  LanguageFamilyNode ab2 = new LanguageFamilyNode("Turkic");
  LanguageFamilyNode abc1= new LanguageFamilyNode("Turkish");
  LanguageFamilyNode abc2= new LanguageFamilyNode("Khazak");
  LanguageFamilyNode abc3 = new LanguageFamilyNode("Uzbek");
  LanguageFamilyNode abc4 = new LanguageFamilyNode("Tadjik");
  LanguageFamilyNode abc5 = new LanguageFamilyNode("Chuvash");
  LanguageFamilyNode b = new LanguageFamilyNode("Extinct Ural-Altaic");
  LanguageFamilyNode bb1 = new LanguageFamilyNode("Sumerian");
  LanguageFamilyNode bb2 = new LanguageFamilyNode("Elamite");
  LanguageFamilyNode bb3 = new LanguageFamilyNode("Cretan");
  LanguageFamilyNode bb4 = new LanguageFamilyNode("Cyprian");
  LanguageFamilyNode bb5 = new LanguageFamilyNode("Etruscan");
  LanguageFamilyNode bb6 = new LanguageFamilyNode("Scythian");
  LanguageFamilyNode c = new LanguageFamilyNode("Eastern Altaic");
  LanguageFamilyNode cb1 = new LanguageFamilyNode("Tunguz");
  LanguageFamilyNode cb2 = new LanguageFamilyNode("Korean");
  LanguageFamilyNode cb3 = new LanguageFamilyNode("Japanese");
  LanguageFamilyNode cb4 = new LanguageFamilyNode("Ainu");
  LanguageFamilyNode cb5 = new LanguageFamilyNode("Kamchatcan");
  // adding nodes 
  altaic.addChild(a);
  altaic.addChild(b);
  altaic.addChild(c);
  a.addChild(ab1);
  a.addChild(ab2);
  ab2.addChild(abc1);
  ab2.addChild(abc2);
  ab2.addChild(abc3);
  ab2.addChild(abc4);
  ab2.addChild(abc5);
  b.addChild(bb1);
  b.addChild(bb2);
  b.addChild(bb3);
  b.addChild(bb4);
  b.addChild(bb5);
  b.addChild(bb6);
  c.addChild(cb1);
  c.addChild(cb2);
  c.addChild(cb3);
  c.addChild(cb4);
  c.addChild(cb5);
  //print
  altaic.printAllDescendants();
 }
}
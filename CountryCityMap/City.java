import java.util.Random;

public class City {
 private static String[] namePrefixes = { "Chiguiro", "Maracas", "Raccoon",
  "Glass", "Iron", "Spring", "Winter", "Autumn", "Summer", "Godel",
  "Recursion", "Escher", "PowPow", "LOL", "Cheese", "MasterRoshi", "Pants", "Dork",
  "Cat", "Liszt", "Hysteria", "Cool", "Ennui", "Tortoise", "Mudkip", "Tonkatsu", 
  "Rainy", "Slump", "Tortilla", "Rodizio", "Ajiaco", "Sunny" };
 
 private static String[] nameSuffixes = { "ville", "vale", "_City", "town", "ton",
   "hill", "field", "land", "ia", "furt", "grad", "lia", "stadt", "stan" };
 
 private String name;
 private Vector2D pos;
 private City[] neighbours; 
 
 private boolean explored = false;

 public City() {
  //TODO complete constructor.
  //Generate a random name that is combination of a random prefix and suffix.
  //Initialize the initial position as a vector.
  //Max x and max y value should be 150.
     
     double randomNum1 = Math.random()*namePrefixes.length;
     double randomNum2 = Math.random()*nameSuffixes.length; 
     this.name = namePrefixes[(int)randomNum1] + nameSuffixes[(int)randomNum2];
     
     randomNum1 = Math.random()*150;
     randomNum2 = Math.random()*150;
     this.pos = new Vector2D(randomNum1,randomNum2);
 }
 
 //maxDist is the further distance apart two cities can be and still be connected.
 //Return the number of neighbours found
 //If there are j neighbours, then the last length-j spots of neighbours should be null
 //And the first j elements should be city objects
 public void setNeighbours(double maxDist, City[] cities)
 {
  //TODO
     neighbours = new City[cities.length - 1];
     int j = 0;
     for (int i = 0; i < cities.length; i++){
         if (this == cities[i]) continue;
         else if (this.pos.distance(cities[i].pos) <= maxDist) {
             neighbours[j] = cities[i];
             j++;
         }
     }
 }
 
 //Searches to see which cities are connected to the current city.
 //If a city can be reached, its boolean 'explore' value will be true after this method is called
 //Otherwise, it will be false.
 public void explore() {
  //TODO: complete this method
     this.explored = true;
     int i = 0;
     while(neighbours[i] != null){
         if (!neighbours[i].explored) neighbours[i].explore();
         i++;
     }
 }
 
 public Vector2D getPos()
 {
     return pos;
 }
 
 public String getName() {
     return name;
 }
 
 public City[] getNeighbours(){
     return neighbours;
 }
 
 public boolean isExplored(){
     return explored;
 }
}


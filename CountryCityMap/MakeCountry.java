public class MakeCountry {
 public static void main(String[] args){
  //Chaning this number will change the number of cities in the country.
  int numCities = 15;
  //You can rename your country to whatever you like.
  String countryName = "Canada";
  //TODO: Use the StopWatch class to determine how long it takes
  //to create the country (print the number of millisecond it takes)
  //TODO Create the country
  StopWatch watch = new StopWatch();
  watch.start();
  Country myCountry = new Country(countryName, numCities, 50);
  watch.stop();
  System.out.println("It took " + watch.getTimeMilli() +" milliseconds to complete that task");
  //TODO: Use the StopWatch class to time how long it takes
  //to determine if the country is connected
  // (print this time in milliseconds)
  //TODO Check if this country is connected. 
  watch.start();
  boolean connected = false;
  connected = myCountry.setConnectivity();
  
  System.out.println(countryName + " is connected... " + connected);
  watch.stop();
  System.out.println("It took " + watch.getTimeMilli() +" milliseconds to complete that task");
  //Once every thing else is complete, uncomment line below to display the image.
  CountryMap map = new CountryMap(myCountry.getCities(), myCountry.getName());
 }
}

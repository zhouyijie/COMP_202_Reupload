public class Country {
 //TODO create this object.
    private String name;
    private City[] cityArray;
    private boolean isConnected;
    
    Country(String name, int n, int maxDist){
        this.name = name;
        cityArray = new City[n];
        for (int i = 0; i < n; i++){
            cityArray[i] = new City();
        }
        for (int i = 0; i < n; i++){
            cityArray[i].setNeighbours(maxDist, cityArray);
        }
    }
    
    public boolean setConnectivity(){
        cityArray[0].explore();
        for (int i = 0; i < cityArray.length; i++){
            if (!cityArray[i].isExplored()) return false;
        }
        return true;
    }
    
    public String getName(){
        return name;
    }
    
    public City[] getCities(){
        return cityArray;
    }
}

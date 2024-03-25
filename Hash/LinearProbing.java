public class LinearProbing{
    String [] key;
    String [] values;
    int size;

    LinearProbing(int size){
        this.size = size;
        key = new String[size];
        values = new String[size]; 
    }

    int hash(String key){
         key = Integer.parseInt(key);
         return (2 * key + 3)%10;

    }

    void insert(String k, String v){
        int temp = hash(k);
        int u = temp;
        do{
            if(key[u] == null){
                key[u] = k;
                values[u] = k;
                return;
            }
            if(key[u] == k){
                values[u] = v;
                return;
            }
            u = (u+1)%10;
        }
        while(u != temp);
    }
}
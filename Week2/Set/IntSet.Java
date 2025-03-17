import java.util.Arrays;

public class IntSet{
    int[] array;

    public IntSet (int s){
        array = new int[s];
    }

    public boolean isEmpty() {
        for(int i = 0; i < array.length; i++){
            if(array[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    public boolean hasElement(int n) {
        for(int i = 0; i < array.length; i++){
            if(array[i] == n) {
                return true;
            }
        }
        return false;
    }

    public void addElement(int n){
        if(hasElement(n)) {
            return;
        }

        
        for(int i = 0; i < array.length; i++){
            if(array[i] == 0) {
                array[i] = n;
                return;
            }
        }

    }

    public void removeElement(int n){
        if (hasElement(n)) {
            for(int i = 0; i < array.length; i++){
                if(array[i] == n) {
                    //Found it!!

                    //Shift everything to the left
                    for(int j = i; j + 1 < array.length; j++){
                        array[j] = array[j + 1];
                    }
                    array[array.length - 1] = 0;
                    return;
                    
                }
            }
        }
    }

    public void print() {
        System.out.println(Arrays.toString(array));
    }
}
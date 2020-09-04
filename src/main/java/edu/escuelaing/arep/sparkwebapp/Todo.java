
package edu.escuelaing.arep.sparkwebapp;

public class Todo {

    private static double mean,deviation;

    public static LinkedList<Double> getArray() {
        return array;
    }

    public static void setArray(LinkedList<Double> array) {
        Todo.array = array;
    }

    private static LinkedList<Double> array;
    private String [] recibido;


    public Todo(String arreglo) {
        array = new LinkedList<>();
        String[] mData = arreglo.split(",");
        for (String i : mData) {
            double value = Double.parseDouble(i);
            array.add(value);
        }
    }
    public String sort(){
        LinkedList.bubbleSort(array);
        String ans=new String("");

        int n = array.getSize();
        for (int i=0; i<n; ++i){
                double c = (double)array.get(i).getValue();
                int c1 = (int)c;
                ans = ans + Integer.toString(c1) +" ";
        }
        System.out.println(ans);
        return ans;
    }
    /**
     * calculates the sum of a data set
     * @param array data set
     * @return Sum of data set
     **/
    public double suma(LinkedList<Double> array){
        double sumatoria = 0.0;
        for(Double i: array) {
            sumatoria+= i;
        }
        return sumatoria;
    }

    /**
     * Calculates the mean of a data set.
     * @param array LinkedList with the data.
     * @return arithmetic mean
     */
    public double mean(LinkedList<Double> array){
        double sumatoria = suma(array);
        return sumatoria / array.getSize();
    }

    /**
     * Calculates standard deviation of a data set.
     * @param array LinkedList with the data.
     * @return result of standard deviation
     */
    public double standardDeviation(LinkedList<Double> array){
        double sumatoria=0;
        double promedio = mean(array);
        for (Double i:array){
            sumatoria+= Math.pow(i-promedio,2);
        }
        return (float) Math.sqrt((sumatoria)/(array.getSize()-1));
    }







    

    
    
}


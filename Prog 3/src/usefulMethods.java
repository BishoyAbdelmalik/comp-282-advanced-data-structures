public class usefulMethods {
    private static String getPartition(int[] a, int firstIndex, int lastIndex, boolean addIndex) {
        String array="";
        if (addIndex){
            array+=" ";
            for(int i=firstIndex;i<=lastIndex;i++) {
                array += String.format("%3s",i) + " ";
            }
            array+=" \n";
        }
        array+="[";
        for (int i=firstIndex;i<=lastIndex;i++){
            array+=String.format("%3s",a[i]);
            if (i!=lastIndex){
                array+=",";
            }
        }
        array+="]";
        return array;
    }
}
